package tmp;
import java.util.*;

public class _2251_최윤재_물통 {

	static int[] volume =  new int[3];	//각 물통의 용량
	static ArrayList<Integer> result = new ArrayList<>(); //결과 저장
	static boolean visited[][][];	//해당 물 부피의 분포가 이전에 있었는지 확인
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
		volume[0] = Integer.parseInt(st.nextToken());
		volume[1] = Integer.parseInt(st.nextToken());
		volume[2] = Integer.parseInt(st.nextToken());
		visited = new boolean[volume[0]+1][volume[1]+1][volume[2]+1];
		////////////////////////////////////////////////////////////////////입력
		Queue<int[]> queue = new LinkedList<>();	//bfs
		visited[0][0][volume[2]] = true;	//초기값 방문 처리
		result.add(volume[2]);	//초기값 결과에 add
		queue.add(new int[] {0, 0, volume[2]});
		
		while(!queue.isEmpty()) {	//bfs
			int[] prev = queue.poll();	//이전 값
			for(int i=0; i<3; i++) {		//i에서 j로 물 옮기는 경우
				for(int j=0; j<3; j++) {
					if(i==j) continue;	//같은 bucket이면 continue
					int[] next = pour(i, j, prev); //물을 부은 후의 물 분포
					if(!visited[next[0]][next[1]][next[2]]) {	//지금까지 해당 물의 용량 분포가 없던 경우일 때만 수행
						if(next[0]==0) result.add(next[2]);	//첫번째 bucket이 비었을 때
						visited[next[0]][next[1]][next[2]] = true;	//visited처리
						queue.add(next);	//bfs
					}
				}
			}
		}
		Collections.sort(result);	//결과 오름차순 출력
		StringBuilder sb = new StringBuilder();
		for(int C : result) sb.append(C+" ");
		System.out.println(sb);
	}
	
	public static int[] pour(int from, int to, int prev[]) {
		int[] next = new int[3];	//다음값
		next[0] = prev[0];
		next[1] = prev[1];
		next[2] = prev[2];
		//from에 들은 양을 모두 to로 부을 수 있는 경우
		if (volume[to] >= prev[from]+prev[to]) {
			next[from] = 0;
			next[to] = prev[from]+prev[to]; 
		}
		//to에 해당하는 bucket이 다 차는 경우
		else {
			next[from] = prev[from]+prev[to] - volume[to];
			next[to] = volume[to];
		}
		return next;	//물 부은 결과 리턴
	}
}
