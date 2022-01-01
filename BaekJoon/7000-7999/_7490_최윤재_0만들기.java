package tmp;
import java.util.*;

public class _7490_최윤재_0만들기 {

	static char[] operator = {' ', '+', '-'};
	static int num;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		while(testcase-- > 0) {	//테스트케이스만큼 반복
			num = sc.nextInt();
			char[] operatorSet = new char[num];
			operatorSet[0] = '+';
			makeOperator(operatorSet, 1, num);	//연산 조합 만들어서 되는 것 다 확인
			System.out.println();
		}
	}
	public static void calc(char[] operatorSet) {
		int acc = 0;	//누적합
		int tmpnum = 0;	//공백이 있을 때 이어붙여지는 숫자
		StringBuilder result = new StringBuilder();	//식 문자열 저장
		for(int i=0; i<num; i++) {
			if(operatorSet[i]==' ') {	//공백인 경우
				tmpnum = tmpnum < 0 ? tmpnum * 10 - (i+1) : tmpnum * 10 + (i+1);	//현재 tmpnum값에 10을 고친 후 음수면 현재 수를 빼고 양수면 현재 수를 더함
			}
			if(operatorSet[i] == '+') {	//더하기일 떄
				acc += tmpnum;
				tmpnum = i+1;
			}
			if(operatorSet[i] == '-') {	//빼기일 때
				acc += tmpnum;
				tmpnum = (i+1) * (-1);
			}
			result.append(operatorSet[i]+""+(i+1));	//식 만들기
		}
		acc += tmpnum;	//마지막 숫자까지 다 계산
		if(acc == 0) {	//계산 결과가 0이면 출력
			System.out.println(result.substring(1));
		}
		
	}
	public static void makeOperator(char[] operatorSet, int idx, int limit) {	//모든 연산 조합을 만들어봄
		if(limit == idx) {	//연산 조합 다 만들면 해당 조합으로 계산해보기
			calc(operatorSet);
			return;
		}
		for(int i=0; i<3; i++) {	//' ' + -
			operatorSet[idx] = operator[i];
			makeOperator(operatorSet, idx+1, limit);
		}
	}

}
