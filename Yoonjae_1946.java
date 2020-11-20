package week3;
import java.util.*;
import java.io.*;


public class Yoonjae_1946 {

	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		int result=0;
		
		for(int i=0; i<testcase; i++) {
			result=1;
			int applicant=Integer.parseInt(br.readLine());
			int record[][] = new int[applicant][2];
			for (int j=0; j<applicant; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				record[j][0] = Integer.parseInt(st.nextToken());
				record[j][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(record, new Comparator<int[]>() {
	            public int compare(int[] o1, int[] o2) {
	                return o1[0] - o2[0];
	            }
	        });
			
			int threshold = record[0][1];
			
			for (int j=1; j<applicant; j++) {
				if (record[j][1]<threshold) {
					result++;
					threshold=record[j][1];
				}
			}
			System.out.println(result);
		}
	}

}
