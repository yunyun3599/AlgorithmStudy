package week11;
import java.io.*;
import java.util.*;

public class _5052_������_��ȭ��ȣ���_3 {

	static String[] num_list;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcase = Integer.parseInt(br.readLine());
		
		Loop:
		for(int i=0; i<testcase; i++) {
			int num = Integer.parseInt(br.readLine());					//��ȣ ����� �Է�
			num_list = new String[num];
			for(int j=0; j<num; j++) num_list[j] = br.readLine();		//��ȣ���� �迭�� ����
			Arrays.sort(num_list);										//��ȣ ���� (������)
			for(int j=0; j<num-1; j++) {							
				if (num_list[j+1].length() > num_list[j].length()) {	//�޹�ȣ�� ���̰� �� �� ��쿡 ���ؼ� ����
					if(num_list[j+1].substring(0,num_list[j].length()).equals(num_list[j])) {	//�ڽ��� �տ� ��ġ�� ��ȣ�� �ڽ��� �պκ� ��ȣ�� ��
						result.append("NO\n");
						continue Loop;
					}
				}
			}
			result.append("YES\n");			
		}
		System.out.println(result);
	}

}
