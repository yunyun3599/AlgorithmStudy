package week11;
import java.util.*;
public class _1182_최윤재_부분수열의합 {
	
	static int num;								//숫자 개수
	static int target;							//목표값
	static int[] num_arr;						//숫자 저장 배열
	static int result;							//만들 수 있는 경우 개수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		target = sc.nextInt();
		num_arr = new int[num];
		
		for(int i=0; i<num; i++) 
			num_arr[i] = sc.nextInt();			//여기까지 입력
		
		check(0, 0, false);						//0번인덱스의 값부터 시작
		System.out.println(result);				//결과 출력
	}
	
	public static void check(int idx, int sum, boolean flag) {	//idx는 이번에 처리할 index, sum은 해당 경우의 지금까지의 원소 합, flag는 현재까지 포함된 원소가 0개면 false, 양수면 true
		if (idx < num) {						//다음 원소가 있는 경우
			check(idx+1, sum, flag);			//이번 원소 포함 안함
			check(idx+1, sum + num_arr[idx], true);	//이번 원소 포함함
		}
		else {									//최종 결과. target값과 맞는지 확인
			if (sum == target && flag) result++;
		}
	}
	
}
