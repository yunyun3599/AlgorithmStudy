package tmp;
import java.util.*;
public class _14719_최윤재_빗물 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		int result = 0;
		
		int block[] = new int[W];	//블록 높이
		for(int i=0; i<W; i++) {
			block[i] = sc.nextInt();
		}
		
		for(int i=1; i<W-1; i++) {	//2번째부터 마지막-1 위치까지 확인
			int floor = block[i];	//현재의 바닥 높이
			int lmax = 0;	//왼쪽에서 가장 높은 블록
			int rmax = 0;	//오른쪽에서 가장 높은 블록
			for(int j=0; j<i; j++) {	//왼쪽에서 가장 높은 블록 구하기
				lmax = Math.max(lmax, block[j]);
			}
			for(int j=i+1; j<W; j++) {	//오른쪽에서 가장 높은 블록 구하기
				rmax = Math.max(rmax, block[j]);
			}
			if(lmax > floor && rmax > floor) {	//왼쪽 오른쪽에서 가장 높은 블록 모두 현재 바닥보다 높은 경우에만 물이 고임
				result += Math.min(lmax, rmax) - floor;
			}
		}
		System.out.println(result);
	}

}
