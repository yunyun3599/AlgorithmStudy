package dynamic;

import java.util.*;

public class 최윤재_2225 {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int K=sc.nextInt();
		long[][] result= new long[K+1][N+1];		//K개의 숫자로 N을 만들 수 있는 경우의 개수
		
		for(int i=0; i<=N;i++) {
			result[1][i]=1;				//1개의 숫자로 0~N까지 만드는 방법은 1개씩
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
