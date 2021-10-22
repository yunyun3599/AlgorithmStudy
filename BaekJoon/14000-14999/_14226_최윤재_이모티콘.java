import java.util.*;

class State implements Comparable<State> {	//pq에 넣을 State
	int num;
	int clipboard;
	int time;
	State(int num, int clipboard, int time) {
		this.num = num;
		this.clipboard = clipboard;
		this.time = time;
	}
	public int compareTo(State other) {
		return this.time - other.time;
	}
}

public class _14226_최윤재_이모티콘 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt();
		boolean visited[][] = new boolean[S*2][S];		//방문 처리 [현재이모티콘개수][클립보드이모티콘개수]
		PriorityQueue<State> pq = new PriorityQueue<>();	//우선순위 큐. 시간이 적은 게 높은 우선순위 
		
		pq.add(new State(1, 0, 0));	//현재 이모티콘 1개, 클립보드에 0개인 초기 상태 넣기 
		visited[1][0] = true;
		
		
		while(true) {
			State cur = pq.poll();	//이전 상태 
			if(cur.num==S) {	//이모티콘 개수가 S면 
				System.out.println(cur.time);
				break;
			}
			//1.이모티콘 하나 지우는 경우
			if(cur.num > 1 && !visited[cur.num-1][cur.clipboard]) {	//총 이모티콘 개수는 1개 줄고, 클립보드 값은 그대로 
				pq.add(new State(cur.num-1, cur.clipboard, cur.time+1));
				visited[cur.num-1][cur.clipboard] = true;
			}
			//2. 클립보드에 기존에 있던 내용 붙여넣기
			if(cur.num+cur.clipboard < S*2 && !visited[cur.num + cur.clipboard][cur.clipboard]) {	//총 이모티콘 개수 = 기존 이모티콘 개수 + 클립보드 내의 이모티콘 개수, 클립보드 값은 그대로 
				pq.add(new State(cur.num + cur.clipboard, cur.clipboard, cur.time+1));
				visited[cur.num + cur.clipboard][cur.clipboard] = true;
			}
			//3. 현재 내용 다 복사
			if(cur.num*2<S*2 && !visited[cur.num][cur.num]) {	//총 이모티콘 개수 = 기존 이모티콘 개수 그대로, 클립보드 이모티콘 개수 = 기존 이모티콘 개수 
				pq.add(new State(cur.num, cur.num, cur.time+1));
				visited[cur.num][cur.num] = true;
			}
		}
	}
}
