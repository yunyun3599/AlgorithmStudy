package tmp;
import java.io.*;
import java.util.*;
public class _9207_������_��׼ָ��׾� {

	static int testcase;
	static char map[][] = new char[5][9];	//�Է¹��� ��
	static int[] axis_x = {0,0,-1,1};	//�����¿�
	static int[] axis_y = {-1,1,0,0};
	static int remain;	//���� ���� ����
	static int repeat;	//��� �ݺ��ߴ���
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testcase = Integer.parseInt(br.readLine());
		
		while(testcase-->0) {
			remain = Integer.MAX_VALUE;
			for(int i=0; i<5; i++) {
				String tmp = br.readLine();
				for(int j=0; j<9; j++) 
					map[i][j] = tmp.charAt(j);
			}//////////////////////////////////////�Է¹ޱ�
			backtracking(0);	//��Ʈ��ŷ ����, �Ķ���ͷ� depth�ֱ�
			result.append(remain+" "+repeat+"\n");	//��� append
			if(testcase!=0) br.readLine();	//������ �׽�Ʈ���̽��� ��� ���� br.readLine() �� ���� ���ֱ�
		}
		System.out.println(result);
	}
	public static void backtracking(int depth) {	//��Ʈ��ŷ
		int cnt = 0;	//���� �� ���� �ִ� o�� ����
		for (int i=0; i<5; i++) {	//for�� ���� ������
			for(int j=0; j<9; j++) {
				if(map[i][j] == 'o') cnt++;
			}
		}
		if(remain > cnt) {	//���� �ּҰ����� �̹��� �õ��ϴ� �ּҰ��� �� ���� ��
			remain = cnt;
			repeat = depth;
		}
		for(int i=0; i<5; i++) {	//��ü ���� �ѹ��� ���ƺ��� o�� �ִ� �κп� ���� ������ �� �ִ� ��� Ž��
			for(int j=0; j<9; j++) {
				if(map[i][j] == 'o') {
					for(int k=0; k<4; k++) {	//�����¿� Ž��
						int nx = j+axis_x[k];
						int ny = i+axis_y[k];
						int nnx = nx+axis_x[k];
						int nny = ny+axis_y[k];
						if(nnx>=0 && nny>=0 && nnx<9 && nny<5 && map[ny][nx]=='o' && map[nny][nnx]=='.') {	//���� �� �̵� ���� ���� Ȯ��
							map[i][j]='.';
							map[ny][nx]='.';
							map[nny][nnx]='o';
							backtracking(depth+1);	//���� �ܰ� ����
							map[i][j] = 'o';	//map���� ������� ��������
							map[ny][nx] = 'o';
							map[nny][nnx] = '.';
						}
					}
				}
			}
		}
	}
}
