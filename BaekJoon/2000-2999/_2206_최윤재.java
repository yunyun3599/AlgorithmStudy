package graph;

import java.util.*;
import java.io.*;

public class _2206_������ {
	
	static int[][] map;							//map ����
	static int[] axis_x = {0,0,-1,1};			//�����¿� Ž���� ���� �迭
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
		////////////////////������� map �Է�////////////////////////
		
		bfs(0, 0);								//���� �Ⱥμ��� ���
		for(int i=0; i<N; i++) {				//��� ���� ���� �ѹ��� �ν�����..
			for(int j=0; j<M; j++) {
				if (map[i][j]==1) {
					bfs(i,j);
				}
			}
		}
		
		if(result==1000001) System.out.println(-1);		//�� �� �ִ� ���� ���ٸ� -1 ���
		else System.out.println(result);
		
	}
	
	static void bfs(int row, int col) {					//bfs
		int[][] copy = new int[N][M];					//map ����
		for(int i=0; i<N; i++) {			
			for(int j=0; j<M; j++) {	
				copy[i][j]=map[i][j];					
				if(i==row && j==col) {					//�� �μ���
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
						copy[new_x][new_y]=copy[cur_x][cur_y]+1;		//�ش� ĭ���� �� �� �ִٸ� ���� ĭ������ �Ÿ� +1���� �ű⿡ ����
						queue.add(new int[] {new_x,new_y});
					}
				}
			}
		}
		if (copy[N-1][M-1]!=0) result=Math.min(result,copy[N-1][M-1]);	//�� ���� �μ��� �Ϳ� ���� ������ ��� ����Ͽ� �ּҰ��� result�� ����
	}

}
