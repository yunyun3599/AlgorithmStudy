import java.io.*;
import java.util.*;

public class _1034_최윤재_램프 {
	
	static int[][] table;
	static boolean[] visited;
	static int result;
	static int K;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		table  = new int[N][M];
		visited = new boolean[N];	//위에서 동일한 내용의 행이 있었다면 true 
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<M; j++) {
				table[i][j] = input.charAt(j) -'0';
			}
		}
		K = Integer.parseInt(br.readLine());
		////////////////////////////////////////입력 
		for(int i=0; i<N; i++) {	//각 행마다 켜질 수 있는 지 확인 
			int off = 0;	//현재 꺼져있는 칸의 개수 
			int samerow = 1;	//현재 행과 동일한 칸의 배치를 갖는 행의 개수 
			if(visited[i]) continue;	//이미 확인해본 행인 경우 
			for(int j=0; j<M; j++) {	//꺼져있는 칸 개수 카운트 
				if(table[i][j] == 0) {
					off++;
				}
			}
			for(int k=i+1; k<N; k++) {	//현재 행과 동일한 배치의 행 개수 구하기 
				if(Arrays.equals(table[k], table[i])) {
					visited[k] = true;
					samerow++;
				}
			}
			if(off%2 == K%2 && off <= K) {	//K번의 조작으로 모든 칸을 킬 수 있는지 (꺼져있는 칸의 개수와 K의 홀짝여부 동일, K가 off보다 커야함)
				result = Math.max(result, samerow);
			}
		}
		System.out.println(result);
	}

}
