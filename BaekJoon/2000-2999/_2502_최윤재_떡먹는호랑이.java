package tmp;
import java.util.*;
public class _2502_������_���Դ�ȣ���� {

	static int day;			//�־��� ��
	static int num;			//�־��� �� ���� ����
	static int[] dp;		//dp�迭
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		day = sc.nextInt();
		num = sc.nextInt();
		
		dp = new int[day];
		int start1 = 1;		//ù���� �� ���� ����
		int start2 = 1;		//��°���� �� ���� ����
		
		while(dp[day-1]!=num) {		//�־��� ���� ���� ������ num�� �ƴϸ� �ٽ� �õ�
			start2 = 1;				//��°�� ���� ���� 1���� �ʱ�ȭ
			dp[0] = start1++;		//ù°�� ���� ���� �ϳ��� �ø���
			while (start2<num) {	//��°�� �� ���� ���� �ϳ��� �÷����鼭 �õ�
				dp[1]= start2++;
				for(int i=2; i<day; i++) {
					dp[i] = dp[i-1]+dp[i-2];	//dp�迭�� ���� �� ���� �� ���� ���� �� �ֱ�
				}
				if(dp[day-1]==num) break;	//�� ���� ���߸� break
			}
		}
		System.out.println(dp[0]);
		System.out.println(dp[1]);
	}

}
