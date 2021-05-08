package tmp;
import java.util.*;
import java.io.*;
public class _2531_최윤재_회전초밥 {
	
	static int dish;		//접시 개수
	static int sushi;		//스시 종류 개수
	static int num;			//먹을 수 있는 최대 개수
	static int coupon;		//쿠폰 스시 번호
	static int[] arr;		//접시 위 스시 저장
	static boolean[] visited;	//해당 스시가 먹었던 스시인지 표시
	static int result;		//결과
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		dish = Integer.parseInt(st.nextToken());
		sushi = Integer.parseInt(st.nextToken());
		num = Integer.parseInt(st.nextToken());
		coupon = Integer.parseInt(st.nextToken());
		arr = new int[dish];
		for(int i=0; i<dish; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}////////////////////////////////////////////////////입력
		for(int i=0; i<dish; i++) {
			result= Math.max(check(i), result);		//i번째 접시부터 시작하는 경우
		}
		System.out.println(result);
	}
	public static int check(int start) {
		visited = new boolean[sushi+1];	//먹은 스시인지 확인하기 위함
		int count = 0;		//서로 다른 종류 몇개 먹었나 표시
		int idx = start;	//한칸씩 이동할 인덱스
		while(true) {
			if(idx-start == num) {	//먹을 수 있는 개수만큼 다 먹었을 때
				if(!visited[coupon]) return count+1;	//쿠폰을 아직 안쓴 경우
				return count;	//쿠폰에 해당하는 초밥을 이미 먹은 경우
			}
			if(!visited[arr[idx%dish]]) {	//아직 먹어보지 않은 스시일 때
				visited[arr[idx%dish]] = true;	//해당 스시를 먹어본것으로 변경
				count++;	//먹어본 스시 종류 개수 하나 늘리기
			}
			idx++;		//인덱스 하나 증가(이미 먹어본 스시인 경우에는 count를 늘리지 않는다.)
		}
	}

}
