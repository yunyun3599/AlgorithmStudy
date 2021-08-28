package tmp;
import java.io.*;
import java.util.*;
public class _2961_최윤재_도영이가만든맛있는음식 {
	
	static int N;	//개수
	static int[] S;	//신 정도 배열
	static int[] B;	//쓴 정도 배열
	static int sour = 1;	//신거 총량
	static int bitter = 0;	//쓴거 총량
	static int result = Integer.MAX_VALUE;	//최소 차이

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		B = new int[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}///////////////////////////////////////////////입력
		for(int i=1; i<=N; i++) {	//i가 포함할 재료 개수
			sour = 1;
			bitter = 0;
			for(int j=0; j<N; j++) {	//j번 인덱스는 꼭 포함해서 조합해보기
				sour *= S[j];
				bitter += B[j];
				calc(j+1, 1, i);	//다음 인덱스 확인
				sour /= S[j];
				bitter -= B[j];
			}
		}
		System.out.println(result);
	}
	public static void calc(int idx, int depth, int num) {
		if(depth == num) {	//포함한 개수가 포함하기로 한 개수와 같아지면 결과 확인
			result = Math.min(result, Math.abs(sour-bitter));
			return;
		}
		for(int i=idx; i<N; i++) {	//추가할 재료들 넣기
			sour *= S[i];
			bitter += B[i];
			calc(i+1, depth+1, num);
			sour /= S[i];		//값 원상복구
			bitter -= B[i];
		}
	}
}
