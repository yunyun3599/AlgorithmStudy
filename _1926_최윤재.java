package week9;
import java.io.*;
import java.util.*;
public class _1926_최윤재 {

	static int height;									
	static int width;
	static int max;						//최종 최대 넓이
	static int tmp_max;					//각 그림 별 넓이
	static int count;					//그림 개수
	static int[][] map;
	static int[] axis_x= {0,0,-1,1};	//상하좌우
	static int[] axis_y= {-1,1,0,0};
	static int visited[][];
	
	public static void main(String[] args) throws IOException {
		Scanner sc= new Scanner(System.in);
		height=sc.nextInt();
		width=sc.nextInt();
		map=new int[height][width];
		visited=new int[height][width];
		
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				map[i][j]=sc.nextInt();
			}
		}
	//////////////////////////////////////////////////////////여기까지 입력
		for(int i=0; i<height; i++) {						//각 map의 원소마다 아직 방문하지 않았고 1이면 dfs 수행
			for (int j=0; j<width; j++) {
				if(visited[i][j]==0 && map[i][j]==1) {
					tmp_max++;								//넓이 1 넓힘
					dfs(i,j);								//dfs 수행
					if (tmp_max>max) max=tmp_max;			//해당 그림의 넓이가 현재 max값보다 크면 max값 업데이트
					count++;								//그림 개수++
					tmp_max=0;								//각 그림별 넓이 저장하는 변수 0으로 다시 세팅
				}
			}
		}
		System.out.println(count);							//결과 출력
		System.out.println(max);
	}
	
	public static void dfs(int y, int x) {					//dfs 수행
		visited[y][x]=1;
		for(int i=0; i<4; i++) {
			int next_x= x+axis_x[i];
			int next_y= y+axis_y[i];
			if(next_x>=0 && next_y >=0 && next_x<width && next_y<height && visited[next_y][next_x]==0 && map[next_y][next_x]==1) {
				dfs(next_y,next_x);
				tmp_max++;
			}
		}
	}
}


//그림
