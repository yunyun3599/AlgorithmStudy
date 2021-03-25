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

public class _1939_������_�߷����� {
	
	static int island;						//�� ����
	static int bridge_num;					//�ٸ� ����
	static ArrayList<Link>[] bridge;		//�ٸ� �迭
	static int factory1;					//�������
	static int factory2;					//��������
	static int max;							//�̺�Ž���� �� ���� ū �� (right)
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		island = Integer.parseInt(st.nextToken());
		bridge_num = Integer.parseInt(st.nextToken());
		bridge = new ArrayList[island];
		
		for(int i=0; i<island; i++) bridge[i] = new ArrayList<>();		//ArrayList ��ü �������
		
		for(int i=0; i<bridge_num; i++) {					//�Է�
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
		////////////////////////////////////////////////////////////////�Է�
		
		int left = 1;									//�ּҰ�
		int right = max;								//�ִ밪
		while(left <= right) {							//�̺�Ž��
			int mid = (left+right)/2;					//�߰���
			boolean[] visited = new boolean[island];	//�湮���� ó��
			if(dfs(factory1, mid, visited)) {			//�ش� mid���� weight�� ���� �� �����ϸ�
				left = mid+1;							//mid���� �� Ű���� �� Ž��
				result = mid;
			}
			else {										//mid���� weight�� ���� �� �Ұ��� �ϸ�
				right = mid-1;							//mid���� �� �ٿ��� Ž��
			}
		}
		
		System.out.println(result);
		
	}
	public static boolean dfs(int loc, int weight, boolean[] visited) {	//�ش� weight�� �������� Ȯ���ϱ� ���� dfs �̿�
		if(visited[loc]) return false;					//�̹� Ž���� ���� ���� false�� return (�Ұ����� ���)
		visited[loc] = true;
		
		if (loc == factory2) {							//�������� ���� ���� true�� return
			return true;
		}
		for(int i=0; i<bridge[loc].size(); i++) {		//���� �� ���� ���� ����
			Link tmp = bridge[loc].get(i);
			if(tmp.weight >= weight) {					//�ٸ��� ��ƿ �� �ִ� ���԰� weight���� Ŀ����
				if(dfs(tmp.dest, weight, visited)) return true;
			}
		}
		return false;
	}

}
