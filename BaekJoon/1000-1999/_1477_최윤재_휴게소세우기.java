import java.io.*;
import java.util.*;
public class _1477_최윤재_휴게소세우기 {

	static int N;
	static int M;
	static int L;
	static int loc[];
	static int dist[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	//입
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		loc = new int[N+2];	//각 휴게소 위치 
		dist = new int[N+1];	//각 휴게소 사이 거리 
		loc[0] = 0;
		loc[N+1] = L;

		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {	//입
			loc[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(loc);	//휴게소 위치 오름차순 정렬 
		for(int i=0; i<=N; i++) {	//휴게소사이 거리 구하기 
			dist[i] = loc[i+1]-loc[i];
		}
		
		int low = 0;
		int high = L;
		while(low<high) {	//이분탐색 
			int cnt = M;	//세울 수 있는 휴게소 개수 
			int mid = (low+high)/2;
			for(int i=0; i<=N; i++) {
				if(dist[i] <= mid) continue;	//현재 목표 거리보다 두 휴게소 사이 거리가 가까우면 휴게소 세울 필요 없음 
				if(mid == 0) {	//안하면 divided by zero 오류 
					low = 1;
					break;
				}
				cnt -= dist[i]/mid;	//목표 거리로 세워야하는 휴게소 개수만큼 세울 수 있는 휴게소 수 줄임 
				if(dist[i]%mid==0) cnt++;	//나누어 떨어지는 경우에는 하나 덜 써도 됨 
				if(cnt<0) {	//너무 거리를 촘촘히 해서 더 세울 수 있는 휴게소 개수가 없을 때 
					low = mid+1;
					break;
				}
			}
			if(cnt >= 0) high = mid;	//세울 수 있는 휴게소 개수가 남거나 딱 맞았으면 거리를 줄여보기 
		}
		System.out.println(low);
	}

}