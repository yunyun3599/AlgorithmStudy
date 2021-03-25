package week11;
import java.io.*;
import java.util.*;

public class _5052_최윤재_전화번호목록_2 {

	static String[] num_list;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcase = Integer.parseInt(br.readLine());
		
		Loop:
		for(int i=0; i<testcase; i++) {
			int num = Integer.parseInt(br.readLine());
			num_list = new String[num];
			for(int j=0; j<num; j++) num_list[j] = br.readLine();
			Comparator<String> c = new Comparator<String>() {
				public int compare(String s1, String s2) {
					return Integer.compare(s1.length(), s2.length());
				}
			};
			Arrays.sort(num_list, c);
			for(int j=0; j<num-1; j++) {
				String base = num_list[j];
				for(int k=j+1; k<num; k++) {
					String sub = num_list[k].substring(0, base.length());
					if(sub.equals(base)) {
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

//25%
