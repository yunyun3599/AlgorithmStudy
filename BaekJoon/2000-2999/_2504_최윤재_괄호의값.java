package tmp;
import java.util.*;
public class _2504_최윤재_괄호의값 {

	static String input;
	static int result;
	static int depth = 0;	//몇개의 중첩된 괄호 안에 있는지 확인하기 위한 변수
	static Stack<Character> stack1 = new Stack();	//괄호 넣을 스택
	static Stack<int[]> stack2 = new Stack(); //중첩된 괄호 안에 있는 괄호들의 값을 저장 {값, 중첩괄호 수}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine();
		for(int i=0; i<input.length(); i++) {	//괄호 개수만큼 반복
			char bracket  = input.charAt(i);
			if (bracket =='[' || bracket=='(') {	//여는 괄호면 depth 하나 늘리고 stack에 넣음
				stack1.push(bracket);
				depth++;
			}
			else if(bracket==']') {	// ] 인경우
				if(stack1.isEmpty() || stack1.pop() != '[') {	//잘못된 괄호문의 경우
					System.out.println(0);
					System.exit(0);
				}
				int tmp = 0;	//현재 탐색할 괄호 쌍 안에 있는 괄호들의 값의 합을 저장할 변수
				while(!stack2.isEmpty() && stack2.peek()[1] == depth) {	//depth를 확인해 현재 확인하는 괄호 내에 있는 괄호들의 값에 대해서만 수행
					int[] inside = stack2.pop();	//안에 있는 괄호들 pop
					tmp += inside[0];	//tmp에 괄호들 값 더함
				}
				depth--;	//괄호 하나 처리했으므로 depth 1 낮춰줌
				if(tmp==0) stack2.push(new int[] {3,depth});	//지금 처리한 괄호 내에 아무것도 없는 경우 그냥 3 넣기
				else stack2.push(new int[] {3*tmp , depth});	//지금 처리한 괄호 내에 다른 괄호가 있는 경우 3 곱하기
			}
			else if(bracket==')') {	// ) 인경우
				if(stack1.isEmpty() || stack1.pop() != '(') {	//잘못된 괄호문의 경우
					System.out.println(0);
					System.exit(0);
				}
				int tmp = 0;	//현재 탐색할 괄호 쌍 안에 있는 괄호들의 값의 합을 저장할 변수
				while(!stack2.isEmpty() && stack2.peek()[1] == depth) {	//depth를 확인해 현재 확인하는 괄호 내에 있는 괄호들의 값에 대해서만 수행
					int[] inside = stack2.pop();	//안에 있는 괄호들 pop
					tmp += inside[0];	//tmp에 괄호들 값 더함
				}
				depth--;	//괄호 하나 처리했으므로 depth 1 낮춰줌
				if(tmp==0) stack2.push(new int[] {2, depth});	//지금 처리한 괄호 내에 아무것도 없는 경우 그냥 2 넣기
				else stack2.push(new int[] {2*tmp, depth});	//지금 처리한 괄호 내에 다른 괄호가 있는 경우 2 곱하기
			}
		}
		if(!stack1.isEmpty()) System.out.println(0);	//괄호 저장 스택이 비어있지 않은 경우 => 잘못된 괄호문의 경우
		else {	//제대로 된 괄호문의 경우
			while(!stack2.isEmpty()) result += stack2.pop()[0];	//stack2에 있는 값을 모두 pop해 합함
			System.out.println(result);	//결과 출력카
		}
	}

}
