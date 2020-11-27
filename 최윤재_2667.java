package graph;
import java.util.*;
import java.io.*;
public class 최윤재_2667 {
	
    static int n;
    static int[][] apartment; 
    static int[][] visited; 
    static int[] complex;
    static int idx = -1;
    static int axis_x[] = {0,0,1,-1};
    static int axis_y[] = {1,-1,0,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        apartment = new int[n][n];
        visited = new int[n][n];
        complex= new int[n*n];

        //전체 사각형 입력 받기
        for(int i=0; i<n; i++){
            String input = sc.next();
            for(int j=0; j<n; j++){
                apartment[i][j] = input.charAt(j)-'0';
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(apartment[i][j] == 1 && visited[i][j]==0){
                    idx++;
                    dfs(i,j);
                }
            }
        }

        Arrays.sort(complex);
        
        System.out.println(idx+1);
        for(int i=0; i<complex.length; i++){
            if(complex[i] != 0)  System.out.println(complex[i]);
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = 1;
        complex[idx]++;

        for(int i=0; i<4; i++){
            int next_x = x + axis_x[i];
            int next_y = y + axis_y[i];

            if(next_x >=0 && next_y >=0 && next_x < n && next_y < n){
                if(apartment[next_x][next_y] == 1 && visited[next_x][next_y]==0){
                    dfs(next_x,next_y);
                }
            }
        }
    }
}