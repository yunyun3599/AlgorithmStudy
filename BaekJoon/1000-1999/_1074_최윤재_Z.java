package tmp;
import java.util.*;

public class _1074_최윤재_Z {
	
	static int N;
	static int r;
	static int c;
	static int result;
	static int[] dx = {0,1,0,1};	//z모양
	static int[] dy = {0,0,1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		N = (int)Math.pow(2, N);	//2의 N제곱으로 변환
		r = sc.nextInt();
		c = sc.nextInt();
		divide(N,0,0);	//분할정복
	}
	public static void divide(int width, int y, int x) {
		if(y>r || x>c) {		//해당 범위에 (r,c)가 없는 경우는 해당 범위 내의 칸 개수만큼 result를 늘리고 바로 리턴
			result += width*width;
			return;
		}
		if(y+width-1<r || x+width-1<c) {
			result += width*width;
			return;
		}
		if(width==2) {			//4칸일 때
			for(int k=0; k<4; k++) {	//상하좌우확인
				if(y+dy[k] == r && x+dx[k]==c) {	//(r,c)인 경우에 걸린 횟수 출력
					System.out.println(result);
					System.exit(0);
				}
				result++;
			}
		}
		else {
			divide(width/2, y, x);
			divide(width/2, y, x+width/2);
			divide(width/2, y+width/2, x);
			divide(width/2, y+width/2, x+width/2);
		}
	}
}
