package week8;
import java.io.*;
public class _1932_최윤재 {
	
	static int triangle[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int height = Integer.parseInt(bf.readLine());									//삼각형 높이
		triangle=new int[height][height];												//각 숫자 값 저장
		
		for(int i=0; i<height; i++) {													//입력받기. 배열에 띄어쓰기를 기준으로 split하여 넣음
			String[] tmp =bf.readLine().split(" ");
			for(int j=0; j<tmp.length; j++) triangle[i][j]=Integer.parseInt(tmp[j]);
		}
		
		for(int i=height-2; i>=0; i--) {												//아래에서 위로 올라가며 값 계산
			for(int j=0; j<i+1; j++) {													//3행 3열이면 4행3열과 4행 4열 값 중 더 큰 값과 자신의 값을 합한 결과를 저장
				triangle[i][j]=Math.max(triangle[i+1][j],triangle[i+1][j+1])+triangle[i][j];
			}
		}
		System.out.println(triangle[0][0]);												//(0,0)에 최종 결과 있으므로 출력
	}
}
