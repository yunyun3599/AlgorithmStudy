package week15;
import java.io.*;
import java.util.*;

class Link{
	int dest;
	int weight;
	Link(int dest, int weight){
		this.dest = dest;
		this.weight = weight;
	}
}

public class _1939_최윤재_중량제한 {
	
	static int island;						//섬 개수
	static int bridge_num;					//다리 개수
	static ArrayList<Link>[] bridge;		//다리 배열
	static int factory1;					//출발지점
	static int factory2;					//도착지점
	static int max;							//이분탐색때 쓸 가장 큰 값 (right)
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		island = Integer.parseInt(st.nextToken());
		bridge_num = Integer.parseInt(st.nextToken());
		bridge = new ArrayList[island];
		
		for(int i=0; i<island; i++) bridge[i] = new ArrayList<>();		//ArrayList 객체 만들어줌
		
		for(int i=0; i<bridge_num; i++) {					//입력
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			bridge[from].add(new Link(to, weight));
			bridge[to].add(new Link(from, weight));
			max = Math.max(max, weight);
		}
		st = new StringTokenizer(br.readLine());
		factory1 = Integer.parseInt(st.nextToken())-1;
		factory2 = Integer.parseInt(st.nextToken())-1;
		////////////////////////////////////////////////////////////////입력
		
		int left = 1;									//최소값
		int right = max;								//최대값
		while(left <= right) {							//이분탐색
			int mid = (left+right)/2;					//중간값
			boolean[] visited = new boolean[island];	//방문여부 처리
			if(dfs(factory1, mid, visited)) {			//해당 mid값을 weight로 뒀을 때 가능하면
				left = mid+1;							//mid값을 더 키워서 또 탐색
				result = mid;
			}
			else {										//mid값을 weight로 뒀을 때 불가능 하면
				right = mid-1;							//mid값을 더 줄여서 탐색
			}
		}
		
		System.out.println(result);
		
	}
	public static boolean dfs(int loc, int weight, boolean[] visited) {	//해당 weight로 가능한지 확인하기 위해 dfs 이용
		if(visited[loc]) return false;					//이미 탐색한 섬일 때는 false를 return (불가능한 경우)
		visited[loc] = true;
		
		if (loc == factory2) {							//도착지점 왔을 때는 true를 return
			return true;
		}
		for(int i=0; i<bridge[loc].size(); i++) {		//다음 섬 어디로 갈지 결정
			Link tmp = bridge[loc].get(i);
			if(tmp.weight >= weight) {					//다리가 버틸 수 있는 무게가 weight보다 커야함
				if(dfs(tmp.dest, weight, visited)) return true;
			}
		}
		return false;
	}

}
