package tmp;
import java.util.*;
import java.io.*;

class Loc{			//�ٸ� ���� �ö��ִ� Ʈ���� LocŬ������ �̿��� ǥ��
	int loc;		//�ٸ� �� ��� �ִ���
	int weight;		//�ش� Ʈ���� weight
	Loc(int loc, int weight){
		this.loc = loc;
		this.weight = weight;
	}
}
public class _13335_������_Ʈ�� {

	static int num;			//Ʈ������
	static int length;		//�ٸ� ����
	static int weight;		//�ٸ��� ��ƿ �� �ִ� ����
	static int[] truck;		//�� Ʈ���� ����
	static Queue<Loc> onBridge = new LinkedList<>();	//�ٸ� ���� �ö� �ִ� Ʈ���� ��ġ�� weight������ ť
	static int time;		//�ҿ� �ð�
	static int idx;			//���° Ʈ������ ó���ƴ��� Ȯ�ο�
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		num = Integer.parseInt(st.nextToken());
		length = Integer.parseInt(st.nextToken());
		weight = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		truck = new int[num];
		for(int i=0; i<num; i++) {
			truck[i] = Integer.parseInt(st.nextToken());
		}/////////////////////////////////////////////////////////�Է�
		onBridge.add(new Loc(1, truck[idx++]));		//ù��° Ʈ�� �÷�����
		time++;										//1�� ����
		while(!onBridge.isEmpty()) {
			time++;						//�ð� ����
			int weight_sum=0;			//���� �ٸ��� �ö��ִ� Ʈ�� ������ ����
			int onBridge_num=onBridge.size();	//���� ť�� �ö��ִ� Ʈ���� ���ؼ� ��ĭ�� ����
				while(onBridge_num-->0) {
					Loc tmp = onBridge.poll();
					if(tmp.loc+1<=length) {		//ù��° Ʈ���� 1�� �Ŀ��� �ٸ� ���� �ִ� ���
						weight_sum += tmp.weight;	//�߷� ���տ� �ش� �߷� ���ϱ�
						onBridge.add(new Loc(tmp.loc+1, tmp.weight));	//�� ��ġ�� �ݿ��Ͽ� queue�� �ٽ� �ֱ�
					}
				}
				if(idx<num && truck[idx]<=weight-weight_sum) {	//���ο� Ʈ���� �ø� �� �ִ� ���
					onBridge.add(new Loc(1, truck[idx++]));
				}
		}
		System.out.println(time);	//�ð� ���
	}

}
