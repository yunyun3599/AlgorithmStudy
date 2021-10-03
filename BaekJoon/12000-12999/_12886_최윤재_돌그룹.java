import java.io.*;
import java.util.*;
public class _12886_최윤재_돌그룹 {

	static HashSet<String> visited = new HashSet<>();	//ABC 내부의 값을 string으로 이어붙임 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ABC[] = new int[3];
		ABC[0] = Integer.parseInt(st.nextToken());
		ABC[1] = Integer.parseInt(st.nextToken());
		ABC[2] = Integer.parseInt(st.nextToken());
		////////////////////////////////////////////입력 
		
		Queue<int[]> queue = new LinkedList<>();	//bfs이용 
		queue.add(ABC);
		StringBuffer sb = new StringBuffer();
		sb.append(ABC[0]);
		sb.append(ABC[1]);
		sb.append(ABC[2]);
		visited.add(sb.toString());
		
		while(!queue.isEmpty()) {		//bfs수행 
			int cur[] = queue.poll();
			if(cur[0] == cur[1] && cur[1] == cur[2]) {	//돌의 개수가 모두 같은 경우 
				System.out.println(1);
				System.exit(0);
			}
			int[] next = move(cur, 0, 1);	//0번째와 1번째 그룹 비교 
			sb = new StringBuffer();
			sb.append(next[0]);
			sb.append(next[1]);
			sb.append(next[2]);
			if(!visited.contains(sb.toString())) {	//아직 방문하지 않은 경우에만 queue.add
				queue.add(next);
				visited.add(sb.toString());
			}
			next = move(cur, 0, 2);	//0번째와 2번째 그룹 비교 
			sb = new StringBuffer();
			sb.append(next[0]);
			sb.append(next[1]);
			sb.append(next[2]);
			if(!visited.contains(sb.toString())) {
				queue.add(next);
				visited.add(sb.toString());
			}
			next = move(cur, 1, 2);	//1번째와 2번째 그룹 비
			sb = new StringBuffer();
			sb.append(next[0]);
			sb.append(next[1]);
			sb.append(next[2]);
			if(!visited.contains(sb.toString())) {
				queue.add(next);
				visited.add(sb.toString());
			}
		}
		System.out.println(0);
	}
	
	public static int[] move(int[] prev, int idx1, int idx2) {	//돌이 더 적은 경우에는 2배, 돌이 더 많은 경우에는 더 적은 돌의 개수만큼 빼는 함
		int next[] = {prev[0], prev[1], prev[2]};
		if(prev[idx1] < prev[idx2]) {
			next[idx2] -= prev[idx1];
			next[idx1] += prev[idx1];
		}
		else {
			next[idx1] -= prev[idx2];
			next[idx2] += prev[idx2];
		}
		return next;
	}
}