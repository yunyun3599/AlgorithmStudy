package tmp;
import java.io.*;
import java.util.*;

class Loc {		//Queue에 넣을 값
	int y;
	int x;
	int broken;	//벽 부순 적 있는지
	int D;	//거리
	Loc(int y, int x, int broken, int D){
		this.y = y;
		this.x = x;
		this.broken = broken;
		this.D = D;
	}
}

public class _14923_최윤재_미로탈출 {

	static int N, M, Hx, Hy, Ex, Ey;
	static int[][] map;
	static int[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		Hy = Integer.parseInt(st.nextToken())-1;
		Hx = Integer.parseInt(st.nextToken())-1;
		st = new StringTokenizer(br.readLine(), " ");
		Ey = Integer.parseInt(st.nextToken())-1;
		Ex = Integer.parseInt(st.nextToken())-1;
		map = new int[N][M];
		visited = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}////////////////////////////////////////////////입력
		Queue<Loc> queue = new LinkedList<>();	//bfs
		queue.add(new Loc(Hy, Hx, 0, 0));	//처음 위치 넣기
		visited[Hy][Hx] = 1;	//visited가 0이면 아직 안간 곳, 1이면 벽 안부수고 간 곳 2면 벽 부순 후에 간 곳
		while(!queue.isEmpty()) {
			Loc cur = queue.poll();
			if(cur.x==Ex && cur.y == Ey) {	//목적지 도달했을 때
				System.out.println(cur.D);
				System.exit(0);
			}
			for(int k=0; k<4; k++) {
				int ny = cur.y+dy[k];
				int nx = cur.x+dx[k];
				if(check(ny, nx)) {		//map상에 있는 좌표이고 visited가 1이 아닐 때만 확인해봄(visited가 1이면 해당 경로가 더 최소값이므로 굳이 할 필요 X)
					if(cur.broken==0 && map[ny][nx]==1) {	//확인해볼 곳이 벽일 때
						if(visited[ny][nx]==0) queue.add(new Loc(ny, nx, 1, cur.D+1));
						visited[ny][nx] = 2;	//벽 부수고 이동했으므로 visited값은 2
					}
					if(map[ny][nx] == 0) {	//벽이 아닌 경우
						if(cur.broken==1 && visited[ny][nx]==0) {	//이전에 벽을 부순 적이 있을 때
							if(visited[ny][nx]==0) queue.add(new Loc(ny, nx, 1, cur.D+1));
							visited[ny][nx] = 2;
						}
						else if(cur.broken==0) {	//이전에 벽을 부순 적이 없을 때
							queue.add(new Loc(ny, nx, 0, cur.D+1));
							visited[ny][nx]  = 1;
						}
					}
				}
			}
		}
		System.out.println(-1);	//도달하지 못하는 경우
	}
	public static boolean check(int y, int x) {
		if (y>=0 && x>=0 && y<N && x<M && visited[y][x]!=1) return true;
		return false;
	}

}
