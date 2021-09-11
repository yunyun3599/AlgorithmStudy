package tmp;
import java.util.Scanner;
import java.util.Stack;

class Strlen{
	int num;
	int depth;			//괄호 몇개가 열려있는지 
	Strlen(int num, int depth){
		this.num = num;
		this.depth = depth;
	}
}
public class _1662_최윤재_압축 {

	static char[] input;	//입력
	static int depth=0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine().toCharArray();
		Stack<Strlen> stack = new Stack<>();
		//////////////////////////////////////////////입력
		for(int i=0; i<input.length; i++) {	//마지막 char까지 확인
			char num = input[i];
			if(num=='(') {	//여는 괄호면 depth 증가
				depth++;
			}
			else if(num==')') {	//닫는 괄호일 경우 동일한 괄호 내에 있는 값들을 모두 pop
				int tmp_len = 0;	//해당 괄호 내의 문자열 길이
				if(!stack.isEmpty() && stack.peek().depth==depth)tmp_len = stack.pop().num;	//stack이 비어있지 않고 ()가 아닌 경우에 수행
				while(!stack.isEmpty() && stack.peek().depth==depth) {	//stack이 비어있지 않고 동일 depth에 한해서만 pop
					Strlen str = stack.pop();
					tmp_len += str.num;		//string의 길이만큼 tmp_len에 더함
				}
				if(!stack.isEmpty())tmp_len *= stack.pop().num;	//stack이 비어있지 않은 경우에 대해서만 여는 괄호 바로 앞의 숫자를 길이에 곱함
				depth--;	//괄호 닫혔으므로 depth 하나 감소
				stack.push(new Strlen(tmp_len, depth));	//지금까지 구한 str의 길이를 stack에 다시 push
			}
			else {	//숫자일 경우
				if(i != input.length-1 && input[i+1]=='(')	//다음 character가 (라서 곱할 일이 있는 경우
					stack.push(new Strlen(num-'0', depth));	//숫자를 그대로 저장
				else
					stack.push(new Strlen(1, depth));		//어차피 str로만 처리되는 경우이므로 str길이인 1을 저장
			}
		}
		int result = 0;
		while(!stack.isEmpty()) {	//stack값들 모두 꺼내면서 길이를 result에 더함
			Strlen str = stack.pop();
			result += str.num;
		}
		System.out.println(result);
	}

}
