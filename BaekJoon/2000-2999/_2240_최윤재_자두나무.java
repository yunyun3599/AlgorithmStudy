import java.util.*;
import java.io.*;


public class _2240_최윤재_자두나무 {

	static int T;	//총 시
	static int W;	//최대 움직일 수 있는 횟
	static int[][][] dp;	//dp[T][W][0]은 T초후에 W번 움직여서 0번 위치에 있을 때 먹을 수 있는 자두의 최대 개
	static int result = 0;	//최종 결
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		dp = new int[T+1][W+1][3];
		/////////////////////////////////////입
		for(int i=1; i<=T; i++) {	//각 초마다 확인 
			int drop = Integer.parseInt(br.readLine());	//떨어지는 나무 위치 
			if(drop==1) dp[i][0][1] = dp[i-1][0][1]+1;	//움직이지 않는 경우는 떨어지는 나무 위치가 1일 때 1번 위치에 대해서 하나씩 증가 
			for(int j=1; j<=W; j++) {	//움직이는 경우의 수 
				if(drop==1) {	//1번나무에서 떨어졌을 때
					dp[i][j][1] = Math.max(dp[i-1][j-1][2]+1, dp[i-1][j][1]+1);	//1번 나무에 위치해있으면 이전에 2번에 있었을 때와 1번에 있었을 때의 경우 중 더 큰 값 + 1 값을 가짐 
					dp[i][j][2] = Math.max(dp[i-1][j][2], dp[i-1][j-1][1]);	//2번 나무에 위치해있으면 이전에 1번에 있었을 때와 2번에 있었을 때의 경우 중 더 큰 값 그대로 가져
				}
				else {		//2번 나무에서 떨어졌을 때 점화식은 1번 나무에서 떨어졌을 때와 같은 로
					dp[i][j][1] = Math.max(dp[i-1][j-1][2], dp[i-1][j][1]);
					dp[i][j][2] = Math.max(dp[i-1][j][2]+1, dp[i-1][j-1][1]+1);
				}
			}			
		}
		for(int i=0; i<W+1; i++) {	//T초 후의 경우 움직인 횟수를 확인하며 최대값 result에 저장 
			result = Math.max(Math.max(result, dp[T][i][1]), dp[T][i][2]);
		}
		System.out.println(result);
	}

}
