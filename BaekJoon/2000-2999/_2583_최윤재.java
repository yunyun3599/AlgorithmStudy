package week10;
import java.util.*;
public class _2583_������ {

	static int[] axis_x = {0, 0, -1, 1};					//�����¿�
	static int[] axis_y = {-1, 1, 0, 0};
	static int width;										//��ü ����, ��
	static int height;
	static int num;											//���簢�� ����
	static int[][] map;										//��ü �׸� ���� ����
	static int[][] visited;									//�湮�� ĭ
	static ArrayList<Integer> result = new ArrayList();		//���еǴ� ������ ũ�� ����
	static int count;										//���еǴ� ���� ���� ����
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		height = sc.nextInt();					
		width = sc.nextInt();
		num=sc.nextInt();
		
		map = new int[height][width];
		visited = new int[height][width];
		
		for(int i=0; i<num; i++) {
			int under_x = sc.nextInt();
			int under_y = sc.nextInt();
			int above_x = sc.nextInt();
			int above_y = sc.nextInt();
			for(int j=under_x; j<above_x; j++) {			//���簢���� ��ġ�� ĭ�� ���� 1�� �ٲ���
				for(int k=under_y; k<above_y; k++) {
					map[k][j] = 1;
				}
			}
		}
		
		for(int i=0; i<width; i++) {						//���� �湮���� �ʾҰ� ���簢���� ���� ĭ�� ���� dfs ����
			for(int j=0; j<height; j++) {
				if(map[j][i]==0 && visited[j][i]==0) {
					result.add(dfs(i,j,0));					//��� ����
					count++;								//���� ���� ����
				}
			}
		}
		Collections.sort(result);							//��� �������� ����
		System.out.println(count);							//��� print
		for(int i=0; i<result.size(); i++) {
			System.out.print(result.get(i)+" ");
		}
	}
	
	public static int dfs(int x, int y, int cnt) {			//dfs �Լ�
		cnt++;												//���� ũ�� �ϳ� ������Ű��
		visited[y][x] = 1;									//�湮 ǥ���ϱ�
		for(int i=0; i<4; i++) {							//�����¿� Ž��
			int next_x = x + axis_x[i];
			int next_y = y + axis_y[i];
			if(next_x >= 0 && next_y >= 0 && next_x < width && next_y < height && visited[next_y][next_x] == 0 && map[next_y][next_x]==0) {
				cnt = dfs(next_x, next_y, cnt);				
			}
		}
		return cnt;											//���� ũ�� return
	}

}
