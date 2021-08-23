package tmp;
import java.util.*;
import java.io.*;
public class _9177_최윤재_단어섞기 {

	static int testcase;
	static char[] word1;
	static char[] word2;
	static char[] target;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testcase = Integer.parseInt(br.readLine());
		int casenum=0;
		while(casenum++ < testcase) {		//테스트캐이스만큼 반복
			StringTokenizer input = new StringTokenizer(br.readLine());
			word1 = input.nextToken().toCharArray();
			word2 = input.nextToken().toCharArray();
			target = input.nextToken().toCharArray();	//입력
			HashSet<Character> set = new HashSet<>();	//word1과 word2에 있는 모든 char들 HashSet에 저장
			for(int i=0; i<word1.length; i++) set.add(word1[i]);
			for(int i=0; i<word2.length; i++) set.add(word2[i]);
			boolean flag = false;
			for(int i=0; i<target.length; i++) {	//target에 있는 char들이 우선 모두 HashSet에 있어야 다음단계 함 (이 과정 없으면 시간초과)
				if(set.contains(target[i])) continue;
				result.append("Data set "+casenum+": no\n");
				flag = true;
				break;
			}
			if(!flag) {	//HashSet안에 필요한 char들이 다 있으면 문자열 조합해봄
				if(checkchar(0,0,0)) result.append("Data set "+casenum+": yes\n");	//가능한경우
				else result.append("Data set "+casenum+": no\n");
			}
		}
		System.out.println(result);
	}
	public static boolean checkchar(int idx1, int idx2, int idx3) {	//idx1은 word1의 지점, idx2는 word2의 지점, idx3은 target의 지점
		boolean ispossible = false;	//최종결과
		if(idx1+idx2 == target.length) return true;	//만드는 것이 가능한 경우에 도달했을 때 true 리턴
		if(idx1<word1.length && target[idx3] == word1[idx1]) ispossible = ispossible || checkchar(idx1+1, idx2, idx3+1);	//or로 ispossible을 처리
		if(idx2<word2.length && target[idx3] == word2[idx2]) ispossible = ispossible || checkchar(idx1, idx2+1, idx3+1);	//전체중 한번이라도 가능하면 true 리턴
		return ispossible;	//결과 리턴
	}
}
