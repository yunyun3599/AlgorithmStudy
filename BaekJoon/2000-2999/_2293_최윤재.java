package week10;
import java.io.*;
import java.util.*;
public class _2293_������ {

	static int[] value;
	static int[] dp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		value = new int[num];										//������ �׼� ����
		dp = new int[target+1];										//�� �ݾ׺� ������ ��� �� ���� (dp[1000]�̸� 1000���� ���� �� �ִ� ����� ��)
		for(int i=0; i<num; i++) {
			value[i] = Integer.parseInt(br.readLine());
		}
		///////////////////////////////////////////////////////////�Է�

		
		for(int i=0; i<num; i++) {									//�� �������� ����
			if (value[i] <= target) dp[value[i]] += 1;				//�� ���� �ϳ��� �ش� �ݾ��� ����� ��� 1������ �켱 ����. (�Ѿ׺��� ���� �ݾ��� ū ��찡 �ֱ� ������ ���ǹ� �Ⱦ��� ��Ÿ�� ������)
			for(int j = value[i]+1; j<=target; j++) {				//�ش� ���� �׼���ŭ ���� ���� ���ϸ� �� ������ �������� �� ���� ���� �� ����
				dp[j] += dp[j - value[i]];
			}
		}
		System.out.println(dp[target]);
	}

}
