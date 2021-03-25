package week12;
import java.io.*;
import java.util.*;
public class _2636_������_ġ�� {

	static int[] axis_y = {-1, 1, 0, 0};				//dfs �̿� �����¿�
	static int[] axis_x = {0, 0, -1, 1};
	static int width;									//ġ�� map�� ����, �ʺ�
	static int height;
	static int[][] map;									//ġ�� �� ����
	static boolean[][] visited;							//�湮���� Ȯ��
	static int time;									//�� �ҿ� �ð�
	static int cheese;									//ġ� �� ��Ҵ��� Ȯ���ϱ� ���� �ش� time�� ������ �� cheese�� ����
	static int pre_cheese;								//ġ� 0�� �Ǳ� ���� �ð��� cheese �� ����
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
		height = Integer.parseInt(st1.nextToken());
		width = Integer.parseInt(st1.nextToken());
		map = new int[height][width];
		visited = new boolean[height][width];
		
		for(int i=0; i<height; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<width; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
				cheese += map[i][j];					// ó�� ���� ġ�� ����
			}
		}
		////////////////////////////////////////////////// �Է�
		while (cheese > 0) {							//ġ� �� ���� �� ���� �ݺ�
			pre_cheese = cheese;						//���� ġ�� �� ����
			for(int i=0; i<height; i++) {				//ġ�� �ӿ� �ִ� �� ������ ������� �ʾƵ� �ǹǷ� dfs�� �����¿� ���� �� �� or ���� ���ؼ��� ���� (�ѷ��ο��ִ� �� �κ��� dfs ����� map�� �����ڸ��� ���� ���ϹǷ�)
				if(visited[i][0] == false) dfs(i,0);
				if(visited[i][width-1] == false) dfs(i,width-1);
			}
			for(int i=0; i<width; i++) {
				if(visited[0][i] == false) dfs(0,i);
				if(visited[height-1][i] == false) dfs(height-1,i);
			}
			time++;										//dfs �� ���� �Ŀ��� �ð� ����
			for(int i=0; i<height; i++) {				//visited �迭 �ʱ�ȭ
				for(int j=0; j<width; j++) {
					visited[i][j] = false;
				}
			}
		}
		System.out.println(time);
		System.out.println(pre_cheese);
	}
	public static void dfs(int x, int y) {				//dfs
		visited[y][x] = true;							//�湮 ó��
		for(int i=0; i<4; i++) {						//�����¿�
			int next_x = x + axis_x[i];
			int next_y = y + axis_y[i];
			if (check(next_x, next_y)) {				//dfs �����ص� �Ǵ��� Ȯ��
				visited[next_y][next_x] = true;			//�湮ó��
				if (map[next_y][next_x] == 1) {			//ġ� ������ ġ�� ���̰� ���̻� dfs ����
					map[next_y][next_x] = 0;
					cheese--;							//ġ�� ���� �ϳ� ����
				}
				else {									//ġ�� ������ dfs ����
					dfs(next_x, next_y);
				}
			}
		}
	}
	
	public static boolean check(int x, int y) {							//�ش� �ڸ��� map���� ��ȿ�ϸ� ���� �湮���� �ʾҴ��� check
		if (x >= 0 && y >= 0 && x < width && y < height && !visited[y][x]) return true;
		return false;
	}
}
















