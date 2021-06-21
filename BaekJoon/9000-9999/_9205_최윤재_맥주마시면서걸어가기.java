package tmp;
import java.util.*;
import java.io.*;

public class _9205_������_���ָ��ø鼭�ɾ�� {

	static int testcase;	//�׽�Ʈ���̽� ����
	static StringBuilder sb = new StringBuilder();	//happy, sad ����
	static int num;	//������ ����
	static int[][] map;	//��ü ������ ������ weight ����
	static int[][] store;	//���������� ��ǥ ����
	static int[] start = new int[2];	//����� ��ǥ ����
	static int[] end = new int[2];	//������ ��ǥ ����
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testcase = Integer.parseInt(br.readLine());
		
		while(testcase-- > 0) {	//�׽�Ʈ���̽���ŭ �ݺ�
			num = Integer.parseInt(br.readLine());	//������ ����
			map = new int[num+2][num+2];	//�� ��ġ���� �� �� �ִ��� weight �迭
			store = new int [num][2];	//���������� ��ǥ ����
			StringTokenizer st = new StringTokenizer(br.readLine());
			start[0] = Integer.parseInt(st.nextToken());	//���� ���� ��ǥ ����
			start[1] = Integer.parseInt(st.nextToken());
			for(int i=0; i<num; i++) {	//�������� ��ǥ ����
				st = new StringTokenizer(br.readLine());
				store[i][0] = Integer.parseInt(st.nextToken());
				store[i][1] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			end[0] = Integer.parseInt(st.nextToken());	//�������� ��ǥ ����
			end[1] = Integer.parseInt(st.nextToken());
			
			if(Math.abs(start[0]-end[0])+Math.abs(start[1]-end[1]) <=1000) {	//������� �������� 1000 ������ �Ÿ��̸� �ٷ� happy
				sb.append("happy\n");
				continue;
			}
			else {	//�ƴϸ� ������� ���������� �Ÿ��� ũ�� ��Ƶ�
				map[0][num+1] = Integer.MAX_VALUE;
				map[num+1][0] = Integer.MAX_VALUE;
			}
			
			makemap();	//�����, ������, �� ������ ������ �Ÿ��� map�� ����
			for(int k=1; k<num+1; k++) {	//k�� �������� �����ϴ� ���
				for(int i=0; i<num+2; i++) {	//�� �����鿡 ���� k�� �������� ����� �� �ٸ� �������� ���� weight ������Ʈ
					for(int j=i+1; j<num+2; j++) {
						if(map[i][k]==Integer.MAX_VALUE || map[k][j]==Integer.MAX_VALUE)	//������ ���� continue
							continue;
						map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);	//���� ���� k�� �����ϴ� �� �� �� ���� �� ����
						map[j][i] = map[i][j];
					}
				}
			}
			if(map[0][num+1] == Integer.MAX_VALUE) sb.append("sad\n");	//������ ���� sad
			else sb.append("happy\n");	//�� �� �ִ� ���� happy
		}
		System.out.println(sb);
	}
	public static void makemap() {
		for(int i=0; i<num; i++) {	//�����-������ ���� �Ÿ��� ������ - ������ ���� �Ÿ��� ����
			int weight = Math.abs(start[0]-store[i][0]) + Math.abs(start[1]-store[i][1]);
			weight = weight>1000? Integer.MAX_VALUE : weight;
			map[0][i+1] = weight;
			map[i+1][0] = weight;
			weight = Math.abs(end[0]-store[i][0]) + Math.abs(end[1]-store[i][1]);
			weight = weight>1000? Integer.MAX_VALUE : weight;
			map[num+1][i+1] = weight;
			map[i+1][num+1] = weight;
		}
		for(int i=0; i<num; i++) {	//�������鳢���� �Ÿ� ����
			for(int j=i+1; j<num; j++) {
				int weight = Math.abs(store[i][0]-store[j][0]) + Math.abs(store[i][1]-store[j][1]);
				weight = weight>1000? Integer.MAX_VALUE : weight;
				map[i+1][j+1] = weight;
				map[j+1][i+1] = weight;
			}
		}
	}
}