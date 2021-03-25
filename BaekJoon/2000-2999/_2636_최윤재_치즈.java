package week12;
import java.io.*;
import java.util.*;
public class _2636_최윤재_치즈 {

	static int[] axis_y = {-1, 1, 0, 0};				//dfs 이용 상하좌우
	static int[] axis_x = {0, 0, -1, 1};
	static int width;									//치즈 map의 높이, 너비
	static int height;
	static int[][] map;									//치즈 값 저장
	static boolean[][] visited;							//방문여부 확인
	static int time;									//총 소요 시간
	static int cheese;									//치즈가 다 녹았는지 확인하기 위해 해당 time이 끝났을 때 cheese의 개수
	static int pre_cheese;								//치즈가 0이 되기 직전 시간의 cheese 값 저장
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
		height = Integer.parseInt(st1.nextToken());
		width = Integer.parseInt(st1.nextToken());
		map = new int[height][width];
		visited = new boolean[height][width];
		
		for(int i=0; i<height; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<width; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
				cheese += map[i][j];					// 처음 들어온 치즈 개수
			}
		}
		////////////////////////////////////////////////// 입력
		while (cheese > 0) {							//치즈가 다 녹을 때 까지 반복
			pre_cheese = cheese;						//이전 치즈 값 저장
			for(int i=0; i<height; i++) {				//치즈 속에 있는 빈 공간은 고려하지 않아도 되므로 dfs를 상하좌우 가장 끝 행 or 열에 대해서만 수행 (둘러싸여있는 빈 부분은 dfs 수행시 map의 가장자리로 가지 못하므로)
				if(visited[i][0] == false) dfs(i,0);
				if(visited[i][width-1] == false) dfs(i,width-1);
			}
			for(int i=0; i<width; i++) {
				if(visited[0][i] == false) dfs(0,i);
				if(visited[height-1][i] == false) dfs(height-1,i);
			}
			time++;										//dfs 다 수행 후에는 시간 증가
			for(int i=0; i<height; i++) {				//visited 배열 초기화
				for(int j=0; j<width; j++) {
					visited[i][j] = false;
				}
			}
		}
		System.out.println(time);
		System.out.println(pre_cheese);
	}
	public static void dfs(int x, int y) {				//dfs
		visited[y][x] = true;							//방문 처리
		for(int i=0; i<4; i++) {						//상하좌우
			int next_x = x + axis_x[i];
			int next_y = y + axis_y[i];
			if (check(next_x, next_y)) {				//dfs 수행해도 되는지 확인
				visited[next_y][next_x] = true;			//방문처리
				if (map[next_y][next_x] == 1) {			//치즈가 있으면 치즈 녹이고 더이상 dfs 안함
					map[next_y][next_x] = 0;
					cheese--;							//치즈 개수 하나 감소
				}
				else {									//치즈 없으면 dfs 수행
					dfs(next_x, next_y);
				}
			}
		}
	}
	
	public static boolean check(int x, int y) {							//해당 자리가 map에서 유효하며 아직 방문하지 않았는지 check
		if (x >= 0 && y >= 0 && x < width && y < height && !visited[y][x]) return true;
		return false;
	}
}
















