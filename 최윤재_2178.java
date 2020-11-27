package graph;
import java.util.*;
import java.io.*;

public class 최윤재_2178 {

	static int maze[][];
	static int visited[][];
	static int axis_x[] = {0,0,-1,1};
	static int axis_y[] = {-1,1,0,0};	//싱하좌우
	static int row;
	static int column;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		row = Integer.parseInt(st.nextToken());
		column = Integer.parseInt(st.nextToken());
		
		maze=new int[row][column];
		visited= new int[row][column];
		
		for(int i=0; i<row; i++) {
			String temp= br.readLine();
			for(int j=0; j<column; j++) {
				maze[i][j]=temp.charAt(j)-'0';				
			}
		}
		bfs();
		System.out.println(maze[row-1][column-1]);
	}

	
	static void bfs() {
	    Queue<Integer> x = new LinkedList<Integer>(); //x값에 대한 Queue
	    Queue<Integer> y = new LinkedList<Integer>(); //y값에 대한 Queue
	    
	    x.offer(0); //저장
	    y.offer(0);
	    
	    visited[0][0] = 1;
	    
	    while(!x.isEmpty()) {
	      int cur_x = x.poll();
	      int cur_y = y.poll();
	      
	      //상하좌우 확인
	      for(int k = 0; k < 4;k++) {
	        int next_x = cur_x + axis_x[k];
	        int next_y = cur_y + axis_y[k];
	        
	        //유효한 범위인지 확인
	        if(next_x >= 0 && next_y >= 0 && next_x < row && next_y < column) {
	          if(maze[next_x][next_y] == 1 && visited[next_x][next_y] == 0) {
	            x.offer(next_x);
	            y.offer(next_y);
	            
	            visited[next_x][next_y] = 1;
	            
	            maze[next_x][next_y] = maze[cur_x][cur_y] + 1; //이동횟수
	          }
	        }
	      }
	    }
	}
}
