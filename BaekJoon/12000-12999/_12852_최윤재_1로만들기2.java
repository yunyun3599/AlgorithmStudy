package tmp;
import java.io.*;
public class _12852_최윤재_1로만들기2 {

	static int input;
	static int dp[];
	static int history[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		input = Integer.parseInt(br.readLine());
		dp = new int[input+1];
		history = new int[input+1];	//하나빼서 만들었는지 2로 나눠 만들었는지 3으로 나눠 만들었는지를 1,2,3값으로 저장
		
		for(int i=2; i<input+1; i++) {	//dp 값 구함
			int three = Integer.MAX_VALUE;	//3으로 나눈 값
			int two = Integer.MAX_VALUE;	//2로 나눈 값
			int one = dp[i-1]+1;	//1로 뺀 값은 dp[i-1]+1임
			if(i%3==0) three = dp[i/3] + 1;	//나눠지는 경우 값 채우기
			if(i%2==0) two = dp[i/2] + 1;	//나눠지는 경우 값 추가하기
			dp[i] = Math.min(three, Math.min(two, one));	//가장 작은 값 찾기
			if(i%3==0 && dp[i]-1 == dp[i/3]) history[i] = 3;	//어떤 값으로부터 계산했는지 저장
			else if(i%2 == 0 && dp[i]-1 == dp[i/2]) history[i] = 2;
			else history[i] = 1;
		}
		
		bw.write(dp[input]+"\n");	//결과 횟수 출력
		while(input>0) {	//히스토리 출력
			bw.write(input+" ");
			if(history[input]==3 || history[input]==2) input /= history[input];	//2나 3으로 나눠지면 나눈 값으로 인덱스가 줄어듦
			else input--;	//하나 빼서 만든 경우면 인덱스를 1 줄이기
		}
		bw.close();
		br.close();
	}

}
