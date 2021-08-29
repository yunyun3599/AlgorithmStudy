package tmp;
import java.io.*;
import java.util.*;

public class _3584_최윤재_가장가까운공통조상 {
		
	static int testcase;
	static int N;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testcase = Integer.parseInt(br.readLine());	//테스트케이스 결과
		
		while(testcase-- > 0) {
			N = Integer.parseInt(br.readLine());	//노드 개수
			int parent[] = new int[N+1];	//parent[i]에 i의 부모 노드 번호 저장
			for(int i=1; i<N; i++) {	//parent 배열 채움
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				int boomo = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				parent[child] = boomo;
			}
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());	//부모를 조사할 노드
			boolean node1parent[] = new boolean[N+1];	//node1의 부모를 쭉 올라가면서 조사
			int tmpparent = node1;
			while(tmpparent != 0) {
				node1parent[tmpparent] = true;	//node1의 부모에 해당하면 배열의 값을 true로 바꿈
				tmpparent = parent[tmpparent];	//더 상위 노드 확인
			}
			tmpparent = node2;	//node2의 부모 조사
			while(!node1parent[tmpparent]) {	//node1와 공통 부모가 나올 때까지 반복
				tmpparent = parent[tmpparent];
			}
			result.append(tmpparent+"\n");	//결과 append
		}
		System.out.println(result);	//결과 출력
	}
}
