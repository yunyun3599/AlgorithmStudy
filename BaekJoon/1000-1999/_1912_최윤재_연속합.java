package week13;
import java.util.*;
public class _1912_������_������ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		int[] dp = new int[num];
		for(int i=0; i<num; i++)
			arr[i] = sc.nextInt();
		////////////////////////////////////////// �Է�
		int max = dp[0] = arr[0];				// max�� ���簡�� �� �ִ밪 ����
		for(int i=1; i<num; i++) {
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);	//���� �Ͱ� ����Ǵ� ���� ������ ���� ��� �� �� ū ���� dp�� ����
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}
