package tmp;
import java.io.*;
import java.util.*;
public class _2075_최윤재 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue pq = new PriorityQueue(Collections.reverseOrder());	//입력값 우선순위큐에 넣음
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
		}
		for(int i=1; i<N; i++) pq.poll(); //N번째 보다 앞의 값들 모두 poll
		System.out.println(pq.poll());
	}

}
