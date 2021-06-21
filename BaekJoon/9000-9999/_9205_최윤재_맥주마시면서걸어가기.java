package tmp;
import java.util.*;
import java.io.*;

public class _9205_최윤재_맥주마시면서걸어가기 {

	static int testcase;	//테스트케이스 개수
	static StringBuilder sb = new StringBuilder();	//happy, sad 저장
	static int num;	//편의점 개수
	static int[][] map;	//전체 지점들 사이의 weight 저장
	static int[][] store;	//편의점들의 좌표 저장
	static int[] start = new int[2];	//출발점 좌표 저장
	static int[] end = new int[2];	//도착지 좌표 저장
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testcase = Integer.parseInt(br.readLine());
		
		while(testcase-- > 0) {	//테스트케이스만큼 반복
			num = Integer.parseInt(br.readLine());	//편의점 개수
			map = new int[num+2][num+2];	//각 위치까지 갈 수 있는지 weight 배열
			store = new int [num][2];	//편의점들의 좌표 저장
			StringTokenizer st = new StringTokenizer(br.readLine());
			start[0] = Integer.parseInt(st.nextToken());	//시작 지점 좌표 저장
			start[1] = Integer.parseInt(st.nextToken());
			for(int i=0; i<num; i++) {	//편의점들 좌표 저장
				st = new StringTokenizer(br.readLine());
				store[i][0] = Integer.parseInt(st.nextToken());
				store[i][1] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			end[0] = Integer.parseInt(st.nextToken());	//도착지점 좌표 저장
			end[1] = Integer.parseInt(st.nextToken());
			
			if(Math.abs(start[0]-end[0])+Math.abs(start[1]-end[1]) <=1000) {	//출발점과 도착점이 1000 이하의 거리이면 바로 happy
				sb.append("happy\n");
				continue;
			}
			else {	//아니면 출발점과 도착점사이 거리를 크게 잡아둠
				map[0][num+1] = Integer.MAX_VALUE;
				map[num+1][0] = Integer.MAX_VALUE;
			}
			
			makemap();	//출발점, 도착점, 각 편의점 사이의 거리를 map에 저장
			for(int k=1; k<num+1; k++) {	//k번 편의점을 경유하는 경우
				for(int i=0; i<num+2; i++) {	//각 지점들에 대해 k번 편의점을 경우할 때 다른 지점으로 가는 weight 업데이트
					for(int j=i+1; j<num+2; j++) {
						if(map[i][k]==Integer.MAX_VALUE || map[k][j]==Integer.MAX_VALUE)	//못가는 경우는 continue
							continue;
						map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);	//현재 값과 k를 경유하는 값 중 더 작은 값 선택
						map[j][i] = map[i][j];
					}
				}
			}
			if(map[0][num+1] == Integer.MAX_VALUE) sb.append("sad\n");	//못가는 경우는 sad
			else sb.append("happy\n");	//갈 수 있는 경우는 happy
		}
		System.out.println(sb);
	}
	public static void makemap() {
		for(int i=0; i<num; i++) {	//출발점-편의점 간의 거리와 편의점 - 도착점 간의 거리를 저장
			int weight = Math.abs(start[0]-store[i][0]) + Math.abs(start[1]-store[i][1]);
			weight = weight>1000? Integer.MAX_VALUE : weight;
			map[0][i+1] = weight;
			map[i+1][0] = weight;
			weight = Math.abs(end[0]-store[i][0]) + Math.abs(end[1]-store[i][1]);
			weight = weight>1000? Integer.MAX_VALUE : weight;
			map[num+1][i+1] = weight;
			map[i+1][num+1] = weight;
		}
		for(int i=0; i<num; i++) {	//편의점들끼리의 거리 저장
			for(int j=i+1; j<num; j++) {
				int weight = Math.abs(store[i][0]-store[j][0]) + Math.abs(store[i][1]-store[j][1]);
				weight = weight>1000? Integer.MAX_VALUE : weight;
				map[i+1][j+1] = weight;
				map[j+1][i+1] = weight;
			}
		}
	}
}