package week18;
import java.util.*;
public class _1351_최윤재_무한수열 {
	
	static HashMap<Long, Long> map;	//해쉬맵 이용
	static int P, Q;	//나누는 수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();	//최종 인덱스
		P = sc.nextInt();
		Q = sc.nextInt();
		
		map = new HashMap<>();
		map.put(0L, 1L);	//인덱스 0일 떄 1 값 넣음
		long result = calc(N);	//calc함수를 돌려 결과값 저장
		System.out.println(result);
	}
	
	public static long calc(Long target) {
		if(map.containsKey(target)) return map.get(target);	//만약 해당 인덱스 값이 있으면 그 인덱스의 값 반환
		else {	//아직 해당 인덱스의 값이 없을 경우
			long tmp = calc(target/P) + calc(target/Q);	//해당 인덱스의 값을 재귀적으로 구함
			map.put(target, tmp);	//인덱스 값 저장
			return tmp;	//방금 구한 값 반환
		}
	}
}
