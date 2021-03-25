package week10;
import java.io.*;
public class _13305_최윤재 {
	
	static int num;				//도시 개수
	static String[] distance;	//도시간 거리
	static String[] city;		//도시에서의 리터당 가격
	static int min = 1000000001;
	static long result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num=Integer.parseInt(br.readLine());
		distance = new String[num-1];
		city = new String[num];
		distance = br.readLine().split(" ");
		city = br.readLine().split(" ");
		//////////////////////////////////////////////////////입력
		
		for(int i=0; i < num-1; i++) {						//지금까지의 가격 중 가장 작은 값이 min
			int cost = Integer.parseInt(city[i]);			
			if ( cost < min ) min = cost;					//현 도시의 기름값과 최소 기름값 비교
			result += Long.parseLong(distance[i]) * min;	//다음 도시까지의 거리와 min 곱해서 최소 가격 찾기
		}													//min과 distance가 둘 다 1000000000인 경우를 생각해보면 result는 Long이 되어야 함
		
		System.out.println(result);
	}

}
