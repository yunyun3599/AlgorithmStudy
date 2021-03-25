package week15;
import java.io.*;
import java.util.*;
public class _11497_최윤재_통나무건너뛰기 {

	static int testcase;
	static int num;
	static int height[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		testcase = Integer.parseInt(br.readLine());						//테스트케이스 종류
		
		for(int i=0; i<testcase; i++) {
			num = Integer.parseInt(br.readLine());						//통나무 개수
			height = new int[num];										//통나무 높이 저장
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = 0;
			while(st.hasMoreTokens()) 
				height[idx++] = Integer.parseInt(st.nextToken());		//여기까지 입력
			Arrays.sort(height);										//높이순으로 배열
			int idx_low = 0;											//앞에서부터 채우는 인덱스
			int idx_high = num-1;										//뒤에서부터 채우는 인덱스
			int[] tmp = new int[num];									//높이차가 최소가 되도록 정렬해놓을 배열
			idx = 0;
			while(idx_low < idx_high) {									//높이순으로 정렬해놓은 배열을 하나는 앞 하나는 뒤에서부터 차곡차곡 쌓음
				tmp[idx_low++] = height[idx++];
				tmp[idx_high--] = height[idx++];
			}
			if (idx_low == idx_high) tmp[idx_low] = height[idx];		//통나무 개수가 홀수일 때 핸들링
			int res = 0;
			for(int j=0; j<num-1; j++) 									//높이 차가 최대인 경우 구하기
				res = Math.max(res, Math.abs(tmp[j]-tmp[j+1]));
			res = Math.max(res, Math.abs(tmp[0]-tmp[num-1]));
			result.append(res+"\n");									//결과 출력
		}
		System.out.println(result);
	}

}
