package tmp;
import java.io.*;
import java.util.*;
public class _1976_최윤재_여행가자_unionfind {

	static int num;
	static int visit_num;
	static int[] parent;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		visit_num = Integer.parseInt(br.readLine());
		parent = new int[num];
		for(int i=0; i<num; i++) parent[i] = -1;
		for(int i=0; i<num; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<num; j++) {
				int connected = Integer.parseInt(st.nextToken());
				if(connected==1) union(i, j);
			}
		}
		String answer = "YES";
		st = new StringTokenizer(br.readLine());
		int to = Integer.parseInt(st.nextToken())-1;
		int from = 0;
		while(st.hasMoreTokens()) {
			from = to;
			to = Integer.parseInt(st.nextToken())-1;
			if(find(from) != find(to)) {
				answer = "NO";
				break;
			}
		}
		System.out.println(answer);
	}
	public static int find(int n) {
		if(parent[n]<0) return n;
		else {
			parent[n] = find(parent[n]);
			return parent[n];
		}
	}
	public static void union(int u, int v) {
		u = find(u);
		v = find(v);
		if(u==v) return;
		if(parent[u] < parent[v]) {
			parent[u] += parent[v];
			parent[v] = u;
		}
		else {
			parent[v] += parent[u];
			parent[u] = v;
		}
	}

}
