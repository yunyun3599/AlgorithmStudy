package week10;
import java.util.*;
public class _2631_������ {

	static int num;
	static int[] children;			//�л� �� ����
	static int[] dp;				//dp �迭
	static int max;					//���������κм��� ��
	
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		
		children = new int[num];
		dp = new int[num];
		for(int i=0; i<num; i++) {
			children[i] = sc.nextInt();
			dp[i] = 1;
		}
		//////////////////////////////////////////////�Է�
		
		dynamic(1);									//���̳��� ���α׷���
		System.out.println(num-max);				//�� �л��� - ���������κм����� �� ����
	}
	
	static void dynamic(int idx) {
		for(int i=0; i<idx; i++) {
			if((children[i] < children[idx]) && (dp[idx] < dp[i] + 1)) {	//�ش� �л��� ���ڰ� ���� �л��� ���ں��� ū ��� ���� ����� �� �ִ� �� ����
				dp[idx] = dp[i] + 1;
			}
		}
		if (dp[idx] > max) max=dp[idx]; 			//���� �� �κ��������� �� ������Ʈ
		if(idx < num-1) dynamic(idx+1);				//���� �л��� ���� ����
	}
}






//�ټ����
