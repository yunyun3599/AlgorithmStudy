package week7;
import java.util.*;
public class 최윤재_5525 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();				//패턴의 O 개수
		int N_len = 2*N+1;					//패턴 길이
		int M = sc.nextInt();				//입력 문자열 길이
		int result=0;						//최종 결과 저장
		LinkedList<Integer> lst = new LinkedList<Integer>();	//각 부분 패턴별 값 결과값 저장
		
		sc.nextLine();
		String line = sc.nextLine();
		
		for(int i=0; i<M; i++) {			
			int count=1;					//패턴이 나타난 부분의 패턴 길이 저장
			if(line.charAt(i)=='I') {
				while(i<line.length()-2) {
					if(line.charAt(i)!=line.charAt(i+1)) {		//앞과 다른 char인경우 (I->O 또는 O->I) 패턴 길이 하나 증가
						count++;
						i++;				//인덱스 증가
					}
					else break;				//패턴이 끝나면 while문 break
				}
			}
			if (count>=N_len) lst.add((count-(N_len))/2+1);		//나타난 부분 패턴내에 기존 패턴이 몇개 포함되는지 계산해서 lst에 저장
		}
		
		for(int i=0; i<lst.size(); i++) {	//lst값 다 더해서 최종 결과 구함
			result+=lst.get(i);
		}
		System.out.println(result);
	}

}

////IOIOI
