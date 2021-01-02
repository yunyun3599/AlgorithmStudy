package graph;

import java.util.*;
public class _1389_최윤재 {
	
	static int user;
	static int relation;
	static int[][] adj;
	static int min=100000000;
	static int min_user;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		user=sc.nextInt();
		relation=sc.nextInt();
		adj=new int[user][user];
		for(int i=0; i<relation; i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			adj[a-1][b-1]=1;			//서로 아는 경우 인접행렬의 해당 값을 1로 만들어줌
			adj[b-1][a-1]=1;
		}
		
		/////////////////여기까지 입력//////////////
		
		for(int i=0; i<user; i++) {		//각 user에 대한 bfs 수행
			bfs(i);
		}
		System.out.println(min_user);
	}
	
	static void bfs(int n) {			//bfs
		int result[]=new int[user];		//각 user에 대한 거리 총합을 저장할 배열
		int visited[] = new int[user];
		int sum=0;
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);						//타겟 user를 queue에 넣음으로써 시작
		visited[n]=1;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for(int i=0; i<user; i++) {	
				if(adj[tmp][i]==1 && visited[i]==0) {		//인접해있고 아직 방문하지 않은 경우 queue에 넣음
					result[i]=result[tmp]+1;
					q.add(i);
					visited[i]=1;
				}
			}
		}
		for(int i=0; i<user; i++) {		//result값들을 다 더해 해당 유저가 다른 유저들에 대해 갖는 거리 저장
			sum+=result[i];
		}
		if(min>sum) {					//총 거리가 기존 최소거리보다 작으면 이번 user를 min_user로 새로 지정
			min=sum;
			min_user=n+1;
		}
		else if(min==sum) {				//거리가 같은 경우는 더 작은 user#를 가진 사람이 min_user
			min_user= min_user < n+1 ? min_user : n+1;
		}
	}
}
