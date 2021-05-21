package tmp;
import java.util.Scanner;
public class _2302_최윤재_극장좌석 {

	static int N;
	static int M;
	static int[] seat;
	static int[] piv;
	static int result=1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		seat = new int[N+1];
		piv = new int[N+1];
		for(int i=0; i<M; i++) {
			int fixed = sc.nextInt();
			seat[fixed] = -1;			//고정석을 -1로 표시해놓음
		}
		piv[0]=1;
		piv[1]=1;
		piv[2]=2;
		for(int i=3; i<N+1; i++) {
			piv[i] = piv[i-1]+piv[i-2];		//바꿀 수 있는 자리 개수에 따라 피보나치 수열의 값을 가지게 됨 
		}
		int count = 0;
		for(int i=1; i<N+1; i++) {
			if(seat[i]!=-1) count++;		//고정석 아니면 자리 개수 증가
			else {						//고정석 나오면 지금까지 세놓은 자리 개수의 피보나치 수열 값을 구해 결과에 곱하기
				result *= piv[count];
				count=0;			//자리 개수 초기화
			}
		}
		result *= piv[count];		//마지막 고정석 뒤에 있는 자리들
		System.out.println(result);
	}

}
