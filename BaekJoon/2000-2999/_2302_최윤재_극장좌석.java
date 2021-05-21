package tmp;
import java.util.Scanner;
public class _2302_������_�����¼� {

	static int N;
	static int M;
	static int[] seat;
	static int[] piv;
	static int result=1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		seat = new int[N+1];
		piv = new int[N+1];
		for(int i=0; i<M; i++) {
			int fixed = sc.nextInt();
			seat[fixed] = -1;			//�������� -1�� ǥ���س���
		}
		piv[0]=1;
		piv[1]=1;
		piv[2]=2;
		for(int i=3; i<N+1; i++) {
			piv[i] = piv[i-1]+piv[i-2];		//�ٲ� �� �ִ� �ڸ� ������ ���� �Ǻ���ġ ������ ���� ������ �� 
		}
		int count = 0;
		for(int i=1; i<N+1; i++) {
			if(seat[i]!=-1) count++;		//������ �ƴϸ� �ڸ� ���� ����
			else {						//������ ������ ���ݱ��� ������ �ڸ� ������ �Ǻ���ġ ���� ���� ���� ����� ���ϱ�
				result *= piv[count];
				count=0;			//�ڸ� ���� �ʱ�ȭ
			}
		}
		result *= piv[count];		//������ ������ �ڿ� �ִ� �ڸ���
		System.out.println(result);
	}

}
