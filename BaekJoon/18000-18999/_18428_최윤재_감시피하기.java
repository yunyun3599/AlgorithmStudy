package week18;
import java.io.*;
import java.util.*;
public class _18428_최윤재_감시피하기 {

	static char[][] map;		//입력 저장
	static boolean[][] visited;	//방문여부 확인
	static int width;	//map 너비
	static boolean flag;//가능한지 여부 확인 (false면 불가인것)
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		width = Integer.parseInt(br.readLine());
		map = new char[width][width];
		
		for(int i=0; i<width; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<width; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}/////////////////여기까지 입력
		for(int i=0; i<width; i++) {
			for(int j=0; j<width; j++) {
				if(map[i][j] == 'X') {	//X가 있는 부분에 대해서 3개의 Obstacle을 세움
					flag = makeWall(i, j, 0);	//makeWall함수에서 장애물 세우고 3개가 세워지면 dfs이용해서 가능한지 확인하게 됨. 가능하면 true반환
					if(flag) break;	//true가 반환되어 가능한 경우가 최소 하나 있음을 확인하게 된다면 반복문 멈춤
				}
			}
			if(flag) break;	//2중for문 둘 다 나옴
		}
		if(flag) System.out.println("YES");	//가능한 경우 Yes 출력
		else System.out.println("NO");	//불가능한 경우 No 출력
	}
	public static boolean makeWall(int y, int x, int wall) {
		boolean flag = false;	//우선 불가능하다고 가정해놓음
		if (wall == 3) {	//벽 3개가 다 세워지면 가능한지 확인하는 함수 부름 (dfs수행)
			flag = flag || findStudent();	//OR 연산으로 가능한 경우 하나라도 있으면 flag가 true값이도록 해놓음
		}
		else {	//벽을 더 세워야 하는 경우
			for(int i=x; i<width; i++) {	//해당 행에서 아직 벽을 더 세울 수 있는 경우
				if(map[y][i] == 'X') {
					map[y][i] = 'O';
					flag = flag || makeWall(y, i+1, wall+1);
					map[y][i] = 'X';
				}
			}
			for(int i=y+1; i<width; i++) {	//다음 행으로 넘어가야 하는 경우
				for(int j=0; j<width; j++) {
					if(map[i][j] == 'X') {
						map[i][j] = 'O';
						flag = flag || makeWall(i, j+1, wall+1);
						map[i][j] = 'X';
					}
				}
			}
		}
		
		return flag;	//학생들이 안들킨 경우에는 true가 반환됨
	}
	public static boolean findStudent() {	//학생이 숨을 수 있는 지에 대해 확인하는 함수
		for(int i=0; i<width; i++) {
			for(int j=0; j<width; j++) {
				if(map[i][j] == 'T') {	//선생님이 있는 칸에서부터 dfs 수행
					visited = new boolean[width][width];	//방문 여부 확인
					if(!dfs(i, j, 0)) return false;	//선생님이 위쪽(상)으로만 가는 경우
					if(!dfs(i, j, 1)) return false;	//선생님니 아래쪽(하)으로만 가는 경우
					if(!dfs(i, j, 2)) return false;	//선생님이 왼쪽(좌)으로만 가는 경우
					if(!dfs(i, j, 3)) return false;	//선생님이 오른쪽(우)으로만 가는 경우
				}
			}
		}
		return true;
	}
	public static boolean dfs(int y, int x, int dir) {
		if (map[y][x]=='S')  return false;	//학생이 들킨 경우 false 반환
		if(map[y][x]=='O') return true; //Obstacle 만난 경우 더이상 탐색 하지 않고 true 반환
		int next_x = 0, next_y = 0;	//다음에 갈 좌표
		switch (dir) {
		case 0:		//상
			next_x = x;
			next_y = y-1;
			break;
		case 1:		//하
			next_x = x;
			next_y = y+1;
			break;
		case 2: 	//좌
			next_x = x-1;
			next_y = y;
			break;
		case 3:		//우
			next_x = x+1;
			next_y = y;
			break;
		}
		if(check(next_y, next_x)) {	//갈 수 있는 좌표인지 확인
			if(!dfs(next_y, next_x, dir)) return false;	//해당 칸에 대한 dfs 또 수행해서 학생이 들킨 경우 false 반환
		}
		return true;	//아무 학생도 안들켰으면 true 반환
	}
	public static boolean check(int y, int x) {
		if(0<=x && 0<=y && x<width && y<width && !visited[y][x]) return true;
		return false;
	}
}
