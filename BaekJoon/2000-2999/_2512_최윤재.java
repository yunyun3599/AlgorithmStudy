package week9;
import java.util.*;
public class _2512_최윤재 {
	
	static int num;
	static int[] budget;
	static int total;
	static int average;
	static int sum=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num=sc.nextInt();
		budget=new int[num];
		for(int i=0; i<num ; i++) {
			budget[i]=sc.nextInt();
			sum+=budget[i];
		}
		total=sc.nextInt();
		//////////////////////////////////////////입력
		
		Arrays.sort(budget);					//오름차순 정렬
		
		average = total/num;
		
		if(sum<=total) {						//전체에게 예산 배정 가능한 경우
			System.out.println(budget[num-1]);
			System.exit(0);
		}
		for(int i=0; i<num; i++) {
			if(budget[i]<=average) {
				total-=budget[i];					//평균 아래인 예산들을 총액에서 뺌
				continue;
			}
			average=total/(num-i);					//남은 값들에 대한 average	
			if(budget[i]>average) break;			//새로 구한 average에 대해 전체가 들어갈 수 있는 예산이 있는지 확인
			i--;									//이 인덱스를 뛰어넘게 되버리므로 하나 빼야함 (안하면 틀렸습니다.)
		}
		System.out.println(average);
	}
}

//예산