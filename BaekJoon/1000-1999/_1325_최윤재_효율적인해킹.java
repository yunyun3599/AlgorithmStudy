package week17;
import java.util.*;
import java.io.*;
public class _1325_최윤재_효율적인해킹 {

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
			computer[tmp1].add(tmp2); 		//의존하는 컴퓨터 인덱스의 arraylist에 의존되는 컴퓨터 추가
		}////////////////////////////////////////////////입력
		visited = new boolean[N+1];
		for(int i=1; i<N+1; i++) {
			//visited = new boolean[N+1];
			calc(i);			//각 컴퓨터에 대해 의존 개수 구하기
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
		for(int i=0; i<computer[computer_no].size(); i++) {	//각 컴퓨터별 컴퓨터가 의존하는 컴퓨터에 대해 result값 키워줌
			int tmp = computer[computer_no].get(i);
			if(!visited[tmp]) {			//중복을 막기 위해 visited배열 이용	
				result[tmp]++;
				calc(tmp);
			}
		}
	}
}
