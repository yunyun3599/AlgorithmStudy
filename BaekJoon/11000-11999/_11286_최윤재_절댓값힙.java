package week14;
import java.util.*;
import java.io.*;
public class _11286_������_������ {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());							//�� ����
		Queue<Number> heap = new PriorityQueue<>();							//�켱���� ť �̿�
		
		for(int i=0; i<num; i++) {											//�Է�
			int tmp = Integer.parseInt(br.readLine());
			if(tmp == 0) {
				if (heap.isEmpty()) bw.write("0\n");						//���� ����� ��
				else {
					Number number = heap.poll();							//���� ������ ���� �� poll
					int value = 0;
					if (number.isPositive == 1) value = number.value;		//isPositive�� 1�� ���, �� ����� ���� �׳� �� ��
					else value = -number.value;								//������ ���� -�� ���� ��
					bw.write(value+"\n");									//��� ���
				}
			}
			else {
				int isPositive = 0;											//���ο� ���ڸ� heap�� �ִ� ���
				if (tmp > 0) isPositive = 1;								//���� ���� ���ڰ� ����� ��� isPositive�� 1�� ����
				else isPositive = -1;										//������ ��� isPositive�� -1�� ����
				heap.add(new Number(Math.abs(tmp), isPositive));			//��� heap�� ����
			}
		}
		bw.flush();
		bw.close();
	}

}

class Number implements Comparable<Number>{				//heap�� ���� ��ü. ������ ���밪�� ����/����� ǥ���ϴ� ���� ������ ����
	int value;
	int isPositive;
	Number(int value, int isPositive){
		this.value = value;
		this.isPositive = isPositive;
	}
	public int compareTo(Number another) {				//heap������ ������ value�� ����������. value�� ������ is Positive�� �̿��� ��������
		if (this.value == another.value) {
			return this.isPositive - another.isPositive;
		}
		return this.value - another.value;
	}
}
