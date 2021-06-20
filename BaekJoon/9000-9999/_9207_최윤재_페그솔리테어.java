package tmp;
import java.io.*;
import java.util.*;
public class _9207_최윤재_페그솔리테어 {

	static int testcase;
	static char map[][] = new char[5][9];	//입력받을 판
	static int[] axis_x = {0,0,-1,1};	//상하좌우
	static int[] axis_y = {-1,1,0,0};
	static int remain;	//남은 말의 개수
	static int repeat;	//몇번 반복했는지
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testcase = Integer.parseInt(br.readLine());
		
		while(testcase-->0) {
			remain = Integer.MAX_VALUE;
			for(int i=0; i<5; i++) {
				String tmp = br.readLine();
				for(int j=0; j<9; j++) 
					map[i][j] = tmp.charAt(j);
			}//////////////////////////////////////입력받기
			backtracking(0);	//백트래킹 수행, 파라미터로 depth주기
			result.append(remain+" "+repeat+"\n");	//결과 append
			if(testcase!=0) br.readLine();	//마지막 테스트케이스인 경우 빼고 br.readLine() 한 번씩 해주기
		}
		System.out.println(result);
	}
	public static void backtracking(int depth) {	//백트래킹
		int cnt = 0;	//현재 판 위에 있는 o의 개수
		for (int i=0; i<5; i++) {	//for문 돌며 세보기
			for(int j=0; j<9; j++) {
				if(map[i][j] == 'o') cnt++;
			}
		}
		if(remain > cnt) {	//현재 최소값보다 이번에 시도하는 최소값이 더 작을 때
			remain = cnt;
			repeat = depth;
		}
		for(int i=0; i<5; i++) {	//전체 판을 한번씩 돌아보며 o이 있는 부분에 대해 움직일 수 있는 경우 탐색
			for(int j=0; j<9; j++) {
				if(map[i][j] == 'o') {
					for(int k=0; k<4; k++) {	//상하좌우 탐색
						int nx = j+axis_x[k];
						int ny = i+axis_y[k];
						int nnx = nx+axis_x[k];
						int nny = ny+axis_y[k];
						if(nnx>=0 && nny>=0 && nnx<9 && nny<5 && map[ny][nx]=='o' && map[nny][nnx]=='.') {	//범위 및 이동 가능 여부 확인
							map[i][j]='.';
							map[ny][nx]='.';
							map[nny][nnx]='o';
							backtracking(depth+1);	//다음 단계 수행
							map[i][j] = 'o';	//map원래 모양으로 돌려놓기
							map[ny][nx] = 'o';
							map[nny][nnx] = '.';
						}
					}
				}
			}
		}
	}
}
