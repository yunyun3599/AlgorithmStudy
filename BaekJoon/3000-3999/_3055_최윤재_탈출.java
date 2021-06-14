package tmp;
import java.io.*;
import java.util.*;

class Loc{			//queue�� ���� ��ġ
	int y;
	int x;
	int time;
	Loc(int y, int x, int time){
		this.y = y;
		this.x = x;
		this.time = time;
	}
}

public class _3055_������_Ż�� {

	static int R;
	static int C;
	static char[][] map;
	static boolean[][] visited;
	static Queue<Loc> queue = new LinkedList<>();	//����ġ ��ġ
	static Queue<Loc> water = new LinkedList<>();	//�� ��ġ
	static int[] axis_x = {-1,1,0,0};
	static int[] axis_y = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			String tmp = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = tmp.charAt(j);
				if(map[i][j]=='S') {		//����ġ �ʱ� ��ġ queue�� ����
					queue.add(new Loc(i, j, 0));
					map[i][j]='.';
					visited[i][j] = true;
				}
				if(map[i][j]=='*') {	//���� �ִ� ��ġ�� ����
					water.add(new Loc(i,j,0));
				}
			}
		}
		while(!queue.isEmpty()) {		//����ġ�� �� ���� ���� ������ �ݺ�
			int dfs_rotation = water.size();	//���� ��ĭ�� �۶߸��� ���� ���� ���� �ִ� ��ġ ���� ����
			for(int i=0; i<dfs_rotation; i++) {	//���� �ִ� �� �������θ� �����¿� �۶߸�
				Loc water_loc = water.poll();
				dfs(water_loc.y, water_loc.x);
			}
			int rotation = queue.size();	//���� ����� ��ġ�鿡�� �����¿� �̵�
			for(int iter=0; iter<rotation; iter++) {
				Loc loc = queue.poll();
				for(int k=0; k<4; k++) {
					int next_y = loc.y+axis_y[k];
					int next_x = loc.x+axis_x[k];
					if(check(next_y, next_x) && map[next_y][next_x]=='D') {	//���� �̵��� ��Ұ� ������϶�
						System.out.println(loc.time+1);
						System.exit(0);
					}
					if(check(next_y, next_x) && map[next_y][next_x]=='.' && !visited[next_y][next_x]) {	//�������� �̵��� �� �ִ� ������ �ִ� ���
						queue.add(new Loc(next_y, next_x, loc.time+1));
						visited[next_y][next_x]=true;
					}
				}
			}
		}
		System.out.println("KAKTUS");	//��� ���� ���� ���
	}
	public static void dfs(int y, int x) {	//�� ��ĭ�� �ø���
		for(int k=0; k<4; k++) {	//�����¿�
			int next_y = y+axis_y[k];
			int next_x = x+axis_x[k];
			if(check(next_y, next_x) && map[next_y][next_x]=='.') {	//�� ��ġ�� ����
				map[next_y][next_x] = '*';	//map�� ǥ��
				water.add(new Loc(next_y, next_x, 0));	//queue�� �� �ִ� ��ġ ���ϱ�
			}
		}
	}
	public static boolean check(int y, int x) {	//���� üũ
		if(y>=0 && x>=0 && y<R && x<C) return true;
		return false;
	}
}
