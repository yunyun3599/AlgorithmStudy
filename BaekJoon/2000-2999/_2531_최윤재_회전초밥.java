package tmp;
import java.util.*;
import java.io.*;
public class _2531_������_ȸ���ʹ� {
	
	static int dish;		//���� ����
	static int sushi;		//���� ���� ����
	static int num;			//���� �� �ִ� �ִ� ����
	static int coupon;		//���� ���� ��ȣ
	static int[] arr;		//���� �� ���� ����
	static boolean[] visited;	//�ش� ���ð� �Ծ��� �������� ǥ��
	static int result;		//���
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		dish = Integer.parseInt(st.nextToken());
		sushi = Integer.parseInt(st.nextToken());
		num = Integer.parseInt(st.nextToken());
		coupon = Integer.parseInt(st.nextToken());
		arr = new int[dish];
		for(int i=0; i<dish; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}////////////////////////////////////////////////////�Է�
		for(int i=0; i<dish; i++) {
			result= Math.max(check(i), result);		//i��° ���ú��� �����ϴ� ���
		}
		System.out.println(result);
	}
	public static int check(int start) {
		visited = new boolean[sushi+1];	//���� �������� Ȯ���ϱ� ����
		int count = 0;		//���� �ٸ� ���� � �Ծ��� ǥ��
		int idx = start;	//��ĭ�� �̵��� �ε���
		while(true) {
			if(idx-start == num) {	//���� �� �ִ� ������ŭ �� �Ծ��� ��
				if(!visited[coupon]) return count+1;	//������ ���� �Ⱦ� ���
				return count;	//������ �ش��ϴ� �ʹ��� �̹� ���� ���
			}
			if(!visited[arr[idx%dish]]) {	//���� �Ծ�� ���� ������ ��
				visited[arr[idx%dish]] = true;	//�ش� ���ø� �Ծ������ ����
				count++;	//�Ծ ���� ���� ���� �ϳ� �ø���
			}
			idx++;		//�ε��� �ϳ� ����(�̹� �Ծ ������ ��쿡�� count�� �ø��� �ʴ´�.)
		}
	}

}
