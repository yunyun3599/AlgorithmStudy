package tmp;
import java.io.*;
import java.util.*;

class Loc{			//queue에 넣을 위치
	int y;
	int x;
	int time;
	Loc(int y, int x, int time){
		this.y = y;
		this.x = x;
		this.time = time;
	}
}

public class _3055_최윤재_탈출 {

	static int R;
	static int C;
	static char[][] map;
	static boolean[][] visited;
	static Queue<Loc> queue = new LinkedList<>();	//고슴도치 위치
	static Queue<Loc> water = new LinkedList<>();	//물 위치
	static int[] axis_x = {-1,1,0,0};
	static int[] axis_y = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			String tmp = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = tmp.charAt(j);
				if(map[i][j]=='S') {		//고슴도치 초기 위치 queue에 저장
					queue.add(new Loc(i, j, 0));
					map[i][j]='.';
					visited[i][j] = true;
				}
				if(map[i][j]=='*') {	//물이 있는 위치들 저장
					water.add(new Loc(i,j,0));
				}
			}
		}
		while(!queue.isEmpty()) {		//고슴도치가 갈 곳이 없을 때까지 반복
			int dfs_rotation = water.size();	//물을 한칸씩 퍼뜨리기 위해 현재 물이 있는 위치 개수 구함
			for(int i=0; i<dfs_rotation; i++) {	//현재 있는 물 기준으로만 상하좌우 퍼뜨림
				Loc water_loc = water.poll();
				dfs(water_loc.y, water_loc.x);
			}
			int rotation = queue.size();	//현재 저장된 위치들에서 상하좌우 이동
			for(int iter=0; iter<rotation; iter++) {
				Loc loc = queue.poll();
				for(int k=0; k<4; k++) {
					int next_y = loc.y+axis_y[k];
					int next_x = loc.x+axis_x[k];
					if(check(next_y, next_x) && map[next_y][next_x]=='D') {	//다음 이동할 장소가 비버집일때
						System.out.println(loc.time+1);
						System.exit(0);
					}
					if(check(next_y, next_x) && map[next_y][next_x]=='.' && !visited[next_y][next_x]) {	//다음으로 이동할 수 있는 구간이 있는 경우
						queue.add(new Loc(next_y, next_x, loc.time+1));
						visited[next_y][next_x]=true;
					}
				}
			}
		}
		System.out.println("KAKTUS");	//비버 집에 못간 경우
	}
	public static void dfs(int y, int x) {	//물 한칸씩 늘리기
		for(int k=0; k<4; k++) {	//상하좌우
			int next_y = y+axis_y[k];
			int next_x = x+axis_x[k];
			if(check(next_y, next_x) && map[next_y][next_x]=='.') {	//빈 위치만 가능
				map[next_y][next_x] = '*';	//map상 표기
				water.add(new Loc(next_y, next_x, 0));	//queue에 물 있는 위치 더하기
			}
		}
	}
	public static boolean check(int y, int x) {	//범위 체크
		if(y>=0 && x>=0 && y<R && x<C) return true;
		return false;
	}
}
