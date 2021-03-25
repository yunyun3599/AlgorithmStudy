package week14;
import java.util.*;
import java.io.*;
public class _1915_������_����ū���簢�� {
	
	static int height;			//����
	static int width;			//�ʺ�
	static int [][] map;		//�Է°�
	static int [][] dp;			//dp�迭
	static int result = 0;		//�����
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		map = new int[height+1][width+1];					//���� ����� ���� �� �� 0���� ä���� map ����
		dp = new int[height+1][width+1];					//�ε��� ���� üũ�ϱ� �������ϱ�
		
		for(int i=1; i<height+1; i++) {	
			String tmp = br.readLine();
			for(int j=1; j<width+1; j++) {
				map[i][j] = tmp.charAt(j-1)-'0';
			}
		}
///////////////////////////////////////////////////////////////�Է�			
		for(int i=1; i<height+1; i++) {						//dp�� �� ���簢�� �� ���� ���̸� ����
			for(int j=1; j<width+1; j++) {
				if (map[i][j] == 0) dp[i][j] = 0;			//�ش� ĭ�� ���� 0�̸� dp���� �׳� 0 ����
				else {										//�ش� ĭ�� ���� 1�� ���
					int min = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));	//�ڱ� ��ĭ, ����ĭ, ���� �밢�� ���� �� ���� ���� �� +1�� �ڽ��� ��
					dp[i][j] = min+1;
					result = Math.max(result, dp[i][j]);	//result������ ���� ���� �� ũ�� result�� ������Ʈ
				}
			}
		}
		System.out.println(result*result);					//���̴� result*result
	}

}
