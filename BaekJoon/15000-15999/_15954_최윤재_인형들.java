package tmp;
import java.util.*;
import java.io.*;

public class _15954_최윤재_인형들 {

	static int N;
	static int K;
	static int dolls[];
	static double min = Double.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		dolls = new int[N];
		for(int i=0; i<N; i++) {
			dolls[i] = Integer.parseInt(st.nextToken());
		}///////////////////////////////////////////////////////입력
		for(int i=0; i<N-K+1; i++) {
			check(i, i+K-1);		//i번째 인형부터 시작해 i+K-1번째 인형까지인 경우
		}
		System.out.printf("%.11f",min);	//최소값 출력
	}
	
	public static void check(int start, int end) {		//인형 조합별로 표준편차 구하는 함수
		double deviation = Math.sqrt(dispersion(start, end));	//분산 리턴받은 값에 루트 씌우가
		min = Math.min(min, deviation);	//더 작은 값 min에 저장
		if(end<N-1) check(start, end+1);	//현재 end값이 인형 끝값이 아닌 경우 인형 하나 더 포함해서 시도해봄
	}
	
	public static double dispersion(int start, int end) {	//분산 리턴하는 함수
		int sum = 0;
		double boonsan = 0;
		for(int i= start; i<=end; i++) {
			sum += dolls[i];
		}//////////////////////////////////////////인형 총합
		double average = (double)sum/(end-start+1);	//인형 평균
		for(int i= start; i<=end; i++) {	//분산 구하기
			double tmp = dolls[i] - average;
			boonsan += Math.pow(tmp, 2);
		}
		return (double)boonsan/(end-start+1);	//분산 리턴
	}
}
