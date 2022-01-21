package tmp;
import java.io.*;
import java.util.*;

class Lecture implements Comparable<Lecture> {	//���� ���۽ð�, ���ð�
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

public class _11000_������_���ǽǹ��� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Lecture[] time = new Lecture[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			time[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(time);	//���� ���۽ð� �������� ����
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(time[0].end);	//���� ���� �����ϴ� ���ǰ� ������ �ð�
		
		for(int i=1; i<N; i++) {
			if(pq.peek() <= time[i].start) pq.poll();	//���� �������� ���� �� ���� ���� ������ ������ ���� ���� ������ ���� �ð��� �� ũ�� �ش� ���ǽ� �̿��ϸ� �ǹǷ� poll
			pq.add(time[i].end);	//���� ���� ������ ���� �ð��� ���� �������� ���� �� ���� ���� ������ ������ ����ð����� ������ ���ο� ���ǽ� ����
		}
		System.out.println(pq.size());
	}

}
