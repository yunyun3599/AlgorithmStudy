package week17;
import java.util.*;
import java.io.*;
public class _1325_������_ȿ��������ŷ {

	static int N;
	static int M;
	static ArrayList<Integer>[] computer;
	static int[] result;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		computer = new ArrayList[N+1];
		result = new int[N+1];
		for(int i=0; i<N+1; i++) computer[i] = new ArrayList();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			computer[tmp1].add(tmp2); 		//�����ϴ� ��ǻ�� �ε����� arraylist�� �����Ǵ� ��ǻ�� �߰�
		}////////////////////////////////////////////////�Է�
		visited = new boolean[N+1];
		for(int i=1; i<N+1; i++) {
			//visited = new boolean[N+1];
			calc(i);			//�� ��ǻ�Ϳ� ���� ���� ���� ���ϱ�
		}
		
		int max = 0;
		for(int i=1; i<=N; i++) max = Math.max(max, result[i]);
		for(int i=1; i<=N; i++) System.out.println(result[i]);
		for(int i=1; i<=N; i++) {
			if(result[i]==max) sb.append(i+" ");
		}
		System.out.println(sb);
	}
	public static void calc(int computer_no) {
		visited[computer_no] = true;
		for(int i=0; i<computer[computer_no].size(); i++) {	//�� ��ǻ�ͺ� ��ǻ�Ͱ� �����ϴ� ��ǻ�Ϳ� ���� result�� Ű����
			int tmp = computer[computer_no].get(i);
			if(!visited[tmp]) {			//�ߺ��� ���� ���� visited�迭 �̿�	
				result[tmp]++;
				calc(tmp);
			}
		}
	}
}
