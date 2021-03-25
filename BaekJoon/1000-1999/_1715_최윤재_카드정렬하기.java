package week14;
import java.util.*;
import java.io.*;
public class _1715_최윤재_카드정렬하기 {

	static int num;										//카드 묶음 개수
	static Queue<Integer> card = new PriorityQueue<>();	//우선순위큐 이용
	static int result = 0;								//최종결과
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		
		for(int i=0; i<num; i++) {
			card.add(Integer.parseInt(br.readLine()));
		}
		//////////////////////////////////////////////////입력
		while(card.size() != 1) {						//모든 카드를 비교할 때 까치
			int num1 = card.poll();						//제일 개수가 적은 카드 묶음
			int num2 = card.poll();						//두번째로 개수가 적은 카드 묶음
			result += num1 + num2;						//두 카드 묶음을 더한 새로운 카드 묶음을 queue에 넣음
			card.add(num1+num2);
		}
		System.out.println(result);						//결과출력
		
	}

}
