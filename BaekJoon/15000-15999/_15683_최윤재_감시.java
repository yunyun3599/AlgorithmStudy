package tmp;

import java.io.*;
import java.util.*;

public class _15683_최윤재_감시 {
	
	static int height;
	static int width;
	static int map[][];
	static int[] axis_x = {0, 0, -1, 1};
	static int[] axis_y = {-1, 1, 0, 0};
	static int result = Integer.MAX_VALUE; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine();
		height = tmp.charAt(0) - '0';
		width = tmp.charAt(2) - '0';
		map = new int[height][width];
		for(int i=0; i<height; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<width; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);					//탐색 수행
		System.out.println(result);	//결과 출력
	}
	
	public static void dfs(int y, int x) {
		for(int i=y; i<height; i++) {					//현 위치부터 한칸씩 1부터 5사이 값을 찾아 감시 수행
			int x_start = (i == y ? x : 0);
			for(int j=x_start; j<width; j++) {
				if(1<=map[i][j]&& map[i][j]<=5) {		//1~5까지만 확인
					int[][] tmp_map = copyarray(map);	//감시한 내용을 map에 표시해뒀다가 다시 돌려놓기 위해 tmp_map에 감시 전 상태 저장 (깊은복사, 얕은복사)
					
					if(map[i][j] == 1) {				//1인경우
						int next_x, next_y;				//갈수있는곳이 상하좌우 중 한 곳
						for(int k=0; k<4; k++) {
							next_x = j + axis_x[k];
							next_y = i + axis_y[k];
							while(check(next_y, next_x)) {	//상하좌우중 한 곳으로만 보내기
								if(map[next_y][next_x]==0) map[next_y][next_x] = 7;	//0인 칸의 값을 7로 바꿔주기
								next_x = next_x + axis_x[k];
								next_y = next_y + axis_y[k];
								if(i==height-1 && j==width-1) result = Math.min(result, count());	//만약 현재 칸이 마지막 칸이었던 경우라면 사각지대 개수 세기
							}
							if (j==(width-1)) dfs(i+1,0); 	//행의 마지막칸이었으면 다음 행 첫칸부터 확인
							else dfs(i, j+1);		//다음칸부터 확인
							map = copyarray(tmp_map);	//map원래 상태로 돌려놓기
						}
					}
					
					else if(map[i][j] == 2) {	//2번 감시카메라
						int next_x1, next_x2, next_y1, next_y2;	//상하 or 좌우 로 감시
						for(int k=0; k<2; k++) {
							next_x1 = j + axis_x[2*k];		//[y1][x1]이 상/좌이면 [y2][x2]는 하/우가 되도록 설정
							next_x2 = j + axis_x[2*k + 1];
							next_y1 = i + axis_y[2*k];
							next_y2 = i + axis_y[2*k + 1];
							while(check(next_y1, next_x1)) {	//정해진 방향대로 쭉 탐색
								if(map[next_y1][next_x1] == 0) map[next_y1][next_x1] = 7;
								next_x1 = next_x1 + axis_x[2*k];
								next_y1 = next_y1 + axis_y[2*k];
							}
							while(check(next_y2, next_x2)) {
								if(map[next_y2][next_x2] == 0) map[next_y2][next_x2] = 7;
								next_x2 = next_x2 + axis_x[2*k+1];
								next_y2 = next_y2 + axis_y[2*k+1];
							}
							if(i==height-1 && j==width-1) result = Math.min(result, count());
							if (j==(width-1)) dfs(i+1,0); 
							else dfs(i, j+1);
							map = copyarray(tmp_map);
						}
					}
					
					else if(map[i][j] == 3) {		//3번 카메라의 경우
						int next_x1, next_x2, next_y1, next_y2;
						for(int k=0; k<4; k++) {
							next_x1 = j + axis_x[k/2];
							next_x2 = j + axis_x[3-(k%2)];
							next_y1 = i + axis_y[k/2];
							next_y2 = i + axis_y[3-(k%2)];
							while(check(next_y1, next_x1)) {
								if(map[next_y1][next_x1] == 0) map[next_y1][next_x1] = 7;
								next_x1 = next_x1 + axis_x[k/2];
								next_y1 = next_y1 + axis_y[k/2];
							}
							while(check(next_y2, next_x2)) {
								if(map[next_y2][next_x2] == 0) map[next_y2][next_x2] = 7;
								next_x2 = next_x2 + axis_x[3-(k%2)];
								next_y2 = next_y2 + axis_y[3-(k%2)];
							}
							if(i==height-1 && j==width-1) result = Math.min(result, count());
							if (j==(width-1)) dfs(i+1,0); 
							else dfs(i, j+1);
							map = copyarray(tmp_map);
						}
					}
					
					else if(map[i][j]==4) {	//4번 카메라의 경우
						int next_x1, next_x2, next_x3, next_y1, next_y2, next_y3;
						for(int k=0; k<4; k++) {
							next_x1 = j + axis_x[k];
							next_x2 = j + axis_x[(k+1) % 4];
							next_x3 = j + axis_x[(k+2) % 4];
							next_y1 = i + axis_y[k];
							next_y2 = i + axis_y[(k+1) % 4];
							next_y3 = i + axis_y[(k+2) % 4];
							while(check(next_y1, next_x1)) {
								if(map[next_y1][next_x1] == 0) map[next_y1][next_x1] = 7;
								next_x1 = next_x1 + axis_x[k];
								next_y1 = next_y1 + axis_y[k];
							}
							while(check(next_y2, next_x2)) {
								if(map[next_y2][next_x2] == 0) map[next_y2][next_x2] = 7;
								next_x2 = next_x2 + axis_x[(k+1) % 4];
								next_y2 = next_y2 + axis_y[(k+1) % 4];
							}
							while(check(next_y3, next_x3)) {
								if(map[next_y3][next_x3] == 0) map[next_y3][next_x3] = 7;
								next_x3 = next_x3 + axis_x[(k+2) % 4];
								next_y3 = next_y3 + axis_y[(k+2) % 4];
							}
							if(i==height-1 && j==width-1) result = Math.min(result, count());
							if (j==(width-1)) dfs(i+1,0); 
							else dfs(i, j+1);
							map = copyarray(tmp_map);
						}
					}
					else if(map[i][j]==5) {	//5번 카메라의 경우
						int next_x1, next_x2, next_x3, next_x4, next_y1, next_y2, next_y3, next_y4;
						next_x1 = j + axis_x[0];
						next_x2 = j + axis_x[1];
						next_x3 = j + axis_x[2];
						next_x4 = j + axis_x[3];
						next_y1 = i + axis_y[0];
						next_y2 = i + axis_y[1];
						next_y3 = i + axis_y[2];
						next_y4 = i + axis_y[3];
						while(check(next_y1, next_x1)) {
							if(map[next_y1][next_x1] == 0) map[next_y1][next_x1] = 7;
							next_x1 = next_x1 + axis_x[0];
							next_y1 = next_y1 + axis_y[0];
						}
						while(check(next_y2, next_x2)) {
							if(map[next_y2][next_x2] == 0) map[next_y2][next_x2] = 7;
							next_x2 = next_x2 + axis_x[1];
							next_y2 = next_y2 + axis_y[1];
						}
						while(check(next_y3, next_x3)) {
							if(map[next_y3][next_x3] == 0) map[next_y3][next_x3] = 7;
							next_x3 = next_x3 + axis_x[2];
							next_y3 = next_y3 + axis_y[2];
						}
						while(check(next_y4, next_x4)) {
							if(map[next_y4][next_x4] == 0) map[next_y4][next_x4] = 7;
							next_x4 = next_x4 + axis_x[3];
							next_y4 = next_y4 + axis_y[3];
						}
						if(i==height-1 && j==width-1) result = Math.min(result, count());
						if (j==(width-1)) dfs(i+1,0); 
						else dfs(i, j+1);
						map = copyarray(tmp_map);
					}
				}
				if(i==height-1 && j==width-1) result = Math.min(result, count());	//마지막칸까지 확인한 경우
			}
		}
	}
	
	
	
	public static int count() {			//0개수세기
		int cnt = 0;
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				if (map[i][j] == 0) cnt++;
			}
		}
		return cnt;
	}
	
	
	public static boolean check(int y, int x) {	//탐색 가능한 곳인지 확인
		if(y>=0 && y<height && x>=0 && x<width && map[y][x] != 6) return true;
		return false;
	}
	
	public static int[][] copyarray(int[][] arr){	//깊은 복사
		int[][] tmp_map = new int[height][width];
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				tmp_map[i][j] = arr[i][j];
			}
		}
		return tmp_map;
	}
}
