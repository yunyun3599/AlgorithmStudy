import java.io.*;
import java.util.*;
public class _2470_최윤재_두용액 {

	static int N;
	static int[] num;
	static int result = Integer.MAX_VALUE;	//결
	static int ans1 = -1;	//더 작은 값의 용액 
	static int ans2 = -2;	//더 큰 값의 용액 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		num = new int[N];
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);	//정렬 
		
		int low = 0;	//탐색할 인덱스 
		int high = N-1;
		
		while(low<high) {	//low<high일 동안만 탐색 
			int val = num[low] + num[high];	//현재 인덱스 상 두 용액의 합 값 
			if(Math.abs(val) < Math.abs(result)) {	//abs(현재 용액 합)이 abs(현재 최소값)보다 작은 경우 
				result = val;		//관련 값들 업데이트 
				ans1 = num[low];
				ans2 = num[high];
			}
			if(val<0) low++;	//합 결과가 0보다 작으면 더 작은 값을 키우기 
			else high--;	//합 결과가 0보다 크면 더 큰 값을 줄이기 
		}
		System.out.println(ans1+" "+ans2);	//결과 출력 
	}

}
