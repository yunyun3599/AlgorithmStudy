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

public class _7562_최윤재_나이트의이동 {
	
	static int[] y_case = {-2,-2,-1,-1,2,2,1,1};		//나이트가 이동 가능한 경우의 수들
	static int[] x_case = {-1,1,-2,2,-1,1,-2,2};
	static int testcase;
	static int width;
	static boolean[][] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testcase = Integer.parseInt(br.readLine());
		while(testcase-- > 0) {								//테스트 케이스만큼 반복
			width = Integer.parseInt(br.readLine());
			visited= new boolean[width][width];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			Loc knight = new Loc(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0);
			st = new StringTokenizer(br.readLine()," ");
			Loc dest = new Loc(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0);		//입력
			Queue<Loc> q = new LinkedList<>();
			q.add(knight);
			while(!q.isEmpty()) {							//bfs 수행
				Loc tmp = q.poll();
				if (tmp.x == dest.x && tmp.y == dest.y) {	//도착지에 도착했을 시에
					sb.append(tmp.move+"\n");				//얼마나 움직였는지 출력
					break;
				}
				for(int i=0; i<8; i++) {					//이동 가능한 경우의 수로 이동
					int next_x = tmp.x + x_case[i];
					int next_y = tmp.y + y_case[i];
					if (check(next_x, next_y)) {			//해당 자리가 이동 가능한 자리인지 확인
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