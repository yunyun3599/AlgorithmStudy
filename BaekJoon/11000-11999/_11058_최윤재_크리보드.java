package tmp;
import java.io.*;
import java.util.*;

public class _11058_최윤재_크리보드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N+1];
		for(int i=1; i<N+1; i++) {
			if(i<=6) {
				dp[i] = i;		//6번째까지는 그냥 횟수만큼이 최대값
				continue;
			}
			else {
				for(int j=2; j<5; j++) {		//앞의것을 붙여넣기 하는 게 하나 증가시키는 것 보다 크므로 3회 전부터 시작, 6회전 것부터는 3회전 것이 붙여넣기로 이미 테스트 해봤으믈 안해도 됨
					dp[i] = Math.max(dp[i-(j+1)]*j, dp[i]);	//선택,복사.붙여넣기 3단계가 필요하므로 3회 전의 것이면 2배, 4회 전의 것이면 3배, 5회 전의 것이면 4배가 됨
				}
			}
		}
		System.out.println(dp[N]);
	}

}
