package tmp;
import java.io.*;
import java.util.*;
public class _1780_최윤재_종이의개수 {

	static int width;	//총 넓이
	static int[][] map;	
	static int one;		//1인 종이
	static int zero;	//0인 종이
	static int minus;	//-1인 종이
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		width = Integer.parseInt(br.readLine());
		map = new int[width][width];
		
		for(int i=0; i<width; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<width; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}	
		///////////////////////////////////////////////////////////////입력
		check(0, 0, width);			//전체 맵에 대해서 우선 확인
		System.out.println(minus);	//결과 출력
		System.out.println(zero);
		System.out.println(one);
	}
	public static void check(int y, int x, int num) {	//시작하는 y,x좌표와 너비 받음
		int val = map[y][x];	//모두 통일되어야 하는 기준 값
		for(int i=y; i<y+num; i++) {
			for(int j=x; j<x+num; j++) {
				if (map[i][j] != val) {	//같은 칸 내에 같지 않은 수가 있는 경우
					for(int k=y; k<y+num; k+=num/3) {
						for(int l=x; l<x+num; l+=num/3) {
							check(k, l, num/3);	//1/3 너비의 사각형을 9개 만들어 재귀적으로 check함수 이용
						}
					}
					return;
				}
			}
		}
		if(val == -1) minus += 1;	//해당 칸의 값이 모두 동일하다고 판정된 경우 해당 값에 맞게 변수 값 하나씩 늘림
		else if(val==0) zero += 1;
		else one += 1;
	}
}
