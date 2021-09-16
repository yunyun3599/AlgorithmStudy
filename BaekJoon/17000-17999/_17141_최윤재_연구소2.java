package tmp;
import java.util.*;
import java.io.*;
import java.awt.Point;

public class _17141_최윤재_연구소2 {
	
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<int[]> virusLoc = new ArrayList<>();	//바이러스를 둘 수 있는 위치 저장
	static int result = Integer.MAX_VALUE;	//최종 결과
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) map[i][j] = -1;
				else if(map[i][j] == 2) {
					virusLoc.add(new int[] {i, j});
					map[i][j] = 0;
				}
			}
		}
		////////////////////////////////////////////////////입력
		//바이러스 배치
		for(int i=0; i<=virusLoc.size() - M ; i++) {
			chooseLoc(i,0);	//위치 조합하는 함수
		}
		if(result == Integer.MAX_VALUE) result = -1;	//모두 퍼뜨리지 못한 경우는 -1
		System.out.println(result);
	}
	public static void chooseLoc(int idx, int selected) {	//virusLoc의 몇번째 인덱스부터 확인할지를 idx로, 몇개 자리가 선택되었는지를 selected로 넘겨줌
		if(selected == M) {	//선택할 수 있는 개수를 다 썼을 떄 바이러스를 퍼뜨리는 spread함수 호출
			spread();
		}
		for(int i=idx; i<virusLoc.size(); i++) {	//바이러스 초기 위치 설정
			int[] loc = virusLoc.get(idx);
			map[loc[0]][loc[1]] = 1;	//1인 경우 바이러스가 처음에 있는 곳
			chooseLoc(i+1, selected+1);
			map[loc[0]][loc[1]] = 0;
		}
	}
	public static void spread() {
		Queue<Point> queue = new LinkedList<>();
		visited = new boolean[N][N];	//방문처리
		int time = 0;
		int queueSize = 0;	//각 time별 이전에 바이러스가 퍼진 자리들의 개수
		int cnt = N*N;	//총 구역의 개수
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1) {	//초기에 바이러스가 있는 위치
					queue.add(new Point(j, i));
					visited[i][j] = true;
					cnt--;	//총 방문한 개수에서 빼줌
				}
				else if(map[i][j] == -1) cnt--;	//벽인 경우도 총 방문한 개수에서 빼줌
			}
		}
		while(!queue.isEmpty()) {
			queueSize = queue.size();
			for(int i=0; i<queueSize; i++) {
				Point prev = queue.poll();
				for(int k=0; k<4; k++) {	//상하좌우
					int ny = prev.y + dy[k];
					int nx = prev.x + dx[k];
					if(check(ny, nx)) {	//방문 안했고, 범위 내에 있으며, 벽이 아닌 지 확인
						queue.add(new Point(nx, ny));	//queue에 새 위치 추가
						visited[ny][nx] = true;	//방문처리
						cnt--;	//방문했으므로 더  퍼뜨려야하는 구역의 개수인 cnt 줄여줌
					}
				}
			}
			time++;	//한 텀마다 시간 1씩 증가. 더 퍼뜨릴 곳이 없을 때도 한 번 증가하게 되므로 추후에 1 빼줘야 함
		}
		if(cnt!= 0) return;	//모든 자리로 퍼뜨리지 못한 경우
		result = Math.min(result, time-1);	//모든 자리로 다 퍼뜨린 경우에는 최소값으로 result 업데이트
	}

	public static boolean check(int y, int x) {
		if(0<=y && 0<=x && y<N && x<N && map[y][x]!=-1 && !visited[y][x]) return true;
		return false;
	}
}
