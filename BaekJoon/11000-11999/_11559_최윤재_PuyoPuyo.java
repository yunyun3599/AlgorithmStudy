package tmp;
import java.util.*;
import java.io.*;

public class _11559_최윤재_PuyoPuyo {

	static char[][] map = new char[12][6];	//처음 맵 저장
	static int combo;	//콤보 개수
	static ArrayList<int[]> target;	//각 콤보별로 터질 위치 저장
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<12; i++) {
			String input = br.readLine();
			for(int j=0; j<6; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		stage(0,0);	//0,0부터 확인하면서 터뜨리기
		System.out.println(combo);
	}
	public static void stage(int y, int x) {
		target = new ArrayList<>();	//각 단계별 터질 위치
		boolean visited[][] = new boolean[12][6];	//각 단계별 방문 처리
		for(int i=0; i<12; i++) {	//각 위치별 bfs수행
			for(int j=0; j<6; j++) {
				if(!visited[i][j]) {	//아직 방문 안한경우 bfs돌림
					ArrayList<int[]> tmp = bfs(i,j,visited);	//돌린 bfs의 결과 터뜨릴 좌표를 tmp에 담음
					for(int[] concat : tmp) {
						target.add(concat);	//이번에 터뜨릴 좌표들은 target에 저장됨
					}
				}
			}
		}
		if(target.size()>=4) {	//target에 터뜨릴 것이 있는 경우 터뜨림
			explode();	//터뜨림
			combo++;	//콤보 증가
			stage(0,0);	//다음 단계 시작
		}
		return;
	}
	public static ArrayList<int[]> bfs(int y, int x, boolean[][] visited){
		if(map[y][x]!= '.') {	//빈칸이 아닌 경우에 한하여 bfs 수행
			Queue<int[]> q = new LinkedList<>();
			ArrayList<int[]> tmp = new ArrayList<>();
			q.add(new int[] {y,x});
			visited[y][x] = true;	//방문처리
			tmp.add(new int[] {y,x});	//해당 좌표 tmp에 저장
			while(!q.isEmpty()) {
				int[] loc = q.poll();
				for(int k=0; k<4; k++) {	//상하좌우
					int ny = loc[0]+dy[k];
					int nx = loc[1]+dx[k];
					if(check(ny,nx)&& !visited[ny][nx] && map[loc[0]][loc[1]] == map[ny][nx]) {	//붙어있는 경우면 queue와 tmp에 좌표 저장
						q.add(new int[] {ny,nx});
						tmp.add(new int[] {ny,nx});
						visited[ny][nx] = true;
					}
				}
			}
			if(tmp.size()>=4) return tmp;	//붙어있는 칸이 4개 이상이면 좌표 저장된 arraylist 리턴
		}
		return new ArrayList<int[]>();	//붙어있는 칸이 4개 미만이면 빈 arraylist 리턴
	}
	public static void explode() {	//터뜨리기
		int[] column = new int[6];	//어떤 column에 위치한 블록이 터졌는지
		for(int[] loc : target) {	//각 location마다 값을.으로 바꾸기
			map[loc[0]][loc[1]]='.';
			column[loc[1]]++;
		}
		down(column);	//터진만큼 내리기
	}
	public static void down(int[] column) {
		for(int i=0; i<6; i++) {
			if(column[i]>0) {	//해당 열의 블록 중 터진 게 있을 때 진행
				for(int j=10; j>=0; j--) {	//밑에서부터 진행
					if(map[j+1][i]=='.' && map[j][i]!='.') {	//현재칸은 빈칸이 아니고 밑 칸은 빈칸일 때
						map[j+1][i] = map[j][i];	//한칸 내림
						map[j][i] = '.';
						if(j!=10) j=j+2;	//내려갔으므로 내려간 칸을 다시 확인해봐야해서 j+2
					}
				}
			}
		}
	}
	public static boolean check(int y, int x) {	//범위 체크
		if(0<=y && 0<=x && y<12 && x<6) return true;
		return false;
	}
}
