package tmp;
import java.io.*;
public class _9935_최윤재_문자열폭발 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringBuffer input = new StringBuffer(br.readLine());	//시간초과날때 쓴 부분
		char[] input = br.readLine().toCharArray();	//입력받은 문자열 char array로 바꿈
		String bomb = br.readLine();	//폭발시킬 문자열
		int len = bomb.length();	//폭발시킬 문자열의 길이
		StringBuilder result = new StringBuilder();	//결과 넣을 StringBuilder

		for(int i=0; i<input.length; i++) {
			result.append(input[i]);	//결과에 input의 char를 하나씩 append
			if(result.length()>=len) {	//폭발시킬 문자열보다 길어진 경우
				boolean explode = true;	//우선 폭발시킨다고 해놓기
				for(int idx = 0; idx<len; idx++) {	//인덱스 증가시키면서 폭발시킬 문자열과 일치하는지 확인
					if(result.charAt(result.length()-len+idx) != bomb.charAt(idx)) {
						explode = false;	//일치하지 않는 경우 폭발 안시킴
						break;
					}
				}
				if(explode) result.delete(result.length()-len, result.length());	//폭발시키는 경우 result에서 해당 문자열만큼 날림
			}
		}
		if(result.length()==0) System.out.println("FRULA");	//아무 문자열도 남지 않은 경우
		else System.out.println(result);	//출력할 문자열 남은 경우
		
		
		/*int idx = input.indexOf(bomb);
		while(idx != -1) {
			input = input.delete(idx, idx+len);
			idx = input.indexOf(bomb, idx-len);
		}
		if(input.length()!=0) System.out.println(input);
		else System.out.println("FRULA");
		*/
	}
}
