package week12;
import java.io.*;
import java.util.*;
public class _1197_������_�ּҽ��д�Ʈ�� {
	
	static int vertex;
	static int edge;
	static ArrayList<Node>[] graph;
	static int[] visited;
	static int visit;
	static int result;
	static PriorityQueue<Node> pqueue = new PriorityQueue<>();					//�켱���� ť ���
	
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
			graph[vertex1].add(new Node(vertex2, weight));				// ����Ǿ������� ���� ��Ŀ� ����
			graph[vertex2].add(new Node(vertex1, weight));
		}
//////////////////////////////////////////////////////////////////////////�Է�
		pqueue.add(new Node(1,0));										//1�� ������ ����
		while(!pqueue.isEmpty()) {
			Node next_node = pqueue.poll();							
			if(visited[next_node.vertex] == 1) continue;				//poll �� ��尡 �̹� visited �����̸� �ٽ� ����
			
			result+= next_node.weight;									//weight�� ���� ����� ����
			visited[next_node.vertex] = 1;								//�湮 ó��
			visit++;													//�湮�� ��� ����++
			if (visit == vertex) break;									//��� ��带 �湮�� ��� break
			
			for(int i=0; i<graph[next_node.vertex].size(); i++) {		//�̹��� �湮�� ���鿡 ���� edge���� ���� ��尡 ���� �̹湮�� ��� �켱���� ť�� ����
				Node tmp = graph[next_node.vertex].get(i);
				if(visited[tmp.vertex] == 0) pqueue.add(tmp);
			}
		}
		System.out.println(result);
	}
}

class Node implements Comparable<Node>{					//Node class�� weight ���� ���� ������� ����
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
