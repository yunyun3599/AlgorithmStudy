package week17;
import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{	//�켱����ť�� ���� ��� ��ü
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

public class _1504_������_Ư�����ִܰ�� {

	static int N;
	static int E;
	static ArrayList<Node>[] map;	//��������Ʈ
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
		/////////////////////////////////////////////////////�Է�
		int start_to_stop1 = dijkstra(0,stop1);		//������ -> ù��°������ -> �ι�°������ -> ������ ���
		int start_to_stop2 = dijkstra(0,stop2);		//������ -> �ι�°����� -> ù��°������ -> ������ ���
		int stop1_to_stop2 = dijkstra(stop1, stop2);
		int stop1_to_dest = dijkstra(stop1, N-1);
		int stop2_to_dest = dijkstra(stop2, N-1);
		
		int case1 = start_to_stop1 + stop1_to_stop2 + stop2_to_dest;
		int case2 = start_to_stop2 + stop1_to_stop2 + stop1_to_dest;
		if(case1<0) System.out.println(-1);		//���� �Ұ��� ��� -1 ���
		else System.out.println(Math.min(case1, case2));	//���� ������ ��� �� ���� ���� ���
	}
	public static int dijkstra(int start, int end) {	//�켱���� ť�� �̿��� dijkstra�˰��� ����
		visited = new boolean[N];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,0));		//���������� �켱����ť�� ����
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			visited[tmp.node] = true;
			if (tmp.node == end) return tmp.dist;	//poll�� ��尡 �������� �� ��������� �Ÿ� ����
			else {		//������ �ƴ� �ÿ��� �ű⿡ ����� ���� �� ���� �湮���� ���� ������ �켱���� ť�� ����
				for(int i=0; i<map[tmp.node].size(); i++) {
					Node next = map[tmp.node].get(i);
					if(!visited[next.node]) pq.add(new Node(next.node, next.dist+tmp.dist));
				}
			}
		}
		return Integer.MIN_VALUE/3;	//��ΰ� ���� ���� ���� ��� (�������� ��ε� ������ ���ϱ� ������ Integer���� ���� �ֵ��� �ϱ� ���� 3���� �������� ������)
	}

}





