import java.util.*;
import java.io.*;
public class _1719_최윤재_택배 {

	static int n;
	static int m;
	static int[][] weight;
	static int[][] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		weight = new int[n+1][n+1];
		result = new int[n+1][n+1];
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				weight[i][j] = 100000000;
			}
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if(weight[node1][node2] < cost) continue;
			weight[node1][node2] = cost;
			weight[node2][node1] = cost;
			result[node1][node2] = node2;
			result[node2][node1] = node1;
		}
		//////////////////////////////////////////입력
		
		//플로이드와샬 
		for(int i=1; i<n+1; i++) {	//i는 경유할 수 있는 노드 번호 
			for(int j=1; j<n+1; j++) {	//j는 출발점 
				for(int k=1; k<n+1; k++) {	//k는 도착
					if(weight[j][k] > weight[j][i]+weight[i][k]) {
						weight[j][k] = weight[j][i]+weight[i][k];
						result[j][k] = result[j][i];	//경유하는 첫 지점 업데이트 
					}
				}
			}
		}
		//결과 출력 
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				if(i==j) sb.append("- ");
				else sb.append((result[i][j])+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
