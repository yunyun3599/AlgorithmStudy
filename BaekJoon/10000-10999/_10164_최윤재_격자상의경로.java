package tmp;
import java.util.*;

public class _10164_최윤재_격자상의경로 {
	
	static int row;		//행,열
	static int column;
	static int circled_num; //동그라미 숫자
	static int circled_row;	//동그라미 숫자의 행, 열
	static int circled_column;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		row = sc.nextInt();
		column = sc.nextInt();
		circled_num = sc.nextInt();
		circled_row = (circled_num-1) / column;
		circled_column = (circled_num-1) % column;
		
		int result = 0;	//최종 결과
		if(circled_num ==0) {	//동그라미 숫자가 없을 때
			result = getResult(row, column);	//그냥 그대로 dp
		}
		else {	//동그라미 숫자가 있을 때
			int before_circle = getResult(circled_row+1, circled_column+1);	//시작점부터 동그라미까지
			int after_circle = getResult(row-circled_row, column-circled_column);	//동그라미부터 도착점까지
			result = before_circle * after_circle;
		}
		
		System.out.println(result);
	}
	
	public static int getResult(int height, int width) {	//dp 수행 함수
		int[][] dp = new int[height][width];
		for(int i=0; i<height; i++) dp[i][0] = 1;	//1행과 1열의 값을 다 1로 채우기
		for(int j=0; j<width; j++) dp[0][j] = 1;
		for(int i=1; i<height; i++) {	//2행과 2열부터 시작
			for(int j=1; j<width; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];	//왼쪽값 + 위쪽값
			}
		}
		return dp[height-1][width-1];	//결과 리턴
	}
}
