package tmp;
import java.io.*;
import java.util.*;

class Loc {					//좌표와 이동 거리, 공사여부를 저장
	int y, x, dist, drill;
	Loc(int y, int x, int dist, int drill){
		this.y = y;
		this.x = x;
		this.dist = dist;
		this.drill = drill;
	}
}

public class _2206_최윤재_벽부수고이동하기 {

	static int width;
	static int height;
	static int[][] map;
	static int[][] visited;
	static int min = Integer.MAX_VALUE;
	static int[] axis_x = {0,0,-1,1};
	static int[] axis_y = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		map = new int[height][width];
		visited = new int[height][width];
		
		for(int i=0; i<height; i++) {
			String tmp = br.readLine();
			for(int j=0; j<width; j++) {
				map[i][j] = tmp.charAt(j)-'0';
				visited[i][j] = Integer.MAX_VALUE;
			}
		}///////////////////////////////////////////////입력
		bfs();	//bfs돌리기
		if(min == Integer.MAX_VALUE) System.out.println(-1);	//불가능한 경우에는 -1 출력
		else System.out.println(min);
	}
	public static void bfs() {
		Queue<Loc> queue = new LinkedList<>();	//visited의 경우 해당 자리까지 왔을 때 공사를 한 적이 있으면 1을 저장, 아니면 0을 저장
		queue.add(new Loc(0,0,1,0));	//y좌표, x좌표, 이동거리
		visited[0][0] = 0;				//첫 칸은 아직 공사 안함
		while(!queue.isEmpty()) {		//bfs돌리기
			Loc loc = queue.poll();
			if(loc.y==height-1 && loc.x==width-1) {	//목적지 도착
				min = loc.dist;		//결과물 업데이트
				return;
			}
			for(int k=0; k<4; k++) {	//상하좌우 탐색
				int y = loc.y + axis_y[k];
				int x = loc.x + axis_x[k];
				if(check(y,x)) {		//갈 수 있는 범위일 때
					if(visited[y][x] > loc.drill) {	//만약에 아직 방문하지 않은 경우거나 공사를 진행한 후에 방문한 적이 있는데 이번 방문 시도는 공사를 아직 하지 않은 경우에 한해 queue에 넣음
						if(map[y][x]==0) {	//벽이 없는 경우
							queue.add(new Loc(y,x,loc.dist+1,loc.drill));
							visited[y][x] = loc.drill;	//visited에는 현재 온 경로에 의해 공사한적이 있는지, 없는지를 그대로 받아 넣게 됨
						}
						else {		//벽이있는 경우
							if(loc.drill==0) {	//아직 벽을 한번도 안부순 경우에 한해서만 가기
								queue.add(new Loc(y,x,loc.dist+1,loc.drill+1));
								visited[y][x] = loc.drill+1;	//visited에는 공사를 한 경우에 이 자리에 온 적이 있다고 표시
							}
						}
					}
				}
			}
		}
	}
	
	public static boolean check(int y, int x) {	//map상에 존재하는지 범위 확인
		if(y >= 0 && y < height && x >= 0 && x < width) return true;
		return false;
	}
	
}
