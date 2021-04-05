package tmp;
import java.io.*;
import java.util.*;
public class _3190_최윤재_뱀 {

	static int[][] map;
	static int sec;
	static int width;
	static int[] axis_x = {1, 0, -1, 0};	//동북서남
	static int[] axis_y = {0, -1, 0, 1};
	static int head_dir = 0;	//head의 방향
	static int head_y = 0;	//머리 좌표
	static int head_x = 0;
	static int tail_dir = 0;	//tail 방향
	static int tail_y = 0;	//꼬리 좌표
	static int tail_x = 0;
	static int snake = 2;	//뱀이 있는 위치를 표시하기 위한 숫자.
	static LinkedList<int[]> dirList = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		width = Integer.parseInt(br.readLine());
		int apple = Integer.parseInt(br.readLine());	//사과개서
		map = new int[width][width];
		StringTokenizer st;
		for(int i=0; i<apple; i++) {	//사과를 map상 1로 표시
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			map[y][x] = 1;
		}
		
		int change_num = Integer.parseInt(br.readLine());	//방향을 바꾸는 경우의 개수
		for(int i=0; i<change_num; i++) {
			st= new StringTokenizer(br.readLine()," ");
			int time = Integer.parseInt(st.nextToken());
			int dir = (st.nextToken().equals("D")) ? 3 : 1;	//오른쪽이면 3으로 표시, 왼쪽이면 1로 표시
			dirList.add(new int[] {time, dir});	//방향을 바꾸는 시간과 방향을 dirlist에 저장
		}
		
		int[] turn = dirList.poll();	//다음 차례로 바꿀 시간과 방향 turn에 저장
		
		map[0][0] = snake++;	//처음 시작하는 뱀의 위치
		while(true) {			
			if(sec == turn[0]) {	//방향을 바꿀 시간이 되었을 떄
				head_dir = (head_dir + turn[1]) % 4;	//현재 방향을 기준으로 새 방향을 계산
				if(!dirList.isEmpty()) turn = dirList.poll();	//그 다음으로 바꿀 시간과 방향을 turn에 저장
			}
			head_y += axis_y[head_dir];	//다음으로 head가 향할 y좌표
			head_x += axis_x[head_dir];	//다음으로 head가 향할 x좌표
			sec++;		//시간 증가
			if((!check(head_y, head_x)) || map[head_y][head_x] > 1) break;	//게임을 끝내야하는 경우 (map밖으로 나가거나 뱀의 몸에 부딪힘)
			if (map[head_y][head_x] == 1) {		//사과 먹는 경우
				map[head_y][head_x] = snake++;	//머리 위치를 뱀이 있음을 표시하는 값으로 바꾸기
				continue;	//머리 뒤쪽 부분은 그냥 두면 됨ㄹ
			}
			else {	//사과 없는 경우
				map[head_y][head_x] = snake++;	//머리가 새로 이동한 위치에 뱀이 있음을 표시하는 값 넣기
				int next_tail_y = tail_y + axis_y[tail_dir];	//다음 꼬리의 위치를 현재 꼬리의 방향 기준으로 계산
				int next_tail_x = tail_x + axis_x[tail_dir];
				if(check(next_tail_y, next_tail_x) && map[next_tail_y][next_tail_x] == map[tail_y][tail_x] + 1) {	//꼬리의 방향을 바꾸지 않아도 되는 경우
					map[tail_y][tail_x] = 0;
					tail_y = next_tail_y;
					tail_x = next_tail_x;
				}
				else {		//꼬리의 방향을 바꿔야하는 경우
					for(int k=0; k<4; k++) {	//4방향을 탐색하며 꼬리방향을 어디로 바꿔야하는지 확인
						next_tail_y = tail_y + axis_y[k];
						next_tail_x = tail_x + axis_x[k];
						if(check(next_tail_y, next_tail_x) && map[next_tail_y][next_tail_x] == map[tail_y][tail_x] + 1) {	//현재 꼬리값보다 1 큰값의 방향으로 바꿔야함
							map[tail_y][tail_x] = 0;	//현재 꼬리는 뱀이 이동했으므로 0으로 바꿔준다
							tail_dir = k;			//새로운 꼬리 방향 저장
							tail_y = next_tail_y;	//새로운 꼬리 좌표 저장
							tail_x = next_tail_x;
							break;
						}
					}
				}
			}
		}
		System.out.println(sec);
	}
	public static boolean check(int y, int x) {	//map안쪽에 있는지 확인
		if(0<=y && 0<=x && y<width && x<width) return true;
		return false;
	}

}
