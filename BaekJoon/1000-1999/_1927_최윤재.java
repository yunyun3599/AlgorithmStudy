package week9;
import java.io.*;
import java.util.*;
public class _1927_������ {
	
	static ArrayList<Integer> heap = new ArrayList();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());									//�Է� ����
		
		for(int i=0; i<N; i++) {													//�Է� �ޱ�
			int tmp = Integer.parseInt(br.readLine());								//tmp�� �̹��� �Էµ� ����
			if(tmp==0) {												//0�� �Էµ� ���
				if (heap.isEmpty()) System.out.println(0);				//heap�� ��������� 0�� ���
				else {													//heap�� ������� ���� ���
					System.out.println(heap.get(0));					//min heap�̹Ƿ� ��Ʈ �� ���
					if (heap.size()!=1) {								//��Ʈ �̿ܿ��� ���� �ٸ� ���� �ִ� ���
						heap.set(0, heap.remove(heap.size()-1));		//����� ��Ʈ�� ����� �� �� ���� ��Ʈ�ڸ��� �ű� 
						down(0);										//downheap ����
					}
					else heap.remove(0);								//heap�� ��Ʈ �ϳ��� �ִ� ���� �׳� ��Ʈ �� ����� ��
				}
			}
			else {								//tmp�� ���� ���� 0�� �ƴ� ��
				heap.add(tmp);					//heap�� �ش� ���� add ������
				sort(heap.size()-1); 			//upheap ����
			}
		}
	}
	
	public static void sort(int idx) {			//upheap �����ϴ� �Լ�
		int idx_parents=(idx-1)/2;				//parent �ε���
		int parents=heap.get(idx_parents);		//parent ��
		int child=heap.get(idx);				//�ڽ� ��� ��
		if(parents>child) {						//parent�� ���� �� Ŀ�� switch�� �Ͼ�� ���
			heap.set(idx_parents, child);		
			heap.set(idx, parents);
			sort(idx_parents);					//��� ȣ��� �ٲ� ���� �Ǵٽ� upheap
		}
		return;
	}
	
	public static void down(int idx) {			//downheap �����ϴ� �Լ�
		int min=0;								//�� �ڽ� ��� �� �� ���� �� ������ ���� 
		int c_idx=-1;							//�� �ڽ� ��� �� �� ���� ���� �ε��� ������ ����
		if(2*idx+1>heap.size()-1) return;		//���� ��尡 ���� ����� ���� �׳� return
		else if(2*idx+1==heap.size()-1) {		//���� �ڽ� ��常 ������ ���
			if (heap.get(idx)>heap.get(heap.size()-1)){		//���� �ڽ� ��尡 parent���� ū ���
				int tmp = heap.get(idx);					//���� �� �ٲ���
				heap.set(idx, heap.get(heap.size()-1));
				heap.set(2*idx+1, tmp);
			}
			return;
		}
		if (heap.get(2*idx+1)>heap.get(2*idx+2)) {	//������ �ڽ� ���� ���� �ڽ� ����� �� ��
			min = heap.get(2*idx+2);
			c_idx=2*idx+2;
		}
		else {
			min=heap.get(2*idx+1);
			c_idx=2*idx+1;
		}
		if(heap.get(idx)>min) {						//�� ���� �ڽ� ����� ������ �θ� ����� ���� ũ�ٸ� switch
			heap.set(c_idx, heap.get(idx));
			heap.set(idx, min);
			down(c_idx);
		}
		return;
	}
}
