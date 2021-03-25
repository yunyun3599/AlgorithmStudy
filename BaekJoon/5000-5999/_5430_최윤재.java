package week8;
import java.util.*;
import java.io.*;
public class _5430_������ {

	static StringBuilder result = new StringBuilder();
	static LinkedList<String> arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));			//�Է¹ޱ�
		
		int testcase=Integer.parseInt(bf.readLine());						//�� �׽�Ʈ���̽� ����
		
		for(int i=0; i<testcase; i++, result.append("\n")) {				//�׽�Ʈ���̽� �ϳ� �� �� ����
			String function = bf.readLine();								//function�� �Լ� ���ڿ� ����
			int num = Integer.parseInt(bf.readLine());						//�迭 �� ���� ����
			String tmp = bf.readLine();										//���� �Է¹���
			tmp=tmp.replace("[", "");										//�յ� ��ȣ[] ���� 
			tmp=tmp.replace("]", "");	
			arr = new LinkedList<String>();									//���� ������ LinkedList	(array ���� D ������ �� delete�� �� ���� ó���� ���� LinkedList ��)
			String[] input = tmp.split(",");								//,�� �������� �Է��� split��
			for(int j=0; j<input.length; j++) arr.add(input[j]);			//split ����� ���� �迭 ���� LinkedList�� �ű�
			
			int Dcount=0;													//D�� ������ ����
			for(int j=0; j<function.length(); j++) 
				if (function.charAt(j)=='D') Dcount++;
			
			if (Dcount > arr.size() || Dcount>tmp.length()) {				//D�� ������ ���� �������� ������ error�� �����. ���� ���� ���� arr.size()�� 1�� ���ͼ� tmp.length�� ���ǿ� or�� ��
				result.append("error");
				continue;
			}
			
			result.append("[");												//error �ƴ� �� ����� ���� [�� ���� append
			int idx = 0;													//���� �տ����� ����ϴ��� ����� ����ϴ��� �˱� ���� idx ��
			for(int j=0;j<function.length();j++) {
				if (function.charAt(j)=='R' && idx==0) idx=arr.size()-1;	//R�� ���Դµ� idx�� 0�̸� �ں��� ����ؾ��ϹǷ� idx ���� �ٲ�
				else if(function.charAt(j)=='R' && idx !=0) idx=0;			//R�� ���Դµ� idx�� 0�ƴϸ� �պ��� ����ؾ��ϹǷ� idx�� 0���� �ٲ�
				else {														//D�� ���� ���� ���� idx�� ����Ű�� �ִ� ���� ����
					arr.remove(idx);
					if(idx!=0) idx--;
				}
			}
			if(idx==0) {													//�պ��� ����ؾ� �ϴ� ���
				while(!arr.isEmpty()) {
					result.append(arr.removeFirst());
					result.append(",");
				}
			}
			else {															//�ں��� ����ؾ� �ϴ� ���
				while(!arr.isEmpty()) {
					result.append(arr.removeLast());
					result.append(",");
				}
			}
			if(result.charAt(result.length()-1)==',') result.deleteCharAt(result.length()-1);		//������ �޸� ����. []�� ����ϴ� ���� �׳� ������ character����� [�� �������Ƿ� ������ character�� ,���� Ȯ��
			result.append("]");												//] append
		}
		System.out.println(result);											//���� ��� ���
	}
}

//AC