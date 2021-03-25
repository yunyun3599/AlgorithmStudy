package week12;
import java.io.*;
import java.util.*;
public class _1890_최윤재_점프 {

	static int[][] map;
	static long[][] dp;							//int로 하면 틀림
	static int width;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		width = Integer.parseInt(br.readLine());
		map = new int[width][width];
		dp = new long[width][width];
		
		for(int i=0; i<width; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<width; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//////////////////////////////////////////////////////////////// 입력
		dp[0][0]=1;
		for(int i=0; i<width; i++) {									//각각 map에 저장된 수만큼 이동했을 때 map을 벗어나지 않는 경우에 한하여 수행
			for(int j=0; j<width; j++) {
				if((i == width-1) && (j == width-1)) break;
				int jump = map[i][j];
				if (i+jump < width) dp[i+jump][j] += dp[i][j];
				if (j+jump < width) dp[i][j+jump] += dp[i][j];
				
			}
		}
		System.out.println(dp[width-1][width-1]);
		
	}

}
