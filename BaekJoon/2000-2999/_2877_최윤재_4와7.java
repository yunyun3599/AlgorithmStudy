package tmp;
import java.util.*;
public class _2877_최윤재_4와7 {
	
	static int K;			//몇번째인지
	static Stack<Integer> stack = new Stack<>();	//각 자릿수별로 어떤 수일지 저장
	static StringBuilder output = new StringBuilder("");	//결과 stringbuilder
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt()+1;	//입력받기 처리를 위해서 +1해줌
		
		while(K>1) {		//K에 대해 결과로 나오는 자릿수만큼 반복 (한자리수 -> 2개, 2자리수 -> 4개, 3자리수 -> 8개 ...)
			stack.push(K%2);	//2로 나눠떨어지지 않는 경우에는 stack에 1을 넣어 7임을 표시 나누어떨어지면 stack에 0을 넣어 4임을 표시
			K = K/2;		//자리수 중 하나 채웠으니까 K반으로 나눔
		}
		while(!stack.isEmpty()) {	//stack의 값들을 4와 7로 변환
			output.append(stack.pop()*3 +4);	//0이면 4, 1이면 7
		}
		System.out.println(output);
	}
}
