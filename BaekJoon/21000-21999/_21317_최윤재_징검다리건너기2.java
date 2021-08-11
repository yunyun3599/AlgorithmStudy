package tmp;
import java.io.*;
import java.util.*;
public class _21317_최윤재_징검다리건너기2 {

	static int N;		//총 돌 개수
	static int[] small;	//작은점프 에너지
	static int[] big;	//큰 점프 에너지
	static int K;	//매우큰점프 에너지
	static int min = Integer.MAX_VALUE;	//최소 에너지 소비량
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		small = new int[N-1];
		big = new int[N-1];
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			small[i] = Integer.parseInt(st.nextToken());
			big[i] = Integer.parseInt(st.nextToken());
		}
		K = Integer.parseInt(br.readLine());		////입력
		jump(0,0,false);	//0번돌에서 0인에너지 소비이고 매우큰점프 안한상태로 시작
		System.out.println(min);	//결과출력
	}
	public static void jump (int num, int result, boolean jump3) {
		if(num==N-1) {	//마지막 돌에 도달했을 때
			min = Math.min(min, result);	//쓴 에너지가 더 적으면 min값 업데이트
			return;
		}
		if(num>N-1) return;	//돌을 넘어가버린경우
		if(!jump3) {	//아직 매우큰점프 안쓴 경우
			jump(num+3, result+K, true);	//매우큰점프를 써서 3칸 뒤의 돌로 이동
		}
		jump(num+1, result+small[num], jump3);	//작은점프를 하는 경우
		jump(num+2, result+big[num], jump3);	//큰점프를 하는 경우
	}
}
