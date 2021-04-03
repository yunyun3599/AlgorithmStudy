package tmp;
import java.io.*;
import java.util.*;
public class _14500_최윤재_테트로미노 {

	static int height;
	static int width;
	static ArrayList<int[][]> maps = new ArrayList<>();		//map에대해 왼쪽으로 돌린 것 4종류, 상하반전 후 왼쪽으로 돌린 것 4종류
	static ArrayList<int[][]> shapes = new ArrayList<>();	//해당 모양으로 움직이기 위한 좌표 값 넣을 것
	static int result = 0;	//결과
	
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		 height = Integer.parseInt(st.nextToken());
		 width = Integer.parseInt(st.nextToken());
		 
		 shapes.add(new int[][] {{0,0,1,1},{0,1,0,1}});	//ㅁ모양을 탐색하기 위한 좌표이동 값
		 shapes.add(new int[][] {{0,0,0,0},{0,1,2,3}});	//ㅡ모양
		 shapes.add(new int[][] {{0,0,0,1},{0,1,2,1}});	//ㅜ모양
		 shapes.add(new int[][] {{0,1,1,2},{0,0,1,1}}); //ㄹ모양
		 shapes.add(new int[][] {{0,0,0,1},{0,1,2,0}}); //ㄱ모양
		 
		 int[][] firstmap = new int[height][width];	//처음 기준이 되는 map입력받기
		 for(int i=0; i<height; i++) {
			 st = new StringTokenizer(br.readLine()," ");
			 for(int j=0; j<width; j++) {
				 firstmap[i][j] = Integer.parseInt(st.nextToken());
			 }
		 }
		 maps.add(firstmap);	//기준 map모양 ArrayList에 저장
		 for(int i=0; i<3; i++) {	//왼쪽으로 3번 돌려서 이 값 ArrayList에 넣음
			int[][] tmp = rotate(i);
			maps.add(tmp);
		 }
		 maps.add(upsidedown());	//위아래 반전한 map 모양 ArrayList에 넣음
		 for(int i=4; i<7; i++) {	//위아래 반전한 map기준으로 왼쪽으로 3번 돌림
			 int[][] tmp = rotate(i);
			 maps.add(tmp);
		 }
		 
		 for(int[][] shape : shapes) {	//각 모양에 대해 돌아간 map모양으로 탐색
			 for(int[][] map : maps) {
				 for(int i=0; i<map.length; i++) {
					 for(int j=0; j<map[0].length; j++) {
						 int tmp = 0;
						 for(int k=0; k<4; k++) {
							 int y = i+shape[0][k];
							 int x = j+shape[1][k];
							 if(check(y,x,map)) {	//범위내에 있으면 탐색
								 tmp+=map[y][x];
							 }
						 }
						 result = Math.max(tmp, result);	//이번에 탐색한 범위 값을 토대로 max값 업데이트
					 }
				 }
				 if(shapes.indexOf(shape)==0) break;	//ㅁ모야이면 한번만 하면 됨
				 else if(shapes.indexOf(shape)==1 && maps.indexOf(map)==1) break;	//ㅡ모양이면 원래 모양이랑 왼쪽으로 한 번 돌린 값만 하면 됨
				 else if(shapes.indexOf(shape)==2 && maps.indexOf(map)==3) break;	//ㅜ모양이면 원래모양이랑 왼쪽으로 돌린 거 3개에 대해서 하면 됨
				 else if(shapes.indexOf(shape)==3 && maps.indexOf(map)==5) break;	//ㄹ같이 생긴 모양이면 원래모양, 왼쪽으로 한번 돌린 모양, 상하반전한모양, 반전한 모양에 대한 왼쪽으로 한번 돌린 모양
			 }						//ㄱ모양은 8종류 다 해야함
		 }
		 System.out.println(result);
    }
	public static int[][] rotate(int idx){	//왼쪽으로 돌아간 map모양 반환
		int[][] standard = maps.get(idx);
		int[][] new_map = new int[standard[0].length][standard.length];
		for(int i=0; i<standard.length; i++) {
			for(int j=0; j<standard[0].length; j++) {
				new_map[standard[0].length-j-1][i] = standard[i][j];
			}
		}
		return new_map;
	}
	public static int[][] upsidedown(){	//위아래 반전된 map모양 반환
		int[][] standard = maps.get(0);
		int[][] new_map = new int[height][width];
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				new_map[i][j] = standard[height-i-1][j];
			}
		}
		return new_map;
	}
	
	public static boolean check(int y, int x, int[][] map) {	//범위 체크
		if(0<=y &&  0<=x && y<(map.length) && x<(map[0].length)) return true;
		return false;
	}
}
	