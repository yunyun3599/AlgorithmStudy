package tmp;
import java.util.*;
import java.io.*;

public class _17070_최윤재_파이프옮기기 {

	static int N;		//너비
	static int[][] map;	//벽지 여부
	static int result;	//결과
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}		
		}////////////////////////////////////////////////////입력
		dfs(0,1,0);			//파이프의 끝이 (0,1)에서 시작, 방향은 가로 (방향 가로:0 세로:1 대각선:2)
		System.out.println(result);
	}
	public static void dfs(int y, int x, int dir) {
		if(y==N-1 && x==N-1) {		//목표 지점에 도착한 경우 result하나 증가
			result++;
			return;
		}
		switch(dir) {	//방향에 따라 갈 수 있는 경우 확인
		case  0:		//가로
			if(check(y, x+1)) dfs(y, x+1, 0);		//가로로 한칸 더
			if(check(y+1, x+1) && map[y+1][x]==0 && map[y][x+1]==0) dfs(y+1, x+1, 2);	//대각선 아래
			break;
		case 1:		//세로
			if(check(y+1, x)) dfs(y+1, x, 1);		//세로로 한칸 더
			if(check(y+1, x+1) && map[y+1][x]==0 && map[y][x+1]==0) dfs(y+1, x+1, 2);	//대각선 아래
			break;
		case 2:	//대각선
			if(check(y, x+1)) dfs(y, x+1, 0);	//가로
			if(check(y+1, x)) dfs(y+1, x, 1);	//세로
			if(check(y+1, x+1) && map[y+1][x]==0 && map[y][x+1]==0) dfs(y+1, x+1, 2);	//대각선
			break;
		}
	}
	
	public static boolean check(int y, int x) {	//범위 및 벽지 체크
		if(y<N && x<N && 0<=y && 0<=x && map[y][x]==0) return true;
		return false;
	}
}

