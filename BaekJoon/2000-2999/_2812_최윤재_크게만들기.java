package week16;
import java.util.*;

public class _2812_최윤재_크게만들기 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int digit = sc.nextInt();				//몇자리 수인지
		int remove = sc.nextInt();				//지울 개수
		sc.nextLine();
		String num = sc.nextLine();				//입력되는 수
		Deque<Integer> dq = new ArrayDeque<Integer>();	//덱 이용
		StringBuilder sb = new StringBuilder();			//결과 저장
		
		dq.add(num.charAt(0)-'0');				//첫번째 수 넣음
		int count = 0;							//몇개 지웠는지 표시
		for(int i=1; i<digit; i++) {
			while(!dq.isEmpty() && count<remove && dq.peekLast() < num.charAt(i)-'0') {		//새로 들어오는 수가 더 작아질때 까지 pop
				dq.pollLast();
				count++;
			}
			dq.add(num.charAt(i)-'0');
		}
		
		for(int i=0; i<digit-remove; i++)		//결과출력
			sb.append(dq.poll());
		System.out.println(sb);
		
	}

}
