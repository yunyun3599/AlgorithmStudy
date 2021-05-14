package tmp;
import java.io.*;
import java.util.*;
public class _2468_������_�������� {

	static int width;
	static int[][] map;			//�� ����
	static boolean[][] visited;
	static int max = 1;
	static int tmp_result = 0;	//���췮�� �������� ����
	static int[] axis_x = {0,0,-1,1};
	static int [] axis_y = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		width = Integer.parseInt(br.readLine());
		map = new int[width][width];
		int highest = 0;	//���� ���� ������ ����
		for(int i=0; i<width; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<width; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				highest = Math.max(highest, map[i][j]);		//���� ���� ������ ���� ���ϱ� (�������� 1���� �� ���� �ش��ϴ� ��ŭ ����)
			}
		}
		for(int i=1; i<highest; i++) {		//���췮�� 1���� ���� ���� ���뿡 �ش��� �� ���� ����
			tmp_result = 0;
			visited = new boolean[width][width];
			for(int y = 0; y<width; y++) {
				for(int x = 0; x<width; x++) {
					if(map[y][x]>i && !visited[y][x]) {	//���밡 ���췮���� ���� ���� �湮���� ���� ���
						dfs(y,x,i);	//dfs������
						tmp_result++;	//�������� ���� �ϳ� �ø���
					}
				}
			}
			max = Math.max(tmp_result, max);	//�̹� ���췮�� �ش��ϴ� �������� ������ �� ũ�� max�� ������Ʈ
		}
		System.out.println(max);
	}
	public static void dfs(int y, int x, int flood) {	//dfs
		visited[y][x] = true;		//�湮ó��
		for(int k=0; k<4; k++) {	//�����¿�
			int next_y = y+axis_y[k];
			int next_x = x+axis_x[k];
			if(check(next_y, next_x, flood)) dfs(next_y,next_x,flood);	//����, �湮����, ���췮 üũ �� ���� �����ϸ� dfs ������
		}
	}
	
	public static boolean check(int y, int x, int flood) {
		if(y>=0 && y<width && x>=0 && x<width && !visited[y][x] && map[y][x]>flood) return true;
		return false;
	}

}
 

