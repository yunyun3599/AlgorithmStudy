package week11;
import java.util.*;
public class _11051_최윤재_이항계수2 {

	static int N;								//NCK
	static int K;
	static int[][] dp;							//이항계수 값들 저장
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		dp = new int[N+1][N+1];
		
		for(int i=0; i<=N; i++) {
			dp[i][0] = 1;						//해당 행에서 0번째자리와 마지막 자리 값은 항상 1
			dp[i][i] = 1;
			for(int j=1; j<i; j++)
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007;	//자신의 왼쪽 위 값 + 오른쪽 위 값 이 자신의 값
		}

		System.out.println(dp[N][K]);
	}

}

//이항계수2