package tmp;
import java.io.*;
import java.util.*;
public class _16234_최윤재_인구이동 {
	
	static int N;	//N*N 국가
	static int L;	//인구수 차 최소
	static int R;	//인구수 차 최대
	static int[][] map;	//국가별 인구수 저장
	static int[] axis_x = {0,0,-1,1};	//dfs이용 쉽게
	static int[] axis_y = {-1,1,0,0};
	static boolean[][] visited;	//방문했는지 여부 확인
	static int move;	//이동 횟수(최종 결과)
	static Queue<int[]> loc = new LinkedList<>();	//이동가능한 국가들의 좌표 저장 (dfs로 묶이는 국가들)
	static boolean no_more_move = true;	//더이상 이동이 불가능한 경우에 true
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}	//입력
		while (!isFinished()) {	//인구수가 동일해질때까지 반복
			no_more_move = true;	//더이상 이동이 불가능하다고 지정해놓고 추후에 이동 가능한 경우가 한번이라도 생기면 값 false로 바꿈
			visited = new boolean[N][N];	//방문했는지 여부 저장
			for(int i=0; i<N; i++) {	//dfs 수행
				for(int j=0; j<N; j++) {
					if(!visited[i][j]) {
						int total = dfs(i,j,map[i][j]);	//total은 이번 dfs 시도로 묶인 국가들 인구수의 총합
						distribute(total);	//평균을 내서 각 국가에 인구수 고루 분배
					}
				}
			}
			if(no_more_move) break;	//더이상 이동이 불가능하다는 결과가 났으면 반복 수행 멈춤
			move++;	//이번 반복에서 이동이 일어났으면 move하나 증가 
		}
		System.out.println(move);	//결과 출력
	}
	public static int dfs(int y, int x, int population) {	//dfs수행해서 이동 가능한 국가들 구함
		loc.add(new int[] {y,x});	//이동 가능한 국가로 묶이면 해당 좌표값 queue에 넣음
		visited[y][x] = true;	//방문 여부 업데이트
		for(int i=0; i<4; i++) {	//상하좌우 탐색
			int next_y = y+axis_y[i];
			int next_x = x+axis_x[i];
			if(check(y, x, next_y, next_x)) population = dfs(next_y, next_x, population+map[next_y][next_x]);	//해당 국가와 경계선 없애도 되는지 확인 후 dfs 수행
		}
		return population;	//총 인구수 return
	}
	
	public static void distribute(int total) {
		int average = total/(loc.size());	//국가들간의 이동이 일어난 후 각 인구수
		while(!loc.isEmpty()) {	//해당되는 국가들의 좌표를 뽑음
			int[] yx = loc.poll();
			map[yx[0]][yx[1]] = average;	//해당 좌표 값을 average로 설정
		}
	}
	
	public static boolean isFinished() {	//모든 국가들의 인구가 같은지 확인
		int population = map[0][0];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] != population) return false;
			}
		}
		return true;
	}
	
	public static boolean check(int y, int x, int next_y, int next_x) {	//다음으로 탐색할 국가가 범위 및 조건을 만족하는지 확인
		if(0<=next_x && next_x<N && 0<=next_y && next_y<N && !visited[next_y][next_x]) {	//범위 및 방문여부 확인
			int diff = Math.abs(map[y][x]-map[next_y][next_x]);	//현재 국가와 다음으로 탐색할 국가의 인구수 차이 구하기
			if(L<= diff && diff <= R) {	//인구차가 조건에 부합하면 true반환, 이동 일어날것이므로 no_more_move값 false로 바꿈
				no_more_move = false;
				return true;
			}
		}
		return false;
	}
}
























