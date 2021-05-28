package tmp;
import java.io.*;
import java.util.*;
public class _9081_������_�ܾ���߱� {

	static int testcase;
	static StringBuilder result = new StringBuilder();		//�������
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testcase = Integer.parseInt(br.readLine());
		for(int i=0; i<testcase; i++) {			//�׽�Ʈ���̽� ������ŭ ������
			String input = br.readLine();	//�ܾ�ޱ�
			int swap_min = 0;		//ABC������ ������������ ���ĵǾ� ���� �� ���������� ���κ� �ٷ� ��
			int swap_max = 0;		//swap_min�� �ٲ� ���� (�������� �κ� �� swap_min���� ū �ּҰ�)
			int swap_min_idx=input.length()-1;	//swap�� ���� �� (�������� ���κ� �ٷ� �� �ε���) , ������ ������ ��ġ�� ��츦 ����� �ε����� �ִ밪���� �ʱ�ȭ
			int swap_max_idx=input.length()-1;	//swap�� ū �� (�������� �κ� �� swap_min���� ū �ּҰ��� �ε���)
			char[] word = input.toCharArray();
			for(int j=0; j<word.length-1; j++) {
				if(word[j]<word[j+1]) {		//���������� ��� ���� ������Ʈ
					swap_min = word[j];
					swap_min_idx = j;
					swap_max = word[j+1];
					swap_max_idx = j+1;
				}
				if(word[j]>=word[j+1]) {	//���������� ������ swap_max�� ������Ʈ �ؾ��ϴ� �� Ȯ���ϱ�
					if(word[j+1] < swap_max && swap_min < word[j+1]) {
						swap_max = word[j+1];
						swap_max_idx = j+1;
					}
				}
			}
			char tmp = word[swap_min_idx];
			word[swap_min_idx] = word[swap_max_idx];
			word[swap_max_idx] = tmp;	////////////swap
			input = new String(word);	//swap_min_idx�� �������� �޺κ��� �������� ����
			String prefix = input.substring(0,swap_min_idx+1);
			char[] suffix = input.substring(swap_min_idx+1).toCharArray();
			Arrays.sort(suffix);
			String res = prefix + new String(suffix);
			result.append(res+'\n');	//����� append
		}
		System.out.println(result);
	}

}
