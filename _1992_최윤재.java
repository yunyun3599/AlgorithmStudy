package week9;
import java.util.*;
public class _1992_최윤재 {
	static StringBuilder result = new StringBuilder();		//결과 저장
	static int[][] map;										//입력 저장
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len=sc.nextInt();
		sc.nextLine();
		map=new int[len][len];
		for(int i=0; i<len; i++) {
			String tmp = sc.nextLine();
			for(int j=0; j<len; j++) {
				map[i][j]=tmp.charAt(j)-'0';
			}
		}
//////////////////////////////////////////////////////////입력 처리
		
		section(len, 0, 0);								//0,0부터 확인하는 함수 호출
		System.out.println(result);						//결과 출력
	}
	
	public static void section(int wid, int x, int y) {	//각 구역별로 확인 후 결과값을 내는 함수
		if(wid==1) {									//구역이 한 칸일 떄
			result.append(map[y][x]);					//해당 칸의 값을 append
			return;
		}
		if(check(wid,x,y)) {							//주어진 칸 내의 숫자가 다 동일한지 확인
			result.append(map[y][x]);					//동일하다면 해당 칸의 숫자를 append
			return;
		}
		result.append("(");								//한 칸도 아니고 동일하지도 않을 때 우선 (를 열어줌
		section(wid/2, x, y);							//각 칸을 4칸으로 쪼개 각 칸별로 재귀 호출
		section(wid/2, x+wid/2, y);
		section(wid/2, x, y+wid/2);
		section(wid/2, x+wid/2, y+wid/2);
		result.append(")");								//나온 해당 값들에 )를 append
	}
	public static boolean check(int wid, int x, int y) {	//주어진 칸 내의 숫자들이 모두 동일한지 확인하는 함수
		int num=map[y][x];
		for(int i=y; i<y+wid; i++) {					//한칸씩 확인
			for(int j=x; j<x+wid; j++) {
				if(num!=map[i][j]) return false;
			}
		}
		return true;									//다 같은 수면 true 리턴
	}

}
