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
public class _1753_������_�ִܰ�� {

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
		//////////////////////////////////////////////////////////////////////������� �Է�
		Queue<Node> pq = new PriorityQueue<Node>((Node1,Node2)-> {			//weight ���� �� �켱����
			return Node1.weight - Node2.weight;
		});
		
		for(int i=0; i<adj_arr[start].size(); i++) {						//�������� ����� ���� �켱���� ť�� ����
			pq.add(adj_arr[start].get(i));
		}
		while(!pq.isEmpty()) {											//ť �� ������ ����
			Node tmp = pq.poll();										//���� weight���� ��� poll
			if (visited[tmp.num]) continue;								//�̹� �湮�� ��쿡�� �ٽ� ����
			visited[tmp.num] = true;									//�湮 ���� ���� ��쿡�� visited �迭 �� true�� �ٲ�
			result[tmp.num] = tmp.weight;								//result�迭�� weight ����
			for(int i=0; i<adj_arr[tmp.num].size(); i++) {				//��� ���� ���� ����� ���� ť�� ����
				Node next = adj_arr[tmp.num].get(i);
				if(!visited[next.num]) pq.add(new Node(next.num,tmp.weight+next.weight));	//���� �湮 ���� ��쿡�� �ֱ�
			}
		}
		for(int i=0; i<node; i++) {										//��� ���
			if (i == start) sb.append("0\n");							//�������� 0 ���
			else if(result[i] == 0) sb.append("INF\n");					//weight�� �ڿ����̹Ƿ� result�� 0�� ����Ǿ� ������ ���� �Ұ��� ���
			else sb.append(result[i]+"\n");
		}
		System.out.println(sb);
	}
	
}
