package graph;
import java.util.*;

public class √÷¿±¿Á_11724 {
	
	static int node;
	static int edge;
	static int visited[];
	static int adj[][];
	static int result;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		node= sc.nextInt();
		edge= sc.nextInt();
		adj = new int[node][node];
		visited = new int[node];
		
		for(int i=0; i<edge; i++) {
			int node1 = sc.nextInt()-1;
			int node2 = sc.nextInt()-1;
			adj[node1][node2]=1;
			adj[node2][node1]=1;
		}
		
		int result=0;
		for(int i=0; i<node; i++) {
			if(visited[i]==0) {
				dfs(i);
				result++;
			}
		}
		System.out.println(result);
	}
	
	static void dfs(int check) {
		visited[check]=1;
		for(int i=0; i<node; i++) {
			if(adj[check][i]==1 && visited[i]==0) {
				dfs(i);
			}
		}
	}

}
