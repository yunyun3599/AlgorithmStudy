package week12;
import java.io.*;
import java.util.*;
public class _14889_������_��ŸƮ�͸�ũ {
	
	static int num;							// ��� ��
	static int[][] power;					// �ɷ�ġ �迭
	static int[] assigned;					// �ش� ����� start���� ���������� 1, �ƴϸ� 0
	static int result = 100000;				// �����
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		power = new int[num][num];
		assigned = new int[num];
		
		for(int i=0; i<num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<num; j++) {
				power[i][j] = Integer.parseInt(st.nextToken());				
			}
		}///////////////////////////////////////////////////////////////// �Է�
		assign(0,0);						//ù��° ����� ���ؼ� ���� ����
		System.out.println(result);			//��� ���
	}
	
	public static void assign(int player, int total) {
		if(total == num/2) {										//�� �ο��� �� �� ���
			ArrayList<Integer> start = new ArrayList<Integer>();	//start���� ���� ����� �ε��� ����
			ArrayList<Integer> link = new ArrayList<Integer>();		//��ũ���� ���� ����� �ε��� ����
			int power_start = 0;									//��ŸƮ���� �ɷ�ġ ��
			int power_link = 0;										//��ũ���� �ɷ�ġ ��
			for(int i=0; i<num; i++) {								//�ش��ϴ� �ε����� �� ���� arraylist�� �־���
				if(assigned[i] == 1) start.add(i);
				else link.add(i);
			}
			for(int i=0; i<num/2-1; i++) {							//arraylist���� �ε��� Ȯ���ؼ� �ɷ�ġ�� �յ��� ����
				for(int j=i+1; j<num/2; j++) {
					power_start += power[start.get(i)][start.get(j)] + power[start.get(j)][start.get(i)];
					power_link += power[link.get(i)][link.get(j)] + power[link.get(j)][link.get(i)];
				}
			}
			result = Math.min(result, Math.abs(power_start - power_link));		//��������� �ɷ�ġ ���� �� ���� ���� ���� ����� ����
			return;
		}
		for(int i = player; i<num; i++) {
			if(assigned[i] == 0) {
				assigned[i] = 1;			//�ش� ����� start���� ���� ���
				assign(i+1, total+1);		
				assigned[i] = 0;			//�ش� ����� start���� ������ ���� ���
			}
		}
	}

}
