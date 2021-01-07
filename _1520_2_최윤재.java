package week8;
import java.io.*;

public class _1520_2_√÷¿±¿Á {
	static int[] axis_x= {0,0,-1,1};
	static int[] axis_y= {-1,1,0,0};
	static int[][] map;
	static int[][] dp;
	static int height;
	static int width;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp1 = br.readLine().split(" ");
		height=Integer.parseInt(tmp1[0]);
		width=Integer.parseInt(tmp1[1]);
		map=new int[height][width];
		dp=new int[height][width];
		
		for(int i=0; i<height; i++) {
			String[] tmp2=br.readLine().split(" ");
			for(int j=0; j<width; j++) {
				map[i][j]=Integer.parseInt(tmp2[j]);
				dp[i][j]=-1;
			}
		}
		
		System.out.println(dfs(width-1, height-1));
	}
	
	public static int dfs(int x, int y) {
		if (x==0 && y==0) return 1;
		
		if(dp[y][x]==-1) {
			dp[y][x]=0;
			
			for(int i=0; i<4; i++) {						
				int next_x = x + axis_x[i];
	            int next_y = y + axis_y[i];
	            if(next_x >=0 && next_y >=0 && next_x < width && next_y < height && map[next_y][next_x]>map[y][x]) {
	            	dp[y][x]+=dfs(next_x, next_y);
	            }
			}
		}
		return dp[y][x];
	}
}