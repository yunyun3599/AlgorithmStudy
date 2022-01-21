package tmp;
import java.io.*;
import java.util.*;

class Lecture implements Comparable<Lecture> {	//강의 시작시간, 끝시간
	int start;
	int end;
	public Lecture(int start, int end) {
		this.start = start;
		this.end = end;
	}
	public int compareTo(Lecture other) {
		if(this.start != other.start) return this.start - other.start;
		return this.end - other.end;
	}
}

public class _11000_최윤재_강의실배정 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Lecture[] time = new Lecture[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			time[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(time);	//강의 시작시간 기준으로 정렬
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(time[0].end);	//가장 먼저 시작하는 강의가 끝나는 시간
		
		for(int i=1; i<N; i++) {
			if(pq.peek() <= time[i].start) pq.poll();	//현재 진행중인 강의 중 가장 먼저 끝나는 값보다 새로 넣을 강의의 시작 시간이 더 크면 해당 강의실 이용하면 되므로 poll
			pq.add(time[i].end);	//새로 넣을 강의의 시작 시간이 현재 진행중인 강의 중 가장 먼저 끝나는 강의의 종료시간보다 빠르면 새로운 강의실 배정
		}
		System.out.println(pq.size());
	}

}
