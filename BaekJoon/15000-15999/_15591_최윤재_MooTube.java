package week18;
import java.io.*;
import java.util.*;


class Video implements Comparable<Video>{		//queue에 넣을 비디오 객체
	int num;
	int weight;
	Video(int num, int weight){
		this.num = num;
		this.weight = weight;
	}
	public int compareTo(Video another) {
		return this.weight - another.weight;
	}
}

public class _15591_최윤재_MooTube {
	
	static ArrayList<Video>[] map;	//값을 저장해 놓을 배열
	static boolean[] checked;	//이미 해당 비디오 기준으로 계산한 적 있는지 확인용
	static int[][] result;		//결과값 저장 배열
	static boolean[] visited;	//방문 여부 확인
	static int video;	//비디오 개수
	static int question;//질문 개수
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		video = Integer.parseInt(st.nextToken());
		question = Integer.parseInt(st.nextToken());
		map = new ArrayList[video+1];
		checked = new boolean[video+1];
		result = new int[video+1][video+1];
		for(int i=0; i<video+1; i++) {
			map[i] = new ArrayList();
		}
		for(int i=1; i<video; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			map[node1].add(new Video(node2, weight));
			map[node2].add(new Video(node1, weight));
		}
		///////////////////////////////////////////////////여기까지 입력
		for(int i=0; i<question; i++) {		//각 질문에 대해 처리
			visited = new boolean[video+1];	//새 visited배열 선언
			st = new StringTokenizer(br.readLine());
			int threshold = Integer.parseInt(st.nextToken());	//기준 연관도
			int node = Integer.parseInt(st.nextToken());		//시작할 기준 노드
			int tmp_result = 0;		//해당 질문에 대한 답
			if(!checked[node]) {	//아직 구한 적 없는 경우에만 bfs 수행
				bfs(node);
				checked[node] = true;
			}
			for(int j=1; j<video+1; j++) {	//연관도 기준을 넘기는 경우들을 더함
				if(j==node) continue;
				if(result[node][j] >= threshold) tmp_result++;
			}
			sb.append(tmp_result+"\n");
		}
		System.out.println(sb);
	}
	public static void bfs(int start) {
		Queue<Video> q = new LinkedList();
		q.add(new Video(start, Integer.MAX_VALUE));
		while(!q.isEmpty()) {
			Video tmp = q.poll();
			visited[tmp.num] = true;
			for(Video next: map[tmp.num]) {	//현재 있는 노드들과 연결된 것들에 대해 풂
				if(!visited[next.num]) {
					result[start][next.num] = Math.min(tmp.weight, next.weight);	//result로 지금 연결되어 있는 엣지 가중치와 연결되어 있는 노드의 result값 중 더 적은 것으로 결정
					q.add(new Video(next.num, result[start][next.num]));
				}
			}
		}
	}

}
