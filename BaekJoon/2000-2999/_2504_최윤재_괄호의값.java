package tmp;
import java.util.*;
public class _2504_������_��ȣ�ǰ� {

	static String input;
	static int result;
	static int depth = 0;	//��� ��ø�� ��ȣ �ȿ� �ִ��� Ȯ���ϱ� ���� ����
	static Stack<Character> stack1 = new Stack();	//��ȣ ���� ����
	static Stack<int[]> stack2 = new Stack(); //��ø�� ��ȣ �ȿ� �ִ� ��ȣ���� ���� ���� {��, ��ø��ȣ ��}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine();
		for(int i=0; i<input.length(); i++) {	//��ȣ ������ŭ �ݺ�
			char bracket  = input.charAt(i);
			if (bracket =='[' || bracket=='(') {	//���� ��ȣ�� depth �ϳ� �ø��� stack�� ����
				stack1.push(bracket);
				depth++;
			}
			else if(bracket==']') {	// ] �ΰ��
				if(stack1.isEmpty() || stack1.pop() != '[') {	//�߸��� ��ȣ���� ���
					System.out.println(0);
					System.exit(0);
				}
				int tmp = 0;	//���� Ž���� ��ȣ �� �ȿ� �ִ� ��ȣ���� ���� ���� ������ ����
				while(!stack2.isEmpty() && stack2.peek()[1] == depth) {	//depth�� Ȯ���� ���� Ȯ���ϴ� ��ȣ ���� �ִ� ��ȣ���� ���� ���ؼ��� ����
					int[] inside = stack2.pop();	//�ȿ� �ִ� ��ȣ�� pop
					tmp += inside[0];	//tmp�� ��ȣ�� �� ����
				}
				depth--;	//��ȣ �ϳ� ó�������Ƿ� depth 1 ������
				if(tmp==0) stack2.push(new int[] {3,depth});	//���� ó���� ��ȣ ���� �ƹ��͵� ���� ��� �׳� 3 �ֱ�
				else stack2.push(new int[] {3*tmp , depth});	//���� ó���� ��ȣ ���� �ٸ� ��ȣ�� �ִ� ��� 3 ���ϱ�
			}
			else if(bracket==')') {	// ) �ΰ��
				if(stack1.isEmpty() || stack1.pop() != '(') {	//�߸��� ��ȣ���� ���
					System.out.println(0);
					System.exit(0);
				}
				int tmp = 0;	//���� Ž���� ��ȣ �� �ȿ� �ִ� ��ȣ���� ���� ���� ������ ����
				while(!stack2.isEmpty() && stack2.peek()[1] == depth) {	//depth�� Ȯ���� ���� Ȯ���ϴ� ��ȣ ���� �ִ� ��ȣ���� ���� ���ؼ��� ����
					int[] inside = stack2.pop();	//�ȿ� �ִ� ��ȣ�� pop
					tmp += inside[0];	//tmp�� ��ȣ�� �� ����
				}
				depth--;	//��ȣ �ϳ� ó�������Ƿ� depth 1 ������
				if(tmp==0) stack2.push(new int[] {2, depth});	//���� ó���� ��ȣ ���� �ƹ��͵� ���� ��� �׳� 2 �ֱ�
				else stack2.push(new int[] {2*tmp, depth});	//���� ó���� ��ȣ ���� �ٸ� ��ȣ�� �ִ� ��� 2 ���ϱ�
			}
		}
		if(!stack1.isEmpty()) System.out.println(0);	//��ȣ ���� ������ ������� ���� ��� => �߸��� ��ȣ���� ���
		else {	//����� �� ��ȣ���� ���
			while(!stack2.isEmpty()) result += stack2.pop()[0];	//stack2�� �ִ� ���� ��� pop�� ����
			System.out.println(result);	//��� ���ī
		}
	}

}
