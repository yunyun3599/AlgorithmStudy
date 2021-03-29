package tmp;
import java.util.*;
import java.io.*;
public class _20055_������_�����̾Ʈ���Ƿκ� {
	
	static int N;	//�����̾Ʈ ���̴� 2N
	static int K;	//�������� 0�� ĭ�� K�� �̻��̸� ���� ����
	static int count;	//�������� 0�� ĭ ���
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
		
		up = new LinkedList<>();		//���ʿ� �ִ� �����̾� ��Ʈ
		down = new LinkedList<>();		//�Ʒ��ʿ� �ִ� �����̾� ��Ʈ
		robot = new int[N];				//�κ��� ���� �ִ� ��ġ ����صδ� �迭
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			int durability = Integer.parseInt(st.nextToken());	//up�ʿ� �ش��ϴ� ĭ�� �������� ����
			up.add(durability);
			if (durability == 0) count++;	//���� ���������� 0�̸� count����
		}
		for(int i=0; i<N; i++) {	//down�� �ش��ϴ� ĭ�� �������� ����
			int durability = Integer.parseInt(st.nextToken());
			down.add(durability);
			if(durability == 0) count++;
		}
		
		while(count < K) {	//�������� 0�� ĭ�� K���� �������� ���߱�
			move();		//�����̾� �����̱�
			moveRobot();//�κ� �����̱�
			insertRobot();//�κ� ���� �ø���
			stage++;	//�ܰ� ����
		}
		System.out.println(stage);	//�ܰ� ���
	}
	
	public static void move() {
		int up_to_down = up.pollLast();	//������ ĭ �̱�
		int down_to_up = down.pollLast();	//�ö� ĭ �̱�
		up.addFirst(down_to_up);	//ĭ �ø���
		down.addFirst(up_to_down);	//ĭ ������
		
		while(!robot1.isEmpty()) {
			int robot_tmp = robot1.poll();
			if(robot_tmp == N-1) continue;
			robot2.add(robot_tmp+1);
		}
		
		
		
		/*robot[N-1]=0;	//������ ĭ �κ� ������
		for(int i=2; i<=N; i++) {	//�κ� ��ĭ�� �̵�(ȿ�������� �ٽ� �����ϱ�)
			if(robot[N-i] == 1) {
				robot[N-i+1] = 1;
				robot[N-i] = 0;
			}
		}*/
		
		
		
	}
	
	public static void moveRobot() {	//�κ� �����̱�
		int before = 0;
		while(!robot2.isEmpty()) {
			int tmp_robot = robot2.poll();
			if(tmp_robot == N-1) continue;
			if(tmp_robot+1 != before && up.get(tmp_robot+1)!=0) {
				robot1.add(tmp_robot+1);
				up.set(tmp_robot+1, up.get(tmp_robot+1)-1);
				if(up.get(tmp_robot+1) == 0) count++;	//������ 0 �ƴ��� Ȯ��
			}
			else {
				robot1.add(tmp_robot);
				before = tmp_robot;
			}
		}
		
		
		
		/*robot[N-1] = 0;	//������ ĭ�� �κ� ������ ������
		for(int i=2; i<=N; i++) {	//�� ĭ���� �̵� �����ϸ� �� ��
			if(robot[N-i] == 1) {	//�κ� �ִ� ĭ�� ����
				if(robot[N-i+1] != 1 && up.get(N-i+1) != 0) {//��ĭ���� ������ �������� Ȯ��
					robot[N-i] = 0;	//����
					robot[N-i+1] = 1;
					up.set(N-i+1, up.get(N-i+1)-1);	//������ ���̱�
					if(up.get(N-i+1) == 0) count++;	//������ 0 �ƴ��� Ȯ��
				}
			}
		}*/
		
		
		
		
	}
	public static void insertRobot() {	//�κ� ���� �ø���
		if(up.getFirst() != 0) {	//ù ĭ ������ 0�̸� �ȵ�
			
			
			//robot[0] = 1;
			
			
			robot1.add(0);
			up.set(0, up.getFirst()-1);
			if(up.getFirst()==0) count++;
		}
	}
}
