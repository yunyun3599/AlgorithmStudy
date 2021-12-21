import java.io.*;
import java.util.*;

public class _1405_최윤재_미친로봇 {
	
	static int N;
	static double east;
	static double west;
	static double south;
	static double north;
	static double result;
	static boolean[][] visited;
	static int[] dy = {0,0,-1,1};	//동서남북 
	static int[] dx = {1,-1,0,0};
	static double[] dir = new double[4];	//동서남북 확률 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i=0; i<4; i++) dir[i] = Integer.parseInt(st.nextToken()) * 0.01;
		visited = new boolean[2*N+1][2*N+1];
		
		calc(N, N, 0, 1);	//시작은 정가운데에서 
		System.out.println(result);
	}
	
	public static void calc(int y, int x, int move, double probability) {	//재귀호출 
		if(move == N) {	//이동 횟수 다 쓴 경우 
			result += probability;	//결과에 현재까지 경로로 오는 확률 더하기 
			return;
		}
		visited[y][x] = true;	//현재 칸에 대한 visited를 true로
		for(int i=0; i<4; i++) {	//동서남북의 경우
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(!visited[ny][nx]) calc(ny, nx, move+1, probability * dir[i]);	//아직 방문 안한 칸에 대해서만 다음 칸으로 이동 
		}
		visited[y][x] = false;
	}

}
