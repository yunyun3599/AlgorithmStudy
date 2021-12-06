package tmp;
import java.util.*;
import java.io.*;

class Location implements Comparable<Location>{
	int y;
	int x;
	int broken;
	Location(int y, int x, int broken) {
		this.y = y;
		this.x = x;
		this.broken = broken;
	}
	public int compareTo(Location other) {
		return this.broken - other.broken;
	}
}

public class _1261_¾Ë°í½ºÆÌ {

	static int[][] map;
	static int[][] dist;
	static int N;
	static int M;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dist = new int[N][M];
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = input.charAt(j)-'0';
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		dijkstra();
		System.out.println(dist[N-1][M-1]);
	}
	public static void dijkstra() {
		PriorityQueue<Location> pq = new PriorityQueue<>();
		dist[0][0] = 0;
		pq.add(new Location(0, 0, 0));
		while(!pq.isEmpty()) {
			Location cur = pq.poll();
			for(int k=0; k<4; k++) {
				int ny = cur.y + dy[k];
				int nx = cur.x + dx[k];
				if(check(ny, nx)) {
					int nbroken = cur.broken;
					if(map[ny][nx]==1) {
						nbroken++;
					}
					if(nbroken < dist[ny][nx]) {
						dist[ny][nx] = nbroken;
						pq.add(new Location(ny, nx, nbroken));
					}
				}
			}
		}
	}
	public static boolean check(int y, int x) {
		if(0<=y && 0<=x && y<N && x<M) {
			return true;
		}
		return false;
	}

}
