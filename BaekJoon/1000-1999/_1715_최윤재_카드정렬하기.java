package week14;
import java.util.*;
import java.io.*;
public class _1715_������_ī�������ϱ� {

	static int num;										//ī�� ���� ����
	static Queue<Integer> card = new PriorityQueue<>();	//�켱����ť �̿�
	static int result = 0;								//�������
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		
		for(int i=0; i<num; i++) {
			card.add(Integer.parseInt(br.readLine()));
		}
		//////////////////////////////////////////////////�Է�
		while(card.size() != 1) {						//��� ī�带 ���� �� ��ġ
			int num1 = card.poll();						//���� ������ ���� ī�� ����
			int num2 = card.poll();						//�ι�°�� ������ ���� ī�� ����
			result += num1 + num2;						//�� ī�� ������ ���� ���ο� ī�� ������ queue�� ����
			card.add(num1+num2);
		}
		System.out.println(result);						//������
		
	}

}
