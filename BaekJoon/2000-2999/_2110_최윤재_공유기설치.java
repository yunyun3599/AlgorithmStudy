package week14;
import java.io.*;
import java.util.*;
public class _2110_������_�����⼳ġ {

	static int house_num;
	static int wifi;
	static int[] house;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		house_num = Integer.parseInt(st.nextToken());
		wifi = Integer.parseInt(st.nextToken());
		house = new int[house_num];
		for(int i = 0; i<house_num; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(house);
		
		int left = 1;									//������ �� �ִ� �Ÿ��� 1�� ��
		int right = house[house_num-1] - house[0];		//������ 2���� �� (�ִ� �Ÿ�)
		int dist = 0 ;
		int result = 0;
		
		while(left <= right) {
			int mid = (left + right) / 2;				//�̹��� ������ ����
			int low = house[0];							//���� �� ��
			int num = 1;								//������ ��ġ ����
			
			for(int i=1; i<house_num; i++) {			//�� ���� ������ ��ġ
				dist = house[i] - low;
				if(mid <= dist) {
					low = house[i];
					num++;
				}
			}
			if(num >= wifi) {							//�����Ⱓ ������ ������ �� ��
				result = mid;
				left = mid + 1;
			}
			else {										//�����Ⱓ ������ �ٿ��� �� ��
				right = mid-1;
			}
		}
		System.out.println(result);
	}

}
