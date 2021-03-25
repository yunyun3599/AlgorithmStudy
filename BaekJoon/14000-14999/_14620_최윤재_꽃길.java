package week19;
import java.io.*;
import java.util.*;

public class _14620_������_�ɱ� {
	
	static int[] axis_x = {0, 0, -1, 1};
	static int[] axis_y = {-1, 1, 0, 0};
	static int[][] map;
	static int[][] value;
	static int width;
	static int final_result = Integer.MAX_VALUE;
			
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		width = Integer.parseInt(br.readLine());
		map = new int[width][width];
		value = new int [width][width];
		for(int i=0; i<width; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<width; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		///////////////////////////////////////////////////////������� �Է�
		for(int i=1; i<width-1; i++) {
			for(int j=1; j<width-1; j++) {
				value[i][j] = map[i][j];
				for(int k=0; k<4; k++) {
					int x = j + axis_x[k];
					int y = i + axis_y[k];
					value[i][j] += map[y][x];		//value�迭�� �� ĭ�� ���� �ɾ��� ���� �� ����
				}
			}
		}
		for(int i=1; i<width-1; i++) {
			for(int j=1; j<width-1; j++) {
				boolean[][] visited = new boolean[width][width];
				final_result = Math.min(final_result, calc(i, j, visited, 1));	//(i,j)�� ���� ���� ���鿡 ���� calc���� Ž��
			}
		}
		System.out.println(final_result);
	}
	public static int calc(int y, int x, boolean[][] visited, int num) {
		int result = 10000;				//������ ���
		if(num==3) return value[y][x];	//����° ���̸� �ش� ĭ�� �� ��ȯ
		visited[y][x] = true;
		visited[y-1][x] = true;
		visited[y][x-1] = true;
		visited [y+1][x] = true;
		visited[y][x+1] = true;			//visited�迭 ó��
		for(int i=y; i<width-1; i++) {
			int x_pos = (i==y) ? x : 1;	//�ùٸ� �κк��� Ž���ϱ� ���� ó��
			for(int j=x_pos; j<width-1; j++) {
				if(!visited[i][j] && !visited[i][j-1] && !visited[i][j+1] && !visited[i-1][j]) {	//�ش� ĭ�� ���� �� �ִ��� Ȯ��
					result = Math.min(result, calc(i, j, visited, num+1));	//��������� result�� ���� �޾ƿ� result �� �� �� ���� �� ä��
					visited[i][j] = false;
					visited[i-1][j] = false;
					visited[i][j-1] = false;
					visited [i+1][j] = false;
					visited[i][j+1] = false;	//visited Ǯ���� (�ٵ� ��??�̤̤�)
				}
			}
		}
		return result + value[y][x];	//��� ����
	}
}



