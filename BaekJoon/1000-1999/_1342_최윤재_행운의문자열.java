package tmp;
import java.util.*;
public class _1342_최윤재_행운의문자열 {

	static String input;
	static int alphabet[] = new int[26];	//각 알파벳 몇개 들어왔나 저장
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine();
		for(int i=0; i<input.length(); i++) {
			alphabet[input.charAt(i)-'a']++;	//각 character별로 알파벳 배열에 개수 저장
		}

		for(int i=0; i<26; i++) {	//각 알파벳별로 하나 이상 있으면 그거로 시작하는 문자열 경우 구함
			if(alphabet[i]>0) {
				alphabet[i]--;	//썼으니까 개수 빼기
				concat(i, 1);	//concat
				alphabet[i]++;	//개수 다시 더하기
			}
		}
		System.out.println(result);
	}
	public static void concat(int prev, int len) {	//prev는 이전에 붙인 알파벳의 인덱스, len은 지금까지 만든 문자열 길이
		if(len==input.length()) {	//문자열 완성된 경우 result 값 하나 늘림
			result++;
			return;
		}
		for(int i=0; i<26; i++) {	//알파벳개수만큼 돌리기
			if(prev!=i && alphabet[i]>0) {	//이전 알파벳과 다르고 쓸 수 있는 알파벳이 남은 경우
				alphabet[i]--;
				concat(i, len+1);
				alphabet[i]++;
			}
		}
	}
}
