package tmp;
import java.io.*;
import java.util.*;
public class _3005_최윤재_크로스워드퍼즐쳐다보기 {

	static int R;
	static int C;
	static char[][] map;
	static boolean[][] visited;
	static String result = "zzzzzzzzzzzzzzzzzzzz";	//사전상 가장 뒤 문자열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			String tmp = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}////////////////////////////////////////입력
		//가로
		visited = new boolean[R][C];
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]!='#' && !visited[i][j]) {	//문자가 있고 아직 확인 안한 경우
					StringBuffer tmp = new StringBuffer();	//만들어지는 단어
					tmp.append(map[i][j]);	//첫 문자 append
					dfs(i, j, 0, 1, tmp);	//dfs로 오른쪽 탐색 (0이 dy고 1이 dx)
				}
			}
		}
		//세로
		visited = new boolean[R][C];	//방문배열 초기화
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]!='#' && !visited[i][j]) {
					StringBuffer tmp = new StringBuffer();
					tmp.append(map[i][j]);
					dfs(i, j, 1, 0, tmp);	//dfs로 아래쪽 탐색 (1이 dy고 0이 dx)
				}
			}
		}
		System.out.println(result);
	}
	static void dfs(int y, int x, int dy, int dx, StringBuffer tmp) {	//현재 위치와 움직일 방향, 만들어지는 문자열을 받음
		if(check(y+dy, x+dx)) {	//범위 맞고 문자 있는 경우
			visited[y+dy][x+dx] = true;
			tmp.append(map[y+dy][x+dx]);
			dfs(y+dy, x+dx, dy, dx, tmp);	//다음 문자 있을 자리도 확인
		}
		else {	//위의 경우가 아니면 단어의 끝
			String tmpresult = tmp.toString();	//비교 위해 string으로 바꿈
			if(tmpresult.length()<2) return;	//문자열 길이가 1이면 확인 안함
			result = result.compareTo(tmpresult) < 0 ? result : tmpresult;	//더 사전순으로 앞인 것을 저장
		}
	}
	
	static boolean check(int y, int x) {	//범위 및 문자 여부 확인
		if(y>=0 && x>=0 && y<R && x<C && map[y][x]!='#') return true;
		return false;
	}
}
