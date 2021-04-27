package tmp;
import java.io.*;
import java.util.*;

class Shark{		//현재 위치와 얼마나 이동했는지 계산
	int y;
	int x;
	int dist;
	Shark(int y, int x, int dist) {
		this.y=y;
		this.x = x;
		this.dist = dist;
	}
}
public class _17086_최윤재_아기상어 {
	
	static int[][] map;
	static int width;
	static int height;
	static int[] axis_x = {-1,-1,-1,0,0,1,1,1};	//상하좌우대각선 커버
	static int[] axis_y = {-1,0,1,-1,1,-1,0,1};
	static int result = 0;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		map = new int[height][width];
		
		for(int i=0; i<height; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<width; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		////////////////////////////////////////////////////////입력
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				if(map[i][j]==0) {					//0인 자리에 대해 bfs 수행
					result = Math.max(result, bfs(i,j));	//bfs수행해서 가장 가까운 상어와의 거리가 현재까지 최대값보다 크면 업데이트
				}
			}
		}
		System.out.println(result);
	}
	public static int bfs(int y, int x) {		//bfs 수행 코드
		visited = new boolean[height][width];
		Queue<Shark> queue = new LinkedList<>();	//queue
		queue.add(new Shark(y, x, 0));	//초기 위치 queue에 넣기
		visited[y][x] = true;		//방문처리
		while(!queue.isEmpty()) {	//queue가 빌때까지 수행
			Shark shark = queue.poll();	//이전 위치 뽑기
			for(int i=0; i<8; i++) {	//해당 위치에 대해 상하좌우 대각선으로 이동
				int next_y = shark.y + axis_y[i];	//다음에 가게 될 좌표
				int next_x = shark.x + axis_x[i];
				if(0<=next_y && next_y<height && 0<=next_x && next_x<width && !visited[next_y][next_x]) {	//map상에 있고, 아직 방문하지 않은 경우
					if(map[next_y][next_x]==1) return shark.dist+1;		//만약 상어를 만나면 거리 하나 늘려서 리턴해줌
					queue.add(new Shark(next_y, next_x, shark.dist+1));	//이번에 도착한 위치 queue에 넣음
					visited[next_y][next_x]=true;	//방문처리해주기
				}
			}
		}
		return -1;	//상어는 최소 한마리는 있으므로 불가능한 경우
	}
}
