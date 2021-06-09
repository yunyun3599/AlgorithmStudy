package tmp;
import java.io.*;
import java.util.*;
public class _1303_최윤재_전쟁전투 {

	static int width;
	static int height;
	static char[][] map;
	static boolean[][] visited;
	static int white;	//흰 옷 입은 사람들의 총합
	static int blue;	//파란 옷 입은 사람들의 총합
	static int[] axis_y = {-1,1,0,0};
	static int[] axis_x = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		
		map = new char[height][width];
		visited = new boolean[height][width];
		
		for(int i=0; i<height; i++) {		//map에 값을 추가해줌
			String tmp = br.readLine();
			for(int j=0; j<width; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		
		for(int i = 0; i<height; i++) {		//dfs 돌리기
			for(int j=0; j<width; j++) {
				if(map[i][j] == 'W' && !visited[i][j]) white += Math.pow(dfs(i,j,'W', 0) , 2);	//W에 대해 돌리기
				if(map[i][j] == 'B' && !visited[i][j]) blue += Math.pow(dfs(i,j,'B', 0), 2);	//B에 대해 돌리기
			}
		}
		System.out.println(white+" "+blue);
	}
	public static int dfs(int y, int x, char color, int count) {	//dfs 함수
		visited[y][x] = true;		//이번 좌표 true로 설정
		count++;		//사람 수 하나 늘리기
		for(int k=0; k<4; k++) {	//상하좌우 탐색
			int next_y = y+axis_y[k];
			int next_x = x+axis_x[k];
			if(check(next_y, next_x, color)) count = dfs(next_y, next_x, color, count);	//동일 옷을 입은 사람이면 재귀적으로 dfs 돌림, count 수 증가
		}
		return count;	//count 리턴
	}
	public static boolean check(int y, int x, char color) {	//범위와 색상 체크
		if(y>=0 && y<height && x>=0 && x<width && !visited[y][x] && map[y][x] == color) return true;
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
