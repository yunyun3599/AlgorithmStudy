package week15;
import java.util.*;

class Loc{					//각 상점의 위치
	int dir;
	int x;
	int y;
	Loc(int dir, int x, int y){
		this.dir = dir;
		this.x = x;
		this.y = y;
	}
}

public class _2564_최윤재_경비원 {

	static int width;
	static int height;
	static int store;
	static Loc[] map;
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		width = sc.nextInt();
		height = sc.nextInt();
		store = sc.nextInt();
		map = new Loc[store];
		
		for(int i=0; i<store; i++) {
			int dir = sc.nextInt();
			int offset = sc.nextInt();
			map[i] = setLocation(dir, offset);
		}
		///////////////////////////////////////////////상점 입력
		int dir = sc.nextInt();
		int offset = sc.nextInt();
		Loc dong = setLocation(dir, offset);
		//////////////////////////////////////////////동근이 위치 입력
		int exception = 0;							//마주보고 있는 변이 특수한 경우이므로 마주보는 방위를 exception변수에 저장
		if (dong.dir == 1) exception = 2;
		else if(dong.dir == 2) exception=1;
		else if (dong.dir == 3) exception = 4;
		else exception = 3;

		for(int i=0; i<store; i++) {
			Loc tmp = map[i];
			if (tmp.dir == exception) {				//평행한 경우
				int max = height + width;
				int point_x = width - dong.x;
				int point_y = height - dong.y;
				int diff = Math.abs(point_x - tmp.x) + Math.abs(point_y - tmp.y);	//최대 거리 지점에서 떨어진 만큼 빼주는 형식
				result += (max - diff);
			}
			else
				result += Math.abs(dong.x - tmp.x) + Math.abs(dong.y - tmp.y);		//평범한 경우
		}
		System.out.println(result);
		 
	}
	
	public static Loc setLocation(int dir, int offset) {							//좌표 반환
		Loc loc;
		switch(dir) {
		case 1:							//북 [0][x]
			loc = new Loc(dir, offset, 0);
			break;
		case 2:							//남 [height][x]
			loc = new Loc(dir, offset, height);
			break;
		case 3:							//서 [x][0]
			loc = new Loc(dir, 0, offset);
			break;	
		default:							//동 [width][x]
			loc = new Loc(dir, width, offset);
			break;
		}
		return loc;
	}
}
