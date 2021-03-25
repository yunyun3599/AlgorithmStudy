package week9;
import java.util.*;
import java.io.*;
public class _1967_������ {
	
	static int num;					//�� ��� ����
	static ArrayList<Node>[] adj;	//��������Ʈ
	static int[] visited;			//�湮 Ȯ��
	static Queue<Node> queue = new LinkedList();
	static int max=0;
	static int max_node=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num=Integer.parseInt(br.readLine());
		visited=new int[num];
		adj=new ArrayList[num];
		
		for(int i=0; i<num; i++) adj[i]=new ArrayList<>();	//�迭�� ArrayList ��ü ����
		for(int i=0; i<num-1; i++) {
			String line = br.readLine();
			String[] tmp = line.split(" ");
			adj[Integer.parseInt(tmp[0])-1].add(new Node(Integer.parseInt(tmp[1])-1,Integer.parseInt(tmp[2])));		//�θ��� -> �ڽĳ�� edge�� adj�� ǥ��
			adj[Integer.parseInt(tmp[1])-1].add(new Node(Integer.parseInt(tmp[0])-1,Integer.parseInt(tmp[2])));		//�ڽĳ�� -> �θ��� edge�� adj�� ǥ��
		}
		//////////////////////////////////////////////////////BFS�� ��Ʈ���� ���� �� ��� ã��
		queue.add(new Node(0,0));							//ť�� ���� ���´� NodeŬ����. ���� �Ķ���ʹ� ��� ��ȣ, ���� �Ķ���ʹ� �ش� ������ ���� �� �ʿ��� ����ġ
		visited[0]=1;
		while(!queue.isEmpty()) {							//��Ʈ���� ���� �ָ� ������ ��� ã�� ���� bfs ����
			Node tmp = queue.poll();						
			for(int i=0; i<adj[tmp.node].size(); i++) {
				if(visited[adj[tmp.node].get(i).node]==0) {			//poll�� ���� ������ ������ queue�� �������
					queue.add(new Node(adj[tmp.node].get(i).node, tmp.weight+adj[tmp.node].get(i).weight));		//���� ��Ʈ���� �ڱ���� ���� �� �ʿ��� ����ġ�� ���� ������ ����
					if (tmp.weight+adj[tmp.node].get(i).weight > max) {
						max=tmp.weight+adj[tmp.node].get(i).weight;
						max_node=adj[tmp.node].get(i).node;
					}
					visited[adj[tmp.node].get(i).node]=1;
				}
			}
		}
	//////////////////////////////////////////////////////////////////////BFS�� ��Ʈ���� ���� �� ��� ã��. (max_node)
		for(int i=0; i<num; i++) visited[i]=0;							//visited�迭 �� �ٽ� ���� 0���� �ٲٱ�
		max=0;															//max ���� 0���� �ٲٱ�
		queue.add(new Node(max_node, 0));								//�տ��� ���� ���� ���� ��Ʈ���� ���� �� ��忡������ bfs ����	
		visited[max_node]=1;
		while(!queue.isEmpty()) {
			Node tmp = queue.poll();
			for(int i=0; i<adj[tmp.node].size(); i++) {
				if(visited[adj[tmp.node].get(i).node]==0) {				//poll�� ���� ������ ������ queue�� �������
					queue.add(new Node(adj[tmp.node].get(i).node, tmp.weight+adj[tmp.node].get(i).weight));		//���� ��Ʈ���� �ڱ���� ���� �� �ʿ��� ����ġ�� ���� ������ ����
					if (tmp.weight+adj[tmp.node].get(i).weight > max) {
						max=tmp.weight+adj[tmp.node].get(i).weight;
						max_node=adj[tmp.node].get(i).node;
					}
					visited[adj[tmp.node].get(i).node]=1;
				}
			}
		}
		System.out.println(max);
	}

}

class Node{
	int node;
	int weight;
	Node(int node, int weight){
		this.node=node;
		this.weight=weight;
	}
}

//Ʈ���� ����