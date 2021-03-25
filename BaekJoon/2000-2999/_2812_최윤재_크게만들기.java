package week16;
import java.util.*;

public class _2812_������_ũ�Ը���� {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int digit = sc.nextInt();				//���ڸ� ������
		int remove = sc.nextInt();				//���� ����
		sc.nextLine();
		String num = sc.nextLine();				//�ԷµǴ� ��
		Deque<Integer> dq = new ArrayDeque<Integer>();	//�� �̿�
		StringBuilder sb = new StringBuilder();			//��� ����
		
		dq.add(num.charAt(0)-'0');				//ù��° �� ����
		int count = 0;							//� �������� ǥ��
		for(int i=1; i<digit; i++) {
			while(!dq.isEmpty() && count<remove && dq.peekLast() < num.charAt(i)-'0') {		//���� ������ ���� �� �۾����� ���� pop
				dq.pollLast();
				count++;
			}
			dq.add(num.charAt(i)-'0');
		}
		
		for(int i=0; i<digit-remove; i++)		//������
			sb.append(dq.poll());
		System.out.println(sb);
		
	}

}
