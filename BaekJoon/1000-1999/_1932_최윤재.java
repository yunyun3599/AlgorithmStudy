package week8;
import java.io.*;
public class _1932_������ {
	
	static int triangle[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int height = Integer.parseInt(bf.readLine());									//�ﰢ�� ����
		triangle=new int[height][height];												//�� ���� �� ����
		
		for(int i=0; i<height; i++) {													//�Է¹ޱ�. �迭�� ���⸦ �������� split�Ͽ� ����
			String[] tmp =bf.readLine().split(" ");
			for(int j=0; j<tmp.length; j++) triangle[i][j]=Integer.parseInt(tmp[j]);
		}
		
		for(int i=height-2; i>=0; i--) {												//�Ʒ����� ���� �ö󰡸� �� ���
			for(int j=0; j<i+1; j++) {													//3�� 3���̸� 4��3���� 4�� 4�� �� �� �� ū ���� �ڽ��� ���� ���� ����� ����
				triangle[i][j]=Math.max(triangle[i+1][j],triangle[i+1][j+1])+triangle[i][j];
			}
		}
		System.out.println(triangle[0][0]);												//(0,0)�� ���� ��� �����Ƿ� ���
	}
}
