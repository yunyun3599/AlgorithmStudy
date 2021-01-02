//백트래킹 이용

package week7;
import java.util.*;
public class 최윤재_2529 {

	static char[] input;					//<,> 저장
	static int n;							//부등호 개수
	static int[] visited = new int[10];		//해당 수를 썼는지 안썼는지 저장
	static String max = "0";				//초기 max 값 저장을 위한 string
	static String min = "9";				//초기 min 값 저장을 위한 string
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();		
		sc.nextLine();
		input = new char[n];
		
		for(int i=0; i<n; i++) {				//<,> 입력 받기
			input[i]=sc.next().charAt(0);
			max+=i+1;
			min+=8-i;
		}
//////////////////////////////////////////////////여기까지 입력
		
		for(int i=0; i<10; i++) {					//DFS 이용
			visited[i]=1;							//가장 앞에 들어갈 숫자
			for(int j=0; j<10; j++) {				//두번째 앞에 들어갈 숫자
				if(i!=j) {							//두 숫자가 같지 않은 경우에만 탐색 진행 (각 숫자 한번씩만 쓸 수 있으므로)
					visited[j]=1;					//두번째 숫자 이용했다고 표시
					promising(i,j,0,""+i+j);		//DFS 수행
					visited[j]=0;					//두번째 숫자 이용했다는 표시 풀기
				}
			}
			visited[i]=0;							//첫번째 숫자 이용했다는 표시 풀기
		}
		
		System.out.println(max);					//결과 출력
		System.out.println(min);
	}
	
	
	
	public static void promising(int front, int back, int loc, String tmp) {		//DFS 코드 겸 promising한지 확인
		char c = input[loc];												//이번에 확인할 부등호 위치
		boolean flag = false;												//부등호와 숫자들이 옳은 관계일 떄만 true로 바꿈
		if(c=='>' && front>back) flag = true; 								// > 부등호인 경우
		else if(c=='<' && front<back) flag = true;							// < 부등호인 경우
		if(flag && loc==n-1) {												//현재의 수와 부등호 관계가 올바르고 마지막 수까지 탐색한 경우
			if (Long.parseLong(tmp)>=Long.parseLong(max)) max=tmp;			//max 값 업데이트 (Integer.parseInt()쓰면 범위를 넘어가는 경우 때문에 런타임 에러남)
			if (Long.parseLong(tmp)<Long.parseLong(min)) min=tmp;			//min 값 업데이트
			return;
		}
		if(flag) {															//flag가 true여서 promising 한 경우 다음 노드 탐색
			for(int i=0; i<10; i++) {
				if(visited[i]==0) {											//아직 방문하지 않은 숫자만 이용
					visited[i]=1;											//방문 표시
					promising(back, i, loc+1, tmp+i);						//DFS 수행	
					visited[i]=0;											//방문 표시했던 것 풀어주기
				}
			}
		}
	}
}


/////부등호
