package tmp;
import java.util.*;
import java.io.*;
public class _2230_������_������ {

	static int N,M;
	static int[] arr;
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		////////////////////////////////////////////////////////�Է�
		Arrays.sort(arr);		//����
		int left = 0;			//���� ��
		int right = 0;			//������ ��
		while(left<N && result != M) {	//M�� �����ϴٰ� �Ǹ��ų� �迭 ��� Ȯ���� ������ �ݺ�
			int diff = arr[right] - arr[left];	//�� �ܰ躰�� ���ҵ� ��
			if(diff<M && right<N-1) right++;	//���̰� M���� ������ ������ �ε��� 1 ����
			else {		//���̰� M���� ū ���
				if(diff>=M) result = Math.min(result, diff);	//M���� ū ��쿡 ���ؼ��� result�� �� ���� ������ ������Ʈ
				left++;	//���� �ε��� ����
			}
		}
		System.out.println(result);
	}

}
