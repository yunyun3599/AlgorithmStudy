package tmp;
import java.io.*;
import java.util.*;
public class _13023_최윤재_ABCDE {

	static int N;
	static int M;
	static ArrayList<Integer>[] adj;	//인접리스트
	static boolean[] visited;
	static boolean isPossible;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N];
		for(int i=0; i<N; i++) adj[i] = new ArrayList<Integer>();
		visited = new boolean[N];
		for(int i=0; i<M; i++) {	//친구 목록 받기
			st = new StringTokenizer(br.readLine());
			int person1 = Integer.parseInt(st.nextToken());
			int person2 = Integer.parseInt(st.nextToken());
			adj[person1].add(person2);
			adj[person2].add(person1);
		}
		for(int i=0; i<N; i++) {	//dfs수행
			dfs(i, 0);
			if(isPossible) break;	//가능한 경우가 하나라도 발견되면 더이상 수행하지 않음
		}
		if(isPossible) System.out.println(1);
		else System.out.println(0);
	}
	public static void dfs(int person, int depth) {
		visited[person] = true;	//방문처리
		if(depth >= 4) {	//depth가 4 이상이면 조건 만족
			isPossible = true; 
			return;
		}
		for(int friend : adj[person]) {	//친구들 중 아직 방문 안한 친구에 한해 dfs 또 수행
			if(!visited[friend]) dfs(friend, depth+1);
		}
		visited[person] = false;
	}

}
