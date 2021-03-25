package week11;
import java.util.*;
public class _1697_������_���ٲ��� {

	static int subin;					//������ ��ǥ
	static int sister;					//���� ��ǥ
	static Queue<int[]> queue = new LinkedList<>();			//BFS
	static boolean[] visited = new boolean[100001];			//���ϸ� �޸� �ʰ�
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		subin = sc.nextInt();
		sister = sc.nextInt();
		
		if (subin >= sister) System.out.println(subin-sister);	//�����̰� �������� �� �ڿ� ���� ��
		else {
			queue.add(new int[] {subin, 0});					//{������ ��ġ, ��} �迭 �̿�
			while(!queue.isEmpty()) {
				int[] tmp = queue.poll();
				int loc= tmp[0];						//������ ���� ��ġ
				int count = tmp[1];						//������� ���� �ð�
				visited[loc]=true;						//�ش� ��ǥ���� �������� ǥ��
				if(loc == sister) {						//������ ���� ���
					System.out.println(count);
					break;
				}
				else {
					if(loc-1 >= 0 && !visited[loc-1]) queue.add(new int[] {loc-1, count+1});			//-1 �̵�
					if(loc+1 <= 100000 && !visited[loc+1]) queue.add(new int[] {loc+1, count+1});		//+1 �̵�
					if(loc*2 <= 100000 && !visited[loc*2]) queue.add(new int[] {loc*2, count+1});		//*2 �̵�
				}
			}
		}
	}
}

