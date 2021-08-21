package tmp;
import java.util.*;

public class _2022_최윤재_사다리 {

	static double x;
	static double y;
	static double c;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		x = sc.nextDouble();
		y = sc.nextDouble();
		c = sc.nextDouble();
		/////////////////////////////////입력
		if(x>y) {		//더 큰 값을 y로
			double tmp = y;
			y=x;
			x=tmp;
		}
		
		double low = 0;	//이분탐색. 건물간 거리가 mid
		double high = y;
		while(low<high) {
			double mid = (low+high)/2;
			double ya = Math.sqrt(y*y-mid*mid);
			double xa = Math.sqrt(x*x - mid*mid);
			double result = (ya*xa)/(ya+xa);		//교차점의 높이 값은 (sqrt((y^2-a^2)(x^2-a^2))/(sqrt(y^2-a^2)+sqrt(x^2-a^2))임
			if(Math.abs(result-c)<= 0.001) {		//오차가 0.001보다 작으면 stop
				System.out.printf("%.3f",Math.round(mid*1000)/1000.0);	//결과 소수점 세번째 자리까지 출력
				System.exit(0);
			}
			else if(result > c) low = mid;	//구한 c가 목표 c보다 크면 건물간 거리를 너무 좁게 잡은 것이므로 low를 mid로 올림
			else high = mid;	//건물간 거리를 너무 멀게 잡은 경우
		}
	}

}
