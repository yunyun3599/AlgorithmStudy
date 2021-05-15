package tmp;
import java.io.*;
import java.util.*;
public class _11048_√÷¿±¿Á_¿Ãµø«œ±‚ {
	
	static int height;
	static int width;
	static int[][] map;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		map = new int[height+1][width+1];
		dp = new int[height+1][width+1];
		for(int i=1; i<height+1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<width+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//////////////////////////////////////////////////////////¿‘∑¬
		for(int i=1; i<height+1; i++) {			//dp ºˆ«‡ ¡¬, ªÛ, ¡¬ªÛ
			for(int j=1; j<width+1; j++) {
				dp[i][j] = Math.max(dp[i-1][j-1], Math.max(dp[i][j-1], dp[i-1][j])) + map[i][j];
			}
		}		
		System.out.println(dp[height][width]);
	}
}
