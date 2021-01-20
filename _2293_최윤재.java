package week10;
import java.io.*;
import java.util.*;
public class _2293_최윤재 {

	static int[] value;
	static int[] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		value = new int[num];										//동전의 액수 저장
		dp = new int[target+1];										//각 금액별 가능한 경우 수 저장 (dp[1000]이면 1000원을 만들 수 있는 경우의 수)
		for(int i=0; i<num; i++) {
			value[i] = Integer.parseInt(br.readLine());
		}
		///////////////////////////////////////////////////////////입력

		
		for(int i=0; i<num; i++) {									//각 동전별로 수행
			if (value[i] <= target) dp[value[i]] += 1;				//딱 동전 하나로 해당 금액을 만드는 경우 1가지를 우선 더함. (총액보다 동전 금액이 큰 경우가 있기 때문에 조건문 안쓰면 런타임 에러남)
			for(int j = value[i]+1; j<=target; j++) {				//해당 동전 액수만큼 빠진 값을 더하면 그 동전을 포함했을 때 개수 구할 수 있음
				dp[j] += dp[j - value[i]];
			}
		}
		System.out.println(dp[target]);
	}

}
