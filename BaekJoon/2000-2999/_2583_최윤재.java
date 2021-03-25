package week10;
import java.util.*;
public class _2583_최윤재 {

	static int[] axis_x = {0, 0, -1, 1};					//상하좌우
	static int[] axis_y = {-1, 1, 0, 0};
	static int width;										//전체 높이, 폭
	static int height;
	static int num;											//직사각형 개수
	static int[][] map;										//전체 그림 형태 저장
	static int[][] visited;									//방문한 칸
	static ArrayList<Integer> result = new ArrayList();		//구분되는 영역의 크기 저장
	static int count;										//구분되는 영역 개수 저장
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		height = sc.nextInt();					
		width = sc.nextInt();
		num=sc.nextInt();
		
		map = new int[height][width];
		visited = new int[height][width];
		
		for(int i=0; i<num; i++) {
			int under_x = sc.nextInt();
			int under_y = sc.nextInt();
			int above_x = sc.nextInt();
			int above_y = sc.nextInt();
			for(int j=under_x; j<above_x; j++) {			//직사각형이 위치한 칸의 값을 1로 바꿔줌
				for(int k=under_y; k<above_y; k++) {
					map[k][j] = 1;
				}
			}
		}
		
		for(int i=0; i<width; i++) {						//아직 방문하지 않았고 직사각형이 없는 칸에 대해 dfs 수행
			for(int j=0; j<height; j++) {
				if(map[j][i]==0 && visited[j][i]==0) {
					result.add(dfs(i,j,0));					//결과 더함
					count++;								//영역 개수 더함
				}
			}
		}
		Collections.sort(result);							//결과 오름차순 정렬
		System.out.println(count);							//결과 print
		for(int i=0; i<result.size(); i++) {
			System.out.print(result.get(i)+" ");
		}
	}
	
	public static int dfs(int x, int y, int cnt) {			//dfs 함수
		cnt++;												//영역 크기 하나 증가시키기
		visited[y][x] = 1;									//방문 표시하기
		for(int i=0; i<4; i++) {							//상하좌우 탐색
			int next_x = x + axis_x[i];
			int next_y = y + axis_y[i];
			if(next_x >= 0 && next_y >= 0 && next_x < width && next_y < height && visited[next_y][next_x] == 0 && map[next_y][next_x]==0) {
				cnt = dfs(next_x, next_y, cnt);				
			}
		}
		return cnt;											//영역 크기 return
	}

}
