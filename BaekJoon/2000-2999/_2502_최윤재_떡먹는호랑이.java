package tmp;
import java.util.*;
public class _2502_최윤재_떡먹는호랑이 {

	static int day;			//주어진 날
	static int num;			//주어진 날 떡의 개수
	static int[] dp;		//dp배열
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		day = sc.nextInt();
		num = sc.nextInt();
		
		dp = new int[day];
		int start1 = 1;		//첫날에 줄 떡의 개수
		int start2 = 1;		//둘째날에 줄 떡의 개수
		
		while(dp[day-1]!=num) {		//주어진 날의 떡의 개수가 num이 아니면 다시 시도
			start2 = 1;				//둘째날 떡의 개수 1개로 초기화
			dp[0] = start1++;		//첫째날 떡의 개수 하나씩 늘리기
			while (start2<num) {	//둘째날 줄 떡의 개수 하나씩 늘려가면서 시도
				dp[1]= start2++;
				for(int i=2; i<day; i++) {
					dp[i] = dp[i-1]+dp[i-2];	//dp배열에 이전 두 날의 떡 개수 합한 값 넣기
				}
				if(dp[day-1]==num) break;	//떡 개수 맞추면 break
			}
		}
		System.out.println(dp[0]);
		System.out.println(dp[1]);
	}

}
