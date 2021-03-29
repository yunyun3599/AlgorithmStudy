package tmp;
import java.util.*;
import java.io.*;
public class _20055_최윤재_컨베이어벨트위의로봇 {
	
	static int N;	//컨베이어벨트 길이는 2N
	static int K;	//내구도가 0인 칸이 K개 이상이면 과정 종료
	static int count;	//내구도가 0인 칸 계산
	static int stage;
	static LinkedList<Integer> up;
	static LinkedList<Integer> down;
	static int[] robot;	
	static PriorityQueue<Integer> robot1 = new PriorityQueue<>(Collections.reverseOrder());
	static PriorityQueue<Integer> robot2 = new PriorityQueue<>(Collections.reverseOrder());
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		up = new LinkedList<>();		//위쪽에 있는 컨베이어 벨트
		down = new LinkedList<>();		//아래쪽에 있는 컨베이어 벨트
		robot = new int[N];				//로봇이 현재 있는 위치 기억해두는 배열
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			int durability = Integer.parseInt(st.nextToken());	//up쪽에 해당하는 칸의 내구도를 저장
			up.add(durability);
			if (durability == 0) count++;	//들어온 내구도부터 0이면 count증가
		}
		for(int i=0; i<N; i++) {	//down에 해당하는 칸의 내구도를 저장
			int durability = Integer.parseInt(st.nextToken());
			down.add(durability);
			if(durability == 0) count++;
		}
		
		while(count < K) {	//내구도가 0인 칸이 K보다 많아지면 멈추기
			move();		//컨베이어 움직이기
			moveRobot();//로봇 움직이기
			insertRobot();//로봇 새로 올리기
			stage++;	//단계 증가
		}
		System.out.println(stage);	//단계 출력
	}
	
	public static void move() {
		int up_to_down = up.pollLast();	//내려갈 칸 뽑기
		int down_to_up = down.pollLast();	//올라갈 칸 뽑기
		up.addFirst(down_to_up);	//칸 올리기
		down.addFirst(up_to_down);	//칸 내리기
		
		while(!robot1.isEmpty()) {
			int robot_tmp = robot1.poll();
			if(robot_tmp == N-1) continue;
			robot2.add(robot_tmp+1);
		}
		
		
		
		/*robot[N-1]=0;	//마지막 칸 로봇 내리기
		for(int i=2; i<=N; i++) {	//로봇 한칸씩 이동(효율적으로 다시 구성하기)
			if(robot[N-i] == 1) {
				robot[N-i+1] = 1;
				robot[N-i] = 0;
			}
		}*/
		
		
		
	}
	
	public static void moveRobot() {	//로봇 움직이기
		int before = 0;
		while(!robot2.isEmpty()) {
			int tmp_robot = robot2.poll();
			if(tmp_robot == N-1) continue;
			if(tmp_robot+1 != before && up.get(tmp_robot+1)!=0) {
				robot1.add(tmp_robot+1);
				up.set(tmp_robot+1, up.get(tmp_robot+1)-1);
				if(up.get(tmp_robot+1) == 0) count++;	//내구도 0 됐는지 확인
			}
			else {
				robot1.add(tmp_robot);
				before = tmp_robot;
			}
		}
		
		
		
		/*robot[N-1] = 0;	//마지막 칸에 로봇 있으면 내리기
		for(int i=2; i<=N; i++) {	//앞 칸으로 이동 가능하면 이 동
			if(robot[N-i] == 1) {	//로봇 있는 칸에 대해
				if(robot[N-i+1] != 1 && up.get(N-i+1) != 0) {//앞칸으로 전진이 가능한지 확인
					robot[N-i] = 0;	//전진
					robot[N-i+1] = 1;
					up.set(N-i+1, up.get(N-i+1)-1);	//내구도 줄이기
					if(up.get(N-i+1) == 0) count++;	//내구도 0 됐는지 확인
				}
			}
		}*/
		
		
		
		
	}
	public static void insertRobot() {	//로봇 새로 올리기
		if(up.getFirst() != 0) {	//첫 칸 내구도 0이면 안됨
			
			
			//robot[0] = 1;
			
			
			robot1.add(0);
			up.set(0, up.getFirst()-1);
			if(up.getFirst()==0) count++;
		}
	}
}
