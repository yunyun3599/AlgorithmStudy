package week8;
import java.io.*;
public class _2579_������ {
	
	static int stair[];
	static int result[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int stair_num=Integer.parseInt(bf.readLine());
		stair=new int[stair_num+1];													//�� ��� �� ����ġ �� ����
		result=new int[stair_num+1];												//�κ� �ִ밪 ����
		
		for(int i=1; i<stair.length; i++) {											//stair����ġ �Է¹ޱ�
			stair[i]=Integer.parseInt(bf.readLine());
		}
		
		result[0]=0;																//�����ϴ� �κ��� ����ġ 0���� �ΰ� ����
		result[1]=stair[1];															//ù°ĭ �ʱ�ȭ
		if(stair_num>1)	result[2]=stair[1]+stair[2];								//��� ������ 1���� �� ������ if�� ó�� �����ָ� ��Ÿ�� ���� ��
		
		for(int i=3; i<stair.length; i++) {											//�κ��ִ밪 ���
			result[i]=Math.max(result[i-2]+stair[i], result[i-3]+stair[i-1]+stair[i]);	//�ٷ� ��ĭ�� 3ĭ ���� ��ġ�� ��� or ��ĭ ���� ��ġ�� ���
		}
		System.out.println(result[stair_num]);										//��� ���
	}

}

//��� ������