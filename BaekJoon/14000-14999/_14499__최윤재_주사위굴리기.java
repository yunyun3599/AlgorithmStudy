package tmp;
import java.io.*;
import java.util.*;
public class _14499__������_�ֻ��������� {
	
	// �ֻ��� ������, dice�迭�� �� index����. 3�� ���� �ٴ�, 5�� ���� ��, 1�� ��, 0�� ��
	//  2
	// 031
	//  4
	//  5
	
	static int[] dice = new int[6];		//�ֻ��� �� ���� 
	static int[][] map;
	static int height;
	static int width;
	static int move;
	static int[] axis_x = {1, -1, 0, 0};	//1=��, 2=��, 3=��, 4=��, ���⿡ ���� axis[dir]�� �����̰��ϱ�
	static int[] axis_y = {0, 0, -1, 1};
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		map = new int[height][width];
		int y = Integer.parseInt(st.nextToken());	//dice �ʱ� ��ġ
		int x = Integer.parseInt(st.nextToken());
		move = Integer.parseInt(st.nextToken());	//�� ������ Ƚ��
		
		for(int i=0; i<height; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<width; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine()," ");
		while(move-->0) {		//������ Ƚ����ŭ �ݺ�
			int dir = Integer.parseInt(st.nextToken())-1;	//�������� ��
			int next_y = y + axis_y[dir];	//�������� ���� ���� ���� ��ġ Ȯ��
			int next_x = x + axis_x[dir];
			if(check(next_y, next_x)) {	//map������ ����� �ʴ� ���
				switch(dir) {	//�������Ͽ� ���� �ֻ��� ��ġ �� ���� �ٲٱ�
				case 0: update_dice(5,0,3,1);	//��
						break;
				case 1: update_dice(5,1,3,0);	//��
						break;
				case 2: update_dice(5,4,3,2);	//��
						break;
				case 3: update_dice(2,3,4,5);	//��
						break;
				}
				
				if(map[next_y][next_x] != 0) {	//������ �ִ� ���� 0�� �ƴ� ���
					dice[3] = map[next_y][next_x];
					map[next_y][next_x] = 0;
				}
				else {	//������ �ִ� ���� 0�� ���
					map[next_y][next_x] = dice[3];
				}
				y = next_y;	//�ֻ��� ��ġ �ٲ��ֱ�
				x = next_x;
				sb.append(dice[5]+"\n");	//����� append (�ֻ��� ���� ��)
			}
		}
		System.out.println(sb);
	}
	public static boolean check(int y, int x) {	//���� üũ
		if(0<=y && 0<=x && y<height && x<width) return true;
		return false;
	}
	public static void update_dice(int idx1, int idx2, int idx3, int idx4) {	//�ֻ��� �迭 �� �̵������ֱ�
		int tmp = dice[idx1];
		dice[idx1] = dice[idx2];
		dice[idx2] = dice[idx3];
		dice[idx3] = dice[idx4];
		dice[idx4] = tmp;
	}

}
