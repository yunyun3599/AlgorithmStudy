package tmp;
import java.io.*;
import java.util.*;
public class _3190_������_�� {

	static int[][] map;
	static int sec;
	static int width;
	static int[] axis_x = {1, 0, -1, 0};	//���ϼ���
	static int[] axis_y = {0, -1, 0, 1};
	static int head_dir = 0;	//head�� ����
	static int head_y = 0;	//�Ӹ� ��ǥ
	static int head_x = 0;
	static int tail_dir = 0;	//tail ����
	static int tail_y = 0;	//���� ��ǥ
	static int tail_x = 0;
	static int snake = 2;	//���� �ִ� ��ġ�� ǥ���ϱ� ���� ����.
	static LinkedList<int[]> dirList = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		width = Integer.parseInt(br.readLine());
		int apple = Integer.parseInt(br.readLine());	//�������
		map = new int[width][width];
		StringTokenizer st;
		for(int i=0; i<apple; i++) {	//����� map�� 1�� ǥ��
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			map[y][x] = 1;
		}
		
		int change_num = Integer.parseInt(br.readLine());	//������ �ٲٴ� ����� ����
		for(int i=0; i<change_num; i++) {
			st= new StringTokenizer(br.readLine()," ");
			int time = Integer.parseInt(st.nextToken());
			int dir = (st.nextToken().equals("D")) ? 3 : 1;	//�������̸� 3���� ǥ��, �����̸� 1�� ǥ��
			dirList.add(new int[] {time, dir});	//������ �ٲٴ� �ð��� ������ dirlist�� ����
		}
		
		int[] turn = dirList.poll();	//���� ���ʷ� �ٲ� �ð��� ���� turn�� ����
		
		map[0][0] = snake++;	//ó�� �����ϴ� ���� ��ġ
		while(true) {			
			if(sec == turn[0]) {	//������ �ٲ� �ð��� �Ǿ��� ��
				head_dir = (head_dir + turn[1]) % 4;	//���� ������ �������� �� ������ ���
				if(!dirList.isEmpty()) turn = dirList.poll();	//�� �������� �ٲ� �ð��� ������ turn�� ����
			}
			head_y += axis_y[head_dir];	//�������� head�� ���� y��ǥ
			head_x += axis_x[head_dir];	//�������� head�� ���� x��ǥ
			sec++;		//�ð� ����
			if((!check(head_y, head_x)) || map[head_y][head_x] > 1) break;	//������ �������ϴ� ��� (map������ �����ų� ���� ���� �ε���)
			if (map[head_y][head_x] == 1) {		//��� �Դ� ���
				map[head_y][head_x] = snake++;	//�Ӹ� ��ġ�� ���� ������ ǥ���ϴ� ������ �ٲٱ�
				continue;	//�Ӹ� ���� �κ��� �׳� �θ� �ʤ�
			}
			else {	//��� ���� ���
				map[head_y][head_x] = snake++;	//�Ӹ��� ���� �̵��� ��ġ�� ���� ������ ǥ���ϴ� �� �ֱ�
				int next_tail_y = tail_y + axis_y[tail_dir];	//���� ������ ��ġ�� ���� ������ ���� �������� ���
				int next_tail_x = tail_x + axis_x[tail_dir];
				if(check(next_tail_y, next_tail_x) && map[next_tail_y][next_tail_x] == map[tail_y][tail_x] + 1) {	//������ ������ �ٲ��� �ʾƵ� �Ǵ� ���
					map[tail_y][tail_x] = 0;
					tail_y = next_tail_y;
					tail_x = next_tail_x;
				}
				else {		//������ ������ �ٲ���ϴ� ���
					for(int k=0; k<4; k++) {	//4������ Ž���ϸ� ���������� ���� �ٲ���ϴ��� Ȯ��
						next_tail_y = tail_y + axis_y[k];
						next_tail_x = tail_x + axis_x[k];
						if(check(next_tail_y, next_tail_x) && map[next_tail_y][next_tail_x] == map[tail_y][tail_x] + 1) {	//���� ���������� 1 ū���� �������� �ٲ����
							map[tail_y][tail_x] = 0;	//���� ������ ���� �̵������Ƿ� 0���� �ٲ��ش�
							tail_dir = k;			//���ο� ���� ���� ����
							tail_y = next_tail_y;	//���ο� ���� ��ǥ ����
							tail_x = next_tail_x;
							break;
						}
					}
				}
			}
		}
		System.out.println(sec);
	}
	public static boolean check(int y, int x) {	//map���ʿ� �ִ��� Ȯ��
		if(0<=y && 0<=x && y<width && x<width) return true;
		return false;
	}

}
