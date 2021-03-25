package week15;
import java.util.*;
public class _15658_최윤재_연산자끼워넣기2 {
	
	static int num;
	static int[] num_list;
	static int[] operator = new int[4];			//+ - * /
	static int max = -1000000000;
	static int min = 1000000000;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		num_list = new int[num];
		for(int i=0; i<num; i++) num_list[i] = sc.nextInt();
		for(int i=0; i<4; i++) operator[i] = sc.nextInt();
		///////////////////////////////////////////////////////여기까지 입력
		calc(1, num_list[0]);
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void calc(int idx, int result) {			//idx가 이번에 확인할 숫자의 인덱스 result는 지금까지의 결과
		if(idx == num) {									//마지막 숫자까지 처리했을 때
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		
		int[] tmp = {result + num_list[idx],				//+-*/ 각각에 대한 결과를 저장해둠
				result - num_list[idx],
				result * num_list[idx],
				result / num_list[idx]
		};
		
		for(int i=0; i<4; i++) {							//+-*/ 각각에 대해 수행
			if(operator[i] > 0) {
				operator[i]--;
				calc(idx+1, tmp[i]);
				operator[i]++;
			}
		}
	}

}
