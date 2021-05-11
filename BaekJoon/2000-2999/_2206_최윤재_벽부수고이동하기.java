package tmp;
import java.io.*;
import java.util.*;

class Loc {					//��ǥ�� �̵� �Ÿ�, ���翩�θ� ����
	int y, x, dist, drill;
	Loc(int y, int x, int dist, int drill){
		this.y = y;
		this.x = x;
		this.dist = dist;
		this.drill = drill;
	}
}

public class _2206_������_���μ����̵��ϱ� {

	static int width;
	static int height;
	static int[][] map;
	static int[][] visited;
	static int min = Integer.MAX_VALUE;
	static int[] axis_x = {0,0,-1,1};
	static int[] axis_y = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		map = new int[height][width];
		visited = new int[height][width];
		
		for(int i=0; i<height; i++) {
			String tmp = br.readLine();
			for(int j=0; j<width; j++) {
				map[i][j] = tmp.charAt(j)-'0';
				visited[i][j] = Integer.MAX_VALUE;
			}
		}///////////////////////////////////////////////�Է�
		bfs();	//bfs������
		if(min == Integer.MAX_VALUE) System.out.println(-1);	//�Ұ����� ��쿡�� -1 ���
		else System.out.println(min);
	}
	public static void bfs() {
		Queue<Loc> queue = new LinkedList<>();	//visited�� ��� �ش� �ڸ����� ���� �� ���縦 �� ���� ������ 1�� ����, �ƴϸ� 0�� ����
		queue.add(new Loc(0,0,1,0));	//y��ǥ, x��ǥ, �̵��Ÿ�
		visited[0][0] = 0;				//ù ĭ�� ���� ���� ����
		while(!queue.isEmpty()) {		//bfs������
			Loc loc = queue.poll();
			if(loc.y==height-1 && loc.x==width-1) {	//������ ����
				min = loc.dist;		//����� ������Ʈ
				return;
			}
			for(int k=0; k<4; k++) {	//�����¿� Ž��
				int y = loc.y + axis_y[k];
				int x = loc.x + axis_x[k];
				if(check(y,x)) {		//�� �� �ִ� ������ ��
					if(visited[y][x] > loc.drill) {	//���࿡ ���� �湮���� ���� ���ų� ���縦 ������ �Ŀ� �湮�� ���� �ִµ� �̹� �湮 �õ��� ���縦 ���� ���� ���� ��쿡 ���� queue�� ����
						if(map[y][x]==0) {	//���� ���� ���
							queue.add(new Loc(y,x,loc.dist+1,loc.drill));
							visited[y][x] = loc.drill;	//visited���� ���� �� ��ο� ���� ���������� �ִ���, �������� �״�� �޾� �ְ� ��
						}
						else {		//�����ִ� ���
							if(loc.drill==0) {	//���� ���� �ѹ��� �Ⱥμ� ��쿡 ���ؼ��� ����
								queue.add(new Loc(y,x,loc.dist+1,loc.drill+1));
								visited[y][x] = loc.drill+1;	//visited���� ���縦 �� ��쿡 �� �ڸ��� �� ���� �ִٰ� ǥ��
							}
						}
					}
				}
			}
		}
	}
	
	public static boolean check(int y, int x) {	//map�� �����ϴ��� ���� Ȯ��
		if(y >= 0 && y < height && x >= 0 && x < width) return true;
		return false;
	}
	
}
