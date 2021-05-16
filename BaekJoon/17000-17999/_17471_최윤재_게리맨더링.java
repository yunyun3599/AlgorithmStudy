package tmp;
import java.io.*;
import java.util.*;
public class _17471_������_�Ը��Ǵ��� {

	static int num;					//���� ����
	static int total_population;	//��� ����� �� �α����� ��
	static int[] population;		//�� ���� �α���
	static boolean[] visited;		//���� ����Ǿ��ִ��� Ȯ���ϴ� dfs�� �� ��
	static boolean[] division;		//�� ���� ��� ������ �����ִ��� ǥ��
	static boolean[][] adj;			//�������
	static int result=Integer.MAX_VALUE;	//�ּ� ���� �� ������ ����
	
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
		//////////////////////////////////////////////////////�Է�
		for(int limit=1; limit<num; limit++) {		//�� �������� ����� ���������� limit���� ���� (limit<=num/2�� �� �ȵǴ� ��?)
			for(int i=0; i<num-limit+1; i++) {		//i��° �������� limit�� ����
				divide(i, 0, limit);
			}
		}
		if (result == Integer.MAX_VALUE) System.out.println(-1);	//������ �� ��쿡�� -1�� ���
		else System.out.println(result);			//��� ���
	}
	
	public static void divide(int include, int count, int limit) {
		if(count==limit) {		//��� ������ �� ������ ��� ������ Ȯ��
			if(connected()) calc(); //�� ������ �� ���� ���ο��� ����Ǿ������� �α� �� ���� ���
			return;
		}
		division[include] = true;	//�̹��� �޾ƿ� ���� true������ �߰�
		for(int i=include+1; i<num-(limit-count)+1; i++) {	//������ true������ �߰��� ����
			divide(i, count+1, limit);
		}
		division[include] = false;
	}
	
	public static boolean connected() {	
		visited = new boolean[num];	//�� ������ dfs�ι� ������ ��� ��� �湮�Ǿ����� Ȯ���ϱ� ����
		for(int i=0; i<num; i++) {	//true�� ������ dfs�� visitedǥ��
			if(division[i]) {
				dfs(i);
				break;
			}
		}
		for(int i=0; i<num; i++) {	//false�� ������ dfs�� visitedǥ��
			if(!division[i]) {
				dfs(i);
				break;
			}
		}
		for(int i=0; i<num; i++) {	//visited�迭�� �ϳ��� false�� ���� �������� �̵� ������ 2���� ���� �ȵ� ��
			if(!visited[i]) return false;
		}
		return true;
	}
	
	public static void dfs(int country) {	//dfs�� �����ؼ� ���� ������ �����ִ� ��� ��ҵ��� visited���� true�� �ٲٱ�
		visited[country] = true;
		for(int i=0; i<num; i++) {
			if(adj[country][i] && !visited[i] && division[country]==division[i]) {
				dfs(i);
			}
		}
	}
	
	public static void calc() {	//�� ������ �α��� ���� ���
		int tmp=0;
		for(int i=0; i<num; i++) {	//true���� ���� �α��� ���
			if(division[i] == true) tmp+=population[i];
		}
		result = Math.min(result, Math.abs((total_population - tmp) - tmp));	//�� ������ �α��� ���� ���ϱ�
	}
}
