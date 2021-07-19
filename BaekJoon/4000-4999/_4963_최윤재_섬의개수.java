package tmp;
import java.io.*;
import java.util.*;

public class _4963_ÃÖÀ±Àç_¼¶ÀÇ°³¼ö {

	static int width;
	static int height;
	static int[][] map;
	static boolean[][] visited;
	static int count;
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		while(width!=0 && height !=0) {
			map = new int[height][width];
			visited = new boolean[height][width];
			count = 0;
			for(int i=0; i<height; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<width; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0; i<height; i++) {
				for(int j=0; j<width; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						count++;
						dfs(i, j);
					}
				}
			}
			sb.append(count+"\n");
			st = new StringTokenizer(br.readLine()," ");
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
		}
		System.out.println(sb);
	}
	public static void dfs(int y, int x) {
		visited[y][x] = true;
		for(int k=0; k<8; k++) {
			int ny = y+dy[k];
			int nx = x+dx[k];
			if(check(ny, nx)) {
				dfs(ny, nx);
			}
		}
	}
	public static boolean check (int y, int x) {
		if(0<=y && 0<= x && y< height && x<width && !visited[y][x] && map[y][x]==1) return true;
		return false;
	}
}
