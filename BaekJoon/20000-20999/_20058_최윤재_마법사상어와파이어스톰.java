package tmp;
import java.io.*;
import java.util.*;

public class _20058_최윤재_마법사상어와파이어스톰 {
	
	static int N;
	static int Q;
	static int width;
	static int map[][];
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	static int max = 0;		//가장 넓은 영역
	static int sum = 0;		//얼음 합
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		width = (int)Math.pow(2, N);
		map = new int[width][width];
		visited = new boolean[width][width];
		for(int i=0; i<width; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<width; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		/////////////////////////////////////////////////////입력
		st = new StringTokenizer(br.readLine(), " ");
		while(Q-->0) {	//반복
			int stage = Integer.parseInt(st.nextToken());	//몇단계인지
			map = rotate(stage);	//맵 90도 돌리기
			melt();	//얼음 녹이기
		}
		
		Queue<int[]> queue = new LinkedList<>();	//최종 맵에서 결과 확인 bfs 이용
		for(int i=0; i<width; i++) {
			for(int j=0; j<width; j++) {
				int area =0;
				if(!visited[i][j] && map[i][j]>0) {
					queue.add(new int[] {i,j});		//bfs로 영역 구하기
					visited[i][j] = true;	//방문처리
					while(!queue.isEmpty()) {
						int[] loc = queue.poll();
						area++;			//영역 1 증가
						sum += map[loc[0]][loc[1]];	//sum에 얼음 값 더하기
						for(int k=0; k<4; k++) {	//다음 칸 확인
							int ny = loc[0]+dy[k];
							int nx = loc[1]+dx[k];
							if(check(ny, nx) && !visited[ny][nx]) {
								queue.add(new int[] {ny, nx});
								visited[ny][nx]=true;
							}
						}
					}
				}
				max = Math.max(max, area);
			}
		}
		System.out.println(sum);
		System.out.println(max);
	}
	
	public static int[][] rotate(int stage) {	//90도 돌리는 함수
		int rotatedMap[][] = new int[width][width];	//돌아간 map
		int small = (int)Math.pow(2, stage);	//좌우 몇칸기준으로 돌릴지
		for(int a=0; a<width/small; a++) {	//칸 시작점의 y좌표
			int start_y = small*a;	//시작 y좌표
			for(int b=0; b<width/small; b++) {	//칸 시작점의 x좌표
				int start_x = small*b;	//시작  x좌표
				for(int i=0; i<small; i++) {
					for(int j=0; j<small; j++) {
						rotatedMap[start_y+j][start_x+small-i-1] = map[start_y+i][start_x+j];	//돌아간 map에 값 재우기
					}
				}
			}
		}
		return rotatedMap;	//돌아간 맵 리턴
	}
	public static void melt() {	//얼음 녹이기
		ArrayList<int[]> loc = new ArrayList<>();	//바로 녹이면 녹은 값이 상하좌우 인접 칸 계산시에 반영되기 때문에 나중에 한번에 녹이기 위해 arraylist에 좌표 저장
		for(int i=0; i<width; i++) {
			for(int j=0; j<width; j++) {
				if(map[i][j]==0) continue;
				int count = 0;
				for(int k=0; k<4; k++) {	//상하좌우 확인
					int nx = j + dx[k];
					int ny = i + dy[k];
					if(check(ny, nx)) count++;	//얼음 있는 칸이면 count++
				}
				if(count<3) loc.add(new int[] {i,j});	//주변에 얼음 있는 칸이 3개 미만이면 arraylist에 좌표 저장
			}
		}
		for(int[] location : loc) {	//arraylist에 저장된 좌표에 해당하는 map값 하나씩 감소
			int y = location[0];
			int x = location[1];
			map[y][x]--;
		}
	}

	public static boolean check(int y, int x) {
		if(0<=y && 0<=x && y<width && x<width && map[y][x]>0) return true;
		return false;
	}
}
