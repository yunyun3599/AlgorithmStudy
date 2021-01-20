package week10;
import java.util.*;
public class _2631_최윤재 {

	static int num;
	static int[] children;			//학생 수 저장
	static int[] dp;				//dp 배열
	static int max;					//최장증가부분수열 값
	
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		
		children = new int[num];
		dp = new int[num];
		for(int i=0; i<num; i++) {
			children[i] = sc.nextInt();
			dp[i] = 1;
		}
		//////////////////////////////////////////////입력
		
		dynamic(1);									//다이나믹 프로그래밍
		System.out.println(num-max);				//총 학생수 - 최장증가부분수열값 이 정답
	}
	
	static void dynamic(int idx) {
			for(int i=0; i<idx; i++) {
			if((children[i] < children[idx]) && (dp[idx] < dp[i] + 1)) {	//해당 학생의 숫자가 이전 학생의 숫자보다 큰 경우 가장 길어질 수 있는 값 저장
				dp[idx] = dp[i] + 1;
			}
		}
		if (dp[idx] > max) max=dp[idx]; 			//가장 긴 부분증가수열 값 업데이트
		if(idx < num-1) dynamic(idx+1);				//다음 학생에 대해 수행
	}
}






//줄세우기
