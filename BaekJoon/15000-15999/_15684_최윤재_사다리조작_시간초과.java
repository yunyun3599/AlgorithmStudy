package tmp;
import java.io.*;
import java.util.*;

public class _15684_������_��ٸ�����_�ð��ʰ� {
	
	static int N;	//���μ� ����
	static int M;	//���μ� ����
	static int H;	//���μ��� ���� �� �ִ� ��ġ�� ����
	static int[][] map;
	static boolean[][] ladder;
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H+1][N+1];
		ladder = new boolean[H+1][N+1];		//ladder�迭�� true, false�� ��ٸ� �ִ��� ������ �־��
		for(int i=0; i<H+1; i++) {
			for(int j=1; j<N+1; j++) {
				map[i][j] = j;
			}
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			ladder[y][x] = true;
		}
		
		change(1, 1, 0);	//��ٸ�Ÿ�� ����
		
		if(result == Integer.MAX_VALUE) System.out.print(-1);
		else System.out.println(result);
	}
	
	public static void change(int y, int x, int count) {
		int tmp_map[][] = copymap();
		if(count > 3) return;		//��ٸ� 3�� �Ѱ� ��������� �׸� �����
		for(int i=1; i<H+1; i++) {	//��ٸ� ���ο� ���� ���� ���ڵ� �ٲٱ�
			for(int j=1; j<N; j++) {
				if(ladder[i][j]) {
					int front = tmp_map[i-1][j];
					int back = tmp_map[i-1][j+1];
					for(int k=i; k<H+1; k++) {
						tmp_map[k][j] = back;
						tmp_map[k][j+1] = front;
					}
				}
			}
		}
		
		if(evaluate(tmp_map)) {		//�ڱ��ڸ� ã�ư��� Ȯ��	
			result = Math.min(result, count);
		}
		
		for(int i = y; i < H+1; i++) {	//���� ��ٸ� ����
			int x_start = i==y ? x : 1;
			for(int j = x_start; j < N; j++) {
				if(!ladder[i][j] && !ladder[i][j-1] && !ladder[i][j+1]) {
					ladder[i][j] = true;
					change(i, j+1, count+1);
					ladder[i][j] = false;
				}
			}
		}
	}
	
	public static boolean evaluate(int[][] tmp_map) {	//�ڸ� �ùٸ��� Ȯ��
		boolean flag = true;
		for(int i=1; i<N+1; i++) {
			if(tmp_map[0][i] != tmp_map[H][i]) {
				flag = false;
			}
		}
		return flag;
	}
	
	public static int[][] copymap(){	//map ����
		int[][] tmp = new int[H+1][N+1];
		for(int i=0; i<H+1; i++) {
			for(int j=0; j<N+1; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		return tmp;
	}
}