package tmp;
import java.io.*;
import java.util.*;
public class _20057_최윤재_마법사상어와토네이도 {

	static int dy[] = {0, 1, 0, -1};	//상하좌우 idx 이동
	static int dx[] = {-1, 0, 1, 0};
	static double percent[] = {1, 1, 7, 2, 7, 2, 10, 10, 5};	//퍼센트
	static int sandx[][] = {	//모래가 날리는 좌표
			{ 1, 1, 0, 0, 0, 0, -1, -1, -2},	//좌
			{-1, 1, -1, -2, 1, 2, -1, 1, 0},	//하
			{-1, -1, 0, 0, 0, 0, 1, 1, 2},	//우
			{-1, 1, -1, -2, 1, 2, -1, 1, 0}	//상
			};
	static int sandy[][] = {
			{-1, 1, -1, -2, 1, 2, -1, 1, 0}, //좌
			{-1, -1, 0, 0, 0, 0, 1, 1, 2},	//하
			{-1, 1, -1, -2, 1, 2, -1, 1, 0}, //우
			{1, 1, 0, 0, 0, 0, -1, -1, -2}	//상
			};
	
	static int N;
	static int[][] map;
	static boolean visited[][];
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0; i<N; i++) {	//입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int mid = N/2;	//가운데 좌표
		visited[mid][mid] = true;	//정 가운데 방문처리
		tornado(mid, mid-1, 0);	//출발
		System.out.println(result);	//결과 더하기
	}
	
	public static void tornado(int y, int x, int dir) {
		visited[y][x] = true;	//방문처리
		int affected_y[] = sandy[dir];	//해당 방향으로 갈 때 영향받는 칸의 x좌표 이동
		int affected_x[] = sandx[dir];	//y좌표 이동
		int tmp = 0;
		for(int i=0; i<9; i++) {	//영향받는 곳 한칸씩 확인
			int ny = y+affected_y[i];
			int nx = x+affected_x[i];
			if(!check(ny, nx)) {	//모래가 바깥으로 날리는 경우
				result += map[y][x] * percent[i] / 100;
			} else {	//모래가 칸 안으로 날리는 경우
				map[ny][nx] += map[y][x] * percent[i] / 100;
			}
			tmp += map[y][x] * percent[i] / 100;	//a가 아닌 값의 합
		}
		if(check(y+dy[dir], x+dx[dir])) {	//a값이 map 위일 때
			map[y+dy[dir]][x+dx[dir]] += map[y][x] - tmp;
		} else {	//a값이 map 위가 아닐 때
			result += map[y][x] - tmp;
		}
		map[y][x] = 0;
		int ndir = (dir+1)%4;	//다음 방향
		if(y == 0 && x == 0) return;	//다 돈 경우
		if(visited[y+dy[ndir]][x+dx[ndir]]) tornado(y+dy[dir], x+dx[dir], dir);	//만약 다음 방향으로 가려고 한 곳이 이미 방문된 곳이면 현재 방향으로 한칸 더 이동
		else tornado(y+dy[ndir], x+dx[ndir], ndir);	//다음 방향으로 갈 수 있으면 가기
	}
	
	public static boolean check(int y, int x) {
		if(y>=0 && x>=0 && y<N && x<N) return true;
		return false;
	}

}
