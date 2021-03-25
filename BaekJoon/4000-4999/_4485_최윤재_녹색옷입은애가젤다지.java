package week13;
import java.util.*;
import java.io.*;
public class _4485_√÷¿±¿Á_≥Ïªˆø ¿‘¿∫æ÷∞°¡©¥Ÿ¡ˆ {

	static int[] axis_x = {0, 0, -1, 1};
	static int[] axis_y = {-1, 1, 0, 0};
	static int width = 0;
	static int[][] map;
	static int [][] dp;
	static boolean[][] visited;
	static int testcase = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		width = Integer.parseInt(br.readLine());
		while(width != 0) {
			testcase++;
			map = new int[width][width];
			dp = new int[width][width];
			visited = new boolean[width][width];
			for(int i=0; i<width; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<width; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dp[0][0] = map[0][0];
			PriorityQueue<Node> pqueue = new PriorityQueue<>();
			pqueue.add(new Node(0,0,map[0][0]));
			visited[0][0] = true;
			while(!pqueue.isEmpty()) {
				Node loc = pqueue.poll();
				if(!visited[loc.y][loc.x] || dp[loc.y][loc.x] > loc.weight) dp[loc.y][loc.x] = loc.weight;
				visited[loc.y][loc.x] = true;
				for(int i=0; i<4; i++) {
					int next_y = loc.y + axis_y[i];
					int next_x = loc.x + axis_x[i];
					if(check(next_y, next_x)) pqueue.add(new Node(next_y, next_x, loc.weight + map[next_y][next_x]));
				}
			}
		bw.write("Problem "+testcase+": "+dp[width-1][width-1]+"\n");
		width = Integer.parseInt(br.readLine());
		}
		bw.flush();
		bw.close();
	}
	public static boolean check(int y, int x) {
		if (0<= y && y<width && 0<=x && x<width && !visited[y][x]) return true;
		return false;
				
	}
}

class Node implements Comparable<Node> {
	int y;
	int x;
	int weight;
	Node(int y, int x, int weight){
		this.y = y;
		this.x = x;
		this.weight = weight;
	}
	public int compareTo(Node loc) {
		return this.weight > loc.weight ? 1 : -1;
	}
}
