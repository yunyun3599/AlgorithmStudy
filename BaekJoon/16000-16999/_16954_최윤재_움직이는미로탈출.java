package tmp;
import java.io.*;
import java.util.*;

public class _16954_최윤재_움직이는미로탈출 {

	static char map[][] = new char[8][8];	//처음 맵 저장
	static ArrayList<int[]> wall = new ArrayList<>();	//현재 벽 위치(#)
	static Queue<int[]> loc = new LinkedList<>();	//현재 가능한 위치 경우의 수들 저장
	static boolean[][] visited;	//방문처리용
	static int dx[] = {-1,-1,-1,0,0,0,1,1,1};	//상하좌우대각선정지
	static int dy[] = {-1,0,1,-1,0,1,-1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<8; i++) {
			String str = br.readLine();
			for(int j=0; j<8; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '#') wall.add(new int[] {i,j});	//현 위치에 wall이 있는 경우 wall arraylist에 위치 저장
			}
		}
		loc.add(new int[] {7,0});	//첫 위치
		while(!loc.isEmpty()) {		//가능한 경우의 수가 없으면 반복문 나감
			int wall_num = wall.size();
			ArrayList<int[]> new_wall = new ArrayList<>();	//wall이 1초 후 이동할 위치들 저장
			for(int i=0; i<wall_num; i++) {
				int[] cur = wall.get(i);
				int ny = cur[0]+1;	//한칸씩 밑으로 내림
				int nx = cur[1];
				if(ny<8) new_wall.add(new int[] {ny,nx});
			}
			int iter = loc.size();	//현재 가능한 상태들에 대해 for문 돌기
			visited = new boolean[8][8];
			for(int i=0; i<iter; i++) {
				int[] cur = loc.poll();
				for(int k=0; k<9; k++) {	//상하좌우대각선정지 중 선택
					int ny = cur[0]+dy[k];
					int nx = cur[1]+dx[k];
					if(check(ny, nx)) {		//이동할 수 있는 칸인지 확인
						if(ny==0 && nx==7) {	////목적지 도착한 경우
							System.out.println(1);
							System.exit(0);
						}
						boolean flag=false;
						for(int j=0; j<wall.size(); j++) {	//현재 벽이 있는 칸인지 확인
							int[] blocked = wall.get(j);
							if(blocked[0] == ny && blocked[1] == nx) {
								flag = true;
								break;
							}
						}
						for(int j=0; j<new_wall.size(); j++) {	//1초 후 벽이 내려올 칸인지 확인
							int[] blocked = new_wall.get(j);
							if(blocked[0] == ny && blocked[1] == nx) {
								flag = true;
								break;
							}
						}
						if(!flag) {	//현재도 벽이 없고 1초 후에도 벽이 없는 경우에 대해서만 좌표 저장
							loc.add(new int[] {ny,nx});
							visited[ny][nx] = true;	//방문 처리
						}
					}
				}
			}
			wall = new_wall;	//다음 턴을 위해 wall array가 가리키는 객체 바꾸기
		}
		System.out.println(0);
	}
	public static boolean check(int y, int x) {
		if(0<=y && 0<= x && y<8 && x<8 && !visited[y][x]) return true;
		return false;
	}
}
