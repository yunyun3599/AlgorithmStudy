package week8;
import java.util.*;
public class _9251_������ {
	
	static int[][] dp;
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input1=sc.nextLine();
		String input2=sc.nextLine();
/////////////////////////////////////////////////////////////////////////�Է�
		
		dp=new int[input1.length()+1][input2.length()+1];			//�� ���ڿ��� ���̺��� 1�� ũ�� dp �迭 ����
		
		
		for(int i=0; i<input1.length(); i++) {						//���� ������ ���Ͽ� �� �� ä��
			for(int j=0; j<input2.length(); j++) {
				if(input1.charAt(i)==input2.charAt(j)) dp[i+1][j+1]=dp[i][j]+1;		//������ ���� ��� �밢�� ��ġ ĭ�� ���� ����ĭ �� +1
				else dp[i+1][j+1]=Math.max(dp[i][j+1], dp[i+1][j]);					//���� �ٸ� ��� �밢�� ��ġ ĭ�� ���� ���� �� �� �� ū �� �״��
			}
		}
		System.out.println(dp[input1.length()][input2.length()]);
	}
}




//LCS