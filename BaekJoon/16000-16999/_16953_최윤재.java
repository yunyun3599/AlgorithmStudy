package graph;
import java.util.*;

public class _16953_������ {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int base=sc.nextInt();
		int target=sc.nextInt();
		/////////////////////////////////////////////////////////�Է�
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {base,1});					//queue���� ������� ����� ���� �ش� ������ ����ؾ� �ϴ� Ƚ���� �迭�� �ؼ� ����
				
		
		while(!q.isEmpty()) {						//bfs ����
			int[] tmp = q.poll();
			if(tmp[0]==target) {					//Ÿ�� ���� ��� poll �� ���� ���ٸ� �����̹Ƿ� tmp[1]�� ����Ǿ��ִ� ��� Ƚ�� ���
				System.out.println(tmp[1]);
				System.exit(0);
			}
			
			if (tmp[0]<100000000) {					//tmp�� target���� ���� �ʴ� �̻� *10+1������ ������ queue�� ����
				int sum = tmp[0]*10+1;
				if(sum<=target) {
					q.add(new int[] {sum,tmp[1]+1});
				}
			}
			
			int mul = 2*tmp[0];						//*2������ �� queue�� ����
			if(mul<=target) {
				q.add(new int[] {mul,tmp[1]+1});
			}
		}
		System.out.println(-1);						//target���� ������� ��쿡�� -1 ���
		
	}

}


//16953. A->B