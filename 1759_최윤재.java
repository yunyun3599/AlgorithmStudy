package week7;
import java.util.*;
public class 최윤재_1759 {
	
	static int L;
	static int C;
	static char[] alphabet;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();							//암호 길이
		C = sc.nextInt();							//암호가 될 수 있는 알파벳 개수
		alphabet=new char[C];						//사용 가능한 알파벳 저장할 배열
		
		for(int i=0; i<C; i++) {
			alphabet[i]=sc.next().charAt(0);
		}
		//////////////////////////////////////////////여기까지 입력
		Arrays.sort(alphabet);						//알파벳 순서대로 정렬
		
		for(int i=0; i<C; i++) {					//DFS 이용, 백트레킹
			if(isVowel(alphabet[i]))				//모음인 경우, isVowel이 해당 character가 모음인지 확인하는 함수		
				promising(i,1,""+alphabet[i]);		//모음 개수를 1로 세팅하고 DFS
			else									//모음이 아닌 경우
				promising(i,0,""+alphabet[i]);
		}
		
		System.out.println(result);					//결과 출력
	}
	
	
	
	static boolean isVowel(char c) {				//모음인지 확인하는 함수
		if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u') return true;
		return false;
	}
	
	static void promising(int start, int vowel, String tmp) {		//DFS. 시작 지점 알파벳과 모음 개수, 현재까지 확정한 string을 인자로 받음
		if(tmp.length()==L && vowel>0 && L-vowel>=2) {				//string이 완성 되었고 모음이 한개 이상이며 자음이 두개 이상인 경우에만 result에 추가
			result.append(tmp+"\n");
			return;
		}
		else 
		for(int i=start+1; i<C; i++) {								//아직 string이 완성되지 않은 경우에는 다음 alphabet을 string에 추가해 DFS 수행
			if(isVowel(alphabet[i])) promising(i, vowel+1,tmp+alphabet[i]);		//모음인 경우
			else promising(i,vowel,tmp+alphabet[i]);							//모음이 아닌 경우
		}
	}
}
