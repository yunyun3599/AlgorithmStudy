package tmp;
import java.util.*;
import java.io.*;

class Location{		//queue에 넣을 정보
	int y;
	int x;
	int move;
	Location(int y, int x, int move){
		this.y = y;
		this.x = x;
		this.move = move;
	}
}

public class _2589_최윤재_보물섬 {
	
	static int width;
	static int height;
	static char map[][];
	static boolean visited[][];
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int dist;	//최종 결과(가장 먼 거리)
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		map = new char[height][width];
		
		for(int i=0; i<height; i++) {	//input 처리
			String input = br.readLine();
			for(int j=0; j<width; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		for(int i=0; i<height; i++) {	//각 L들을 시작점으로 해서 bfs 모두 수행해봄
			for(int j=0; j<width; j++) {
				if(map[i][j]=='L') {
					visited = new boolean[height][width];	//방문 처리용 배열
					Queue<Location> q = new LinkedList<>();	//queue
					q.add(new Location(i, j, 0));	//시작점 add
					visited[i][j] = true;	//방문 처리
					int tmp_dist = 0;	//이번 위치가 시작점일 때 가장 먼 거리
					while(!q.isEmpty()) {
						Location loc = q.poll();
						tmp_dist = loc.move;	//가장 먼 거리 업데이트
						for(int k=0; k<4; k++) {	//상하좌우 탐색
							int y = loc.y + dy[k];
							int x = loc.x + dx[k];
							if(check(y,x)) {	//새로 갈 수 있는 경우에 한해서 queue에 add
								q.add(new Location(y,x, loc.move+1));
								visited[y][x] = true;	//방문처리
							}
						}
					}
					dist = Math.max(tmp_dist, dist);	//지금까지 최장거리와 이번 시도의 최장거리 중 더 긴 값을 저장
				}
			}
		}
		System.out.println(dist);	//결과 출력
	}
	public static boolean check(int y, int x) {
		if(0<=y && 0<=x && y<height && x<width && !visited[y][x] && map[y][x]=='L') return true;
		return false;
	}
}
