package graph;

import java.util.*;
public class _1389_������ {
	
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
			adj[a-1][b-1]=1;			//���� �ƴ� ��� ��������� �ش� ���� 1�� �������
			adj[b-1][a-1]=1;
		}
		
		/////////////////������� �Է�//////////////
		
		for(int i=0; i<user; i++) {		//�� user�� ���� bfs ����
			bfs(i);
		}
		System.out.println(min_user);
	}
	
	static void bfs(int n) {			//bfs
		int result[]=new int[user];		//�� user�� ���� �Ÿ� ������ ������ �迭
		int visited[] = new int[user];
		int sum=0;
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);						//Ÿ�� user�� queue�� �������ν� ����
		visited[n]=1;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			for(int i=0; i<user; i++) {	
				if(adj[tmp][i]==1 && visited[i]==0) {		//�������ְ� ���� �湮���� ���� ��� queue�� ����
					result[i]=result[tmp]+1;
					q.add(i);
					visited[i]=1;
				}
			}
		}
		for(int i=0; i<user; i++) {		//result������ �� ���� �ش� ������ �ٸ� �����鿡 ���� ���� �Ÿ� ����
			sum+=result[i];
		}
		if(min>sum) {					//�� �Ÿ��� ���� �ּҰŸ����� ������ �̹� user�� min_user�� ���� ����
			min=sum;
			min_user=n+1;
		}
		else if(min==sum) {				//�Ÿ��� ���� ���� �� ���� user#�� ���� ����� min_user
			min_user= min_user < n+1 ? min_user : n+1;
		}
	}
}
