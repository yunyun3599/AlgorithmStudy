package tmp;
import java.io.*;
import java.util.*;
public class _14499__최윤재_주사위굴리기 {
	
	// 주사위 전개도, dice배열에 들어간 index값임. 3이 가장 바닥, 5가 가장 위, 1이 동, 0이 서
	//  2
	// 031
	//  4
	//  5
	
	static int[] dice = new int[6];		//주사위 값 저장 
	static int[][] map;
	static int height;
	static int width;
	static int move;
	static int[] axis_x = {1, -1, 0, 0};	//1=동, 2=서, 3=북, 4=남, 방향에 따라 axis[dir]로 움직이게하기
	static int[] axis_y = {0, 0, -1, 1};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		map = new int[height][width];
		int y = Integer.parseInt(st.nextToken());	//dice 초기 위치
		int x = Integer.parseInt(st.nextToken());
		move = Integer.parseInt(st.nextToken());	//총 움직일 횟수
		
		for(int i=0; i<height; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<width; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine()," ");
		while(move-->0) {		//움직일 횟수만큼 반복
			int dir = Integer.parseInt(st.nextToken())-1;	//동서남북 값
			int next_y = y + axis_y[dir];	//동서남북 값에 따라 다음 위치 확인
			int next_x = x + axis_x[dir];
			if(check(next_y, next_x)) {	//map밖으로 벗어나지 않는 경우
				switch(dir) {	//동서남북에 따라 주사위 위치 값 새로 바꾸기
				case 0: update_dice(5,0,3,1);	//동
						break;
				case 1: update_dice(5,1,3,0);	//서
						break;
				case 2: update_dice(5,4,3,2);	//북
						break;
				case 3: update_dice(2,3,4,5);	//남
						break;
				}
				
				if(map[next_y][next_x] != 0) {	//지도에 있는 값이 0이 아닌 경우
					dice[3] = map[next_y][next_x];
					map[next_y][next_x] = 0;
				}
				else {	//지도에 있는 값이 0인 경우
					map[next_y][next_x] = dice[3];
				}
				y = next_y;	//주사위 위치 바꿔주기
				x = next_x;
				sb.append(dice[5]+"\n");	//결과값 append (주사위 위쪽 값)
			}
		}
		System.out.println(sb);
	}
	public static boolean check(int y, int x) {	//범위 체크
		if(0<=y && 0<=x && y<height && x<width) return true;
		return false;
	}
	public static void update_dice(int idx1, int idx2, int idx3, int idx4) {	//주사위 배열 값 이동시켜주기
		int tmp = dice[idx1];
		dice[idx1] = dice[idx2];
		dice[idx2] = dice[idx3];
		dice[idx3] = dice[idx4];
		dice[idx4] = tmp;
	}

}
