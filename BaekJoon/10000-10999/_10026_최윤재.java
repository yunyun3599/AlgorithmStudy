package graph;
import java.util.*;
import java.io.*;
public class _10026_최윤재 {

	static int axis_x[] = {0,0,-1,1};
	static int axis_y[] = {-1,1,0,0};	//상하좌우
	static int num;
	static char[][] map; 
	static int [][] visited;
	static int result1;
	static int result2;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		num = Integer.parseInt(br.readLine());
		map=new char[num][num];
		visited=new int[num][num];
				
		for (int i=0; i<num ; i++) {
			String line = br.readLine();
			for(int j=0; j<num; j++) {
				map[i][j]=line.charAt(j);
			}
		}
		
		////////////////여기까지가 입력////////////////////
		
		
		//정상인 사람이 보는 구역 개수
		for(int i=0; i<num;i++) {
			for(int j=0;j<num;j++) {
				if(visited[i][j]==0) {		//아직 방문하지 않은 경우에는 해당 칸부터 dfs 수행
					dfs(i,j);
					result1++;				//구역 개수 하나 늘림
				}
			}
		}
		
		//map을 빨=초 로 바꿈(G를 R로)
		for(int i=0; i<num;i++) {
			for(int j=0;j<num;j++) {
				if(map[i][j]=='G') map[i][j]='R';
				visited[i][j]=0;
			}
		}
		
		//적록색약인 사람이 보는 구역 개수
		for(int i=0; i<num;i++) {
			for(int j=0;j<num;j++) {
				if(visited[i][j]==0) {
					dfs(i,j);
					result2++;
				}
			}
		}
		
		System.out.printf("%d %d", result1, result2);
	}
	
	public static void dfs(int x, int y) {
        visited[x][y] = 1;

        for(int i=0; i<4; i++){					//상하좌우 탐색
            int next_x = x + axis_x[i];
            int next_y = y + axis_y[i];

            if(next_x >=0 && next_y >=0 && next_x < num && next_y < num){			//아직 방문하지 않고 같은 색인 경우 dfs 수행
                if(map[next_x][next_y] == map[x][y] && visited[next_x][next_y]==0){
                    dfs(next_x,next_y);
                }
            }
        }
    }

}
