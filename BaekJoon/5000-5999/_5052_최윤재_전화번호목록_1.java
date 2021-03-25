package week11;
import java.io.*;
import java.util.*;

public class _5052_최윤재_전화번호목록_1 {

	static long[] num_list;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcase = Integer.parseInt(br.readLine());
		
		Loop:
		for(int i=0; i<testcase; i++) {
			int num = Integer.parseInt(br.readLine());
			num_list = new long[num];
			for(int j=0; j<num; j++) num_list[j] = Long.parseLong(br.readLine());
			Arrays.sort(num_list);
			for(int j=0; j<num-1; j++) {
				long base = num_list[j];
				int base_digit = (int)Math.log10(num_list[j]+1);
				for(int k=j+1; k<num; k++) {
					int digit = (int)Math.log10(num_list[k]+1);
					long check1 = Math.abs(num_list[k] - base*(long)Math.pow(10,digit-base_digit));
					long check2 = num_list[k] % (long)Math.pow(10, digit-base_digit);
					if(check1 == check2) {
						result.append("NO\n");
						continue Loop;
					}
				}
			}
			result.append("YES\n");			
		}
		System.out.println(result);
	}

}

//12%
