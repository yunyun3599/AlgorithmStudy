package tmp;
import java.util.*;
import java.io.*;

public class _10971_최윤재_외판원순회2 {

	static int N;
	static int adj[][];	//인접배열
	static boolean visited[];	//방문처리
	static int result = Integer.MAX_VALUE;	//결과
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		adj = new int[N][N];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}/////////////////////////////////입력
		visited[0] = true;	//0번째 도시로 시작 (어차피 순환이라 시작하는 지점 상관 없음)
		move(0, 0, 1);	//현재 위치한 도시, 현재까지 weight의 합, 방문한 도시 개수 순으로 파라미터
		System.out.println(result);	//결과 출력
	}
	public static void move(int current, int total, int num) {
		if(num==N) {	//모든 도시를 다 돌았을 때 (다시 0번 도시로 돌아가면 됨)
			if(adj[current][0]!=0) result  = Math.min(result, total+adj[current][0]);	//현재 도시에서 0번 도시로 갈 수 있을 때
			return;
		}
		else {	//아직 방문할 도시가 남았을 때
			for(int i=0; i<N; i++) {
				if(!visited[i] && adj[current][i]!=0) {	//아직 방문 안했고 현재 위치에서 갈 수 있는 도시 방문하기
					visited[i] = true;
					move(i, total+adj[current][i], num+1);
					visited[i] = false;
				}
			}
		}
	}
}