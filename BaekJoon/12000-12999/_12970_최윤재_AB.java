package tmp;
import java.util.*;
public class _12970_������_AB {

	static int N;
	static int K;
	static char[] result;
	static int[] range;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N= sc.nextInt();		//���ڿ� ����
		K=sc.nextInt();			//��ǥ ����
		result = new char[N];	//A�� B���� �迭
		range = new int[N/2+1];	//A�� �ε����� ������ŭ ���� �� ���� �� �ִ� �ִ밪�� ������ �� (N=6�̰� 2�� �ε����� ��� AABBBB�� �ִ��� ���̹Ƿ� 8 ����)
		int A_num = 0;			//�ش� ������ ���� ����� A�� ����
		for(int i=0; i<N/2+1; i++) {	//�� ������ ���ϸ� ��
			range[i] = i*(N-i);	//A�� i�� ����� �� ���� �� �ִ� �ִ밪�� i*(N-i)����. (�տ� A�� i��, �ڿ��� �� B)
			if(range[i]>=K) {	//K���� �������� �Ͽ� A�� ����� �� ���� �� �ִ� �������� Ȯ��
				A_num=i;
				break;
			}
		}
		calc(0, A_num);		//A�� B�� ���� ����� �迭 ����
		System.out.println(-1);	//�ȵǴ� ��� -1 ����
	}
	public static void calc(int idx, int A_num) {
		if(idx == N) {			//N���� A,B�� ���� �������� ��
			if(ispossible()) {	//������ K������ Ȯ��
				System.out.println(result);	//K�� ��� ����
				System.exit(0);
			}
		}
		else {
			if(A_num>0) {		//A�� ���� �� �� �� �ִ� ���
				result[idx] = 'A';	//A�� �ش� �ڸ� �� ����
				calc(idx+1, A_num-1);	//A_num �ϳ� �ٿ��� ���� �ڸ� Ž��
			}
			result[idx] = 'B';	//B�� ����ϴ� ���
			calc(idx+1, A_num);	//A_num ���� �ʿ� ����
		}
	}
	public static boolean ispossible() {	//K���� �������� Ȯ��
		int ACount=0;		//���������� ���� �������� Ȯ���ϹǷ� ���ݱ��� ���� A������ ����
		int tmp_result=0;	//�ӽ������� ��� ������ ����
		for(int i=0; i<N; i++) {
			if(result[i]=='A') ACount++;	//A�� ACount�� �ϳ� �ø�
			else if(result[i]=='B') tmp_result+=ACount; 	//B�� ���� ��� �տ��� ���� A�� ������ŭ ����� ���ϱ�
		}
		if(tmp_result==K) return true;	//���⼭ ���� ����� K���� ������ true retrun
		return false;
	}
}
