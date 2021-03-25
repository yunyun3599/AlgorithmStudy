package week10;
import java.io.*;
public class _11729_최윤재 {

	static int num;			// 원판 개수
	static int total;		//총 움직이는 횟수
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		num = Integer.parseInt(br.readLine());
		
		bw.write((int) Math.pow(2, num)-1 + "\n");				//하노이 타워 최소 이동횟수 공식 (2^원판개수 -1)
		hanoi(num, 1, 2, 3);									//재귀 호출. num개를 1에서 2를 이용해 3으로
		//System.out.println(total);							//이동시마다 total++해서 System.out.println(total)로 출력하면 원판 12개부터 출력이 안됨
		bw.flush();												//결과 출력
		bw.close();
	}
	public static void hanoi (int num, int from, int via, int to) throws IOException {
		if ( num==1 ) {											//원판 하나일 때
			bw.write(from + " " + to + "\n");
			//total++;
			return;
		}
		hanoi(num-1, from, to, via);							//재귀 호출
		bw.write(from + " " + to + "\n");
		//total++;
		hanoi(num-1, via, from, to);
	}
}
