package week8;
import java.util.*;
public class _9251_최윤재 {
	
	static int[][] dp;
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input1=sc.nextLine();
		String input2=sc.nextLine();
/////////////////////////////////////////////////////////////////////////입력
		
		dp=new int[input1.length()+1][input2.length()+1];			//각 문자열의 길이보다 1씩 크게 dp 배열 생성
		
		
		for(int i=0; i<input1.length(); i++) {						//앞의 값들을 비교하여 뒷 값 채움
			for(int j=0; j<input2.length(); j++) {
				if(input1.charAt(i)==input2.charAt(j)) dp[i+1][j+1]=dp[i][j]+1;		//값들이 같은 경우 대각선 위치 칸의 값은 현재칸 값 +1
				else dp[i+1][j+1]=Math.max(dp[i][j+1], dp[i+1][j]);					//값이 다른 경우 대각선 위치 칸의 값은 위나 옆 값 중 큰 값 그대로
			}
		}
		System.out.println(dp[input1.length()][input2.length()]);
	}
}




//LCS