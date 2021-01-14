package week9;
import java.util.*;
import java.io.*;
public class _1967_최윤재 {
	
	static int num;					//총 노드 개수
	static ArrayList<Node>[] adj;	//인접리스트
	static int[] visited;			//방문 확인
	static Queue<Node> queue = new LinkedList();
	static int max=0;
	static int max_node=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num=Integer.parseInt(br.readLine());
		visited=new int[num];
		adj=new ArrayList[num];
		
		for(int i=0; i<num; i++) adj[i]=new ArrayList<>();	//배열에 ArrayList 객체 생성
		for(int i=0; i<num-1; i++) {
			String line = br.readLine();
			String[] tmp = line.split(" ");
			adj[Integer.parseInt(tmp[0])-1].add(new Node(Integer.parseInt(tmp[1])-1,Integer.parseInt(tmp[2])));		//부모노드 -> 자식노드 edge를 adj에 표시
			adj[Integer.parseInt(tmp[1])-1].add(new Node(Integer.parseInt(tmp[0])-1,Integer.parseInt(tmp[2])));		//자식노드 -> 부모노드 edge를 adj에 표시
		}
		//////////////////////////////////////////////////////BFS로 루트에서 가장 먼 노드 찾음
		queue.add(new Node(0,0));							//큐에 넣을 형태는 Node클래스. 앞의 파라미터는 노드 번호, 뒤의 파라미터는 해당 노드까지 오는 데 필요한 가중치
		visited[0]=1;
		while(!queue.isEmpty()) {							//루트에서 가장 멀리 떨어진 노드 찾기 위해 bfs 수행
			Node tmp = queue.poll();						
			for(int i=0; i<adj[tmp.node].size(); i++) {
				if(visited[adj[tmp.node].get(i).node]==0) {			//poll한 노드와 인접한 노드들을 queue에 집어넣음
					queue.add(new Node(adj[tmp.node].get(i).node, tmp.weight+adj[tmp.node].get(i).weight));		//각각 루트부터 자기까지 오는 데 필요한 가중치의 합을 가지고 있음
					if (tmp.weight+adj[tmp.node].get(i).weight > max) {
						max=tmp.weight+adj[tmp.node].get(i).weight;
						max_node=adj[tmp.node].get(i).node;
					}
					visited[adj[tmp.node].get(i).node]=1;
				}
			}
		}
	//////////////////////////////////////////////////////////////////////BFS로 루트에서 가장 먼 노드 찾음. (max_node)
		for(int i=0; i<num; i++) visited[i]=0;							//visited배열 값 다시 전부 0으로 바꾸기
		max=0;															//max 값도 0으로 바꾸기
		queue.add(new Node(max_node, 0));								//앞에서 구한 값을 토대로 루트에서 가장 먼 노드에서부터 bfs 수행	
		visited[max_node]=1;
		while(!queue.isEmpty()) {
			Node tmp = queue.poll();
			for(int i=0; i<adj[tmp.node].size(); i++) {
				if(visited[adj[tmp.node].get(i).node]==0) {				//poll한 노드와 인접한 노드들을 queue에 집어넣음
					queue.add(new Node(adj[tmp.node].get(i).node, tmp.weight+adj[tmp.node].get(i).weight));		//각각 루트부터 자기까지 오는 데 필요한 가중치의 합을 가지고 있음
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

//트리의 지름