package week9;
import java.io.*;
import java.util.*;
public class _1926_������ {

	static int height;									
	static int width;
	static int max;						//���� �ִ� ����
	static int tmp_max;					//�� �׸� �� ����
	static int count;					//�׸� ����
	static int[][] map;
	static int[] axis_x= {0,0,-1,1};	//�����¿�
	static int[] axis_y= {-1,1,0,0};
	static int visited[][];
	
	public static void main(String[] args) throws IOException {
		Scanner sc= new Scanner(System.in);
		height=sc.nextInt();
		width=sc.nextInt();
		map=new int[height][width];
		visited=new int[height][width];
		
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				map[i][j]=sc.nextInt();
			}
		}
	//////////////////////////////////////////////////////////������� �Է�
		for(int i=0; i<height; i++) {						//�� map�� ���Ҹ��� ���� �湮���� �ʾҰ� 1�̸� dfs ����
			for (int j=0; j<width; j++) {
				if(visited[i][j]==0 && map[i][j]==1) {
					tmp_max++;								//���� 1 ����
					dfs(i,j);								//dfs ����
					if (tmp_max>max) max=tmp_max;			//�ش� �׸��� ���̰� ���� max������ ũ�� max�� ������Ʈ
					count++;								//�׸� ����++
					tmp_max=0;								//�� �׸��� ���� �����ϴ� ���� 0���� �ٽ� ����
				}
			}
		}
		System.out.println(count);							//��� ���
		System.out.println(max);
	}
	
	public static void dfs(int y, int x) {					//dfs ����
		visited[y][x]=1;
		for(int i=0; i<4; i++) {
			int next_x= x+axis_x[i];
			int next_y= y+axis_y[i];
			if(next_x>=0 && next_y >=0 && next_x<width && next_y<height && visited[next_y][next_x]==0 && map[next_y][next_x]==1) {
				dfs(next_y,next_x);
				tmp_max++;
			}
		}
	}
}


//�׸�
