package week13;
import java.util.*;
import java.io.*;

class Location{
	int y;
	int x;
	Location(int y, int x){
		this.x = x;
		this.y = y;
	}
}

public class _15686_최윤재_치킨배달 {

	static int N;				//도시 크기 N*N
	static int M;				//최대 치킨집 개수
	static boolean[] open;
	static ArrayList<Location> house = new ArrayList<>();		//집이 있는 위치들을 저장
	static ArrayList<Location> chicken = new ArrayList<>();		//치킨집이 있는 위치들을 저장
	static int distance = 1000000;		//최종 결과
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				int check = Integer.parseInt(st.nextToken());
				if(check == 1) house.add(new Location(i,j));		//집의 위치 add
				if(check == 2) chicken.add(new Location(i,j));		//치킨집의 위치 add
			}
		}
		open = new boolean[chicken.size()];						//open배열로 연 치킨집만 true를 저장
		
		makemap(0, 0);
		bw.write(distance+" ");
		bw.flush();
		bw.close();
	}
	
	public static void makemap(int loc, int num) {
		if (num == M) {												//연 치킨집이 M값과 같을 때
			int tmp_total_distance = 0;								//이번에 열은 치킨집에 대한 총 거리
			for(int i=0; i<house.size(); i++) {
				int tmp = 101;										//특정 집의 치킨집까지 최소 거리 저장
				for(int j=0; j<chicken.size(); j++) {
					if (open[j]) {
						int dist = Math.abs(house.get(i).y-chicken.get(j).y) + Math.abs(house.get(i).x-chicken.get(j).x);	//이번에 비교한 치킨집과 지금까지의 최소값 중 더 작은값 채택
						tmp = Math.min(tmp, dist);
					}
				}
				tmp_total_distance += tmp;							//구한 최소거리를 이번 케이스의 총 거리에 더함
			}
			distance = Math.min(distance, tmp_total_distance);		//최종 결과값과 비교하여 더 작은 값을 최종값으로 업데이트
			return;
		}
		for(int i=loc; i<chicken.size(); i++) {						//i번째 치킨집이 열은 경우와 열지 않은 경우에 대해 탐색
			open[i] = true;
			makemap(i+1, num+1);									//num이 연 치킨집의 개수
			open[i] = false;
		}
	}
}


