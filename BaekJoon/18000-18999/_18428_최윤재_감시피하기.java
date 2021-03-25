package week18;
import java.io.*;
import java.util.*;
public class _18428_������_�������ϱ� {

	static char[][] map;		//�Է� ����
	static boolean[][] visited;	//�湮���� Ȯ��
	static int width;	//map �ʺ�
	static boolean flag;//�������� ���� Ȯ�� (false�� �Ұ��ΰ�)
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		width = Integer.parseInt(br.readLine());
		map = new char[width][width];
		
		for(int i=0; i<width; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<width; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}/////////////////������� �Է�
		for(int i=0; i<width; i++) {
			for(int j=0; j<width; j++) {
				if(map[i][j] == 'X') {	//X�� �ִ� �κп� ���ؼ� 3���� Obstacle�� ����
					flag = makeWall(i, j, 0);	//makeWall�Լ����� ��ֹ� ����� 3���� �������� dfs�̿��ؼ� �������� Ȯ���ϰ� ��. �����ϸ� true��ȯ
					if(flag) break;	//true�� ��ȯ�Ǿ� ������ ��찡 �ּ� �ϳ� ������ Ȯ���ϰ� �ȴٸ� �ݺ��� ����
				}
			}
			if(flag) break;	//2��for�� �� �� ����
		}
		if(flag) System.out.println("YES");	//������ ��� Yes ���
		else System.out.println("NO");	//�Ұ����� ��� No ���
	}
	public static boolean makeWall(int y, int x, int wall) {
		boolean flag = false;	//�켱 �Ұ����ϴٰ� �����س���
		if (wall == 3) {	//�� 3���� �� �������� �������� Ȯ���ϴ� �Լ� �θ� (dfs����)
			flag = flag || findStudent();	//OR �������� ������ ��� �ϳ��� ������ flag�� true���̵��� �س���
		}
		else {	//���� �� ������ �ϴ� ���
			for(int i=x; i<width; i++) {	//�ش� �࿡�� ���� ���� �� ���� �� �ִ� ���
				if(map[y][i] == 'X') {
					map[y][i] = 'O';
					flag = flag || makeWall(y, i+1, wall+1);
					map[y][i] = 'X';
				}
			}
			for(int i=y+1; i<width; i++) {	//���� ������ �Ѿ�� �ϴ� ���
				for(int j=0; j<width; j++) {
					if(map[i][j] == 'X') {
						map[i][j] = 'O';
						flag = flag || makeWall(i, j+1, wall+1);
						map[i][j] = 'X';
					}
				}
			}
		}
		
		return flag;	//�л����� �ȵ�Ų ��쿡�� true�� ��ȯ��
	}
	public static boolean findStudent() {	//�л��� ���� �� �ִ� ���� ���� Ȯ���ϴ� �Լ�
		for(int i=0; i<width; i++) {
			for(int j=0; j<width; j++) {
				if(map[i][j] == 'T') {	//�������� �ִ� ĭ�������� dfs ����
					visited = new boolean[width][width];	//�湮 ���� Ȯ��
					if(!dfs(i, j, 0)) return false;	//�������� ����(��)���θ� ���� ���
					if(!dfs(i, j, 1)) return false;	//�����Դ� �Ʒ���(��)���θ� ���� ���
					if(!dfs(i, j, 2)) return false;	//�������� ����(��)���θ� ���� ���
					if(!dfs(i, j, 3)) return false;	//�������� ������(��)���θ� ���� ���
				}
			}
		}
		return true;
	}
	public static boolean dfs(int y, int x, int dir) {
		if (map[y][x]=='S')  return false;	//�л��� ��Ų ��� false ��ȯ
		if(map[y][x]=='O') return true; //Obstacle ���� ��� ���̻� Ž�� ���� �ʰ� true ��ȯ
		int next_x = 0, next_y = 0;	//������ �� ��ǥ
		switch (dir) {
		case 0:		//��
			next_x = x;
			next_y = y-1;
			break;
		case 1:		//��
			next_x = x;
			next_y = y+1;
			break;
		case 2: 	//��
			next_x = x-1;
			next_y = y;
			break;
		case 3:		//��
			next_x = x+1;
			next_y = y;
			break;
		}
		if(check(next_y, next_x)) {	//�� �� �ִ� ��ǥ���� Ȯ��
			if(!dfs(next_y, next_x, dir)) return false;	//�ش� ĭ�� ���� dfs �� �����ؼ� �л��� ��Ų ��� false ��ȯ
		}
		return true;	//�ƹ� �л��� �ȵ������� true ��ȯ
	}
	public static boolean check(int y, int x) {
		if(0<=x && 0<=y && x<width && y<width && !visited[y][x]) return true;
		return false;
	}
}
