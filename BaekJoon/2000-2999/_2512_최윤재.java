package week9;
import java.util.*;
public class _2512_������ {
	
	static int num;
	static int[] budget;
	static int total;
	static int average;
	static int sum=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num=sc.nextInt();
		budget=new int[num];
		for(int i=0; i<num ; i++) {
			budget[i]=sc.nextInt();
			sum+=budget[i];
		}
		total=sc.nextInt();
		//////////////////////////////////////////�Է�
		
		Arrays.sort(budget);					//�������� ����
		
		average = total/num;
		
		if(sum<=total) {						//��ü���� ���� ���� ������ ���
			System.out.println(budget[num-1]);
			System.exit(0);
		}
		for(int i=0; i<num; i++) {
			if(budget[i]<=average) {
				total-=budget[i];					//��� �Ʒ��� ������� �Ѿ׿��� ��
				continue;
			}
			average=total/(num-i);					//���� ���鿡 ���� average	
			if(budget[i]>average) break;			//���� ���� average�� ���� ��ü�� �� �� �ִ� ������ �ִ��� Ȯ��
			i--;									//�� �ε����� �پ�Ѱ� �ǹ����Ƿ� �ϳ� ������ (���ϸ� Ʋ�Ƚ��ϴ�.)
		}
		System.out.println(average);
	}
}

//����