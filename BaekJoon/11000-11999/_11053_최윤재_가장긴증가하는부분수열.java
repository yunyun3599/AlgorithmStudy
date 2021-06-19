package tmp;
import java.util.*;
import java.io.*;


public class _11053_최윤재_가장긴증가하는부분수열 {

	static int len;
	static int[] arr;
	static LinkedList<Integer> dp = new LinkedList();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		len = Integer.parseInt(br.readLine());
		arr = new int[len];
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr[0] = Integer.parseInt(st.nextToken());
		dp.add(arr[0]);
		for(int i=1; i<len; i++) {
			arr[i] = Integer.parseInt(st.nextToken());		//입력받기
			int idx = binary_search(arr[i]);		//이진탐색으로 arr[i]보다 값이 크거나 arr[i]가 가장 큰 경우 가장 뒤의 인덱스를 돌려받음
			if(dp.get(idx)>=arr[i]) dp.set(idx, arr[i]);	//arr[i]가 받아온 arr[idx]의 값보다 작으면 dp[idx]의 값 바꿈
			else if(idx==dp.size()-1) dp.add(arr[i]);	//idx가 마지막 원소라면 가장 뒤에 appendx
		}
		System.out.println(dp.size());
	}
	
	public static int binary_search(int num) {			//이진탐색
		int low = 0; int high=dp.size()-1; int mid = (low+high)/2;
		System.out.println();
		while(low<high) {
			if(num==dp.get(mid)) {
				return mid;
			}
			if(num>dp.get(mid)) {
				low=mid+1;
			}
			else {
				high=mid;
			}
			mid = (low+high)/2;
		}
		return low;
	}
}
