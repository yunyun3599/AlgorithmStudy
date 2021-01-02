package week7;
import java.util.*;
public class 최윤재_1107 {

	static int target;									//목표 채널
	static int broken;									//고장난 개수
	static int[] number = new int[10];					//고장난 채널을 저장
	static int min;										//최종 결과
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		target=sc.nextInt();
		broken=sc.nextInt();
		for(int i=0; i<broken; i++) {					//고장난 번호 배열상 0으로 바꿈
			number[sc.nextInt()]=-1;
		}	
		min = Math.abs(target - 100);					//우선 target과 100번 채널을 +,-버튼으로 움직인 값을 최소로 설정해놓음		

		if(target==100) System.out.println(0);			//목표 채널이 100인경우
		else System.out.println(check());				//목표 채널이 100이 아닌 경우			
	}
	
	public static int check() {
		boolean flag=true;
		String tmp="";
		for(int i=0; i<=5000000; i++) {					//모든 경우 확인
			flag=true;
			tmp=""+i;
			for(int j=0; j<tmp.length();j++) {
				if(number[tmp.charAt(j)-'0']==-1) {		//고장난 버튼 있으면 flag를 false로
					flag=false;
					break;
				}
			}
			if(flag) {
				min=Math.min(min, Math.abs(i-target)+tmp.length());		//minimum 값 업데이트
			}
		}
		return min;
	}
	
}
