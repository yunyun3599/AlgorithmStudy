import java.io.*;
import java.util.*;
public class _1987_최윤재_알파벳 {

	static int R;
	static int C;
	static char[][] map;
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,-1,1};
	static boolean visited[] = new boolean[26];
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		/////////////////////입력 
		dfs(0, 0, 1);	//dfs로 확인 
		System.out.println(result);
	}
	
	public static void dfs(int y, int x, int dist) {
		int idx = map[y][x] - 'A';	//방문 처리 
		visited[idx] = true;
		boolean canMove = false;	//더 이동이 가능한 지 
		for(int k=0; k<4; k++) {	//상하좌우 
			int ny = y + dy[k];
			int nx = x + dx[k];
			if(check(ny, nx) && !visited[map[ny][nx]-'A']) {	//이동이 가능한 경우 
				canMove = true;
				dfs(ny, nx, dist+1);
			}
		}
		if(!canMove) result = Math.max(result, dist);	//모든 경우에서 이동이 불가능하면 결과 업데이트 
		visited[idx] = false;
	}
	
	public static boolean check(int y, int x) {	//범위 체크 
		if(0<= y && 0 <= x && y<R && x<C) return true;
		return false;
	}

}
