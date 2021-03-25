package week14;
import java.util.*;
public class _11656_������_���̻�迭 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();						//String�Է¹ޱ�
		Queue<String> pqueue = new PriorityQueue<>();		//���̻� �迭�� ������ �켱���� ť
		StringBuilder sb = new StringBuilder();				//�����
		
		for(int i=0; i<line.length(); i++) {				//���� String�� ���� �տ������� char �ϳ��� �������鼭 �켱���� ť�� ����
			String tmp = line.substring(i);					//�켱���� ť���� �˾Ƽ� ���������� ����
			pqueue.add(tmp);
		}
		
		while(!pqueue.isEmpty()) {							//�켱���� ť���� ������� �� ����
			sb.append(pqueue.poll()+"\n");
		}
		
		System.out.println(sb);

	}

}
