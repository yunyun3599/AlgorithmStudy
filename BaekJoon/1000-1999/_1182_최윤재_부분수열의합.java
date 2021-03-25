package week11;
import java.util.*;
public class _1182_������_�κм������� {
	
	static int num;								//���� ����
	static int target;							//��ǥ��
	static int[] num_arr;						//���� ���� �迭
	static int result;							//���� �� �ִ� ��� ����
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		target = sc.nextInt();
		num_arr = new int[num];
		
		for(int i=0; i<num; i++) 
			num_arr[i] = sc.nextInt();			//������� �Է�
		
		check(0, 0, false);						//0���ε����� ������ ����
		System.out.println(result);				//��� ���
	}
	
	public static void check(int idx, int sum, boolean flag) {	//idx�� �̹��� ó���� index, sum�� �ش� ����� ���ݱ����� ���� ��, flag�� ������� ���Ե� ���Ұ� 0���� false, ����� true
		if (idx < num) {						//���� ���Ұ� �ִ� ���
			check(idx+1, sum, flag);			//�̹� ���� ���� ����
			check(idx+1, sum + num_arr[idx], true);	//�̹� ���� ������
		}
		else {									//���� ���. target���� �´��� Ȯ��
			if (sum == target && flag) result++;
		}
	}
	
}
