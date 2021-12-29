package tmp;
import java.io.*;
import java.util.*;
public class _5721_최윤재_사탕줍기대회 {

	static int N;
	static int M;
	static StringBuilder answer = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		while(N!=0) {
			int[] dp = new int[N+1];	//해당 행까지의 dp값
			for(int i=1; i<N+1; i++) {
				st = new StringTokenizer(br.readLine());
				int tmp[] = new int[M+1];	//한 행 내의 열에 대한 dp값
				for(int j=1; j<M+1; j++) {
					int num = Integer.parseInt(st.nextToken());
					if(j==1) tmp[1] = num;
					if(j>1) tmp[j] = Math.max(tmp[j-2]+num, tmp[j-1]);	//해당 열에서 가장 크게 가져갈 수 있는 경우
				}
				dp[i] = tmp[M];
				if(i>=2) {	//지금까지의 행까지를 고려했을 때 가장 크게 가져갈 수 있는 경우
					dp[i] = Math.max(dp[i-2] + dp[i], dp[i-1]);
				}
			}
			answer.append(dp[N]+"\n");	//정답 append
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		}
		System.out.println(answer);
	}

}
