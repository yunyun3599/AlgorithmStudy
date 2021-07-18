package tmp;
import java.util.*;
import java.io.*;

public class _11054_최윤재_가장긴바이토닉수열 {
	
	static int N;
	static int[] input;
	static int asc_dp_val[];	//각 인덱스의 값까지 최장 부분 증가 수열 저장 {1,2,3,2,1}이면 {1,2,3,3,3}저장될 것
	static int desc_dp_val[];	//각 인덱스의 값부터 최장 부분 감소 수열 저장 {1,2,3,2,1,}이면 {3,3,3,2,1}저장될 것
	static ArrayList<Integer> asc_dp = new ArrayList<>();	//ascending 처리를 위한 값 저장
	static ArrayList<Integer> desc_dp = new ArrayList<>();	//descending 처리를 위한 값 저장
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		asc_dp_val = new int[N];
		desc_dp_val = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) input[i] = Integer.parseInt(st.nextToken());	//입력
		
		asc_dp_val[0] = 1;	//asc은 앞에서부터 dp값 구함
		desc_dp_val[N-1] = 1;	//desc는 뒤에서부터 asc인것처럼 dp값 구함
		asc_dp.add(input[0]);	//가창 처음 값들 넣어두기
		desc_dp.add(input[N-1]);
		for(int i=0; i<N; i++) {
			
			int asc_idx = binary_search(input[i], true);	//binary search를 이용해 현재 탐색하는 수가 asc_dp 혹은 desc_dp 중 어디쯤 들어가는 것이 적절한지 idx 구함
			int desc_idx = binary_search(input[N-i-1], false);
			
			if(asc_dp.get(asc_idx) >= input[i]) asc_dp.set(asc_idx, input[i]);	//구한 값이 중간에 있는 값을 대체하는 경우 (10, 20, 40, 50)이 있었는데 이번 값이 30이면 idx가 2로 반환되고 (10, 20, 30, 50)이 됨
			else if(asc_idx==asc_dp.size()-1) asc_dp.add(input[i]);	//구한 값이 마지막 값보다 더 큰 경우 (10,20,30)이 있었는데 40이 들어오면 asc_dp값이 (10,20,30,40)이 됨
			asc_dp_val[i] = asc_dp.size();
			
			if(desc_dp.get(desc_idx) >= input[N-i-1]) desc_dp.set(desc_idx, input[N-i-1]);	//desc의 경우도 input을 뒤에서부터 확인하며 asc과 동일하게 수행
			else if(desc_idx==desc_dp.size()-1) desc_dp.add(input[N-i-1]);
			desc_dp_val[N-i-1] = desc_dp.size();
		}
		int result = 0;
		for(int i=0; i<N; i++) {	//asc_dp_val과 desc_dp_val값을 합한 것에서 1 뺀 것을 해당 값이  asc의 끝이자 desc의 시작인 값인 경우의 바이토닉 부분수열 값. (asc와 desc에서 해당 값 두번 계산되므로 1 빼야함)
			result = Math.max(result, asc_dp_val[i]+desc_dp_val[i]);
		}
		System.out.println(result-1);
		
	}
	public static int binary_search(int num, boolean asc) {	//이분탐색 asc인지 여부 받아와서 다른 dp배열 및 연결리스트 이용
		int low = 0;
		if(asc) {
			int high = asc_dp.size()-1;
			int mid = (low+high)/2;
			while(low<high) {
				if(num==asc_dp.get(mid)) {
					return mid;
				}
				else if(num>asc_dp.get(mid)) {
					low = mid+1;
				}
				else {
					high=mid;
				}
				mid = (low+high)/2;
			}
		}
		else {
			int high = desc_dp.size()-1;
			int mid = (low+high)/2;
			while(low<high) {
				if(num==desc_dp.get(mid)) {
					return mid;
				}
				else if(num>desc_dp.get(mid)) {
					low = mid+1;
				}
				else {
					high=mid;
				}
				mid = (low+high)/2;
			}
		}
		return low;
	}

}






