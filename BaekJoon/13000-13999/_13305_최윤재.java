package week10;
import java.io.*;
public class _13305_������ {
	
	static int num;				//���� ����
	static String[] distance;	//���ð� �Ÿ�
	static String[] city;		//���ÿ����� ���ʹ� ����
	static int min = 1000000001;
	static long result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num=Integer.parseInt(br.readLine());
		distance = new String[num-1];
		city = new String[num];
		distance = br.readLine().split(" ");
		city = br.readLine().split(" ");
		//////////////////////////////////////////////////////�Է�
		
		for(int i=0; i < num-1; i++) {						//���ݱ����� ���� �� ���� ���� ���� min
			int cost = Integer.parseInt(city[i]);			
			if ( cost < min ) min = cost;					//�� ������ �⸧���� �ּ� �⸧�� ��
			result += Long.parseLong(distance[i]) * min;	//���� ���ñ����� �Ÿ��� min ���ؼ� �ּ� ���� ã��
		}													//min�� distance�� �� �� 1000000000�� ��츦 �����غ��� result�� Long�� �Ǿ�� ��
		
		System.out.println(result);
	}

}
