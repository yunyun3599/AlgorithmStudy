package week19;
import java.io.*;
import java.util.*;

public class _14620_최윤재_꽃길 {
	
	static int[] axis_x = {0, 0, -1, 1};
	static int[] axis_y = {-1, 1, 0, 0};
	static int[][] map;
	static int[][] value;
	static int width;
	static int final_result = Integer.MAX_VALUE;
			
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		width = Integer.parseInt(br.readLine());
		map = new int[width][width];
		value = new int [width][width];
		for(int i=0; i<width; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<width; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		///////////////////////////////////////////////////////여기까지 입력
		for(int i=1; i<width-1; i++) {
			for(int j=1; j<width-1; j++) {
				value[i][j] = map[i][j];
				for(int k=0; k<4; k++) {
					int x = j + axis_x[k];
					int y = i + axis_y[k];
					value[i][j] += map[y][x];		//value배열에 각 칸에 꽃을 심었을 때의 값 저장
				}
			}
		}
		for(int i=1; i<width-1; i++) {
			for(int j=1; j<width-1; j++) {
				boolean[][] visited = new boolean[width][width];
				final_result = Math.min(final_result, calc(i, j, visited, 1));	//(i,j)에 꽃은 심은 경우들에 대해 calc에서 탐색
			}
		}
		System.out.println(final_result);
	}
	public static int calc(int y, int x, boolean[][] visited, int num) {
		int result = 10000;				//리턴할 결과
		if(num==3) return value[y][x];	//세번째 꽃이면 해당 칸의 값 반환
		visited[y][x] = true;
		visited[y-1][x] = true;
		visited[y][x-1] = true;
		visited [y+1][x] = true;
		visited[y][x+1] = true;			//visited배열 처리
		for(int i=y; i<width-1; i++) {
			int x_pos = (i==y) ? x : 1;	//올바른 부분부터 탐색하기 위한 처리
			for(int j=x_pos; j<width-1; j++) {
				if(!visited[i][j] && !visited[i][j-1] && !visited[i][j+1] && !visited[i-1][j]) {	//해당 칸에 심을 수 있는지 확인
					result = Math.min(result, calc(i, j, visited, num+1));	//현재까지의 result와 새로 받아온 result 값 중 더 작은 값 채택
					visited[i][j] = false;
					visited[i-1][j] = false;
					visited[i][j-1] = false;
					visited [i+1][j] = false;
					visited[i][j+1] = false;	//visited 풀어줌 (근데 왜??ㅜㅜㅜ)
				}
			}
		}
		return result + value[y][x];	//결과 리턴
	}
}



