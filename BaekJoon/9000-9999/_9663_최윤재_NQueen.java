package tmp;
import java.util.*;
public class _9663_최윤재_NQueen {

	static int N;
	static int result;
	static boolean map[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new boolean[N][N];
		
		dfs(0);		//dfs로 자리 채움
		System.out.println(result);
	}
	
	static void dfs(int row) {
		if(row == N) {	//모든 자리가 다 채워진 경우
			result++;
			return;
		}
		for(int i=0; i<N; i++) {	//각 열을 돌면서 채워보기
			if(promising(row, i) ) {	//채울 수 있는 자리인지 확인
				map[row][i] = true;
				dfs(row+1);			//채우고 다음 행 처리
				map[row][i] = false;
			}
		}
	}

	static boolean promising(int row, int col) {	//채울 수 있는 자리인지 확인
		for(int i=0; i<row; i++) {
			int diff = row - i;		//위의 행과의 차 (대각선 자리 도출에 쓰임)
			if(col-diff >= 0 && map[i][col-diff]) return false;	//왼쪽 대각선
			if(col+diff < N && map[i][col+diff]) return false;	//오른쪽 대각선
			if(map[i][col]) return false;	//같은 열인지
		}
		return true;	//모두 아니면 놓을 수 있는 자리
	}
}
