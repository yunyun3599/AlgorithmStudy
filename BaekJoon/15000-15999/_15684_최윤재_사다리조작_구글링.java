package tmp;
import java.io.*;
import java.util.*;

public class _15684_������_��ٸ�����_���۸� {

	static int N,M,H;
	static int[][] map;
	static boolean[][] visited;
	static int ladder_num;
	static boolean isEnd;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    H = Integer.parseInt(st.nextToken());
	    
	    map = new int[H+2][N+1];
	    
	    for(int i=0; i<M; i++) {
	    	st = new StringTokenizer(br.readLine()," ");
	    	map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
	    }
	    for(int i=0; i<=3; i++) {	//��ٸ��� 0��~3�� ���� ��쿡 ���� ����
	    	ladder_num = i;
	    	check(1,1,0);
	    	if(isEnd) break;	//�����ϴ� ��� ����� �׸��ϱ�
	    }
	    System.out.println(isEnd? ladder_num : -1);
	}
	static void check(int y, int x, int cnt) {
		if(isEnd) return;		//�����ϴ� ��� return
		if(ladder_num == cnt) {	//��ٸ� �� ��ȹ�Ѹ�ŭ �� �������� �������� Ȯ�� �� �������� ���� ����
			if(eval()) {
				isEnd = true;
			}
			return;
		}
		for(int i=y; i<=H; i++) {	//��ٸ� ���� ��쿡 ���� ��Ʈ��ŷ
			int x_start = y==i ? x : 1;
			for(int j=x_start; j<N; j++) {
				if(map[i][j]==1 || map[i][j-1]==1 || map[i][j+1]==1) continue;
				map[i][j] = 1;
				check(i, j, cnt+1);
				map[i][j] = 0;
			}
		}
	}
	static boolean eval() {
		for(int i=1; i<=N; i++) {	//i�� �̹��� Ȯ���� ���� ��ġ
			int j = 1;		//j�� ���������� ���° ĭ�� ��ġ�ߴ����� ���� ����
			int tmp = i;	//tmp�� ���� � �����ٿ� �ִ��� ����
			while(j<=H+1) {	//���� �ؿ� �̸� ������ �ݺ�
				if(map[j][tmp] == 1 ) {//���������� ���� ���
					tmp++;	//���������� �����Ƿ� tmp�� 1 ����
				}
				else if(map[j][tmp-1] == 1) {	//�������� ���� ���
					tmp--;
				}
				j++;	//�� ĭ ������ �̵��� ��
			}
			if( i != tmp) {	//ó�� ��ġ�� �ٸ��� false ��ȯ
				return false;
			}
		}
		return true;
	}

}

//���� ��α� : https://jaejin89.tistory.com/97





