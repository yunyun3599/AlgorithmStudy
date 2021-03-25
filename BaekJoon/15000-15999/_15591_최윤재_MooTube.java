package week18;
import java.io.*;
import java.util.*;


class Video implements Comparable<Video>{		//queue�� ���� ���� ��ü
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

public class _15591_������_MooTube {
	
	static ArrayList<Video>[] map;	//���� ������ ���� �迭
	static boolean[] checked;	//�̹� �ش� ���� �������� ����� �� �ִ��� Ȯ�ο�
	static int[][] result;		//����� ���� �迭
	static boolean[] visited;	//�湮 ���� Ȯ��
	static int video;	//���� ����
	static int question;//���� ����
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
		///////////////////////////////////////////////////������� �Է�
		for(int i=0; i<question; i++) {		//�� ������ ���� ó��
			visited = new boolean[video+1];	//�� visited�迭 ����
			st = new StringTokenizer(br.readLine());
			int threshold = Integer.parseInt(st.nextToken());	//���� ������
			int node = Integer.parseInt(st.nextToken());		//������ ���� ���
			int tmp_result = 0;		//�ش� ������ ���� ��
			if(!checked[node]) {	//���� ���� �� ���� ��쿡�� bfs ����
				bfs(node);
				checked[node] = true;
			}
			for(int j=1; j<video+1; j++) {	//������ ������ �ѱ�� ������ ����
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
			for(Video next: map[tmp.num]) {	//���� �ִ� ����� ����� �͵鿡 ���� ǯ
				if(!visited[next.num]) {
					result[start][next.num] = Math.min(tmp.weight, next.weight);	//result�� ���� ����Ǿ� �ִ� ���� ����ġ�� ����Ǿ� �ִ� ����� result�� �� �� ���� ������ ����
					q.add(new Video(next.num, result[start][next.num]));
				}
			}
		}
	}

}
