package tmp;

import java.io.*;
import java.util.*;

public class _1495_최윤재_기타리스트 {

	static int N;
	static int S;
	static int M;
	static int[] volume;
	static boolean[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		volume = new int[N+1];
		dp = new boolean[N+1][M+1];	//dp[i][j]는 i번째 곡을 j 볼륨으로 연주가능한지 여부
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			volume[i] = Integer.parseInt(st.nextToken());
		}
		dp[0][S] = true;	//처음 연주 볼륨
		for(int i=1; i<=N; i++) {
			for(int j=0; j<=M; j++) {
				if(!dp[i-1][j]) continue;	//이전 회차에서 해당 볼륨으로 연주하지 못한 경우
				if(j - volume[i] >=0) dp[i][j-volume[i]] = true;	//볼륨을 뺐을 때 범위 내인지
				if(j + volume[i] <= M) dp[i][j+volume[i]] = true;	//볼륨을 더했을 때 범위 내인지
			}
		}
		for(int i=M; i>=0; i--) {	//결과 출력
			if(dp[N][i]) {
				System.out.println(i);
				System.exit(0);
			}
		}
		System.out.println(-1);
	}
}
