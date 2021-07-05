package tmp;
import java.util.*;
import java.io.*;
public class _2467_최윤재_용액 {

	static int num;	//용액 개수
	static int solution[];	//용액 저장
	static int result = Integer.MAX_VALUE;	//0에 가장 가까운 값
	static int answer1;	//더 수가 작은 용액
	static int answer2;	//더 수가 큰 용액
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		solution = new int[num];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<num; i++) solution[i] = Integer.parseInt(st.nextToken());
		////////////////////////////입력
		Arrays.sort(solution);	//오름차순 정렬
		
		int left = 0;	//왼쪽 인덱스
		int right = num-1;	//오른쪽 인덱스
		
		while(left<right) {
			if(Math.abs(solution[left]+solution[right]) < result) {	//현재 result보다 0에 더 가까우면 업데이트
				result = Math.abs(solution[left]+solution[right]);
				answer1 = solution[left];
				answer2 = solution[right];
			}
			if(solution[left]+solution[right]<0) left++;	//합한 값이 0보다 작으면 음수 부분 ++
			else right--;	//합한 값이 0보다 크면 양수 부분--
		}
		System.out.println(answer1 + " " + answer2);
	}

}
