package graph;
import java.util.*;

public class _16953_최윤재 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int base=sc.nextInt();
		int target=sc.nextInt();
		/////////////////////////////////////////////////////////입력
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {base,1});					//queue에는 현재까지 계산한 값과 해당 값까지 계산해야 하는 횟수를 배열로 해서 넣음
				
		
		while(!q.isEmpty()) {						//bfs 수행
			int[] tmp = q.poll();
			if(tmp[0]==target) {					//타겟 값과 방금 poll 한 값이 같다면 정답이므로 tmp[1]에 저장되어있는 계산 횟수 출력
				System.out.println(tmp[1]);
				System.exit(0);
			}
			
			if (tmp[0]<100000000) {					//tmp가 target값을 넘지 않는 이상 *10+1연산을 수행해 queue에 넣음
				int sum = tmp[0]*10+1;
				if(sum<=target) {
					q.add(new int[] {sum,tmp[1]+1});
				}
			}
			
			int mul = 2*tmp[0];						//*2연산을 해 queue에 넣음
			if(mul<=target) {
				q.add(new int[] {mul,tmp[1]+1});
			}
		}
		System.out.println(-1);						//target값을 못만드는 경우에는 -1 출력
		
	}

}


//16953. A->B