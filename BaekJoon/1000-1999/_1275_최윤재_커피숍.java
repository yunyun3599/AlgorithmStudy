package tmp;
import java.io.*;
import java.util.*;
public class _1275_최윤재_커피숍 {
	
	static int N;
	static int Q;
	static long tree[];
	static int input[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		input = new int[N+1];
		tree=new long[4*N];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		init(1, N, 1);
		for(int i=0; i<Q; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int max = x>y? x : y;
			int min = x>y? y : x;
			long tmp = sum(1, N, 1, min , max);
			update(1,N,1,a,b);
			sb.append(tmp+"\n");
		}
		System.out.println(sb);
	}
	public static long init(int start, int end, int node) {
		if(start==end) {
			tree[node] = input[start];
			return tree[node];
		}
		tree[node] = init(start, (start+end)/2, node*2) + init((start+end)/2+1, end, node*2+1);
		return tree[node];
	}
	public static long sum(int start, int end, int node, int left, int right) {
		if(end<left || right<start) {	//노드의 구간 내에 없는 경우
			return 0;
		}
		if(left<=start && end<=right) {	//노드의 구간 내에 모두 포함되는 경우
			return tree[node];
		}
		return sum(start, (start+end)/2, node*2, left, right) + sum((start+end)/2+1, end, node*2+1, left, right);
	}
	public static long update(int start, int end, int node, int idx, long val) {
		if(idx<start || idx>end) {
			return tree[node];
		}
		if(start == end) {
			return tree[node] = val;
		}
		tree[node] = update(start, (start+end)/2, node*2, idx, val) + update((start+end)/2+1, end, node*2+1, idx, val);
		return tree[node];
	}
}






