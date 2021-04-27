package tmp;
import java.io.*;
import java.util.*;

class Shark{		//���� ��ġ�� �󸶳� �̵��ߴ��� ���
	int y;
	int x;
	int dist;
	Shark(int y, int x, int dist) {
		this.y=y;
		this.x = x;
		this.dist = dist;
	}
}
public class _17086_������_�Ʊ��� {
	
	static int[][] map;
	static int width;
	static int height;
	static int[] axis_x = {-1,-1,-1,0,0,1,1,1};	//�����¿�밢�� Ŀ��
	static int[] axis_y = {-1,0,1,-1,1,-1,0,1};
	static int result = 0;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		map = new int[height][width];
		
		for(int i=0; i<height; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<width; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		////////////////////////////////////////////////////////�Է�
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				if(map[i][j]==0) {					//0�� �ڸ��� ���� bfs ����
					result = Math.max(result, bfs(i,j));	//bfs�����ؼ� ���� ����� ������ �Ÿ��� ������� �ִ밪���� ũ�� ������Ʈ
				}
			}
		}
		System.out.println(result);
	}
	public static int bfs(int y, int x) {		//bfs ���� �ڵ�
		visited = new boolean[height][width];
		Queue<Shark> queue = new LinkedList<>();	//queue
		queue.add(new Shark(y, x, 0));	//�ʱ� ��ġ queue�� �ֱ�
		visited[y][x] = true;		//�湮ó��
		while(!queue.isEmpty()) {	//queue�� �������� ����
			Shark shark = queue.poll();	//���� ��ġ �̱�
			for(int i=0; i<8; i++) {	//�ش� ��ġ�� ���� �����¿� �밢������ �̵�
				int next_y = shark.y + axis_y[i];	//������ ���� �� ��ǥ
				int next_x = shark.x + axis_x[i];
				if(0<=next_y && next_y<height && 0<=next_x && next_x<width && !visited[next_y][next_x]) {	//map�� �ְ�, ���� �湮���� ���� ���
					if(map[next_y][next_x]==1) return shark.dist+1;		//���� �� ������ �Ÿ� �ϳ� �÷��� ��������
					queue.add(new Shark(next_y, next_x, shark.dist+1));	//�̹��� ������ ��ġ queue�� ����
					visited[next_y][next_x]=true;	//�湮ó�����ֱ�
				}
			}
		}
		return -1;	//���� �ּ� �Ѹ����� �����Ƿ� �Ұ����� ���
	}
}
