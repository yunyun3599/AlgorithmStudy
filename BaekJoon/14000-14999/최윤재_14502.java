package graph;
import java.util.*;


public class √÷¿±¿Á_14502 {
	
	static int row, column;
	static int lab[][];
	static int axis_x[] = {0,0,-1,1};
	static int axis_y[] = {-1,1,0,0};	//ªÛ«œ¡¬øÏ
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		row=sc.nextInt();
		column=sc.nextInt();
		lab=new int[row][column];
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<column; j++) {
				lab[i][j]=sc.nextInt();
			}
		}
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<column; j++) {
				if(lab[i][j]==0) {
					lab[i][j]=1;
					buildWall(1,0);
					lab[i][j]=0;
				}
			}
		}
		System.out.println(result);
	}
	
	static void buildWall(int wall, int idx) {
		if(wall==3) {
			bfs();
			return;
		}
		for(int i=idx; i<row ; i++) {
			for(int j=0; j<column; j++) {
				if(lab[i][j]==0) {
					lab[i][j]=1;
					buildWall(wall+1, i);
					lab[i][j]=0;
				}
			}
		}
	}
	
	static void bfs() {
		int[][] infectedLab = new int[row][column];
		for(int i=0; i<row; i++) {
			for(int j=0; j<column; j++) {
				infectedLab[i][j]=lab[i][j];
			}
		}
		
		Queue<int[]> queue = new LinkedList<int[]>();
		for(int i=0; i<row; i++) {
			for(int j=0; j<column; j++) {
				if(infectedLab[i][j]==2) {
					queue.add(new int[]{i,j});
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int[] temparr = queue.poll();
			int cur_x=temparr[0];
			int cur_y=temparr[1];
			
			for(int i=0; i<4; i++) {
				int new_x=cur_x+axis_x[i];
				int new_y=cur_y+axis_y[i];
				if(new_x>=0 && new_y>=0 && new_x<row && new_y<column) {
					if(infectedLab[new_x][new_y]==0) {
						infectedLab[new_x][new_y]=2;
						queue.add(new int[] {new_x,new_y});
					}
				}
			}
		}
		int temp=0;
		for(int i=0; i<row;i++) {
			for(int j=0; j<column; j++) {
				if(infectedLab[i][j]==0) temp++;
			}
		}
		result=Math.max(result, temp);
	}

}

