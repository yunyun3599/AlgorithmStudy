package tmp;
import java.util.*;
public class _2580_√÷¿±¿Á_Ω∫µµƒÌ {

	static int sudoku[][] = new int[9][9];
	static boolean visited_row[][] = new boolean[9][10];
	static boolean visited_col[][] = new boolean[9][10];
	static boolean visited_box[][][] = new boolean[3][3][10];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<9; i++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			for(int j =0; j<9; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
				visited_row[i][sudoku[i][j]] = true;
				visited_col[j][sudoku[i][j]] = true;
				visited_box[i/3][j/3][sudoku[i][j]] = true;
			}
		}
		dfs(0,0);
	}

	static boolean visitCheck(int y, int x, int num) {
		return !visited_row[y][num] && !visited_col[x][num] && !visited_box[y/3][x/3][num];
	}
	
	static void updateVisit(int y, int x, int num,boolean bool) {
		visited_row[y][num] = bool;
		visited_col[x][num] = bool;
		visited_box[y/3][x/3][num] = bool;
	}
	
	static void goNext(int y, int x) {
		int row = y + (x/8);
		int col = (x+1) % 9;
		dfs(row, col);
	}
	
	static void dfs(int y, int x) {
		if(y==9) {
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(sudoku[i][j]+" ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		if(sudoku[y][x]==0) {
			for(int i=1; i<10; i++) {
				if(visitCheck(y,x,i)) {
					updateVisit(y,x,i,true);
					sudoku[y][x] = i;
					goNext(y,x);
					updateVisit(y,x,i,false);
				}
			}
			sudoku[y][x] = 0;
		}
		else {
			goNext(y,x);
		}
	}
}
