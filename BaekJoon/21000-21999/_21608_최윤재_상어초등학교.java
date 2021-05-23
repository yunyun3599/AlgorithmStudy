package tmp;
import java.io.*;
import java.util.*;

class Seat implements Comparable<Seat>{			//priority queue에 넣을 객체. 좌표와 주변에 좋아하는 친구 수, 빈 자리를 요소로 가짐
	int y;				//우선순위 큐 내에서 정렬하는 순서는 좋아하는 친구 수 -> 빈 자리 -> y좌표 -> x좌표 순
	int x;
	int likes;
	int empty;
	Seat(int y, int x, int likes, int empty){
		this.y = y;
		this.x = x;
		this.likes = likes;
		this.empty = empty;
	}
	public int compareTo(Seat another) {
		if(this.likes == another.likes) {
			if(this.empty == another.empty) {
				if(this.y == another.y) return this.x-another.x;
				else return this.y-another.y;
			}
			else return another.empty - this.empty;
		}
		else return another.likes-this.likes;
	}
}

public class _21608_최윤재_상어초등학교 {
	
	static int N;
	static int[][] map;
	static int[][] like;
	static int[] axis_x = {0,0,-1,1};
	static int[] axis_y = {-1,1,0,0};
	static PriorityQueue<Seat> pq;
	static int result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		like = new int[N*N][5];
		for(int i=0; i<N*N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<5; j++) {
				like[i][j] = Integer.parseInt(st.nextToken());		//좋아하는 친구 저장 배열
			}
		}////////////////////////////////////////////////////////////입력
		for(int i=0; i<N*N; i++) {
			pq = new PriorityQueue<>();		//각 학생에 대해 우선순위 큐
			assign(i);						//학생 순서대로 자리 배치
			Seat seat = pq.poll();			//가장 우선순위 높은 자리 poll
			map[seat.y][seat.x] = like[i][0];	//해당 자리에 해당 학생 앉힘
		}
		for(int i=0; i<N; i++) {			//주변에 앉은 좋아하는 친구 수 대로 점수 매기기
			for(int j=0; j<N; j++) {
				int likes = 0;
				int tmp[] = new int[4];		//이번에 점수 계산할 학생이 좋아하는 친구들을 tmp배열에 넣음
				for(int k=0; k<N*N; k++) {	//tmp 배열 채우는 과정
					if(map[i][j]==like[k][0]) {
						for(int k1=0; k1<4; k1++) tmp[k1] = like[k][k1+1];
					}
				}
				for(int k=0; k<4; k++) {	//상하좌우를 확인해서 좋아하는 친구 수를 likes에 저장
					int y = i+axis_y[k];
					int x = j+axis_x[k];
					if(check(y,x)) {
						if(map[y][x]==tmp[0] || map[y][x]==tmp[1] || map[y][x]==tmp[2] || map[y][x]==tmp[3]) likes++;
					}
				}
				if(likes==1) result+=1;			//좋아하는 친구 수대로 점수 계산
				else if(likes==2) result+=10;
				else if(likes==3) result+=100;
				else if(likes==4) result+=1000;
			}
		}
		System.out.println(result);
	}
	public static void assign(int student) {		//자리 배정 함수
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==0) {				//아직 비어있는 자리에 대해 수행
					int likes=0, empty=0;		//likes는 좋아하는 친구 수, empty는 빈 자리
					for(int k=0; k<4; k++) {
						int y = i+axis_y[k];	//상하좌우 보기
						int x = j+axis_x[k];
						if(check(y, x)) {		//map 범위 체크
							if(map[y][x]==0) empty++;	//빈자리인 경우 empty증가
							else if(map[y][x]==like[student][1] || map[y][x]==like[student][2] || map[y][x]==like[student][3] || map[y][x]==like[student][4]) likes++;	//좋아하는 친구인 경우 likes증가
						}
					}
					pq.add(new Seat(i,j,likes,empty));	//priority queue에 넣음
				}
			}
		}
	}
	public static boolean check(int y, int x) {			//범위 체크
		if(0<=y && 0<= x && y<N && x<N) return true;
		return false;
	}

}
