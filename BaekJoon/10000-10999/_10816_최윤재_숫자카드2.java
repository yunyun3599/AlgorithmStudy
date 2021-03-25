package week13;
import java.io.*;
import java.util.*;
public class _10816_최윤재_숫자카드2 {

	static int[] Sanggeun = new int[20000001];			// 0 인덱스에 -10000000, 10000000인덱스에 0, 20000000인덱스에 10000000
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		for(int i=0; i<num; i++) {
			Sanggeun[10000000 - sc.nextInt()]++;		//해당 인덱스 값++
		}
		
		num = sc.nextInt();
		for(int i=0; i<num; i++) 
			result.append(Sanggeun[10000000 - sc.nextInt()]+" ");	//해당 카드 값의 개수 출력
		System.out.println(result);
	}

}
