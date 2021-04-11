package tmp;
import java.io.*;
import java.util.*;
public class _14891_최윤재_톱니바퀴 {

	static LinkedList<Integer>[] wheel = new LinkedList[4];	//오른쪽 인덱스 2, 왼쪽 인덱스 6, 시계방향 회전시에 마지막 poll해서 앞으로, 반시계방향일때는 pollFirst해서 제일 뒤로
	static boolean handled[] = new boolean[4];	//이미 돌린 톱니바퀴인지 확인

	public static void main(String[] args) throws IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<4; i++) {
			wheel[i] = new LinkedList<>();
			String tmp = br.readLine();
			for(int j=0; j<8; j++) wheel[i].add(tmp.charAt(j)-'0');	//N극이 0, S극이 1
		}	//입력
		
		int num = Integer.parseInt(br.readLine());	//돌리는 횟수
		
		while(num-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int wheel_num = Integer.parseInt(st.nextToken())-1;	//돌릴 톱니바퀴 idx
			int dir = Integer.parseInt(st.nextToken());		//시계방향이 1, 시계반대방향이 -1
			rotate(wheel_num, dir);
		}
		int result=0;
		for(int i=0; i<4; i++) {
			if(wheel[i].get(0)==0) continue;	//N이면 result에 더하지 않음
			result += Math.pow(wheel[i].get(0)*2, i);	//S면 2의 i승한만큼 더하기
		}
		System.out.println(result);
	}
	
	public static void rotate(int idx, int dir) {	//돌리기
		handled[idx] = true;	//이번 톱니바퀴는 돌렸음을 체크
		int next_idx = idx-1;	//맞닿아있는 톱니바퀴들
		if(0<=next_idx && !handled[next_idx]) {	//이번 톱니바퀴의 왼쪽에 있는 톱니바퀴
			if(wheel[idx].get(6) != wheel[next_idx].get(2)) rotate(next_idx, dir*(-1)); 	//닿아있는 극이 다르면 재귀적으로 수행
		}
		next_idx = idx+1;	//이번 톱니바퀴의 오른쪽에 있는 톱니바퀴
		if(next_idx<=3 && !handled[next_idx]) {
			if(wheel[idx].get(2) != wheel[next_idx].get(6)) rotate(next_idx, dir*(-1)); 
		}
		if(dir==1) {	//시계방향일경우
			int move = wheel[idx].pollLast();
			wheel[idx].addFirst(move);
		}
		else {	//반시계방향일경우
			int move = wheel[idx].pollFirst();
			wheel[idx].add(move);
		}
		handled[idx] = false;	//방문 처리 풀어주기
	}

}
