package week19;
import java.io.*;
import java.util.*;

class Robot{			//�κ� ��ġ�� ����
	int x;
	int y;
	int dir;
	Robot(int y, int x, int dir){
		this.y = y;
		this.x = x;
		this.dir = dir;	//0=��, 1=��, 2=��, 3=��
	}
}

public class _14503_������_�κ�û�ұ� {
	
	static int height;
	static int width;
	static int map[][];
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		map = new int[height][width];
		st = new StringTokenizer(br.readLine());
		Robot robot = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		for(int i=0; i<height; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<width; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//////////////////////////////////////////////������� �Է�
		Queue<Robot> q = new LinkedList();
		q.add(robot);			//ó�� ��ġ�� queue�� ����
		while(!q.isEmpty()) {	//queue�� �� ������
			Robot loc = q.poll();
			int x = loc.x;
			int y = loc.y;
			int dir = loc.dir;
			boolean clean = false;	//û�Ҹ� �� ������ �� �� ������ true (�����ؾ��ϴ��� Ȯ�ο�)
			if (map[y][x] == 0) {	//���� ��ġ�� ���� û�Ҹ� �������� result++
				map[y][x] = 2;		//û�Ҹ� �̹� �ߴٴ� �ǹ̷� 2�� ���� �ٲ���
				result++;
			}
			Robot tmp;
			for(int i=0; i<4; i++) {
				tmp = move(new Robot(y, x, dir-i), 1);		//�� ��ġ���� 4������ Ž��
				if (check(tmp) && map[tmp.y][tmp.x]==0) {	//�� ���� �� û�� ������ ĭ�� ������ queue�� ����
					q.add(tmp);
					clean = true;
					break;
				}
			}
			if(!clean) {		//�����ؾ��ϴ� ���
				tmp = move(new Robot(y, x, dir + 1), -1);	//���������� ���ԵǴ� ���⿡�� �ڷ� ���� (���� ���⿡ �״�δϱ� dir+1�ؼ� �־���)
				if(check(tmp) && map[tmp.y][tmp.x] != 1) q.add(tmp);
			}
		}
		System.out.println(result);
	}
	
	public static Robot move(Robot robot, int front) {
		int ndir = (robot.dir-1);	//������ ���� �� ���� (�������� ��)
		int nx = robot.x;
		int ny = robot.y;
		switch(ndir) {			//�� ���⺰�� ���� ��������
			case 0:
			case -4: ny -= front;
					ndir = 0;	//���� ���Ⱚ���� �ȹٲ��ָ� ����ؼ� �پ��
					break;
			case 1:
			case -3: nx += front;
					ndir = 1;
					break;
			case 2:  
			case -2: ny += front;
					ndir = 2;
					break;
			case 3:
			case -1: nx -= front;
					ndir = 3;
					break;
		}
		return new Robot(ny, nx, ndir);
	}
	public static boolean check(Robot robot) {	//��ġ�� ������ ��ġ���� Ȯ��
		if (robot.y >=0 && robot.y < height && robot.x >=0 && robot.x < width) 
			return true;
		return false;
	}
}




