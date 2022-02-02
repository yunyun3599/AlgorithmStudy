import java.util.*;

public class _9658_최윤재_돌게임4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		boolean[] dp = new boolean[1001];
		
		dp[1] = false;	//돌이 1개 ~ 4개까지 있을 때의 결
		dp[2] = true;
		dp[3] = false;
		dp[4] = true;
		for(int i=5; i<=N; i++) {
			//돌은 1,3,4개를 가져갈 수 있으므로 돌 개수가 현재보다 1,3,4 작은 경우 중 한 경우라도 창영이가 이겼으면 이번에는 상영이가 승리
			dp[i] = !(dp[i-1] & dp[i-3] & dp[i-4]);	//dp[n] == false이면 창영이가 이긴 경우 
		}
		
		if(dp[N]) System.out.println("SK");
		else System.out.println("CY");
	}
}
