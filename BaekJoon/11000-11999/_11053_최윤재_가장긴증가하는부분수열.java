package tmp;
import java.util.*;
import java.io.*;


public class _11053_������_����������ϴºκм��� {

	static int len;
	static int[] arr;
	static LinkedList<Integer> dp = new LinkedList();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		len = Integer.parseInt(br.readLine());
		arr = new int[len];
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr[0] = Integer.parseInt(st.nextToken());
		dp.add(arr[0]);
		for(int i=1; i<len; i++) {
			arr[i] = Integer.parseInt(st.nextToken());		//�Է¹ޱ�
			int idx = binary_search(arr[i]);		//����Ž������ arr[i]���� ���� ũ�ų� arr[i]�� ���� ū ��� ���� ���� �ε����� ��������
			if(dp.get(idx)>=arr[i]) dp.set(idx, arr[i]);	//arr[i]�� �޾ƿ� arr[idx]�� ������ ������ dp[idx]�� �� �ٲ�
			else if(idx==dp.size()-1) dp.add(arr[i]);	//idx�� ������ ���Ҷ�� ���� �ڿ� appendx
		}
		System.out.println(dp.size());
	}
	
	public static int binary_search(int num) {			//����Ž��
		int low = 0; int high=dp.size()-1; int mid = (low+high)/2;
		System.out.println();
		while(low<high) {
			if(num==dp.get(mid)) {
				return mid;
			}
			if(num>dp.get(mid)) {
				low=mid+1;
			}
			else {
				high=mid;
			}
			mid = (low+high)/2;
		}
		return low;
	}
}
