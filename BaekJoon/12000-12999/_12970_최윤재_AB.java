package tmp;
import java.util.*;
public class _12970_최윤재_AB {

	static int N;
	static int K;
	static char[] result;
	static int[] range;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N= sc.nextInt();		//문자열 길이
		K=sc.nextInt();			//목표 숫자
		result = new char[N];	//A와 B저장 배열
		range = new int[N/2+1];	//A가 인덱스의 개수만큼 있을 때 나올 수 있는 최대값을 저장할 것 (N=6이고 2번 인덱스의 경우 AABBBB가 최대일 때이므로 8 저장)
		int A_num = 0;			//해당 범위에 대해 사용할 A의 개수
		for(int i=0; i<N/2+1; i++) {	//앞 반절만 구하면 됨
			range[i] = i*(N-i);	//A를 i개 사용할 때 나올 수 있는 최대값은 i*(N-i)개임. (앞에 A가 i개, 뒤에는 다 B)
			if(range[i]>=K) {	//K값을 기준으로 하여 A가 몇개있을 때 만들 수 있는 범위인지 확인
				A_num=i;
				break;
			}
		}
		calc(0, A_num);		//A와 B를 섞어 만드는 배열 생성
		System.out.println(-1);	//안되는 경우 -1 리턴
	}
	public static void calc(int idx, int A_num) {
		if(idx == N) {			//N개의 A,B를 전부 나열했을 때
			if(ispossible()) {	//개수가 K개인지 확인
				System.out.println(result);	//K면 결과 리턴
				System.exit(0);
			}
		}
		else {
			if(A_num>0) {		//A를 아직 더 쓸 수 있는 경우
				result[idx] = 'A';	//A로 해당 자리 값 설정
				calc(idx+1, A_num-1);	//A_num 하나 줄여서 다음 자리 탐색
			}
			result[idx] = 'B';	//B를 사용하는 경우
			calc(idx+1, A_num);	//A_num 줄일 필요 없음
		}
	}
	public static boolean ispossible() {	//K값과 동일한지 확인
		int ACount=0;		//순차적으로 무슨 문자인지 확인하므로 지금까지 나온 A개수의 총합
		int tmp_result=0;	//임시적으로 결과 저장할 변수
		for(int i=0; i<N; i++) {
			if(result[i]=='A') ACount++;	//A면 ACount를 하나 늘림
			else if(result[i]=='B') tmp_result+=ACount; 	//B가 나온 경우 앞에서 나온 A의 개수만큼 결과에 더하기
		}
		if(tmp_result==K) return true;	//여기서 나온 결과와 K값이 같으면 true retrun
		return false;
	}
}
