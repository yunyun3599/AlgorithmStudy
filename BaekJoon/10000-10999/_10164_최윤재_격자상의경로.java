package tmp;
import java.util.*;

public class _10164_������_���ڻ��ǰ�� {
	
	static int row;		//��,��
	static int column;
	static int circled_num; //���׶�� ����
	static int circled_row;	//���׶�� ������ ��, ��
	static int circled_column;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		row = sc.nextInt();
		column = sc.nextInt();
		circled_num = sc.nextInt();
		circled_row = (circled_num-1) / column;
		circled_column = (circled_num-1) % column;
		
		int result = 0;	//���� ���
		if(circled_num ==0) {	//���׶�� ���ڰ� ���� ��
			result = getResult(row, column);	//�׳� �״�� dp
		}
		else {	//���׶�� ���ڰ� ���� ��
			int before_circle = getResult(circled_row+1, circled_column+1);	//���������� ���׶�̱���
			int after_circle = getResult(row-circled_row, column-circled_column);	//���׶�̺��� ����������
			result = before_circle * after_circle;
		}
		
		System.out.println(result);
	}
	
	public static int getResult(int height, int width) {	//dp ���� �Լ�
		int[][] dp = new int[height][width];
		for(int i=0; i<height; i++) dp[i][0] = 1;	//1��� 1���� ���� �� 1�� ä���
		for(int j=0; j<width; j++) dp[0][j] = 1;
		for(int i=1; i<height; i++) {	//2��� 2������ ����
			for(int j=1; j<width; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];	//���ʰ� + ���ʰ�
			}
		}
		return dp[height-1][width-1];	//��� ����
	}
}
