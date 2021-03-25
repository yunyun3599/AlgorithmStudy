package week19;

import java.io.*;
import java.util.*;

public class _11404_최윤재_플로이드 {

	static int city;
	static int bus;
	static int map[][];
	static int MAX = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		city = Integer.parseInt(br.readLine());
		bus = Integer.parseInt(br.readLine());
		map = new int[city][city];
		for(int i=0; i<city; i++) Arrays.fill(map[i], MAX);
		for(int i=0; i<bus; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			map[start][end] = Math.min(map[start][end], weight); //더 작은 값만 저장
		}
		///////////////////////////////////입력
		floyd_warshall();				//플로이드와샬 수행
		for(int i=0; i<city; i++) {		//츨력
			for(int j=0; j<city; j++) {
				if(map[i][j]==MAX) bw.append(0+" ");
				else bw.append(map[i][j]+" ");
			}
			bw.append("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void floyd_warshall() {
		for(int i=0; i<city; i++) {		//경유할 도시
			for(int j=0; j<city; j++) {	//시작도시
				for(int k=0; k<city; k++) {	//도착도시
					if(map[j][i]!=MAX && map[i][k]!=MAX && j!=k)	//갈 수 있는 경우에 한하여 확인
						map[j][k] = Math.min(map[j][k], map[j][i]+map[i][k]); //더 작은 값 선택
				}
			}
		}
	}

}
