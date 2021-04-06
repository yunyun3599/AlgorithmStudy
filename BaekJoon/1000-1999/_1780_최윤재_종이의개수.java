package tmp;
import java.io.*;
import java.util.*;
public class _1780_������_�����ǰ��� {

	static int width;	//�� ����
	static int[][] map;	
	static int one;		//1�� ����
	static int zero;	//0�� ����
	static int minus;	//-1�� ����
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		width = Integer.parseInt(br.readLine());
		map = new int[width][width];
		
		for(int i=0; i<width; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<width; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}	
		///////////////////////////////////////////////////////////////�Է�
		check(0, 0, width);			//��ü �ʿ� ���ؼ� �켱 Ȯ��
		System.out.println(minus);	//��� ���
		System.out.println(zero);
		System.out.println(one);
	}
	public static void check(int y, int x, int num) {	//�����ϴ� y,x��ǥ�� �ʺ� ����
		int val = map[y][x];	//��� ���ϵǾ�� �ϴ� ���� ��
		for(int i=y; i<y+num; i++) {
			for(int j=x; j<x+num; j++) {
				if (map[i][j] != val) {	//���� ĭ ���� ���� ���� ���� �ִ� ���
					for(int k=y; k<y+num; k+=num/3) {
						for(int l=x; l<x+num; l+=num/3) {
							check(k, l, num/3);	//1/3 �ʺ��� �簢���� 9�� ����� ��������� check�Լ� �̿�
						}
					}
					return;
				}
			}
		}
		if(val == -1) minus += 1;	//�ش� ĭ�� ���� ��� �����ϴٰ� ������ ��� �ش� ���� �°� ���� �� �ϳ��� �ø�
		else if(val==0) zero += 1;
		else one += 1;
	}
}
