package week11;
import java.util.*;
public class _1697_최윤재_숨바꼭질 {

	static int subin;					//수빈이 좌표
	static int sister;					//동생 좌표
	static Queue<int[]> queue = new LinkedList<>();			//BFS
	static boolean[] visited = new boolean[100001];			//안하면 메모리 초과
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		subin = sc.nextInt();
		sister = sc.nextInt();
		
		if (subin >= sister) System.out.println(subin-sister);	//수빈이가 동생보다 더 뒤에 있을 때
		else {
			queue.add(new int[] {subin, 0});					//{수빈이 위치, 초} 배열 이용
			while(!queue.isEmpty()) {
				int[] tmp = queue.poll();
				int loc= tmp[0];						//수빈이 현재 위치
				int count = tmp[1];						//현재까지 지난 시간
				visited[loc]=true;						//해당 좌표에는 가봤음을 표시
				if(loc == sister) {						//동생을 잡은 경우
					System.out.println(count);
					break;
				}
				else {
					if(loc-1 >= 0 && !visited[loc-1]) queue.add(new int[] {loc-1, count+1});			//-1 이동
					if(loc+1 <= 100000 && !visited[loc+1]) queue.add(new int[] {loc+1, count+1});		//+1 이동
					if(loc*2 <= 100000 && !visited[loc*2]) queue.add(new int[] {loc*2, count+1});		//*2 이동
				}
			}
		}
	}
}

