package week11;
import java.io.*;
public class _2156_������_�����ֽý� {

	static int num;			//�� ����
	static int[] wine;		//������ �� ����
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		wine = new int[num+1];
		dp = new int[num+1];
		for(int i=1; i<=num; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		/////////////////////////////////////////////////////////////////�Է�
		dp[1] = wine[1];
		if (num == 1) {						//���� �ϳ��� ���
			System.out.println(dp[1]);
		}
		else if (num == 2) {				//���� �ΰ��� ���
			System.out.println(wine[1] + wine[2]);
		}
		else {								//���� 2�� �̻��Τ� �Ť���
			dp[2] = wine[1] + wine[2];
			for(int i=3; i<=num; i++) {
				dp[i] = Math.max(dp[i-3]+wine[i-1], dp[i-2]) + wine[i];	//�ٷ� ���� ���� �Դ� ��� or �վ����� �Դ� ���
				dp[i] = Math.max(dp[i], dp[i-1]);						//�������� 2���� ���� �ʴ� ���
			}	
			System.out.println(dp[num]);
		}
	}
}
