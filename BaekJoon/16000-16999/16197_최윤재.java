package tmp;
import java.io.*;
import java.util.*;
class Location{			//queue에 넣을 위치
	int y;
	int x;
	int count;
	Location(int y, int x, int count){
		this.y = y;
		this.x = x;
		this.count = count;
	}
}
public class _16197_최윤재_두동전 {

	static char[][] map;
	static int height;
	static int width;
	static int[] axis_x = {0,0,-1,1};
	static int[] axis_y = {-1,1,0,0};
	static Queue<Location> queue1 = new LinkedList<>();
	static Queue<Location> queue2 = new LinkedList<>();
	static boolean[][] visited1;
	static boolean[][] visited2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		map = new char[height][width];
		visited1 = new boolean[height][width];
		visited2 = new boolean[height][width];
		for(int i=0; i<height; i++) {
			String tmp = br.readLine();
			for(int j=0; j<width; j++) {
				map[i][j] = tmp.charAt(j);
				if(map[i][j]=='o') {
					queue1.add(new Location(i,j,0));
				}
			}
		}
		queue2.add(queue1.poll());
		visited1[queue1.peek().y][queue1.peek().x]=true;
		visited2[queue2.peek().y][queue2.peek().x]=true;
		while(!queue1.isEmpty()) {
			Location coin1 = queue1.poll();
			Location coin2 = queue2.poll();
			visited1[coin1.y][coin1.x] = true;
			visited2[coin2.y][coin2.x] = true;
			if(coin1.count>9) {
				System.out.println(-1);
				System.exit(0);
			}
			for(int k=0; k<4; k++) {
				int next_y1 = coin1.y+axis_y[k];
				int next_x1 = coin1.x+axis_x[k];
				int next_y2 = coin2.y+axis_y[k];
				int next_x2 = coin2.x+axis_x[k];
				if(check(next_y1, next_x1) && !check(next_y2, next_x2)) {
					System.out.println(coin1.count+1);
					System.exit(0);
				}
				else if(!check(next_y1, next_x1) && check(next_y2, next_x2)) {
					System.out.println(coin1.count+1);
					System.exit(0);
				}
				else if(check(next_y1, next_x1) && check(next_y2, next_x2)) {
					if(visited1[next_y1][next_x1] || visited2[next_y2][next_x2]) continue;
					if(map[next_y1][next_x1]=='#' && map[next_y2][next_x2]=='#') continue;
					if(map[next_y1][next_x1]!='#') 
						queue1.add(new Location(next_y1, next_x1, coin1.count+1));
					else queue1.add(new Location(coin1.y, coin1.x, coin1.count+1));
					if(map[next_y2][next_x2]!='#') 
						queue2.add(new Location(next_y2, next_x2, coin2.count+1));
					else queue2.add(new Location(coin2.y, coin2.x, coin2.count+1));
				}
			}
		}
		System.out.println(-1);
	}
	public static boolean check(int y, int x) {
		if(y>=0 && x>=0 && y<height && x<width)
			return true;
		return false;
	}

}
