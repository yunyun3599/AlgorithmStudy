package dynamic;

import java.util.*;

public class ������_2225 {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int K=sc.nextInt();
		long[][] result= new long[K+1][N+1];		//K���� ���ڷ� N�� ���� �� �ִ� ����� ����
		
		for(int i=0; i<=N;i++) {
			result[1][i]=1;				//1���� ���ڷ� 0~N���� ����� ����� 1����
		}
		
		for(int i=2; i<=K; i++) {
			for(int j=0; j<=N;j++) {
				for(int a=0; a<=j; a++) {
					result[i][j]+=result[i-1][a]%1000000000;
				}
			}
		}
		
		System.out.println(result[K][N]%1000000000);
	}

}
