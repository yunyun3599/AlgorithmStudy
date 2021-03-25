package week17;
import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{	//우선순위큐에 넣을 노드 객체
	int node;
	int dist;
	Node(int node, int dist){
		this.node = node;
		this.dist = dist;
	}
	public int compareTo(Node another) {
		return this.dist - another.dist;
	}
}

public class _1504_최윤재_특정한최단경로 {

	static int N;
	static int E;
	static ArrayList<Node>[] map;	//인접리스트
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		map = new ArrayList[N];
		
		for(int i=0; i<N; i++)
			map[i] = new ArrayList();
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken())-1;
			int node2 = Integer.parseInt(st.nextToken())-1;
			int dist = Integer.parseInt(st.nextToken());
			map[node1].add(new Node(node2, dist));
			map[node2].add(new Node(node1, dist));
		}
		st = new StringTokenizer(br.readLine());
		int stop1 = Integer.parseInt(st.nextToken())-1;
		int stop2 = Integer.parseInt(st.nextToken())-1;
		/////////////////////////////////////////////////////입력
		int start_to_stop1 = dijkstra(0,stop1);		//시작점 -> 첫번째경유지 -> 두번째경유지 -> 도착점 경로
		int start_to_stop2 = dijkstra(0,stop2);		//시작점 -> 두번째경우지 -> 첫번째경유지 -> 도착점 경로
		int stop1_to_stop2 = dijkstra(stop1, stop2);
		int stop1_to_dest = dijkstra(stop1, N-1);
		int stop2_to_dest = dijkstra(stop2, N-1);
		
		int case1 = start_to_stop1 + stop1_to_stop2 + stop2_to_dest;
		int case2 = start_to_stop2 + stop1_to_stop2 + stop1_to_dest;
		if(case1<0) System.out.println(-1);		//도달 불가의 경우 -1 출력
		else System.out.println(Math.min(case1, case2));	//도달 가능한 경우 더 작은 값을 출력
	}
	public static int dijkstra(int start, int end) {	//우선순위 큐를 이용해 dijkstra알고리즘 구현
		visited = new boolean[N];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,0));		//시작점부터 우선순위큐에 넣음
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			visited[tmp.node] = true;
			if (tmp.node == end) return tmp.dist;	//poll한 노드가 도착점일 때 여기까지의 거리 리턴
			else {		//도착점 아닐 시에는 거기에 연결된 노드들 중 아직 방문하지 않은 노드들을 우선순위 큐에 넣음
				for(int i=0; i<map[tmp.node].size(); i++) {
					Node next = map[tmp.node].get(i);
					if(!visited[next.node]) pq.add(new Node(next.node, next.dist+tmp.dist));
				}
			}
		}
		return Integer.MIN_VALUE/3;	//경로가 없는 경우는 음수 출력 (마지막에 경로들 조합을 합하기 때문에 Integer범위 내에 있도록 하기 위해 3으로 나눈값을 리턴함)
	}

}





