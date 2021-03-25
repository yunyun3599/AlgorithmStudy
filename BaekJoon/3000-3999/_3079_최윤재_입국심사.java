package week19;
import java.io.*;
import java.util.*;
public class _3079_최윤재_입국심사 {

	static int num;
	static int friends;
	static int[] immigration;		//걸리는 시간 저장
	static long max;			//가장 시간 오래 걸리는 입국심사대 (최댓값 계산 위함)
	static long result = Long.MAX_VALUE;	//결과
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		num = Integer.parseInt(st.nextToken());		//입국심사대 개수
		friends = Integer.parseInt(st.nextToken());	//친구 명수
		immigration = new int[num];
		for(int i=0; i<num; i++) {
			immigration[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, immigration[i]);
		}
		binary_search();		//이분탐색 진행
		System.out.println(result);
	}
	
	public static void binary_search() {
		long low = 0;
		long high = max * friends;	//가장 오래 걸리는 심사대에서 모두가 줄을 선 경우가 최대 걸리는 시간
		
		while(low <= high) {		//시간을 key값으로 해서 이분탐색 진행
			long mid = (low + high)/2;
			long possible = 0;
			
			for(int i=0; i<num; i++) {	//현재 시간내에 몇명까지 심사받을 수 있는지를 possible에 저장
				possible += mid / immigration[i];
			}
			if(possible >= friends) {	//현재 mid값인 시간 내에 모든 친구가 심사 받을 수 있으면 시간 줄여보기
				result = Math.min(result, mid);
				high = mid - 1;
			}
			else low = mid + 1;		//현재 시간 내에 모든 사람이 심사받지 못할 경우 시간 늘리기
		}
	}
}
