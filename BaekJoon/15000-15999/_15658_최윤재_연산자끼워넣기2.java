package week15;
import java.util.*;
public class _15658_������_�����ڳ����ֱ�2 {
	
	static int num;
	static int[] num_list;
	static int[] operator = new int[4];			//+ - * /
	static int max = -1000000000;
	static int min = 1000000000;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		num_list = new int[num];
		for(int i=0; i<num; i++) num_list[i] = sc.nextInt();
		for(int i=0; i<4; i++) operator[i] = sc.nextInt();
		///////////////////////////////////////////////////////������� �Է�
		calc(1, num_list[0]);
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void calc(int idx, int result) {			//idx�� �̹��� Ȯ���� ������ �ε��� result�� ���ݱ����� ���
		if(idx == num) {									//������ ���ڱ��� ó������ ��
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		
		int[] tmp = {result + num_list[idx],				//+-*/ ������ ���� ����� �����ص�
				result - num_list[idx],
				result * num_list[idx],
				result / num_list[idx]
		};
		
		for(int i=0; i<4; i++) {							//+-*/ ������ ���� ����
			if(operator[i] > 0) {
				operator[i]--;
				calc(idx+1, tmp[i]);
				operator[i]++;
			}
		}
	}

}
