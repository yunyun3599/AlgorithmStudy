package tmp;
import java.io.*;
import java.util.*;
public class _1976_최윤재_여행가자_dfs {

	static int num;			//총 도시 개수
	static int visit_num;	//방문할 도시 개수
	static int[][] adj;		//인접행렬
	static StringTokenizer st;
	static boolean[] visited;	//방문처리
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		visit_num = Integer.parseInt(br.readLine());
		adj = new int[num][num];
		for(int i=0; i<num; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<num; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}/////////////////////////////////////////////////////////입력
		st = new StringTokenizer(br.readLine());
		boolean flag = true;	//우선은 가능하다고 해놓기
		int from;				//이전에 여행했던 도시
		int to = Integer.parseInt(st.nextToken())-1;	//다음으로 이동할 도시
		while(st.hasMoreTokens()) {	//갈 도시들을 다 갈때까지수행
			visited = new boolean[num];	//방문처리용
			from = to;	//이전에 도착지가 이번 루프에서는 출발지
			to = Integer.parseInt(st.nextToken())-1;	//새로운 도착지 받기
			if (from==to) continue;		//만약에 같은 도시를 또 여행하는 경우는 무조건 true니까 continue (안했다가 틀렸음 어이없음)
			flag &= dfs(from,to);	//모든 경우에 대해 여행이 가능해야하므로 and연산을 이용해서 하나라도 안되는 경우는 flag가 false이도록 함
		}
		if(flag) System.out.println("YES");
		else System.out.println("NO");
	}
	public static boolean dfs(int city, int dest) {	//dfs수행해서 갈 수 있는지 확인
		boolean flag = false;	//우선은 못간다고 해놓기
		visited[city] = true;	//방문처리
		for(int i=0; i<num; i++) {	//갈 수 있는 도시들에 대해 재귀적으로 dfs수행
			if(adj[city][i]==1 && !visited[i]) {	//갈 수 있는 길이 있고 아직 방문 안한 경우
				if(i==dest) return true;	//다음에 갈 도시가 도착지면 true 리턴
				else flag = flag | dfs(i, dest);	//모든 경우중에 한번이라도 도착 가능하면 되므로 or연산 이용해서 true가 하나라도 있나 확인
			}
		}
		return flag; //flag 리턴
	}

}
