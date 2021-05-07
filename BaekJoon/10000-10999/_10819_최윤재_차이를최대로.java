package tmp;
import java.io.*;
import java.util.*;
public class _10819_������_���̸��ִ�� {
	
	static int N;
	static int[] arr;
	static int max;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());		//���� ����
		arr = new int[N];		//���� �迭
		visited = new boolean[N];	//���Ǿ����� ǥ��
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}////////////////////////////////////////////////////�Է�
		for(int i=0; i<N; i++) {
			max = Math.max(max, backtracking(i, 0, 1));		//������ �ٲ㰡�� ����
		}
		System.out.println(max);
	}
	public static int backtracking(int prev, int res, int depth) {	//prev�� �տ� ���� ������ �ε���, res�� ���ݱ����� ���� ���, depth�� � �����
		int result = 0;
		if(depth==N) return res;	//��� ���� ����� ��� res ����
		visited[prev] = true;		//������ ���� ���� ����ߴٰ� ǥ��
		for(int i=0; i<N; i++) {	//�������� ����� ���� ����
			if(!visited[i]) {		//���� ������ ���� ���ڿ� ����
				result = Math.max(result, backtracking(i, res+Math.abs(arr[prev] - arr[i]), depth+1));	//������߿� �� ū���� result�� ����
			}
		}
		visited[prev] = false;
		return result;		//��� ����
	}
}



