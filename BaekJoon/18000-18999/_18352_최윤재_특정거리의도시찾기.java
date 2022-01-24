import java.io.*;
import java.util.*;
public class _18352_최윤재_특정거리의도시찾기 {
	
	static int N, M, K, X;
	static HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();	//각 도시에 대한 인접 도시 정보 저장 
	static boolean visited[];	//각 도시 방문 여부 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {	//인접리스트 초기화 
			adj.put(i, new ArrayList<Integer>());
		}
		
		for(int i=0; i<M; i++) {	//인접 정보 저장 
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adj.get(from).add(to);
		}
		
		Queue<Integer> queue = new LinkedList<>();	//bfs 이용 
		queue.add(X);
		visited[X] = true;
		while(!queue.isEmpty() && K!= 0) {	//거리가 K될 때까지 수행 
			K--;
			int size = queue.size();
			for(int i=0; i<size; i++) {
				int from = queue.poll();
				ArrayList<Integer> tmp_adj = adj.get(from);	//현재 확인하려는 도시와 인접한 도시 정보 가져옴 
				for(int to : tmp_adj) {	//각 도착지별로 아직 방문 안한 경우 queue에 추가 
					if(visited[to]) continue;
					queue.add(to);
					visited[to] = true;
				}
			}
		}
		if(queue.size() == 0) System.out.println(-1);	//해당 거리에 존재하는 도시가 없는 경우 
		else {	//queue에 남아있는 도시들을 오름차순으로 리턴
			ArrayList<Integer> result = new ArrayList<>();
			while(!queue.isEmpty()) {
				result.add(queue.poll());
			}
			Collections.sort(result);
			StringBuilder sb = new StringBuilder();
			for(int city : result) {
				sb.append(city+"\n");
			}
			System.out.println(sb);
		}
	}

}
