package tmp;
import java.util.*;
public class _2877_������_4��7 {
	
	static int K;			//���°����
	static Stack<Integer> stack = new Stack<>();	//�� �ڸ������� � ������ ����
	static StringBuilder output = new StringBuilder("");	//��� stringbuilder
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt()+1;	//�Է¹ޱ� ó���� ���ؼ� +1����
		
		while(K>1) {		//K�� ���� ����� ������ �ڸ�����ŭ �ݺ� (���ڸ��� -> 2��, 2�ڸ��� -> 4��, 3�ڸ��� -> 8�� ...)
			stack.push(K%2);	//2�� ������������ �ʴ� ��쿡�� stack�� 1�� �־� 7���� ǥ�� ����������� stack�� 0�� �־� 4���� ǥ��
			K = K/2;		//�ڸ��� �� �ϳ� ä�����ϱ� K������ ����
		}
		while(!stack.isEmpty()) {	//stack�� ������ 4�� 7�� ��ȯ
			output.append(stack.pop()*3 +4);	//0�̸� 4, 1�̸� 7
		}
		System.out.println(output);
	}
}
