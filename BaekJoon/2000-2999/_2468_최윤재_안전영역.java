package tmp;
import java.io.*;
import java.util.*;
public class _2468_최윤재_안전영역 {

	static int width;
	static int[][] map;			//값 저장
	static boolean[][] visited;
	static int max = 1;
	static int tmp_result = 0;	//강우량별 안전영역 개수
	static int[] axis_x = {0,0,-1,1};
	static int [] axis_y = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		width = Integer.parseInt(br.readLine());
		map = new int[width][width];
		int highest = 0;	//가장 높은 지대의 높이
		for(int i=0; i<width; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<width; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				highest = Math.max(highest, map[i][j]);		//가장 높은 지대의 높이 구하기 (강수량을 1부터 이 값에 해당하는 만큼 돌림)
			}
		}
		for(int i=1; i<highest; i++) {		//강우량을 1부터 가장 높은 지대에 해당할 때 까지 돌림
			tmp_result = 0;
			visited = new boolean[width][width];
			for(int y = 0; y<width; y++) {
				for(int x = 0; x<width; x++) {
					if(map[y][x]>i && !visited[y][x]) {	//지대가 강우량보다 높고 아직 방문하지 않은 경우
						dfs(y,x,i);	//dfs돌리기
						tmp_result++;	//안전영역 개수 하나 늘리기
					}
				}
			}
			max = Math.max(tmp_result, max);	//이번 강우량에 해당하는 안전영역 개수가 더 크면 max값 업데이트
		}
		System.out.println(max);
	}
	public static void dfs(int y, int x, int flood) {	//dfs
		visited[y][x] = true;		//방문처리
		for(int k=0; k<4; k++) {	//상하좌우
			int next_y = y+axis_y[k];
			int next_x = x+axis_x[k];
			if(check(next_y, next_x, flood)) dfs(next_y,next_x,flood);	//범위, 방문여부, 강우량 체크 후 조건 만족하면 dfs 돌리기
		}
	}
	
	public static boolean check(int y, int x, int flood) {
		if(y>=0 && y<width && x>=0 && x<width && !visited[y][x] && map[y][x]>flood) return true;
		return false;
	}

}
 

