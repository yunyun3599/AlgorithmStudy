package graph;
import java.util.*;

public class √÷¿±¿Á_1260 {

	static int adj[][];
	static int visited[];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int node = sc.nextInt();
		int edge = sc.nextInt();
		int start = sc.nextInt();
		
		adj = new int[node][node];
		visited= new int[node];
		for(int i=0; i<node; i++) {
			Arrays.fill(adj[i], 0);
		}
		Arrays.fill(visited, 0);
		
		int a=0, b=0;
		for(int i=0; i<edge; i++) {
			a = sc.nextInt()-1;
			b = sc.nextInt()-1;
			adj[a][b]= adj[b][a]= 1;
		}
	
		dfs(start-1);
		System.out.println();
		Arrays.fill(visited, 0);
		bfs(start-1);
	}
	
	static void dfs(int node) {
		visited[node]=1;
		System.out.print((node+1)+" ");
		for(int i=0; i<visited.length; i++) {
			if(adj[node][i]==1 && visited[i]==0) {
				dfs(i);
			}
		}
		
	}
	
	static void bfs(int start) {
		Queue <Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		visited[start]=1;
		while(!queue.isEmpty()) {
			int q = queue.poll();
			System.out.print((q+1)+" ");
			for(int i=0; i<visited.length;i++) {
				if(adj[q][i]==1 && visited[i]==0) {
					queue.add(i);
					visited[i]=1;
				}
			}
		}
	}

}
