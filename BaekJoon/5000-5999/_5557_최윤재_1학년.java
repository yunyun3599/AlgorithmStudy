package tmp;
import java.io.*;
import java.util.StringTokenizer;
public class _5557_최윤재_1학년 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int input[] = new int[N-1];
		long dp[][] = new long[N-1][21];	//row번쨰 숫자를 계산한 후에 나올 수 있는 결과가 column인 경우의 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		int target = Integer.parseInt(st.nextToken());	//최종적으로 만들 숫자
		////////////////////입력
		
		dp[0][input[0]] = 1;
		for(int i=1; i<N-1; i++) {	//각 숫자에 대해 수행
			for(int j=0; j<21; j++) {
				if(dp[i-1][j]>0) {		//이전 숫자까지 계산했을 떄 j를 만들 수 있는 경우
					if(j-input[i]>=0) {	//이번 숫자를 뺀 결과가 범위 이내인 경우
						dp[i][j-input[i]] += dp[i-1][j];
					}
					if(j+input[i] <=20) {
						dp[i][j+input[i]] += dp[i-1][j];
					}
				}
			}
		}
		System.out.println(dp[N-2][target]);	//결과 출력
	}

}
