package tmp;
import java.util.*;
import java.io.*;

public class _1005_최윤재_ACMCraft {
	
	static int testcase;
	static int N;
	static int K;
	static int W;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testcase = Integer.parseInt(br.readLine());
		while(testcase-- > 0) {		//테스트케이스만큼 반복
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int[] time = new int[N+1];		//각 건물 건설 시간
			int[] indegree = new int[N+1];	//해당 노드로 들어오는 edge 개수
			int[] finish = new int[N+1];	//건물 완성까지 소요되는 시간
			LinkedList<Integer>[] graph = new LinkedList[N+1];	//각 건물별로 해당 건물 완공 후에 짓기 시작할 수 있는 건물 번호 저장
			
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<N+1; i++) {	////////////////////건설 시간 저장, 그래프 초기화
				time[i] = Integer.parseInt(st.nextToken());
				graph[i] = new LinkedList<>();
			}
			for(int i=0; i<K; i++) {	//입력 처리
				st = new StringTokenizer(br.readLine()," ");
				int first = Integer.parseInt(st.nextToken());
				int second = Integer.parseInt(st.nextToken());
				graph[first].add(second);	//그래프에 연결 요소들 추가
				indegree[second]++;	//indegree증가시켜주기
			}
			W = Integer.parseInt(br.readLine());	//목표 건물
			
			Queue<Integer> q = new LinkedList<>();	//위상정렬을 위해 queue이용
			for(int i=1; i<N+1; i++) {
				if(indegree[i]==0) {	//가장 처음부터 지을 수 있는 건물들
					q.add(i);
					finish[i] = time[i];
				}
			}
			while(!q.isEmpty()) {	//queue를 돌면서 모든 노드 처리
				int first = q.poll();
				for(int second : graph[first]) {	//현재 노드가 끝난 후에 건설 가능한 건물들 queue에 삽입
					finish[second] = Math.max(finish[second], finish[first]+time[second]);	//현재 finish에 있는 값과 새로 계산되는 값 중 더 큰 값으로 저장
					indegree[second]--;		//앞의 노트 하나 처리됐으므로 indegree 하나 감소
					if(indegree[second]==0) q.add(second);	//indegree가 0이면 이전에 처리해야 하는 노드들이 다 처리된 것이므로 queue에 삽입
				}
			}
			System.out.println(finish[W]);
		}
	}

}
