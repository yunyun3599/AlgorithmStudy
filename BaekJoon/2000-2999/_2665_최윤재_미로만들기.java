package tmp;
import java.util.*;
import java.io.*;

class Location{			//queue에 넣을 값
	int y, x, broken;	//좌표와 몇번 흰방으롱 바꿨는지
	Location(int y, int x, int broken){
		this.y = y;
		this.x = x;
		this.broken = broken;
	}
}

public class _2665_최윤재_미로만들기 {

	static int n;
	static int map[][];
	static int visited[][];		//아직 방문한 적 없는 경우에는 -1을 저장, 방문한 적 있으면 해당칸까지 오는 데 흰방으로 바꾼 횟수 저장
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				visited[i][j] = -1;	//visited값 초기에 전부 -1로 세팅
			}
		}
		
		for(int i=0; i<n; i++) {
			char input[] = br.readLine().toCharArray();
			for(int j=0; j<n; j++) {
				map[i][j] = input[j]-'0';
			}
		}
		///////////////////////////////////////////////////////입력
		Queue<Location> q = new LinkedList<>();	//bfs
		q.add(new Location(0, 0, 0));	//처음 위치 queue에 삽입
		
		while(!q.isEmpty()) {	//queue가 빌 때까지 반복
			Location cur = q.poll();
			if(cur.y == n-1 && cur.x == n-1) result = Math.min(result, cur.broken);	//도착지에 오면 result와 여기까지 오는 데 흰 방으로 바꾼 횟수 비교해서 최솟값 저장
			for(int k=0; k<4; k++) {	//상하좌우
				int ny = cur.y + dy[k];
				int nx = cur.x + dx[k];
				if(check(ny, nx, cur.broken)) {	//범위 및 visited 확인
					if(map[ny][nx] == 0) {	//검은 방이면 broken 하나 키워야 함
						q.add(new Location(ny, nx, cur.broken+1));
						visited[ny][nx] = cur.broken+1;	//visited 값 업데이트
					}
					else {	//검은 방 아니면 broken 그대로
						q.add(new Location(ny, nx, cur.broken));
						visited[ny][nx] = cur.broken;	//visited값 업데이트
					}
				}
			}
		}
		System.out.println(result);	//결과 출력
	}
	public static boolean check(int y, int x, int broken) {	//좌표와 지금까지 흰 방으로 바꾼 횟수 고려해서 다음 칸을 queue에 넣을지 boolean 리턴
		if(0<=y && 0<=x && y<n && x<n) {	//좌표 범위 체크
			if(visited[y][x]==-1) return true;	//아직 아예 방문한 적 없는 칸이면 true 리턴
			if(map[y][x] == 0 && visited[y][x] > broken+1) return true;	//검은 방인 경우 흰 방으로 바꿔야하므로 지금까지 바꾼 횟수 +1 한 값이 visited보다 작아야 true 리턴
			if(map[y][x] == 1 && visited[y][x] > broken) return true;	//흰 방인 경우 현재까지 흰 방으로 바꾼 횟수가 visited보다 작아야 true 리턴
		}
		return false;
	}

}
