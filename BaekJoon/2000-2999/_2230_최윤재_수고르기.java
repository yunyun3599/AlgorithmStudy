package tmp;
import java.util.*;
import java.io.*;
public class _2230_최윤재_수고르기 {

	static int N,M;
	static int[] arr;
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		////////////////////////////////////////////////////////입력
		Arrays.sort(arr);		//정렬
		int left = 0;			//왼쪽 수
		int right = 0;			//오른쪽 수
		while(left<N && result != M) {	//M이 가능하다고 판명나거나 배열 모두 확일할 때까지 반복
			int diff = arr[right] - arr[left];	//각 단계별로 원소들 차
			if(diff<M && right<N-1) right++;	//차이가 M보다 작으면 오른쪽 인덱스 1 증가
			else {		//차이가 M보다 큰 경우
				if(diff>=M) result = Math.min(result, diff);	//M보다 큰 경우에 대해서만 result를 더 작은 값으로 업데이트
				left++;	//왼쪽 인덱스 증가
			}
		}
		System.out.println(result);
	}

}
