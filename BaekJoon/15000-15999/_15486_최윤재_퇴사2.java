package tmp;
import java.io.*;
import java.util.*;
public class _15486_최윤재_퇴사2 {
	
	static int day;
	static int[][] table; 
	static int[] dp;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		day = Integer.parseInt(br.readLine());	//마지막날
		table = new int[day][2];
		dp = new int[day];
		for(int i=0; i<day; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			table[i][0] = Integer.parseInt(st.nextToken())-1;		//끝나는 날에 값 넣기 위해 걸리는 날-1을 넣어줌
			table[i][1] = Integer.parseInt(st.nextToken());			//일 처리하면 얻는 비용
		}
		
		for(int i=0; i<day; i++) {
			int complete_day = i+table[i][0];	//i번째 날에 시작한 일을 끝내는 날이 complete_day
			if(complete_day < day) dp[complete_day] = Math.max(dp[complete_day], max+table[i][1]);	//퇴사날을 넘어가지 않는 경우라면 현재 자신의 최대값과 i번째 날에 시작해 그날 끝나는 것 중 더 큰 값 고르기
			max = Math.max(max, dp[i]);	//i번째 날까지 일한 셈이므로 i번째 날까지의 최대값과 max값중 더 큰 값으로 설정
		}
		System.out.println(max);
	}
}
