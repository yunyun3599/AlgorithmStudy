package tmp;
import java.io.*;
import java.util.*;
public class _1303_������_�������� {

	static int width;
	static int height;
	static char[][] map;
	static boolean[][] visited;
	static int white;	//�� �� ���� ������� ����
	static int blue;	//�Ķ� �� ���� ������� ����
	static int[] axis_y = {-1,1,0,0};
	static int[] axis_x = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		
		map = new char[height][width];
		visited = new boolean[height][width];
		
		for(int i=0; i<height; i++) {		//map�� ���� �߰�����
			String tmp = br.readLine();
			for(int j=0; j<width; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		
		for(int i = 0; i<height; i++) {		//dfs ������
			for(int j=0; j<width; j++) {
				if(map[i][j] == 'W' && !visited[i][j]) white += Math.pow(dfs(i,j,'W', 0) , 2);	//W�� ���� ������
				if(map[i][j] == 'B' && !visited[i][j]) blue += Math.pow(dfs(i,j,'B', 0), 2);	//B�� ���� ������
			}
		}
		System.out.println(white+" "+blue);
	}
	public static int dfs(int y, int x, char color, int count) {	//dfs �Լ�
		visited[y][x] = true;		//�̹� ��ǥ true�� ����
		count++;		//��� �� �ϳ� �ø���
		for(int k=0; k<4; k++) {	//�����¿� Ž��
			int next_y = y+axis_y[k];
			int next_x = x+axis_x[k];
			if(check(next_y, next_x, color)) count = dfs(next_y, next_x, color, count);	//���� ���� ���� ����̸� ��������� dfs ����, count �� ����
		}
		return count;	//count ����
	}
	public static boolean check(int y, int x, char color) {	//������ ���� üũ
		if(y>=0 && y<height && x>=0 && x<width && !visited[y][x] && map[y][x] == color) return true;
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
