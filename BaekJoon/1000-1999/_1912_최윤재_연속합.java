package week13;
import java.util.*;
public class _1912_최윤재_연속합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		int[] dp = new int[num];
		for(int i=0; i<num; i++)
			arr[i] = sc.nextInt();
		////////////////////////////////////////// 입력
		int max = dp[0] = arr[0];				// max에 현재가지 중 최대값 저장
		for(int i=1; i<num; i++) {
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);	//앞의 것과 연결되는 경우와 연결을 끊는 경우 중 더 큰 경우로 dp값 설정
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}
