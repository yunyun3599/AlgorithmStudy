package tmp;
import java.util.*;
import java.io.*;

class Move implements Comparable<Move> {
	int start;
	int end;
	Move(int start, int end){
		this.start = start;
		this.end = end;
	}
	public int compareTo(Move other) {
		return this.end-other.end;	//도착 지점이 앞이 사람이 먼저 오게 정렬
	}
}

public class _2836_최윤재_수상택시 {
	
	static int N;
	static int M;
	static ArrayList<Move> loc = new ArrayList<>();	//출발점이 도착점보다 뒤인 사람들 출발지점, 도착지점 저장할 arraylist
	static int right;		//start 지점 중 가장 뒷부분
	static int left;		//end 지점 중 가장 앞부분
	static long answer;		//거꾸로 오는 사람들 거리 총합

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		while(N-->0) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if(end<start) loc.add(new Move(start, end));	//출발점이 도착점보다 뒤인 사람들 출발지점, 도착지점 저장
		}////////////////////////////////////////////////////////입력
		Collections.sort(loc);	//도착점 기준으로 정렬
		right = loc.get(0).start;	//출발점이 더 뒤에 있으므로 start가 right
		left = loc.get(0).end;		//도착점이 더 앞에 있으므로 end가 left
		for(int i=1; i<loc.size(); i++) {	//배열 길이만큼 반복
			Move move = loc.get(i);
			if(move.end < right) right = move.start<right ? right : move.start;	//이번에 탐색할 경로가 이전 경로와 겹쳐지는 경우
			else {		//이번에 탐색할 경로가 이전 경로와 끊어져있는 경우
				answer += right-left;	//이전 경로의 총합 우선 저장
				right = move.start;	//right와 left값 업데이트
				left = move.end;
			}
		}
		answer += right-left;	//경로 값 결과에 더함
		System.out.println(answer*2 + M);	//내려갈 때 한번, 다시 올라갈 떄 한번 총 두번 왔다갔다 하므로 answer에 2 곱함. 출발지점이 도착지점보다 더 앞에 있는 사람들은 M을 더함으로써 다 커버 가능
	}

}
