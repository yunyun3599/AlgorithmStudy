package week17;
import java.util.*;
public class _1463_최윤재_1로만들기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N+1];	//해당 인덱스값을 만들기 위한 최소 횟수 저장
		dp[0] = dp[1] = 0;
		for(int i=2; i<=N; i++) {
			if(i%2 == 0 && i%3 == 0)	//6의 배수인 경우
				dp[i] = Math.min(dp[i-1], Math.min(dp[i/2], dp[i/3])) + 1;
			else if(i%2 == 0)			//2의 배수이고 3의 배수는 아닌 경우
				dp[i] = Math.min(dp[i-1], dp[i/2]) + 1;
			else if(i%3 == 0)			//3의 배수이고 2의 배수는 아닌 경우
				dp[i] = Math.min(dp[i-1], dp[i/3]) + 1;
			else dp[i] = dp[i-1] + 1;
		}
		System.out.println(dp[N]);		//결과 출력
	}

}
