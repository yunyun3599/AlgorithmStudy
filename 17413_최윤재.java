package week7;
import java.util.*;
public class 최윤재_17413 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String line = sc.nextLine();				//입력받을 string
		Stack stack = new Stack();					//스택 이용
		StringBuilder sb = new StringBuilder();		//결과 저장할 StringBuilder
		
		for(int i=0; i<line.length(); i++) {		//index별로 확인
			switch(line.charAt(i)) {
			case '<':								//해당 인덱스가 '<'인 경우
				while(!stack.isEmpty()) sb.append(stack.pop());		//이전까지 저장한 내역을 역으로 출력
				while(true) {
					if(line.charAt(i)=='>') {		//다음으로 '>'가 오는 경우 while문 빠져나감
						sb.append('>');
						break;
					}
					sb.append(line.charAt(i++));	//'>'가 오기 전까지는 순차적으로 출력
				}
				break;
			case ' ':								//띄어쓰기가 들어온 경우
				while(!stack.isEmpty()) sb.append(stack.pop());	//이전 값들 역으로 출력
				sb.append(' ');					
				break;
			default:								//그냥 문자열 들어온 경우에는 stack에 넣음
				stack.add(line.charAt(i));
				break;
			}
		}
		while(!stack.isEmpty()) {					//stack값들 역으로 출력하기
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}
}





//단어뒤집기 2
