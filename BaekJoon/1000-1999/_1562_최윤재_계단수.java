package tmp;
import java.util.*;
public class _1562_최윤재_계단수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long dp[][][] = new long[N+1][10][1024];	//dp[i][j][k]이면 i번째 자리에 j가 올 때 사용한 0~9 숫자에 대한 비트마스킹이 k
		for(int i=1; i<=9; i++) {
			dp[1][i][1<<i] = 1;	//한자리 수에 대한 경우는 1~9를 쓰는 경우 1개씩
		}
		
		for(int i=2; i<=N; i++) {	//dp
			for(int j=0; j<=9; j++) {
				for(int visit = 0; visit < 1024; visit++) {	//i자리일 때 j를 마지막으로 쓴 경우 
					int newVisit = visit | (1<<j);	//새로 j를 쓰므로 j를 쓴 것을 포함해 새로 visit를 비트마스킹
					if(j==0) dp[i][j][newVisit] += dp[i-1][j+1][visit];	//j가 0일 때
					else if(j==9) dp[i][j][newVisit] += dp[i-1][j-1][visit];	//j가 9일 때
					else dp[i][j][newVisit] += dp[i-1][j-1][visit] + dp[i-1][j+1][visit];
					dp[i][j][newVisit] %= 1000000000;	//10억으로 나눈 나머지를 구해야함
				}
			}
		}
		long result = 0;
		for(int i=0; i<=9; i++) {	//마지막 수가 0~9일때까지 모든 가능한 경우의 수 합하기
			result += dp[N][i][1023];
		}
		System.out.println(result % 1000000000);
	}

}
