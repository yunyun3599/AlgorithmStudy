package tmp;
import java.io.*;
import java.util.*;
public class _10819_최윤재_차이를최대로 {
	
	static int N;
	static int[] arr;
	static int max;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());		//숫자 개수
		arr = new int[N];		//숫자 배열
		visited = new boolean[N];	//사용되었는지 표시
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}////////////////////////////////////////////////////입력
		for(int i=0; i<N; i++) {
			max = Math.max(max, backtracking(i, 0, 1));		//순서를 바꿔가며 수행
		}
		System.out.println(max);
	}
	public static int backtracking(int prev, int res, int depth) {	//prev가 앞에 사용된 숫자의 인덱스, res가 지금까지의 연산 결과, depth가 몇개 썼는지
		int result = 0;
		if(depth==N) return res;	//모든 숫자 사용한 경우 res 리턴
		visited[prev] = true;		//이전에 사용된 숫자 사용했다고 표시
		for(int i=0; i<N; i++) {	//다음으로 사용할 숫자 고르기
			if(!visited[i]) {		//아직 사용되지 않은 숫자에 대해
				result = Math.max(result, backtracking(i, res+Math.abs(arr[prev] - arr[i]), depth+1));	//결과들중에 더 큰값을 result로 세팅
			}
		}
		visited[prev] = false;
		return result;		//결과 리턴
	}
}



