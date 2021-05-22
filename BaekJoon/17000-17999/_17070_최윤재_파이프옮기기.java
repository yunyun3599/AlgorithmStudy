package tmp;
import java.util.*;
import java.io.*;

public class _17070_������_�������ű�� {

	static int N;		//�ʺ�
	static int[][] map;	//���� ����
	static int result;	//���
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}		
		}////////////////////////////////////////////////////�Է�
		dfs(0,1,0);			//�������� ���� (0,1)���� ����, ������ ���� (���� ����:0 ����:1 �밢��:2)
		System.out.println(result);
	}
	public static void dfs(int y, int x, int dir) {
		if(y==N-1 && x==N-1) {		//��ǥ ������ ������ ��� result�ϳ� ����
			result++;
			return;
		}
		switch(dir) {	//���⿡ ���� �� �� �ִ� ��� Ȯ��
		case  0:		//����
			if(check(y, x+1)) dfs(y, x+1, 0);		//���η� ��ĭ ��
			if(check(y+1, x+1) && map[y+1][x]==0 && map[y][x+1]==0) dfs(y+1, x+1, 2);	//�밢�� �Ʒ�
			break;
		case 1:		//����
			if(check(y+1, x)) dfs(y+1, x, 1);		//���η� ��ĭ ��
			if(check(y+1, x+1) && map[y+1][x]==0 && map[y][x+1]==0) dfs(y+1, x+1, 2);	//�밢�� �Ʒ�
			break;
		case 2:	//�밢��
			if(check(y, x+1)) dfs(y, x+1, 0);	//����
			if(check(y+1, x)) dfs(y+1, x, 1);	//����
			if(check(y+1, x+1) && map[y+1][x]==0 && map[y][x+1]==0) dfs(y+1, x+1, 2);	//�밢��
			break;
		}
	}
	
	public static boolean check(int y, int x) {	//���� �� ���� üũ
		if(y<N && x<N && 0<=y && 0<=x && map[y][x]==0) return true;
		return false;
	}
}

