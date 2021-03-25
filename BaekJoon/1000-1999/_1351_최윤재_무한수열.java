package week18;
import java.util.*;
public class _1351_������_���Ѽ��� {
	
	static HashMap<Long, Long> map;	//�ؽ��� �̿�
	static int P, Q;	//������ ��
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();	//���� �ε���
		P = sc.nextInt();
		Q = sc.nextInt();
		
		map = new HashMap<>();
		map.put(0L, 1L);	//�ε��� 0�� �� 1 �� ����
		long result = calc(N);	//calc�Լ��� ���� ����� ����
		System.out.println(result);
	}
	
	public static long calc(Long target) {
		if(map.containsKey(target)) return map.get(target);	//���� �ش� �ε��� ���� ������ �� �ε����� �� ��ȯ
		else {	//���� �ش� �ε����� ���� ���� ���
			long tmp = calc(target/P) + calc(target/Q);	//�ش� �ε����� ���� ��������� ����
			map.put(target, tmp);	//�ε��� �� ����
			return tmp;	//��� ���� �� ��ȯ
		}
	}
}
