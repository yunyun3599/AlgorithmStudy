package tmp;
import java.util.*;
import java.io.*;
public class _2234_최윤재_성곽 {

	static int width;
	static int height;
	static boolean wall[][][];	//{서, 북, 동, 남} 벽의 유무 저장
	static int map[][][];		//map[행][열][구역, 넓이] 각 구역이 몇 구역인지와 해당 구역의 넓이 저장
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean visited[][];	//처음 bfs를 수행해서 넓이 구할 때 이용할 visited 배열
	static boolean visited2[][];//구한 넓이 값을 각 칸에 저장할 때(map배열 채울 때) 사용할 visited배열
	static int max1;	//가장 넓은 구역의 넓이
	static int max2;	//벽 하나를 허물었을 때 가장 넓은 구역의 넓이
	static int num;		//구역의 개수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		wall = new boolean[height][width][4];
		map = new int[height][width][2];
		visited = new boolean[height][width];
		visited2 = new boolean[height][width];
		for(int i=0; i<height; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<width; j++) {
				int value = Integer.parseInt(st.nextToken());
				for(int k=0; k<4; k++) {
					wall[i][j][k] = value%2==0?false : true;	//2로 나눈 나머지 값들이 이진수값이므로 true false로 표시해 wall 배열에 넣음
					value  = value/2;
				}
			}
		}
		///////////////////////////////////////////////////입력
		for(int i=0; i<height; i++) {		//처음 bfs를 돌려 구역 넓이 구하기
			for(int j=0; j<width; j++) {
				if(!visited[i][j]) {
					max1 = Math.max(bfs(i,j), max1);
					num++;		//구역 개수 하나 증가
				}
			}
		}
		for(int i=0; i<height; i++) {		//벽 하나 허물었을 때 구역 넓이 구하기
			for(int j=0; j<width; j++) {	//각 칸에 대해 수행
				for(int k=2; k<4; k++) {	//북, 서 방향은 고려할 필요 없음. (앞 칸에서의 남, 동과 동일하므로)
					if(wall[i][j][k]) {		//벽이 존재하는 경우 -> 벽을 뚫을 수 있는 경우임
						int ny = i+dy[k];	//다음 좌표 계산
						int nx = j+dx[k];
						if(ny<height && nx<width && map[i][j][0]!=map[ny][nx][0]) {	//다음 좌표가 map상에 있고 현재 칸과 다음 칸이 다른 구역일 때
							max2 = Math.max(map[i][j][1]+map[ny][nx][1], max2);	//max2값과 지금 사이에 끼고 있는 벽이 없는 경우 중 더 큰 값이 max2값이 됨.
						}
					}
				}
			}
		}
		
		System.out.println(num);
		System.out.println(max1);
		System.out.println(max2);
	}
	public static int bfs(int y, int x) {	//처음 구역 크기 구하는 bfs
		int area = 0;	//해당 구역의 크기
		visited[y][x] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {y, x});
		while(!queue.isEmpty()) {	//bfs 돌리기
			int[] yx = queue.poll();
			area++;
			for(int k=0; k<4; k++) {	//다음 칸 확인
				if(wall[yx[0]][yx[1]][k]) continue;	//벽이 존재하는 경우 탐색 안하고 continue
				int ny = yx[0] + dy[k];	//다음 칸 좌표
				int nx = yx[1] + dx[k];
				if(visited[ny][nx]) continue;	//이미 방문한 경우 continue
				visited[ny][nx] = true;	//아직 방문하지 않은 경우 queue에 추가
				queue.add(new int[] {ny, nx});
			}
		}
		fill(y, x, area);	//이번에 구한 구역에 대해 구역 넓이로 각 칸의 value를 채우는 함수
		return area;
	}
	public static void fill(int y, int x, int value) {	//각 칸을 포함된 구역의 크기로 채우는 함수
		visited2[y][x] = true;	//fill함수에서 사용할 방문배열
		map[y][x][0] = num;		//구역 번호를 저장 (같은 구역일 경우 벽을 뚫을 필요 없으므로)
		map[y][x][1] = value;	//구역 넓이를 저장
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {y, x});
		while(!queue.isEmpty()) {	//bfs돌려서 해당 구역에 대해 구역 넓이 값 저장
			int[] yx = queue.poll();
			for(int k=0; k<4; k++) {
				if(wall[yx[0]][yx[1]][k]) continue;	//벽이 있는 경우
				int ny = yx[0] + dy[k];
				int nx = yx[1] + dx[k];
				if(visited2[ny][nx]) continue;	//이미 방문한 경우
				visited2[ny][nx] = true;	//아직 방문 안한경우
				map[ny][nx][0] = num;	//0번 인덱스에 구역의 번호 저장
				map[ny][nx][1] = value;	//1번 인덱스에 구역의 넓이 저장
				queue.add(new int[] {ny, nx});
			}
		}
	}
}
