package week18;
import java.util.*;
import java.io.*;
public class _1541_������_�Ҿ������ȣ {

	static ArrayList<Integer> arr = new ArrayList();	//���ڵ� ������ arraylist
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String expression = br.readLine();	//expression�� ��ü ���� ����
		int loc = 0;	//���� ������ ��ȣ�� �˱� ���� �ε���
		StringTokenizer st = new StringTokenizer(expression, "+-");	//+-�� �����ڷ� �ؼ� ���ڸ� ����
		String tmp = st.nextToken();	//tmp�� ���� ��
		arr.add(Integer.parseInt(tmp));	//ó�� ���ڴ� ������ ���
		loc += tmp.length();	//������ ���̸� ����� loc �ε��� ������Ŵ
		while(st.hasMoreTokens()) {
			tmp = st.nextToken();	//���� ���ڿ� ���� ����
			if (expression.charAt(loc)=='+') arr.add(Integer.parseInt(tmp));	//���� ���ڰ� ����� ���
			else arr.add(-Integer.parseInt(tmp));	//���� ���ڰ� ������ ���
			loc += tmp.length()+1;	//��ȣ Ȯ���� ���� loc ����
		}
		int result = 0;	//����� ����
		boolean inbracket = false;	//ó�� ������ ������ true�� �ٲ㼭 +������ ��ȣ ���� -���� �׳� ���
		for(int i : arr) {	//�� ���ҿ� ���� ����
			if (!inbracket) {	//���� ������ �ϳ��� �ȳ����� ��
				result += i;	//����� ������ ���ؾ� ��
				if (i < 0) inbracket = true;//������ ������ inbracket���� true�� �ٲٱ�
			}
			else {	//������ ���� �� ���
				if (i < 0) result += i;	//������ �׳� ����
				else result -= i;	//����� ��ȣ �ٲ㼭 ����
			}
		}
		System.out.println(result);
	}

}
