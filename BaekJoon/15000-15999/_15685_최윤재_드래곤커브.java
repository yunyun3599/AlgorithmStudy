package tmp;
import java.io.*;
import java.util.*;
public class _15685_최윤재_드래곤커브 {
	
	static int curve;
	static int[][] input;		//각 커브의 사양을 저장하는 배열
	static int[][] map = new int[101][101];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		curve = Integer.parseInt(br.readLine());	//드래곤커브 개수
		input = new int[curve][4];		//x,y좌표 , 시작 방향, 세대
		for(int i=0; i<curve; i++) {	//오른쪽 0  위1  왼쪽2  아래3
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) input[i][j] = Integer.parseInt(st.nextToken());
		}//////////////////////////////////////////////////////////입력
		for(int i=0; i<curve; i++) {		//커브 개수만큼 지도 위에 표시
			ArrayList<Integer> dir = new ArrayList<>();	//움직일 방향을 저장해놓는 어레이리스트
			int[] loc = {input[i][0], input[i][1]};	//처음 위치
			map[loc[1]][loc[0]] = 1;	//처음 위치 꼭지점을 사용중임을 표시
			dir.add(input[i][2]);		//초기 방향을 넣기
			int repetition = input[i][3];	//몇차 드래곤커브인지
			for(int j=0; j<repetition+1; j++) {	//드래곤커브는 0차부터 시작 
				fill(dir, loc);	//커브 모양 구해서 map에 표시하는 함수
				if(j!=0) { 	//dir배열내 요소 더블링 할 때(0차커브 아님)
					ArrayList<Integer> tmp = new ArrayList();
					for(int k=0; k<dir.size(); k++) {	//현재 있는 방향들을 전부 시계방향으로 90도 돌림
						int changed_dir = dir.get(dir.size()-k-1) + 1;
						if (changed_dir > 3 ) changed_dir = 0;
						tmp.add(changed_dir);
					}
					dir.addAll(tmp);	//기존 배열에 방향 돌린 값 추가
				}
				else {	//0차 커브일 때
					int changed_dir = dir.get(0) + 1;
					if (changed_dir > 3 ) changed_dir = 0;
					dir.set(0, changed_dir);
				}
			}
		}
		System.out.println(count());
	}
	
	public static void fill(ArrayList<Integer> dir, int[] loc) {
		for(int i=0; i<dir.size(); i++) {
			switch(dir.get(dir.size()-i-1)) {	//방향에 맞춰 다음 위치 구함
			case 0:
				loc[0] += 1;
				break;
			case 1:
				loc[1] -= 1;
				break;
			case 2:
				loc[0] -= 1;
				break;
			case 3:
				loc[1] += 1;
				break;
			}
			map[loc[1]][loc[0]] = 1;
		}
	}
	
	public static int count() {		//4방향이 다 드래곤커브인 정사각형 개수 구하기
		int result=0;
		int[] axis_x = {0,0,1,1};
		int[] axis_y = {0,1,0,1};
		for(int i=0; i<100; i++) {		//100*100행렬
			for(int j=0; j<100; j++) {
				boolean flag = true;
				for(int k=0; k<4; k++) {
					if(map[i+axis_y[k]][j+axis_x[k]]==0) flag=false;	//0인게 있으면 false로 표시
				}
				if(flag) result++;
			}
		}
		return result;
	}

}
