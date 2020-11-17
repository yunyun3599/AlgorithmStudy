package week2;

import java.util.*;

public class YJ_2447 {
	
	public static StringBuilder result=new StringBuilder();	//매번 System.out.print()하니까 시간 초과가 떠서 Stringbuilder에 문자열 저장
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();					//n은 패턴의 가로,세로 길이
		
		for (int i =0; i<n ; i++) {
			for(int j=0; j<n; j++) {
				pattern(i,j,n);
			}
			result.append("\n");
		}
		System.out.println(result);
	}
	
	public static void pattern(int i, int j, int n) {
		if((i/n)%3==1 && (j/n)%3==1) {			// 정 가운데 부분은 *이 찍히지 않기 때문에 i행 j열의 경우 i와 j를 n으로 나눈 경우 몫이 1이 되면 별을 찍지 말아야 함.
			result.append(" ");
		}
		else {
			if (n/3==0) {
				result.append("*");
			}
			else {
				pattern(i,j,n/3);
			}
		}
	}
}