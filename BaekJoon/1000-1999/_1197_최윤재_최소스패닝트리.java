package week12;
import java.io.*;
import java.util.*;
public class _1197_최윤재_최소스패닝트리 {
	
	static int vertex;
	static int edge;
	static ArrayList<Node>[] graph;
	static int[] visited;
	static int visit;
	static int result;
	static PriorityQueue<Node> pqueue = new PriorityQueue<>();					//우선순위 큐 사용
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		vertex = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		graph = new ArrayList[vertex+1];
		visited = new int[vertex+1];
			
		for(int i=0; i<vertex+1; i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<edge; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int vertex1 = Integer.parseInt(st.nextToken());
			int vertex2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[vertex1].add(new Node(vertex2, weight));				// 연결되어있으면 인접 행렬에 저장
			graph[vertex2].add(new Node(vertex1, weight));
		}
//////////////////////////////////////////////////////////////////////////입력
		pqueue.add(new Node(1,0));										//1번 노드부터 수행
		while(!pqueue.isEmpty()) {
			Node next_node = pqueue.poll();							
			if(visited[next_node.vertex] == 1) continue;				//poll 한 노드가 이미 visited 상태이면 다시 뽑음
			
			result+= next_node.weight;									//weight를 최종 결과에 합함
			visited[next_node.vertex] = 1;								//방문 처리
			visit++;													//방문된 노드 개수++
			if (visit == vertex) break;									//모든 노드를 방문한 경우 break
			
			for(int i=0; i<graph[next_node.vertex].size(); i++) {		//이번에 방문한 노드들에 대한 edge들을 도착 노드가 아직 미방문인 경우 우선순위 큐에 넣음
				Node tmp = graph[next_node.vertex].get(i);
				if(visited[tmp.vertex] == 0) pqueue.add(tmp);
			}
		}
		System.out.println(result);
	}
}

class Node implements Comparable<Node>{					//Node class는 weight 값이 작은 순서대로 정렬
	int vertex;
	int weight;
	Node(int vertex, int weight){
		this.vertex = vertex;
		this.weight = weight;
	}
	public int compareTo(Node node) {
		if(this.weight > node.weight) {
			return 1;
		}
		else if (this.weight < node.weight) {
			return -1;
		}
		return 0;
	}
}
