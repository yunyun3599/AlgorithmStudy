import java.io.*;
import java.util.*;
public class _1027_최윤재_고층건물 {

	static int N;	//빌딩 개수 
	static long building[];	//빌딩 높이 배열 
	static int max;	//최대값 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		building = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			building[i] = Long.parseLong(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			int count = 0;
			int left = i-1;
			int right = i+1;
			long diff = Long.MIN_VALUE;
			
			long distToStandard = 1;
			for(long dist = 1; left>=0; left--, dist++) {
				if(dist == 1) {	//바로 왼쪽 옆건물인 경우 
					count++;
					diff = building[left] - building[i];
					continue;
				}
				long newdiff = building[left] - building[i];
				if(newdiff > (diff*dist)/(double)distToStandard) {
					count++;
					diff = newdiff;
					distToStandard = dist;
				}
			}
			
			distToStandard = 1;
			for(long dist=1; right<N; right++, dist++) {
				if(dist == 1) {	//바로 오른쪽 옆건물인 경우 
					count++;
					diff = building[right] - building[i];
					continue;
				}
				long newdiff = building[right] - building[i];
				if(newdiff > (diff*dist)/(double)distToStandard) {
					count++;
					diff = newdiff;
					distToStandard = dist;
				}
			}
			max = Math.max(max, count);
		}
		System.out.println(max);
	}

}
