package tmp;
import java.util.*;
public class _1562_������_��ܼ� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long dp[][][] = new long[N+1][10][1024];	//dp[i][j][k]�̸� i��° �ڸ��� j�� �� �� ����� 0~9 ���ڿ� ���� ��Ʈ����ŷ�� k
		for(int i=1; i<=9; i++) {
			dp[1][i][1<<i] = 1;	//���ڸ� ���� ���� ���� 1~9�� ���� ��� 1����
		}
		
		for(int i=2; i<=N; i++) {	//dp
			for(int j=0; j<=9; j++) {
				for(int visit = 0; visit < 1024; visit++) {	//i�ڸ��� �� j�� ���������� �� ��� 
					int newVisit = visit | (1<<j);	//���� j�� ���Ƿ� j�� �� ���� ������ ���� visit�� ��Ʈ����ŷ
					if(j==0) dp[i][j][newVisit] += dp[i-1][j+1][visit];	//j�� 0�� ��
					else if(j==9) dp[i][j][newVisit] += dp[i-1][j-1][visit];	//j�� 9�� ��
					else dp[i][j][newVisit] += dp[i-1][j-1][visit] + dp[i-1][j+1][visit];
					dp[i][j][newVisit] %= 1000000000;	//10������ ���� �������� ���ؾ���
				}
			}
		}
		long result = 0;
		for(int i=0; i<=9; i++) {	//������ ���� 0~9�϶����� ��� ������ ����� �� ���ϱ�
			result += dp[N][i][1023];
		}
		System.out.println(result % 1000000000);
	}

}
