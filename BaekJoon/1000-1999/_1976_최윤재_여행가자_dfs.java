package tmp;
import java.io.*;
import java.util.*;
public class _1976_������_���డ��_dfs {

	static int num;			//�� ���� ����
	static int visit_num;	//�湮�� ���� ����
	static int[][] adj;		//�������
	static StringTokenizer st;
	static boolean[] visited;	//�湮ó��
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		visit_num = Integer.parseInt(br.readLine());
		adj = new int[num][num];
		for(int i=0; i<num; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<num; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}/////////////////////////////////////////////////////////�Է�
		st = new StringTokenizer(br.readLine());
		boolean flag = true;	//�켱�� �����ϴٰ� �س���
		int from;				//������ �����ߴ� ����
		int to = Integer.parseInt(st.nextToken())-1;	//�������� �̵��� ����
		while(st.hasMoreTokens()) {	//�� ���õ��� �� ������������
			visited = new boolean[num];	//�湮ó����
			from = to;	//������ �������� �̹� ���������� �����
			to = Integer.parseInt(st.nextToken())-1;	//���ο� ������ �ޱ�
			if (from==to) continue;		//���࿡ ���� ���ø� �� �����ϴ� ���� ������ true�ϱ� continue (���ߴٰ� Ʋ���� ���̾���)
			flag &= dfs(from,to);	//��� ��쿡 ���� ������ �����ؾ��ϹǷ� and������ �̿��ؼ� �ϳ��� �ȵǴ� ���� flag�� false�̵��� ��
		}
		if(flag) System.out.println("YES");
		else System.out.println("NO");
	}
	public static boolean dfs(int city, int dest) {	//dfs�����ؼ� �� �� �ִ��� Ȯ��
		boolean flag = false;	//�켱�� �����ٰ� �س���
		visited[city] = true;	//�湮ó��
		for(int i=0; i<num; i++) {	//�� �� �ִ� ���õ鿡 ���� ��������� dfs����
			if(adj[city][i]==1 && !visited[i]) {	//�� �� �ִ� ���� �ְ� ���� �湮 ���� ���
				if(i==dest) return true;	//������ �� ���ð� �������� true ����
				else flag = flag | dfs(i, dest);	//��� ����߿� �ѹ��̶� ���� �����ϸ� �ǹǷ� or���� �̿��ؼ� true�� �ϳ��� �ֳ� Ȯ��
			}
		}
		return flag; //flag ����
	}

}
