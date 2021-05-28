package tmp;
import java.io.*;
import java.util.*;
public class _9081_최윤재_단어맞추기 {

	static int testcase;
	static StringBuilder result = new StringBuilder();		//결과저장
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testcase = Integer.parseInt(br.readLine());
		for(int i=0; i<testcase; i++) {			//테스트케이스 개수만큼 돌리기
			String input = br.readLine();	//단어받기
			int swap_min = 0;		//ABC순서로 오름차순으로 정렬되어 있을 때 오름차순의 끝부분 바로 앞
			int swap_max = 0;		//swap_min과 바꿀 숫자 (내림차순 부분 중 swap_min보다 큰 최소값)
			int swap_min_idx=input.length()-1;	//swap할 작은 수 (오름차순 끝부분 바로 앞 인덱스) , 사전상 마지막 배치일 경우를 대비해 인덱스를 최대값으로 초기화
			int swap_max_idx=input.length()-1;	//swap할 큰 수 (내림차순 부분 중 swap_min보다 큰 최소값의 인덱스)
			char[] word = input.toCharArray();
			for(int j=0; j<word.length-1; j++) {
				if(word[j]<word[j+1]) {		//오름차순인 경우 값들 업데이트
					swap_min = word[j];
					swap_min_idx = j;
					swap_max = word[j+1];
					swap_max_idx = j+1;
				}
				if(word[j]>=word[j+1]) {	//내림차순이 나오면 swap_max를 업데이트 해야하는 지 확인하기
					if(word[j+1] < swap_max && swap_min < word[j+1]) {
						swap_max = word[j+1];
						swap_max_idx = j+1;
					}
				}
			}
			char tmp = word[swap_min_idx];
			word[swap_min_idx] = word[swap_max_idx];
			word[swap_max_idx] = tmp;	////////////swap
			input = new String(word);	//swap_min_idx를 기준으로 뒷부분은 오름차순 정렬
			String prefix = input.substring(0,swap_min_idx+1);
			char[] suffix = input.substring(swap_min_idx+1).toCharArray();
			Arrays.sort(suffix);
			String res = prefix + new String(suffix);
			result.append(res+'\n');	//결과에 append
		}
		System.out.println(result);
	}

}
