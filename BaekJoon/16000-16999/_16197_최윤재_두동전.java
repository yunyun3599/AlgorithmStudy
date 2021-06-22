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
	static Queue<Location> queue = new LinkedList<>();	//동전 위치 넣을 queue
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		map = new char[height][width];
		for(int i=0; i<height; i++) {		//입력
			String tmp = br.readLine();
			for(int j=0; j<width; j++) {
				map[i][j] = tmp.charAt(j);
				if(map[i][j]=='o') {
					queue.add(new Location(i,j,0));
				}
			}
		}
		while(!queue.isEmpty()) {	//queue가 빌 때까지 반복
			Location coin1 = queue.poll();	//동전 2개 poll	
			Location coin2 = queue.poll();
			if(coin1.count>9) {	//10번 넘게 버튼을 누른 경우
				System.out.println(-1);
				System.exit(0);
			}
			for(int k=0; k<4; k++) {	//상하좌우로 이동
				int next_y1 = coin1.y+axis_y[k];
				int next_x1 = coin1.x+axis_x[k];
				int next_y2 = coin2.y+axis_y[k];
				int next_x2 = coin2.x+axis_x[k];
				if(check(next_y1, next_x1) && !check(next_y2, next_x2)) {	//동전 중 하나만 판 밖으로 나간 경우
					System.out.println(coin1.count+1);
					System.exit(0);
				}
				else if(!check(next_y1, next_x1) && check(next_y2, next_x2)) {	//동전 중 하나만 판 밖으로 나간 경우
					System.out.println(coin1.count+1);
					System.exit(0);
				}
				else if(check(next_y1, next_x1) && check(next_y2, next_x2)) {	//동전 둘 다 판 안에 있는 경우
					if(map[next_y1][next_x1]!='#') 	//다음 위치가 벽일 때
						queue.add(new Location(next_y1, next_x1, coin1.count+1));
					else queue.add(new Location(coin1.y, coin1.x, coin1.count+1));	//다음 위치가 벽이 아닐 때
					if(map[next_y2][next_x2]!='#') 	//다음 위치가 벽일 때
						queue.add(new Location(next_y2, next_x2, coin2.count+1));
					else queue.add(new Location(coin2.y, coin2.x, coin2.count+1));	//다음 위치가 벽이 아닐 때
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
