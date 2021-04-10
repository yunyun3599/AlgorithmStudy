package tmp;
import java.io.*;
import java.util.*;
public class _16234_������_�α��̵� {
	
	static int N;	//N*N ����
	static int L;	//�α��� �� �ּ�
	static int R;	//�α��� �� �ִ�
	static int[][] map;	//������ �α��� ����
	static int[] axis_x = {0,0,-1,1};	//dfs�̿� ����
	static int[] axis_y = {-1,1,0,0};
	static boolean[][] visited;	//�湮�ߴ��� ���� Ȯ��
	static int move;	//�̵� Ƚ��(���� ���)
	static Queue<int[]> loc = new LinkedList<>();	//�̵������� �������� ��ǥ ���� (dfs�� ���̴� ������)
	static boolean no_more_move = true;	//���̻� �̵��� �Ұ����� ��쿡 true
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}	//�Է�
		while (!isFinished()) {	//�α����� �������������� �ݺ�
			no_more_move = true;	//���̻� �̵��� �Ұ����ϴٰ� �����س��� ���Ŀ� �̵� ������ ��찡 �ѹ��̶� ����� �� false�� �ٲ�
			visited = new boolean[N][N];	//�湮�ߴ��� ���� ����
			for(int i=0; i<N; i++) {	//dfs ����
				for(int j=0; j<N; j++) {
					if(!visited[i][j]) {
						int total = dfs(i,j,map[i][j]);	//total�� �̹� dfs �õ��� ���� ������ �α����� ����
						distribute(total);	//����� ���� �� ������ �α��� ��� �й�
					}
				}
			}
			if(no_more_move) break;	//���̻� �̵��� �Ұ����ϴٴ� ����� ������ �ݺ� ���� ����
			move++;	//�̹� �ݺ����� �̵��� �Ͼ���� move�ϳ� ���� 
		}
		System.out.println(move);	//��� ���
	}
	public static int dfs(int y, int x, int population) {	//dfs�����ؼ� �̵� ������ ������ ����
		loc.add(new int[] {y,x});	//�̵� ������ ������ ���̸� �ش� ��ǥ�� queue�� ����
		visited[y][x] = true;	//�湮 ���� ������Ʈ
		for(int i=0; i<4; i++) {	//�����¿� Ž��
			int next_y = y+axis_y[i];
			int next_x = x+axis_x[i];
			if(check(y, x, next_y, next_x)) population = dfs(next_y, next_x, population+map[next_y][next_x]);	//�ش� ������ ��輱 ���ֵ� �Ǵ��� Ȯ�� �� dfs ����
		}
		return population;	//�� �α��� return
	}
	
	public static void distribute(int total) {
		int average = total/(loc.size());	//�����鰣�� �̵��� �Ͼ �� �� �α���
		while(!loc.isEmpty()) {	//�ش�Ǵ� �������� ��ǥ�� ����
			int[] yx = loc.poll();
			map[yx[0]][yx[1]] = average;	//�ش� ��ǥ ���� average�� ����
		}
	}
	
	public static boolean isFinished() {	//��� �������� �α��� ������ Ȯ��
		int population = map[0][0];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] != population) return false;
			}
		}
		return true;
	}
	
	public static boolean check(int y, int x, int next_y, int next_x) {	//�������� Ž���� ������ ���� �� ������ �����ϴ��� Ȯ��
		if(0<=next_x && next_x<N && 0<=next_y && next_y<N && !visited[next_y][next_x]) {	//���� �� �湮���� Ȯ��
			int diff = Math.abs(map[y][x]-map[next_y][next_x]);	//���� ������ �������� Ž���� ������ �α��� ���� ���ϱ�
			if(L<= diff && diff <= R) {	//�α����� ���ǿ� �����ϸ� true��ȯ, �̵� �Ͼ���̹Ƿ� no_more_move�� false�� �ٲ�
				no_more_move = false;
				return true;
			}
		}
		return false;
	}
}
























