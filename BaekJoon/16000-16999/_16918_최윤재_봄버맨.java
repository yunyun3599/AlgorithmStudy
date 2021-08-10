package tmp;
import java.io.*;
import java.util.*;

public class _16918_최윤재_봄버맨 {

	static int[][] map;			//맵
	static int R;	//행
	static int C;	//열
	static int N;	//시간
	static int time;	//현재시간
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		if(N==1) {	//처음 받은 맵 그대로 끝나는 경우
			for(int i=0; i<R; i++) {
				String input = br.readLine();
				System.out.println(input);
			}
			System.exit(0);
		}
		for(int i=0; i<R; i++) {	//map에 input저장 빈 칸은 0으로 폭탄 있는 칸은 1로 표기
			String input = br.readLine();
			for(int j=0; j<C; j++) {
				if(input.charAt(j)=='.') map[i][j] = 0;
				else map[i][j] = 1;
			}
		}
		
		time=0;	//시간
		while(++time!=N) {	//시간을 늘려가면서 할 일 수행, 총 하는 일이 4종류이므로(1,2번 폭탄 각각 설치, 1,2번 폭탄 각각 폭발) 시간을 4로 나눈 나머지를 이용해서 종류 분류
			if(time%4==1) {		//2번 폭탄을 채우는 경우
				fill(2);	//2번 채움
			}
			else if(time%4==2) {	//1번 폭탄이 터지는 경울
				for(int i=0; i<R; i++) {	//dfs
					for(int j=0; j<C; j++) {
						if(map[i][j]==1) {
							explode(i, j, 1);
						}
					}
				}				
			}
			else if(time%4==3) {	//1번 폭탄을 채우는 경우
				fill(1);
			}
			else {		//2번 폭탄이 터지는 경우
				for(int i=0; i<R; i++) {	//dfs
					for(int j=0; j<C; j++) {
						if(map[i][j]==2) {
							explode(i, j, 2);
						}
					}
				}	
			}
		}
		StringBuilder result = new StringBuilder();	//결과 append
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]!=0) result.append('O');	//폭탄 있으면 O로 출력
				else result.append('.');
			}
			result.append("\n");
		}
		System.out.println(result);
	}
	public static void fill(int num) {	//빈 칸을 num으로 채움
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]==0) {
					map[i][j] = num;
				}
			}
		}
	}
	public static void explode(int y, int x, int num) {	//num값과 같은 숫자의 폭탄들 dfs를 이용해 폭파
		map[y][x] = 0;	//폭파
		for(int k=0; k<4; k++) {	//상하좌우
			int ny = y+dy[k];
			int nx = x+dx[k];
			if(check(ny, nx)) {	//범위체크
				if(map[ny][nx] != num) map[ny][nx]=0;	//연쇄작용 없는 경우는 그냥 폭파
				else {
					explode(ny, nx, num);	//연쇄작용 있는 경우는 dfs 재귀적으로 돌리기
				}
			}
		}
	}
	public static boolean check(int y, int x) {
		if(y>=0 && x>=0 && y<R && x<C) return true;
		return false;
	}
}
