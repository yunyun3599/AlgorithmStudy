package tmp;
import java.io.*;
import java.util.*;

public class _15684_최윤재_사다리조작_구글링 {

	static int N,M,H;
	static int[][] map;
	static boolean[][] visited;
	static int ladder_num;
	static boolean isEnd;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    H = Integer.parseInt(st.nextToken());
	    
	    map = new int[H+2][N+1];
	    
	    for(int i=0; i<M; i++) {
	    	st = new StringTokenizer(br.readLine()," ");
	    	map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
	    }
	    for(int i=0; i<=3; i++) {	//사다리를 0개~3개 놓는 경우에 대해 수행
	    	ladder_num = i;
	    	check(1,1,0);
	    	if(isEnd) break;	//부합하는 경우 생기면 그만하기
	    }
	    System.out.println(isEnd? ladder_num : -1);
	}
	static void check(int y, int x, int cnt) {
		if(isEnd) return;		//부합하는 경우 return
		if(ladder_num == cnt) {	//사다리 수 계획한만큼 다 놓았으면 가능한지 확인 후 가능한지 여부 설정
			if(eval()) {
				isEnd = true;
			}
			return;
		}
		for(int i=y; i<=H; i++) {	//사다리 놓는 경우에 대한 백트래킹
			int x_start = y==i ? x : 1;
			for(int j=x_start; j<N; j++) {
				if(map[i][j]==1 || map[i][j-1]==1 || map[i][j+1]==1) continue;
				map[i][j] = 1;
				check(i, j, cnt+1);
				map[i][j] = 0;
			}
		}
	}
	static boolean eval() {
		for(int i=1; i<=N; i++) {	//i가 이번에 확인할 세로 위치
			int j = 1;		//j가 위에서부터 몇번째 칸에 위치했는지에 대한 변수
			int tmp = i;	//tmp는 현재 어떤 세로줄에 있는지 여부
			while(j<=H+1) {	//가장 밑에 이를 때까지 반복
				if(map[j][tmp] == 1 ) {//오른쪽으로 가는 경우
					tmp++;	//오른쪽으로 갔으므로 tmp는 1 증가
				}
				else if(map[j][tmp-1] == 1) {	//왼쪽으로 가는 경우
					tmp--;
				}
				j++;	//한 칸 밑으로 이동한 것
			}
			if( i != tmp) {	//처음 위치와 다르면 false 반환
				return false;
			}
		}
		return true;
	}

}

//참고 블로그 : https://jaejin89.tistory.com/97





