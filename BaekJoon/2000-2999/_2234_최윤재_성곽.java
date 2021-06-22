package tmp;
import java.util.*;
import java.io.*;
public class _2234_������_���� {

	static int width;
	static int height;
	static boolean wall[][][];	//{��, ��, ��, ��} ���� ���� ����
	static int map[][][];		//map[��][��][����, ����] �� ������ �� ���������� �ش� ������ ���� ����
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean visited[][];	//ó�� bfs�� �����ؼ� ���� ���� �� �̿��� visited �迭
	static boolean visited2[][];//���� ���� ���� �� ĭ�� ������ ��(map�迭 ä�� ��) ����� visited�迭
	static int max1;	//���� ���� ������ ����
	static int max2;	//�� �ϳ��� �㹰���� �� ���� ���� ������ ����
	static int num;		//������ ����
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		wall = new boolean[height][width][4];
		map = new int[height][width][2];
		visited = new boolean[height][width];
		visited2 = new boolean[height][width];
		for(int i=0; i<height; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<width; j++) {
				int value = Integer.parseInt(st.nextToken());
				for(int k=0; k<4; k++) {
					wall[i][j][k] = value%2==0?false : true;	//2�� ���� ������ ������ ���������̹Ƿ� true false�� ǥ���� wall �迭�� ����
					value  = value/2;
				}
			}
		}
		///////////////////////////////////////////////////�Է�
		for(int i=0; i<height; i++) {		//ó�� bfs�� ���� ���� ���� ���ϱ�
			for(int j=0; j<width; j++) {
				if(!visited[i][j]) {
					max1 = Math.max(bfs(i,j), max1);
					num++;		//���� ���� �ϳ� ����
				}
			}
		}
		for(int i=0; i<height; i++) {		//�� �ϳ� �㹰���� �� ���� ���� ���ϱ�
			for(int j=0; j<width; j++) {	//�� ĭ�� ���� ����
				for(int k=2; k<4; k++) {	//��, �� ������ ����� �ʿ� ����. (�� ĭ������ ��, ���� �����ϹǷ�)
					if(wall[i][j][k]) {		//���� �����ϴ� ��� -> ���� ���� �� �ִ� �����
						int ny = i+dy[k];	//���� ��ǥ ���
						int nx = j+dx[k];
						if(ny<height && nx<width && map[i][j][0]!=map[ny][nx][0]) {	//���� ��ǥ�� map�� �ְ� ���� ĭ�� ���� ĭ�� �ٸ� ������ ��
							max2 = Math.max(map[i][j][1]+map[ny][nx][1], max2);	//max2���� ���� ���̿� ���� �ִ� ���� ���� ��� �� �� ū ���� max2���� ��.
						}
					}
				}
			}
		}
		
		System.out.println(num);
		System.out.println(max1);
		System.out.println(max2);
	}
	public static int bfs(int y, int x) {	//ó�� ���� ũ�� ���ϴ� bfs
		int area = 0;	//�ش� ������ ũ��
		visited[y][x] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {y, x});
		while(!queue.isEmpty()) {	//bfs ������
			int[] yx = queue.poll();
			area++;
			for(int k=0; k<4; k++) {	//���� ĭ Ȯ��
				if(wall[yx[0]][yx[1]][k]) continue;	//���� �����ϴ� ��� Ž�� ���ϰ� continue
				int ny = yx[0] + dy[k];	//���� ĭ ��ǥ
				int nx = yx[1] + dx[k];
				if(visited[ny][nx]) continue;	//�̹� �湮�� ��� continue
				visited[ny][nx] = true;	//���� �湮���� ���� ��� queue�� �߰�
				queue.add(new int[] {ny, nx});
			}
		}
		fill(y, x, area);	//�̹��� ���� ������ ���� ���� ���̷� �� ĭ�� value�� ä��� �Լ�
		return area;
	}
	public static void fill(int y, int x, int value) {	//�� ĭ�� ���Ե� ������ ũ��� ä��� �Լ�
		visited2[y][x] = true;	//fill�Լ����� ����� �湮�迭
		map[y][x][0] = num;		//���� ��ȣ�� ���� (���� ������ ��� ���� ���� �ʿ� �����Ƿ�)
		map[y][x][1] = value;	//���� ���̸� ����
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {y, x});
		while(!queue.isEmpty()) {	//bfs������ �ش� ������ ���� ���� ���� �� ����
			int[] yx = queue.poll();
			for(int k=0; k<4; k++) {
				if(wall[yx[0]][yx[1]][k]) continue;	//���� �ִ� ���
				int ny = yx[0] + dy[k];
				int nx = yx[1] + dx[k];
				if(visited2[ny][nx]) continue;	//�̹� �湮�� ���
				visited2[ny][nx] = true;	//���� �湮 ���Ѱ��
				map[ny][nx][0] = num;	//0�� �ε����� ������ ��ȣ ����
				map[ny][nx][1] = value;	//1�� �ε����� ������ ���� ����
				queue.add(new int[] {ny, nx});
			}
		}
	}
}
