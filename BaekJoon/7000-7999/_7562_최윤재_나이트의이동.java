package week16;
import java.io.*;
import java.util.*;

class Loc{
	int x;
	int y;
	int move;
	Loc(int x, int y, int move){
		this.x = x;
		this.y = y;
		this.move = move;
	}
}

public class _7562_������_����Ʈ���̵� {
	
	static int[] y_case = {-2,-2,-1,-1,2,2,1,1};		//����Ʈ�� �̵� ������ ����� ����
	static int[] x_case = {-1,1,-2,2,-1,1,-2,2};
	static int testcase;
	static int width;
	static boolean[][] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testcase = Integer.parseInt(br.readLine());
		while(testcase-- > 0) {								//�׽�Ʈ ���̽���ŭ �ݺ�
			width = Integer.parseInt(br.readLine());
			visited= new boolean[width][width];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			Loc knight = new Loc(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0);
			st = new StringTokenizer(br.readLine()," ");
			Loc dest = new Loc(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0);		//�Է�
			Queue<Loc> q = new LinkedList<>();
			q.add(knight);
			while(!q.isEmpty()) {							//bfs ����
				Loc tmp = q.poll();
				if (tmp.x == dest.x && tmp.y == dest.y) {	//�������� �������� �ÿ�
					sb.append(tmp.move+"\n");				//�󸶳� ���������� ���
					break;
				}
				for(int i=0; i<8; i++) {					//�̵� ������ ����� ���� �̵�
					int next_x = tmp.x + x_case[i];
					int next_y = tmp.y + y_case[i];
					if (check(next_x, next_y)) {			//�ش� �ڸ��� �̵� ������ �ڸ����� Ȯ��
						q.add(new Loc(next_x, next_y, tmp.move+1));
						visited[next_y][next_x] = true;
					}
				}
			}
		}
		System.out.println(sb);
	}
	public static boolean check(int x, int y) {
		if (0<=x && 0<=y && x<width && y<width && !visited[y][x]) return true;
		return false;
	}

}