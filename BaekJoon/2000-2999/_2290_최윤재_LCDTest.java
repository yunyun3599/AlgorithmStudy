package tmp;
import java.util.*;

public class _2290_최윤재_LCDTest {
	
	static int s;
	static String n;
	static char[][] result;
	static char[][] num = {
			{'-', ' ', '-', '|', '|', '|', '|'},	// 인덱스별 위치
			{' ', ' ', ' ', ' ', ' ', '|', '|'},	//   0
			{'-', '-', '-', ' ', '|', '|', ' '},	// 3   5
			{'-', '-', '-', ' ', ' ', '|', '|'},	//   1
			{' ', '-', ' ', '|', ' ', '|', '|'},	// 4   6
			{'-', '-', '-', '|', ' ', ' ', '|'},	//   2
			{'-', '-', '-', '|', '|', ' ', '|'},
			{'-', ' ', ' ', ' ', ' ', '|', '|'},
			{'-', '-', '-', '|', '|', '|', '|'},
			{'-', '-', '-', '|', ' ', '|', '|'}
	};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		s = Integer.parseInt(st.nextToken());
		n = st.nextToken();
		int width = (s+3)*n.length()-1;
		result = new char[2*s+3][width];
		
		for(int i=0; i<result.length; i++) {		//result배열의 값을 우선 다 ' '으로 채워둠
			for(int j=0; j<result[0].length; j++) {
				result[i][j] = ' ';
			}
		}
		
		int startloc = 0;
		for(int i=0; i<n.length(); i++) {
			int number = n.charAt(i) - '0';
			int y, x;
			for(int j=0; j<7; j++) {	//0번~7번까지의 자리를 반복해서 채워나가기
				y = 0;			//각 자리별 시작 인덱스(y,x)
				x = startloc;
				switch(j) {
				case 0:
					x = startloc + 1;
					break;
				case 1:
					x = startloc + 1;
					y = s + 1;
					break;
				case 2:
					x = startloc + 1;
					y = 2 * s + 2;
					break;
				case 3:
					y = 1;
					break;
				case 4:
					y = s + 2;
					break;
				case 5:
					x = startloc + s + 1;
					y = 1;
					break;
				case 6:
					x = startloc + s + 1;
					y = s + 2;
					break;
				}
				
				if(j<3) fill(y, x, 0, 1, num[number][j]);	//result배열에 채우는 함수 fill
				else fill(y, x, 1, 0, num[number][j]);		//가로로 채워야 할 때는 row=0, col=1 세로인 경우에는 그 반대로 파라미터 넘기기
			}
			startloc += s+3;
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<result.length; i++) {		//결과 stringbuffer에 저장 후 출력
			for(int j=0; j<result[0].length; j++)
				sb.append(result[i][j]);
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	public static void fill(int y, int x, int row, int col, char bar) {	//y,x는 시작 인덱스, row,col은 가로로 채울지 세로로 채울지, bar는 '|'인지 '-'인지
		if(bar==' ') return;	//공백부분이면 바로 리턴
		for(int i=0; i<s; i++, y+=row, x+=col) {	//s만큼 반복해서 채움
			result[y][x] = bar;
		}
	}

}
