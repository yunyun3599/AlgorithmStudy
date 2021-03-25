package dynamic;

import java.util.*;
public class ÃÖÀ±Àç_2565 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int line[][]=new int[num+1][2];
		int[] result = new int[num+1];
		int max = 1;
		
		for(int i=1; i<=num ; i++) {
			line[i][0]=sc.nextInt();
			line[i][1]=sc.nextInt();
		}
		
		Arrays.sort(line, new Comparator<int[]>(){
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		
		for (int i=1; i<=num; i++) {
			result[i]=1;
			for(int j=1; j<i; j++) {
				if(line[j][1]<line[i][1]) {
					result[i]=Math.max(result[i], result[j]+1);
				}
			}
			max=Math.max(result[i], max);
		}
		System.out.println(num-max);
	}

}
