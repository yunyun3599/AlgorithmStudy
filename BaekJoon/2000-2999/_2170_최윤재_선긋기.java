import java.io.*;
import java.util.*;

class Line implements Comparable<Line> {
	int start;
	int end;
	public Line(int start, int end) {
		this.start = start;
		this.end = end;
	}
	public int compareTo(Line other) {
		return this.start - other.start;
	}
}

public class Main {

	static int N;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ArrayList<Line> arr = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr.add(new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(arr);
		
		int l,r;
		Line line = arr.get(0);
		l = line.start;
		r = line.end;
		for(int i=1; i<N; i++) {
			line = arr.get(i);
			if(line.start <= r) r = Math.max(r, line.end);
			else {
				result += (r-l);
				l = line.start;
				r = line.end;
			}
		}
		result += (r-l);
		System.out.println(result);
	}

}
