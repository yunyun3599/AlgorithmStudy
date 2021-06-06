package tmp;
import java.util.*;
import java.io.*;

public class _17609_√÷¿±¿Á_»∏πÆ {
	
	static int num;
	static String[] input;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		input = new String[num];
		for(int i=0; i<num; i++) input[i] = br.readLine();
		
		for(int i=0; i<num; i++) {
			if(check(i)) {
				sb.append("0\n");
				continue;
			}
			if(pseudocheck(i)) {
				sb.append("1\n");
				continue;
			}
			else sb.append("2\n");
		}
		System.out.println(sb);
	}
	
	public static boolean check(int idx) {
		String str = input[idx];
		int idx1 = 0;
		int idx2 = str.length()-1;
		while(idx1<=idx2) {
			if(str.charAt(idx1) == str.charAt(idx2)) {
				idx1++; idx2--;
			}
			else return false;
		}
		return true;
	}
	
	public static boolean pseudocheck(int idx) {
		String str = input[idx];
		int idx1 = 0;
		int idx2 = str.length()-1;
		int chance = 0;
		boolean flag1 = true, flag2=true;
		while(idx1<=idx2) {
			if(str.charAt(idx1) == str.charAt(idx2)) {
				idx1++; idx2--;
				continue;
			}
			int left = idx1+1;
			int right = idx2;
			while (left<=right) {
				if(str.charAt(left)==str.charAt(right)) {
					left++;
					right--;
				}
				else {
					flag1 = false;
					break;
				}
			}
			left = idx1;
			right = idx2-1;
			while(left<=right) {
				if(str.charAt(left)==str.charAt(right)) {
					left++;
					right--;
				}
				else {
					flag2 = false;
					break;
				}
			}
			return flag1|flag2;
		}
		return true;
	}
}
