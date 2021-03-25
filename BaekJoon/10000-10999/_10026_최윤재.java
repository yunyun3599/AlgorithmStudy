package graph;
import java.util.*;
import java.io.*;
public class _10026_������ {

	static int axis_x[] = {0,0,-1,1};
	static int axis_y[] = {-1,1,0,0};	//�����¿�
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
		
		////////////////��������� �Է�////////////////////
		
		
		//������ ����� ���� ���� ����
		for(int i=0; i<num;i++) {
			for(int j=0;j<num;j++) {
				if(visited[i][j]==0) {		//���� �湮���� ���� ��쿡�� �ش� ĭ���� dfs ����
					dfs(i,j);
					result1++;				//���� ���� �ϳ� �ø�
				}
			}
		}
		
		//map�� ��=�� �� �ٲ�(G�� R��)
		for(int i=0; i<num;i++) {
			for(int j=0;j<num;j++) {
				if(map[i][j]=='G') map[i][j]='R';
				visited[i][j]=0;
			}
		}
		
		//���ϻ����� ����� ���� ���� ����
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

        for(int i=0; i<4; i++){					//�����¿� Ž��
            int next_x = x + axis_x[i];
            int next_y = y + axis_y[i];

            if(next_x >=0 && next_y >=0 && next_x < num && next_y < num){			//���� �湮���� �ʰ� ���� ���� ��� dfs ����
                if(map[next_x][next_y] == map[x][y] && visited[next_x][next_y]==0){
                    dfs(next_x,next_y);
                }
            }
        }
    }

}
