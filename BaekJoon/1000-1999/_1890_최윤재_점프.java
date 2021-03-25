package week12;
import java.io.*;
import java.util.*;
public class _1890_������_���� {

	static int[][] map;
	static long[][] dp;							//int�� �ϸ� Ʋ��
	static int width;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		width = Integer.parseInt(br.readLine());
		map = new int[width][width];
		dp = new long[width][width];
		
		for(int i=0; i<width; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<width; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//////////////////////////////////////////////////////////////// �Է�
		dp[0][0]=1;
		for(int i=0; i<width; i++) {									//���� map�� ����� ����ŭ �̵����� �� map�� ����� �ʴ� ��쿡 ���Ͽ� ����
			for(int j=0; j<width; j++) {
				if((i == width-1) && (j == width-1)) break;
				int jump = map[i][j];
				if (i+jump < width) dp[i+jump][j] += dp[i][j];
				if (j+jump < width) dp[i][j+jump] += dp[i][j];
				
			}
		}
		System.out.println(dp[width-1][width-1]);
		
	}

}
