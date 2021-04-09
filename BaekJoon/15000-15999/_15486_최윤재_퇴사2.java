package tmp;
import java.io.*;
import java.util.*;
public class _15486_������_���2 {
	
	static int day;
	static int[][] table; 
	static int[] dp;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		day = Integer.parseInt(br.readLine());	//��������
		table = new int[day][2];
		dp = new int[day];
		for(int i=0; i<day; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			table[i][0] = Integer.parseInt(st.nextToken())-1;		//������ ���� �� �ֱ� ���� �ɸ��� ��-1�� �־���
			table[i][1] = Integer.parseInt(st.nextToken());			//�� ó���ϸ� ��� ���
		}
		
		for(int i=0; i<day; i++) {
			int complete_day = i+table[i][0];	//i��° ���� ������ ���� ������ ���� complete_day
			if(complete_day < day) dp[complete_day] = Math.max(dp[complete_day], max+table[i][1]);	//��糯�� �Ѿ�� �ʴ� ����� ���� �ڽ��� �ִ밪�� i��° ���� ������ �׳� ������ �� �� �� ū �� ����
			max = Math.max(max, dp[i]);	//i��° ������ ���� ���̹Ƿ� i��° �������� �ִ밪�� max���� �� ū ������ ����
		}
		System.out.println(max);
	}
}
