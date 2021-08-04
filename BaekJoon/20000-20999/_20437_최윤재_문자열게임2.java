package tmp;
import java.io.*;
import java.util.*;
public class _20437_최윤재_문자열게임2 {

	static int testcase;
	static ArrayList<Integer>[] alphabet = new ArrayList[26];	//a-z 몇번 인덱스에 있는지 저장 
	static int K;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testcase = Integer.parseInt(br.readLine());
		while(testcase-->0) {
			int min = Integer.MAX_VALUE;
			String input = br.readLine();
			K = Integer.parseInt(br.readLine());
			for(int i=0; i<26; i++) {
				alphabet[i] = new ArrayList<Integer>();
			}
			for(int i=0; i<input.length(); i++) 	//문자열의 알파벳들 위치 저장
				alphabet[input.charAt(i)-'a'].add(i);
			findlongest();	//정답 찾는 함수
		}
		System.out.println(sb);
	}
	public static void findlongest() {
		int max = 0;	//시작-끝 같은 문자, 해당 문자 K개
		int min = Integer.MAX_VALUE;	//K개 문자 갖는 가장 짧은 문자열 길이
		boolean none = true;	//가능한 경우가 없는 경우에 true
		for(int i=0; i<26; i++) {
			int len = alphabet[i].size();
			if(len>=K) {	//K개 이상 등장하는 알파벳이 있는 경우 (none = false)
				int left = 0;	//왼쪽 인덱스
				int right = K-1;	//오른쪽인덱스
				while(right<len) {	//인덱스들 하나씩 ++ 하며 max, min값 확인
					max = Math.max(max, alphabet[i].get(right)-alphabet[i].get(left)+1);
					min = Math.min(min, alphabet[i].get(right)-alphabet[i].get(left)+1);
					left++;
					right++;
				}
//				while(len>K) {
//					int leftLonggap = alphabet[i].get(leftLong+1)-alphabet[i].get(leftLong);
//					int rightLonggap = alphabet[i].get(rightLong) - alphabet[i].get(rightLong-1);
//					if(leftLonggap<rightLonggap) leftLong++;
//					else rightLong--;
//					int leftShortgap = alphabet[i].get(leftShort+1)-alphabet[i].get(leftShort);
//					int rightShortgap = alphabet[i].get(rightShort)-alphabet[i].get(rightShort-1);
//					if(leftShortgap<rightShortgap)rightShort--;
//					else leftShort++;
//					len--;
//				}
				none = false;
			}
		}
		if(none) sb.append("-1\n");	//결과 출력
		else sb.append(min+" "+max+"\n");
	}

}
