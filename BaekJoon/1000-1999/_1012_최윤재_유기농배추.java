package week16;
import java.util.*;
import java.io.*;
public class _1012_최윤재_유기농배추 {
	
	static int testcase;
	static int[][] map;
	static boolean[][] visited;
	static int[] axis_x = {0, 0, -1, 1};
	static int[] axis_y = {-1, 1, 0, 0};
	static int width;
	static int height;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testcase = Integer.parseInt(br.readLine());
		for(int i=0; i<testcase; i++) {
			int count = 0;													//결과값
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			width = Integer.parseInt(st.nextToken());						//가로, 세로, 배추 개수 입력
			height = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			map = new int[height][width];
			visited = new boolean[height][width];
			for(int j=0; j<num; j++) {										//배추 자리 저장
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			for(int j=0; j<height; j++) {
				for(int k=0; k<width; k++) {
					if (map[j][k] == 1 && !visited[j][k]) {
						dfs(k, j);											//dfs이용해 연결요소 개수 구함
						count++;
					}
				}
			}
			sb.append(count+"\n");
			for(int j=0; j<height; j++) {
				for(int k=0; k<width; k++)
					visited[j][k]=false;
			}
		}
		System.out.println(sb);
	}
	public static void dfs(int x, int y) {
		visited[y][x] = true;
		for(int i=0; i<4; i++) {
			int next_x = x+axis_x[i];
			int next_y = y+axis_y[i];
			if(check(next_x, next_y)) dfs(next_x, next_y);
		}
	}
	public static boolean check(int x, int y) {
		if(0<=x && 0<=y && x<width && y<height && !visited[y][x]) {
			if(map[y][x]==1)
				return true;
		}
		return false;
	}
	

}
