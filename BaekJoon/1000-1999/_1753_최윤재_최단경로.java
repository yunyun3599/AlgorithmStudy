package week16;
import java.util.*;
import java.io.*;

class Node{
	int num;
	int weight;
	Node(int num, int weight){
		this.num = num;
		this.weight = weight;
	}
}
public class _1753_최윤재_최단경로 {

	static int node;
	static int edge;
	static int start;
	static ArrayList<Node>[] adj_arr;
	static boolean[] visited;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		node = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine())-1;
		adj_arr = new ArrayList[node];
		for(int i=0; i<node; i++) adj_arr[i] = new ArrayList<>();
		visited = new boolean[node];
		result = new int[node];
		for(int i=0; i<edge; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int outgoing = Integer.parseInt(st.nextToken())-1;
			int incoming = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			adj_arr[outgoing].add(new Node(incoming, weight));
		}
		//////////////////////////////////////////////////////////////////////여기까지 입력
		Queue<Node> pq = new PriorityQueue<Node>((Node1,Node2)-> {			//weight 작은 게 우선순위
			return Node1.weight - Node2.weight;
		});
		
		for(int i=0; i<adj_arr[start].size(); i++) {						//시작점과 연결된 노드들 우선순위 큐에 넣음
			pq.add(adj_arr[start].get(i));
		}
		while(!pq.isEmpty()) {											//큐 빌 때까지 수행
			Node tmp = pq.poll();										//가장 weight적은 노드 poll
			if (visited[tmp.num]) continue;								//이미 방문한 경우에는 다시 뽑음
			visited[tmp.num] = true;									//방문 아직 안한 경우에는 visited 배열 값 true로 바꿈
			result[tmp.num] = tmp.weight;								//result배열에 weight 저장
			for(int i=0; i<adj_arr[tmp.num].size(); i++) {				//방금 뽑은 노드와 연결된 노드들 큐에 넣음
				Node next = adj_arr[tmp.num].get(i);
				if(!visited[next.num]) pq.add(new Node(next.num,tmp.weight+next.weight));	//아직 방문 안한 경우에만 넣기
			}
		}
		for(int i=0; i<node; i++) {										//결과 출력
			if (i == start) sb.append("0\n");							//시작점은 0 출력
			else if(result[i] == 0) sb.append("INF\n");					//weight가 자연수이므로 result에 0이 저장되어 있으면 도달 불가한 경우
			else sb.append(result[i]+"\n");
		}
		System.out.println(sb);
	}
	
}
