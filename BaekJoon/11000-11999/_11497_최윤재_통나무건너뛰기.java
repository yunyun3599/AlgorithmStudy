package week15;
import java.io.*;
import java.util.*;
public class _11497_������_�볪���ǳʶٱ� {

	static int testcase;
	static int num;
	static int height[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		testcase = Integer.parseInt(br.readLine());						//�׽�Ʈ���̽� ����
		
		for(int i=0; i<testcase; i++) {
			num = Integer.parseInt(br.readLine());						//�볪�� ����
			height = new int[num];										//�볪�� ���� ����
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = 0;
			while(st.hasMoreTokens()) 
				height[idx++] = Integer.parseInt(st.nextToken());		//������� �Է�
			Arrays.sort(height);										//���̼����� �迭
			int idx_low = 0;											//�տ������� ä��� �ε���
			int idx_high = num-1;										//�ڿ������� ä��� �ε���
			int[] tmp = new int[num];									//�������� �ּҰ� �ǵ��� �����س��� �迭
			idx = 0;
			while(idx_low < idx_high) {									//���̼����� �����س��� �迭�� �ϳ��� �� �ϳ��� �ڿ������� �������� ����
				tmp[idx_low++] = height[idx++];
				tmp[idx_high--] = height[idx++];
			}
			if (idx_low == idx_high) tmp[idx_low] = height[idx];		//�볪�� ������ Ȧ���� �� �ڵ鸵
			int res = 0;
			for(int j=0; j<num-1; j++) 									//���� ���� �ִ��� ��� ���ϱ�
				res = Math.max(res, Math.abs(tmp[j]-tmp[j+1]));
			res = Math.max(res, Math.abs(tmp[0]-tmp[num-1]));
			result.append(res+"\n");									//��� ���
		}
		System.out.println(result);
	}

}
