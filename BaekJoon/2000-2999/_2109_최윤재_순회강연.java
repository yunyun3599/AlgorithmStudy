package tmp;
import java.io.*;
import java.util.*;

public class _2109_최윤재_순회강연 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<int[]> input = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);	//입력받을 우선순위 큐. 날짜를 오름차순 정렬
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);	//최종적으로 갈 강의에 대한 우선순위 큐. 페이를 오름차순 정렬
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int pay = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());
			input.add(new int[] {pay, day});
		}//////////////입력
		
		while(!input.isEmpty()) {
			int[] lecture = input.poll();	//확인할 강의
			int pay = lecture[0]; int day = lecture[1];
			if(pq.size() < day) {	//현재까지 하기로 한 강의들 중 어떤 것도 빼지 않아도 되는 상황
				pq.add(new int[] {pay, day});
			} else {	//현재까지 넣은 강의 중 어떤 것을 빼야하는 상황
				while(pq.size() >= day) {	//필요한 만큼 빼기
					if(pq.peek()[0] > pay) break;	//만약 지금 것의 페이가 하기로 한 강의의 가장 낮은 페이보다 적으면 이번 강의는 추가하지 않음
					pq.poll();	//이전에 넣은 강의 뺌
				}
				if(pq.size() == day) continue;	//강의를 안A 경우
				pq.add(new int[] {pay, day});	//강의를 빼서 이번 강의를 넣는 경우
			}
		}
		
		int money = 0;
		while(!pq.isEmpty()) {
			money += pq.poll()[0];	//하기로 한 강의들의 페이 총합을 구하기
		}
		System.out.println(money);
	}

}
