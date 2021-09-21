package tmp;
import java.util.*;
import java.io.*;
public class _15961_√÷¿±¿Á_»∏¿¸√ π‰ {

	static int[] arr;
	static int[] visited;
	static int N;
	static int d;
	static int k;
	static int c;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visited = new int[d+1];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int startIdx = 0;
		int endIdx = 0;
		int res = 1;
		visited[arr[endIdx]] = 1;
		while( endIdx < N + k - 1 ) {
			if(endIdx - startIdx + 1 < k) {
				endIdx++;
				if(visited[arr[endIdx%N]] == 0) res++;
				visited[arr[endIdx%N]]++;
				continue;
			}
			if(visited[c]==0) result = Math.max(result, res+1);
			else result = Math.max(result, res);
			visited[arr[startIdx]]--;
			if(visited[arr[startIdx]]==0) res--;
			startIdx++;
			endIdx++;visited[arr[endIdx%N]]++;
			if(visited[arr[endIdx%N]]==1) res++;
		}
		System.out.println(result);
	}

}
