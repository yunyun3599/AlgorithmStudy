package week11;
import java.io.*;
public class _2156_최윤재_포도주시식 {

	static int num;			//잔 개수
	static int[] wine;		//포도주 양 저장
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		wine = new int[num+1];
		dp = new int[num+1];
		for(int i=1; i<=num; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		/////////////////////////////////////////////////////////////////입력
		dp[1] = wine[1];
		if (num == 1) {						//잔이 하나인 경우
			System.out.println(dp[1]);
		}
		else if (num == 2) {				//잔이 두개인 경우
			System.out.println(wine[1] + wine[2]);
		}
		else {								//잔이 2개 이상인ㄱ ㅕㅇ우
			dp[2] = wine[1] + wine[2];
			for(int i=3; i<=num; i++) {
				dp[i] = Math.max(dp[i-3]+wine[i-1], dp[i-2]) + wine[i];	//바로 앞의 잔을 먹는 경우 or 앞앞잔을 먹는 경우
				dp[i] = Math.max(dp[i], dp[i-1]);						//연속으로 2개를 먹지 않는 경우
			}	
			System.out.println(dp[num]);
		}
	}
}
