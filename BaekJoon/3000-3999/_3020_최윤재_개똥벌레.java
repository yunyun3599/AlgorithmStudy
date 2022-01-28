import java.io.*;
import java.util.*;
public class _3020_최윤재_개똥벌레 {

	static int N;
	static int H;
	static int ceiling[];	//인덱스 값이 장애물 높이, 저장되는 값이 해당 높이인 장애물 개수 
	static int floor[];
	static int min = Integer.MAX_VALUE;
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		ceiling = new int[H+1];
		floor = new int[H+1];
		
		for(int i=0; i<N/2; i++) {	//N은 항상 짝수이므로 종유석으로 끝남 
			ceiling[Integer.parseInt(br.readLine())]++;
			floor[Integer.parseInt(br.readLine())]++;
		}
		
		int acc_ceiling[] = new int[H+1];
		int acc_floor[] = new int[H+1];
		for(int i=H-1; i>0; i--) {		//해당 길이 구간으로 갔을 때 지나쳐야하는 장애물 개
			acc_ceiling[i] += acc_ceiling[i+1] + ceiling[i];
			acc_floor[i] += acc_floor[i+1] + floor[i];
		}
		
		for(int i=1; i<H+1; i++) {	//구간 위치 하나하나에 대해 확인
			int sum = acc_floor[i] + acc_ceiling[H-i+1];
			if(sum==min) {
				count++;
			}
			if(sum < min) {
				min = sum;
				count = 1;			
			}
		}
		System.out.println(min+" "+count);
	}

}
