package week19;
import java.io.*;
import java.util.*;

class Robot{			//로봇 위치와 방향
	int x;
	int y;
	int dir;
	Robot(int y, int x, int dir){
		this.y = y;
		this.x = x;
		this.dir = dir;	//0=북, 1=동, 2=남, 3=서
	}
}

public class _14503_최윤재_로봇청소기 {
	
	static int height;
	static int width;
	static int map[][];
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		map = new int[height][width];
		st = new StringTokenizer(br.readLine());
		Robot robot = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		for(int i=0; i<height; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<width; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//////////////////////////////////////////////여기까지 입력
		Queue<Robot> q = new LinkedList();
		q.add(robot);			//처음 위치를 queue에 넣음
		while(!q.isEmpty()) {	//queue가 빌 때까지
			Robot loc = q.poll();
			int x = loc.x;
			int y = loc.y;
			int dir = loc.dir;
			boolean clean = false;	//청소를 한 군데라도 할 수 있으면 true (후진해야하는지 확인용)
			if (map[y][x] == 0) {	//뽑은 위치가 아직 청소를 안했으면 result++
				map[y][x] = 2;		//청소를 이미 했다는 의미로 2로 숫자 바꿔줌
				result++;
			}
			Robot tmp;
			for(int i=0; i<4; i++) {
				tmp = move(new Robot(y, x, dir-i), 1);		//현 위치에서 4개방향 탐색
				if (check(tmp) && map[tmp.y][tmp.x]==0) {	//네 방향 중 청소 가능한 칸이 있으면 queue에 넣음
					q.add(tmp);
					clean = true;
					break;
				}
			}
			if(!clean) {		//후진해야하는 경우
				tmp = move(new Robot(y, x, dir + 1), -1);	//마지막으로 보게되는 방향에서 뒤로 후진 (보는 방향에 그대로니까 dir+1해서 넣어줌)
				if(check(tmp) && map[tmp.y][tmp.x] != 1) q.add(tmp);
			}
		}
		System.out.println(result);
	}
	
	public static Robot move(Robot robot, int front) {
		int ndir = (robot.dir-1);	//다음에 보게 될 방향 (왼쪽으로 돎)
		int nx = robot.x;
		int ny = robot.y;
		switch(ndir) {			//각 방향별로 어디로 가야할지
			case 0:
			case -4: ny -= front;
					ndir = 0;	//원래 방향값으로 안바꿔주면 계속해서 줄어듦
					break;
			case 1:
			case -3: nx += front;
					ndir = 1;
					break;
			case 2:  
			case -2: ny += front;
					ndir = 2;
					break;
			case 3:
			case -1: nx -= front;
					ndir = 3;
					break;
		}
		return new Robot(ny, nx, ndir);
	}
	public static boolean check(Robot robot) {	//위치가 가능한 위치인지 확인
		if (robot.y >=0 && robot.y < height && robot.x >=0 && robot.x < width) 
			return true;
		return false;
	}
}




