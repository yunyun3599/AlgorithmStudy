package week3;
import java.util.*;

import java.lang.Math;

public class Yoonjae_1339 {
	
	static int[] words = new int[26];
	
	public static void main(String[] args) {
		//A´Â 65
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<num; i++) {
			String word=sc.nextLine();
			int len = word.length();
			for(int j=0; j<len; j++) {
				words[word.charAt(j)-65]+=Math.pow(10, len-j-1);
			}
		}
		
		Arrays.sort(words);
		
		int result=0;
		int mul = 9;
		for(int i=0; i<10; i++) {
			result+=words[25-i]*mul;
			mul--;
		}
		System.out.println(result);
	}

}
