package week18;
import java.util.*;
import java.io.*;
public class _1541_최윤재_잃어버린괄호 {

	static ArrayList<Integer> arr = new ArrayList();	//숫자들 저장할 arraylist
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String expression = br.readLine();	//expression에 전체 수식 저장
		int loc = 0;	//현재 숫자의 부호를 알기 위한 인덱스
		StringTokenizer st = new StringTokenizer(expression, "+-");	//+-를 구분자로 해서 숫자만 뽑음
		String tmp = st.nextToken();	//tmp에 숫자 들어감
		arr.add(Integer.parseInt(tmp));	//처음 숫자는 무조건 양수
		loc += tmp.length();	//숫자의 길이를 고려해 loc 인덱스 증강시킴
		while(st.hasMoreTokens()) {
			tmp = st.nextToken();	//다음 숫자에 대해 수행
			if (expression.charAt(loc)=='+') arr.add(Integer.parseInt(tmp));	//다음 숫자가 양수인 경우
			else arr.add(-Integer.parseInt(tmp));	//다음 숫자가 음수인 경우
			loc += tmp.length()+1;	//부호 확인을 위해 loc 증가
		}
		int result = 0;	//결과값 저장
		boolean inbracket = false;	//처음 음수가 나오면 true로 바꿔서 +값들은 괄호 내에 -값은 그냥 계산
		for(int i : arr) {	//각 원소에 대해 수행
			if (!inbracket) {	//아직 음수가 하나도 안나왔을 때
				result += i;	//결과에 무조건 더해야 함
				if (i < 0) inbracket = true;//음수가 나오면 inbracket변수 true로 바꾸기
			}
			else {	//음수가 나온 후 경우
				if (i < 0) result += i;	//음수는 그냥 더함
				else result -= i;	//양수는 부호 바꿔서 더함
			}
		}
		System.out.println(result);
	}

}
