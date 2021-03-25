package week11;
import java.util.*;
public class _11051_������_���װ��2 {

	static int N;								//NCK
	static int K;
	static int[][] dp;							//���װ�� ���� ����
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		dp = new int[N+1][N+1];
		
		for(int i=0; i<=N; i++) {
			dp[i][0] = 1;						//�ش� �࿡�� 0��°�ڸ��� ������ �ڸ� ���� �׻� 1
			dp[i][i] = 1;
			for(int j=1; j<i; j++)
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007;	//�ڽ��� ���� �� �� + ������ �� �� �� �ڽ��� ��
		}

		System.out.println(dp[N][K]);
	}

}

//���װ��2