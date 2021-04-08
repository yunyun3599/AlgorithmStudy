package tmp;
import java.io.*;
import java.util.*;
public class _3967_최윤재_매직스타 {
	
	static char[][] final_map = new char[5][9];	//최종 출력할 것
	static int[][] map = new int[5][9];		//int 값으로 저장해놓을 map (계산시 쓸 map)
	static boolean[] used = new boolean[12];	//1-12중 이미 사용된 값이면 true
	static String result = "";	//최종 결과 String을 저장
	static ArrayList<int[]> empty_loc = new ArrayList<>();	//채워야하는 값의 위치
	static int[][] loc = {{0,4},{1,1},{1,3},{1,5},{1,7},{2,2},{2,6},{3,1},{3,3},{3,5},{3,7},{4,4}};	//숫자가 존재하는 곳의 위치
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<5; i++) {
			String tmp = br.readLine();
			for(int j=0; j<9; j++) {
				char tmp_char = tmp.charAt(j);
				int tmp_num = tmp_char - 'A' + 1;
				if(0 < tmp_num && tmp_num < 13) {	//알파벳이 들어가있으면 1-12값 넣음
					map[i][j] = tmp_num;
					used[tmp_num-1] = true;
				}
				else if(tmp_char=='.') map[i][j] = -1;	//채우지 않을 곳은 -1
				else {		//아직 수가 차지 않은 곳은 0
					map[i][j] = 0;
					empty_loc.add(new int[] {i,j});
				}
				final_map[i][j] = tmp_char;
			}
		}
		fill(0);	//채우기 수행
		int idx = 0;
		for(int[] yx : loc ) {
			final_map[yx[0]][yx[1]] = result.charAt(idx++);	//결과로 받아온 String을 토대로 finalmap값 수정
		}
		for(int i=0; i<5; i++) {	//결과 출력
			for(int j=0; j<9; j++) {
				System.out.print(final_map[i][j]);
			}System.out.println();
		}
	}
	public static void fill(int idx) {	//값 채우기
		if(idx == empty_loc.size()) {	//모든 값이 채워진 경우
			if(calc()) {	//모든 선이 26인지 확인
				for(int i=0; i<12; i++) {	//맞다면 char값을 더해 result에 string값 넣기
					result += Character.toString((char)((map[loc[i][0]][loc[i][1]]-1)+'A'));
				}
			}
			return;
		}
		int[] yx = empty_loc.get(idx);	//이번에 탐색할 곳의 x,y좌표
		int y = yx[0]; int x = yx[1];
		for(int i=1; i<13; i++) {
			if(used[i-1]) continue;	//이미 쓰인 값이면 continue
			map[y][x] = i;	//아직 안쓰인 값 넣기
			used[i-1] = true;//썼다고 표시
			fill(idx+1);
			used[i-1] = false;
			if(!result.equals(""))return;	//이미 result가 나온 경우는 더이상 할 필요 없으니까 return (이거 안썼다가 시간초과남)
		}
	}
	
	public static boolean calc() {	//모든 line의 값이 26인지 확인
		int line1=0, line2=0, line3=0, line4=0, line5=0, line6=0;
		line1 = map[0][4]+map[1][3]+map[2][2]+map[3][1];
		line2 = map[0][4]+map[1][5]+map[2][6]+map[3][7];
		line3 = map[1][1]+map[1][3]+map[1][5]+map[1][7];
		line4 = map[1][1]+map[2][2]+map[3][3]+map[4][4];
		line5 = map[1][7]+map[2][6]+map[3][5]+map[4][4];
		line6 = map[3][1]+map[3][3]+map[3][5]+map[3][7];
		if(line1==26 && line2==26 && line3==26 && line4==26 && line5==26 && line6==26) return true;
		return false;
	}

}
