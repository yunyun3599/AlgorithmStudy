package week14;
import java.util.*;
import java.io.*;
public class _1915_최윤재_가장큰정사각형 {
	
	static int height;			//높이
	static int width;			//너비
	static int [][] map;		//입력값
	static int [][] dp;			//dp배열
	static int result = 0;		//결과값
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		map = new int[height+1][width+1];					//가장 윗행과 가장 앞 열 0으로 채워서 map 만듦
		dp = new int[height+1][width+1];					//인덱스 범위 체크하기 귀찮으니까
		
		for(int i=1; i<height+1; i++) {	
			String tmp = br.readLine();
			for(int j=1; j<width+1; j++) {
				map[i][j] = tmp.charAt(j-1)-'0';
			}
		}
///////////////////////////////////////////////////////////////입력			
		for(int i=1; i<height+1; i++) {						//dp에 각 정사각형 한 변의 길이를 저장
			for(int j=1; j<width+1; j++) {
				if (map[i][j] == 0) dp[i][j] = 0;			//해당 칸의 값이 0이면 dp에도 그냥 0 넣음
				else {										//해당 칸의 값이 1인 경우
					int min = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));	//자기 윗칸, 왼쪽칸, 왼쪽 대각선 윗값 중 가장 작은 값 +1이 자신의 값
					dp[i][j] = min+1;
					result = Math.max(result, dp[i][j]);	//result값보다 현재 값이 더 크면 result값 업데이트
				}
			}
		}
		System.out.println(result*result);					//넓이는 result*result
	}

}
