package week14;
import java.io.*;
import java.util.*;
public class _2110_최윤재_공유기설치 {

	static int house_num;
	static int wifi;
	static int[] house;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		house_num = Integer.parseInt(st.nextToken());
		wifi = Integer.parseInt(st.nextToken());
		house = new int[house_num];
		for(int i = 0; i<house_num; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(house);
		
		int left = 1;									//공유기 간 최대 거리가 1일 때
		int right = house[house_num-1] - house[0];		//공유기 2개일 때 (최대 거리)
		int dist = 0 ;
		int result = 0;
		
		while(left <= right) {
			int mid = (left + right) / 2;				//이번에 설정할 간격
			int low = house[0];							//가장 앞 집
			int num = 1;								//공유기 설치 개수
			
			for(int i=1; i<house_num; i++) {			//각 집에 공유기 설치
				dist = house[i] - low;
				if(mid <= dist) {
					low = house[i];
					num++;
				}
			}
			if(num >= wifi) {							//공유기간 간격을 넓혀야 할 때
				result = mid;
				left = mid + 1;
			}
			else {										//공유기간 간격을 줄여야 할 때
				right = mid-1;
			}
		}
		System.out.println(result);
	}

}
