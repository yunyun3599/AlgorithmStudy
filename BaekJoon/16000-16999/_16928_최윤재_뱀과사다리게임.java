package tmp;
import java.io.*;
import java.util.*;

class Loc{
	int num;
	int roll;
	Loc(int num, int roll){
		this.num = num;
		this.roll = roll;
	}
}

public class _16928_최윤재_뱀과사다리게임 {
	
	static int laddernum;
	static int snakenum;
	static HashMap<Integer, Integer> ladder = new HashMap<>();
	static HashMap<Integer, Integer> snake = new HashMap<>();
	static int loc = 1;
	static int[] dice = {1,2,3,4,5,6};
	static boolean visited[] = new boolean[101];
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		laddernum = Integer.parseInt(st.nextToken());
		snakenum = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<laddernum; i++) {		//사다리 정보 hashmap에 저장
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			ladder.put(from, to);
		}
		for(int i=0; i<snakenum; i++) {			//뱀 정보 hashmap에 저장
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			snake.put(from, to);
		}
		
		Queue<Loc> queue = new LinkedList<>();	//bfs
		queue.add(new Loc(1, 0));
		visited[1] = true;		//방문처리
		while(!queue.isEmpty()) {
			Loc cur = queue.poll();	//이전 위치와 주사위 굴린 횟수 poll
			if(cur.num==100) {	//도착한 경우
				System.out.println(cur.roll);
				break;
			}
			for(int k=0; k<6; k++) {	//주사위 굴리는 경우의 수 6개
				int nextnum = cur.num+dice[k];
				if(nextnum>100 || visited[nextnum]) continue;	//이미 방문한 곳이거나 100 이상의 수인 경우는 확인 안함
				if(ladder.containsKey(nextnum)) {	//사다리 있는 칸인 경우
					queue.add(new Loc(ladder.get(nextnum), cur.roll+1));	//사다리로 이동한 칸을 queue에 넣기
					visited[ladder.get(nextnum)] = true;
					visited[nextnum] = true;
					continue;
				}
				if(snake.containsKey(nextnum)) {	//뱀이 있는 칸인 경우
					queue.add(new Loc(snake.get(nextnum), cur.roll+1));
					visited[snake.get(nextnum)] = true;
					visited[nextnum] = true;
					continue;
				}
				queue.add(new Loc(nextnum, cur.roll+1));	//아무것도 없는 칸인 경우
				visited[nextnum] = true;
			}
		}
	}

}
