package week8;
import java.io.*;
public class _2579_최윤재 {
	
	static int stair[];
	static int result[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int stair_num=Integer.parseInt(bf.readLine());
		stair=new int[stair_num+1];													//각 계단 별 가중치 값 저장
		result=new int[stair_num+1];												//부분 최대값 저장
		
		for(int i=1; i<stair.length; i++) {											//stair가중치 입력받기
			stair[i]=Integer.parseInt(bf.readLine());
		}
		
		result[0]=0;																//시작하는 부분은 가중치 0으로 두고 시작
		result[1]=stair[1];															//첫째칸 초기화
		if(stair_num>1)	result[2]=stair[1]+stair[2];								//계단 개수가 1개일 때 때문에 if문 처리 안해주면 런타임 에러 남
		
		for(int i=3; i<stair.length; i++) {											//부분최대값 계산
			result[i]=Math.max(result[i-2]+stair[i], result[i-3]+stair[i-1]+stair[i]);	//바로 앞칸과 3칸 전을 거치는 경우 or 두칸 전을 거치는 경우
		}
		System.out.println(result[stair_num]);										//결과 출력
	}

}

//계단 오르기