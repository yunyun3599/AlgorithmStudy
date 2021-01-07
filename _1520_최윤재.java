package week8;
import java.io.*;

class signal{
	boolean flag=false;
	int up = 0;
	int down = 0;
	int left = 0;
	int right = 0;	
}

public class _1520_√÷¿±¿Á {
	static int[] axis_x= {0,0,-1,1};
	static int[] axis_y= {-1,1,0,0};
	static int[][] map;
	static int[][] dp;
	static int height;
	static int width;
	static signal[][] signal_arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp1 = br.readLine().split(" ");
		height=Integer.parseInt(tmp1[0]);
		width=Integer.parseInt(tmp1[1]);
		map=new int[height][width];
		dp=new int[height][width];
		signal_arr = new signal[height][width];
		
		for(int i=0; i<height; i++) {
			String[] tmp2=br.readLine().split(" ");
			for(int j=0; j<width; j++) {
				map[i][j]=Integer.parseInt(tmp2[j]);
				signal_arr[i][j]=new signal();
			}
		}
		
		dp[0][0]=1;
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				for(int k=0; k<4; k++) {						//0ªÛ 1«œ 2¡¬ 3øÏ
					int next_x = j + axis_x[k];
		            int next_y = i + axis_y[k];
		            if(next_x >=0 && next_y >=0 && next_x < width && next_y < height && map[next_y][next_x]<map[i][j]) {
		            	dp[next_y][next_x]+=dp[i][j];
		            	switch(k) {
		            	case 0: signal_arr[i][j].up=1;
		            			break;
		            	case 1: signal_arr[i][j].down=1;
		            			break;
		            	case 2: signal_arr[i][j].left=1;
		            			break;
		            	case 3: signal_arr[i][j].right=1;
		            			break;
		            	}
		            	check(next_x, next_y, j, i);
		            }
				}
			}
		}
		System.out.println(dp[height-1][width-1]);
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void check(int next_x, int next_y, int cur_x, int cur_y) {
		if(signal_arr[next_y][next_x].up==1) {
			dp[next_y-1][next_x]+=dp[cur_y][cur_x];				//ªÛ
			check(next_y-1,next_x,cur_x,cur_y);
		}
    	if(signal_arr[next_y][next_x].down==1) {
    		dp[next_y+1][next_x]+=dp[cur_y][cur_x];				//«œ
    		check(next_y+1,next_x,cur_x,cur_y);
    	}
    	if(signal_arr[next_y][next_x].left==1) {
    		dp[next_y][next_x-1]+=dp[cur_y][cur_x];				//¡¬
    		check(next_y,next_x-1,cur_x,cur_y);
    	}
    	if(signal_arr[next_y][next_x].right==1) {
    		dp[next_y][next_x+1]+=dp[cur_y][cur_x];				//øÏ
    		check(next_y,next_x+1,cur_x,cur_y);
    	}
	}
}









