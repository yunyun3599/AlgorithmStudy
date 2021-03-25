package week19;
import java.io.*;
import java.util.*;
public class _3079_������_�Ա��ɻ� {

	static int num;
	static int friends;
	static int[] immigration;		//�ɸ��� �ð� ����
	static long max;			//���� �ð� ���� �ɸ��� �Ա��ɻ�� (�ִ� ��� ����)
	static long result = Long.MAX_VALUE;	//���
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		num = Integer.parseInt(st.nextToken());		//�Ա��ɻ�� ����
		friends = Integer.parseInt(st.nextToken());	//ģ�� ���
		immigration = new int[num];
		for(int i=0; i<num; i++) {
			immigration[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, immigration[i]);
		}
		binary_search();		//�̺�Ž�� ����
		System.out.println(result);
	}
	
	public static void binary_search() {
		long low = 0;
		long high = max * friends;	//���� ���� �ɸ��� �ɻ�뿡�� ��ΰ� ���� �� ��찡 �ִ� �ɸ��� �ð�
		
		while(low <= high) {		//�ð��� key������ �ؼ� �̺�Ž�� ����
			long mid = (low + high)/2;
			long possible = 0;
			
			for(int i=0; i<num; i++) {	//���� �ð����� ������ �ɻ���� �� �ִ����� possible�� ����
				possible += mid / immigration[i];
			}
			if(possible >= friends) {	//���� mid���� �ð� ���� ��� ģ���� �ɻ� ���� �� ������ �ð� �ٿ�����
				result = Math.min(result, mid);
				high = mid - 1;
			}
			else low = mid + 1;		//���� �ð� ���� ��� ����� �ɻ���� ���� ��� �ð� �ø���
		}
	}
}
