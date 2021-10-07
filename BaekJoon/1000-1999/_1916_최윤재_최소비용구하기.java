import java.io.*;
import java.util.*;

class Bus implements Comparable<Bus> {
	int to;
	int weight;
	Bus(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}
	public int compareTo(Bus other) {
		return this.weight - other.weight;
	}
}

public class _1916_최윤재_최소비용구하기 {

	static int N;
	static int M;
	static ArrayList<Bus>[] adj;	//adj[i]에 i번째 도시에서 갈 수 있는 도착지와 weight 나
	static boolean visited[];	//방문처리 
	static int start;	//시작 도시 
	static int end;		//도착 도시 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		adj = new ArrayList[N+1];	//인접행렬 
		visited = new boolean[N+1];
		
		for(int i=0; i<=N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adj[from].add(new Bus(to, weight));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		////////////////////////////////////////////////입력
		
		PriorityQueue<Bus> pq = new PriorityQueue<>();	//우선순위 큐 이
		pq.add(new Bus(start, 0));	//출발 지점을 weight를 0으로 해서 pq에 넣음 
		
		while(!pq.isEmpty()) {
			Bus prev = pq.poll();	//가장 가까운 도시 poll 
			if(prev.to==end) {	//도착지가 최종 도착지면 끝 
				System.out.println(prev.weight);
				break;
			}
			if(visited[prev.to]) continue; //poll한 값의 도착지가 이미 도착한 적 있는 곳이면 continue
			visited[prev.to] = true;	//방문 처리 
			for(Bus next : adj[prev.to]) {	//해당 지점에서 갈 수 있는 도시들 확인 
				if(visited[next.to]) continue;	//가려는 곳이 이미 도착해있으면 continue
				pq.add(new Bus(next.to, prev.weight + next.weight));	//아직 방문하지 않은 도시이면 pq에 넣기 
			}
		}
	}

}
