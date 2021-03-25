package graph;

import java.util.*;
import java.io.*;

public class _2206_최윤재 {
	
	static int[][] map;							//map 저장
	static int[] axis_x = {0,0,-1,1};			//상하좌우 탐색을 위한 배열
	static int[] axis_y = {-1,1,0,0};
	static int N;
	static int M;
	static int result = 1000001;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] strs = input.trim().split("\\s+");
		N= Integer.parseInt(strs[0]);
		M= Integer.parseInt(strs[1]);
		map=new int[N][M];
		
		for(int i=0; i<N; i++) {
			String line= br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j]=line.charAt(j)-'0';
			}
		}
		////////////////////여기까지 map 입력////////////////////////
		
		bfs(0, 0);								//벽을 안부수는 경우
		for(int i=0; i<N; i++) {				//모든 벽에 대해 한번씩 부숴본다..
			for(int j=0; j<M; j++) {
				if (map[i][j]==1) {
					bfs(i,j);
				}
			}
		}
		
		if(result==1000001) System.out.println(-1);		//갈 수 있는 길이 없다면 -1 출력
		else System.out.println(result);
		
	}
	
	static void bfs(int row, int col) {					//bfs
		int[][] copy = new int[N][M];					//map 복사
		for(int i=0; i<N; i++) {			
			for(int j=0; j<M; j++) {	
				copy[i][j]=map[i][j];					
				if(i==row && j==col) {					//벽 부수기
					copy[i][j]=0;
				}
			}
		}
		
		copy[0][0]=1;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {0,0});
		
		while(!queue.isEmpty()) {
			int[] temparr = queue.poll();
			int cur_x=temparr[0];
			int cur_y=temparr[1];
			
			for(int i=0; i<4; i++) {
				int new_x=cur_x+axis_x[i];
				int new_y=cur_y+axis_y[i];
				if(new_x>=0 && new_y>=0 && new_x<N && new_y<M) {
					if(copy[new_x][new_y]==0) {
						copy[new_x][new_y]=copy[cur_x][cur_y]+1;		//해당 칸으로 갈 수 있다면 이전 칸까지의 거리 +1값을 거기에 저장
						queue.add(new int[] {new_x,new_y});
					}
				}
			}
		}
		if (copy[N-1][M-1]!=0) result=Math.min(result,copy[N-1][M-1]);	//각 벽을 부수는 것에 대한 경우들을 모두 고려하여 최소값을 result에 저장
	}

}
