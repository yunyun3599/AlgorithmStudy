package tmp;

import java.io.*;
import java.util.*;

public class _3980_최윤재_선발명단 {
	
	static boolean assigned[];
	static int[][] score;
	static int max;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader  br= new BufferedReader(new InputStreamReader(System.in));
		
		int testcase = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<testcase; i++) {
			assigned = new boolean[11];
			max = 0;
			score = new int[11][11];
			for(int j=0; j<11; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k=0; k<11; k++) {
					score[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			calc(0,0);
			result.append(max+"\n");
		}
		System.out.println(result);
	}
	
	public static void calc(int player, int sum) {
		if(player==11) {
			max = Math.max(sum, max);
			return;
		}
		for(int i=0; i<11; i++) {
			if(score[player][i] == 0 || assigned[i]) continue;
			assigned[i] = true;
			calc(player+1, sum+score[player][i]);
			assigned[i] = false;
		}
	}

}
