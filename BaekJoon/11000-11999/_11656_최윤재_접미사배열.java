package week14;
import java.util.*;
public class _11656_최윤재_접미사배열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();						//String입력받기
		Queue<String> pqueue = new PriorityQueue<>();		//접미사 배열을 저장할 우선순위 큐
		StringBuilder sb = new StringBuilder();				//결과값
		
		for(int i=0; i<line.length(); i++) {				//받은 String에 대해 앞에서부터 char 하나씩 지워가면서 우선순위 큐에 넣음
			String tmp = line.substring(i);					//우선순위 큐에서 알아서 사전순으로 정렬
			pqueue.add(tmp);
		}
		
		while(!pqueue.isEmpty()) {							//우선순위 큐에서 순서대로 값 꺼냄
			sb.append(pqueue.poll()+"\n");
		}
		
		System.out.println(sb);

	}

}
