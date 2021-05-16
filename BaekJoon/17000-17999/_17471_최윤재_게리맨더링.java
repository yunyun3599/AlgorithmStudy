package tmp;
import java.io.*;
import java.util.*;
public class _17471_최윤재_게리맨더링 {

	static int num;					//구역 개수
	static int total_population;	//모든 나라들 총 인구수의 합
	static int[] population;		//각 나라별 인구수
	static boolean[] visited;		//서로 연결되어있는지 확인하는 dfs에 쓸 것
	static boolean[] division;		//각 나라가 어느 구역에 속해있는지 표시
	static boolean[][] adj;			//인접행렬
	static int result=Integer.MAX_VALUE;	//최소 차이 값 저장할 변수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		population = new int[num];
		division = new boolean[num];
		adj = new boolean[num][num];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<num; i++) {
			population[i] = Integer.parseInt(st.nextToken());
			total_population += population[i];
		}
		for(int i=0; i<num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int near = Integer.parseInt(st.nextToken());
			for(int j=0; j<near; j++) {
				adj[i][Integer.parseInt(st.nextToken())-1] = true;
			}
		}
		//////////////////////////////////////////////////////입력
		for(int limit=1; limit<num; limit++) {		//각 구열별로 몇개국을 선택할지를 limit으로 설정 (limit<=num/2는 왜 안되는 것?)
			for(int i=0; i<num-limit+1; i++) {		//i번째 국가부터 limit개 선택
				divide(i, 0, limit);
			}
		}
		if (result == Integer.MAX_VALUE) System.out.println(-1);	//분할이 된 경우에는 -1을 출력
		else System.out.println(result);			//결과 출력
	}
	
	public static void divide(int include, int count, int limit) {
		if(count==limit) {		//모든 구역을 다 선택한 경우 연결요소 확인
			if(connected()) calc(); //두 구역이 각 구역 내부에서 연결되어있으면 인구 수 차이 계산
			return;
		}
		division[include] = true;	//이번에 받아온 국가 true구역에 추가
		for(int i=include+1; i<num-(limit-count)+1; i++) {	//다음에 true구역에 추가할 국가
			divide(i, count+1, limit);
		}
		division[include] = false;
	}
	
	public static boolean connected() {	
		visited = new boolean[num];	//각 구역이 dfs두번 수행의 결과 모두 방문되었는지 확인하기 위함
		for(int i=0; i<num; i++) {	//true인 국가들 dfs로 visited표시
			if(division[i]) {
				dfs(i);
				break;
			}
		}
		for(int i=0; i<num; i++) {	//false인 국가들 dfs로 visited표시
			if(!division[i]) {
				dfs(i);
				break;
			}
		}
		for(int i=0; i<num; i++) {	//visited배열중 하나라도 false면 구역 내에서는 이동 가능한 2개로 분할 안된 것
			if(!visited[i]) return false;
		}
		return true;
	}
	
	public static void dfs(int country) {	//dfs를 수행해서 같은 구역에 속해있는 모든 요소들의 visited값을 true로 바꾸기
		visited[country] = true;
		for(int i=0; i<num; i++) {
			if(adj[country][i] && !visited[i] && division[country]==division[i]) {
				dfs(i);
			}
		}
	}
	
	public static void calc() {	//각 구역의 인구수 차이 계산
		int tmp=0;
		for(int i=0; i<num; i++) {	//true구역 내의 인구수 계산
			if(division[i] == true) tmp+=population[i];
		}
		result = Math.min(result, Math.abs((total_population - tmp) - tmp));	//두 구역의 인구수 차이 구하기
	}
}
