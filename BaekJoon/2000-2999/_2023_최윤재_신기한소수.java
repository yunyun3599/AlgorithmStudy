import java.util.*;
public class _2023_최윤재_신기한소수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder result = new StringBuilder();
		
		int num = (int)Math.pow(10, N-1);	//해당 자릿수를 갖는 최소값 
		while(num<(int)Math.pow(10, N)) {	//다음 자릿수로 넘어가기 전까지 수행 
			for(int divider = N-1; divider >=0; divider-- ) {	//앞에서부터 한 숫자씩 끊어서 확인 
				int divider_val = (int)Math.pow(10, divider);	//앞에서부터 한 숫자씩 끊기 위해 나누어줄 값 
				int subnum = num / divider_val;	//나눠진 앞부분의 값 
				if(check(subnum)) {	//소수인지 확인 
					if(divider == 0) {	//전부 다 확인 결과 소수인 경우 
						result.append(num+"\n");
						num++;
					}
				}
				else {	//소수가 아닌 경우는 해당하는 앞부분을 공통으로 가진 것들은 전부 미포함이 되므로 5000 중 50을 확인하다 걸린 경우 다음번에 5100을 확인하도록 숫자 키움 
					num += divider_val;	//나눈 만큼 더하고 나눴다가 곱해서 해당 prefix보다 하나 큰 prefix를 만듦 
					num = (num / divider_val) * divider_val;
					break;
				}
			}
		}
		System.out.println(result);
	}
	public static boolean check(int base) {	//소수인지 판별 (에라토스테데스의 체는 메모리 초과)
		if(base == 1) return false;
		for(int i=2; i*i<=base; i++) {	//제곱해서 최댓값보다 작은 경우들에 대해 나눠봄 
			if(base%i == 0) {
				return false;
			}
		}
		return true;
	}

}
