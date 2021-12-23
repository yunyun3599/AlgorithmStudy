package tmp;
import java.util.*;
import java.io.*;

public class _16916_최윤재_부분문자열 {

	static String input;
	static String pattern;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine();
		pattern = sc.nextLine();
		kmp();
		System.out.println(0);
	}
	
	static void kmp() {
		int p[] = makep();
		int j=0;
		for(int i=0; i<input.length(); i++) {
			while(j>0 && input.charAt(i) != pattern.charAt(j)) j = p[j-1];
			if(input.charAt(i) == pattern.charAt(j)) {
				if(j == pattern.length() - 1) {
					System.out.println(1);
					System.exit(0);
				}
				j++;
			}
		}
	}
	static int[] makep() {
		int[] p = new int[pattern.length()];
		int j=0;
		for(int i=1; i<pattern.length(); i++) {
			while(j>0 && pattern.charAt(i) != pattern.charAt(j)) j = p[j-1];
			if(pattern.charAt(i)==pattern.charAt(j)) p[i] = ++j;
		}
		return p;
	}

}
