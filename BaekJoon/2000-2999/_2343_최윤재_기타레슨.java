package tmp;
import java.io.*;
import java.util.*;

public class _2343_������_��Ÿ���� {
	
	static int N;
	static int M;
	static int[] lesson;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());		//���� ����
		M = Integer.parseInt(st.nextToken());		//��緹�� ����
		lesson = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			lesson[i] = Integer.parseInt(st.nextToken());
		}
		int low = 1;		//�̺�Ž��
		int high = 1000000000;
		int mid = 0;
		while(low<high) {	//Ű�� ã��������
			mid = (low+high)/2;	//mid �� ������Ʈ
			if(check(mid)) {	//���� ������ ����� �ð��� �� �ٿ���
				high = mid;
			}
			else {				//�Ұ����� ���� �ð��� �÷���
				low = mid+1;
			}
		}
		System.out.println(low);
	}
	public static boolean check(int size) {	//size�� ��緹���� ũ��
		int idx = 0;	//���° ���Ǳ��� ����ߴ��� Ȯ�ο�
		int num = 0;	//������� ��� ��緹�̰� �ʿ����� Ȯ��
		int tmp = 0;	//�� ��緹�̺� �󸶳� �ð��� ä������ �����
		while(num<M && idx<N) {	//���Ǹ� ������ �� �־��ų� �ִ� ������ �Ѿ ���� �ݺ��� �׸�
			if (tmp+lesson[idx] <= size) {	//������ ũ�� ���� �̹� ������ �� �� �ִ� ���
				tmp += lesson[idx];	//���� ����
				idx++;	//�ε��� ����
			}
			else {	//���� ������� ��緹�̿� ������ ���
				num++;	//��緹�� ���� ����
				tmp = 0;	//��緹�� ������ ���ݱ��� �� �� 0���� �ʱ�ȭ
			}
		}
		
		if(idx==N) return true;	//���� ��� ������ �� ��� true ��ȯ
		return false;	//��� ������ ���� ��������  false ��ȯ
	}
}
