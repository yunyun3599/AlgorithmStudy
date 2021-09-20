import java.util.*;
import java.io.*;
public class _20207_최윤재_달력 {

	static int N;
	static int date[] = new int[367];		//해당 날에 스케줄이 몇개인지 저장 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			for(int j=start; j<=end; j++) {
				date[j]++;	//스케쥴이 있는 날들++
			}
		}
		//////////////////////////입력
		int width = 0;	//연속된 날짜 개수
		int height = 0; //스케줄이 가장 많은 날의 스케줄 개수
		int result = 0;
		for(int i=1; i<367; i++) {
			if(date[i]==0) {	//스케줄이 없는 날이 나올 시에 지금까지 쌓아왔던 스케줄 계
				result += width * height;
				width = 0;
				height = 0;
			}
			else {	//스케줄이 있는 날이면 연속된 날 하나 증가, 스케줄 개수는 가장 많은 날의 개수로 업데이
				width++;
				height = Math.max(height, date[i]);
			}
		}
		System.out.println(result);
		
	}

}
