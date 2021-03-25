package week17;
import java.util.*;
public class _1463_������_1�θ���� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N+1];	//�ش� �ε������� ����� ���� �ּ� Ƚ�� ����
		dp[0] = dp[1] = 0;
		for(int i=2; i<=N; i++) {
			if(i%2 == 0 && i%3 == 0)	//6�� ����� ���
				dp[i] = Math.min(dp[i-1], Math.min(dp[i/2], dp[i/3])) + 1;
			else if(i%2 == 0)			//2�� ����̰� 3�� ����� �ƴ� ���
				dp[i] = Math.min(dp[i-1], dp[i/2]) + 1;
			else if(i%3 == 0)			//3�� ����̰� 2�� ����� �ƴ� ���
				dp[i] = Math.min(dp[i-1], dp[i/3]) + 1;
			else dp[i] = dp[i-1] + 1;
		}
		System.out.println(dp[N]);		//��� ���
	}

}
