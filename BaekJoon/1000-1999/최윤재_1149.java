package dynamic;

import java.util.*;

public class 최윤재_1149 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N= sc.nextInt();
		int[][] val= new int[N][3];				//RGB 값 저장
		int[][] result=new int[N][3];			//동적프로그래밍 값 저장
		
		for(int i=0; i<N;i++) {
			val[i][0]=sc.nextInt();
			val[i][1]=sc.nextInt();
			val[i][2]=sc.nextInt();
		}
		
		result[0][0]=val[0][0];					//첫 집 기준으로 수행, 첫 집의 RGB 갑 저장
		result[0][1]=val[0][1];
		result[0][2]=val[0][2];
		
		for(int i=1; i<N; i++) {
			result[i][0]=Math.min(result[i-1][1], result[i-1][2])+val[i][0];		//R일 때
			result[i][1]=Math.min(result[i-1][0], result[i-1][2])+val[i][1];		//G일때
			result[i][2]=Math.min(result[i-1][0], result[i-1][1])+val[i][2];		//B일 때
		}
		int min=Math.min(result[N-1][0], Math.min(result[N-1][1], result[N-1][2]));
		System.out.println(min);
	}

}
