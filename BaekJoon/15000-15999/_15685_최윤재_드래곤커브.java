package tmp;
import java.io.*;
import java.util.*;
public class _15685_������_�巡��Ŀ�� {
	
	static int curve;
	static int[][] input;		//�� Ŀ���� ����� �����ϴ� �迭
	static int[][] map = new int[101][101];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		curve = Integer.parseInt(br.readLine());	//�巡��Ŀ�� ����
		input = new int[curve][4];		//x,y��ǥ , ���� ����, ����
		for(int i=0; i<curve; i++) {	//������ 0  ��1  ����2  �Ʒ�3
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) input[i][j] = Integer.parseInt(st.nextToken());
		}//////////////////////////////////////////////////////////�Է�
		for(int i=0; i<curve; i++) {		//Ŀ�� ������ŭ ���� ���� ǥ��
			ArrayList<Integer> dir = new ArrayList<>();	//������ ������ �����س��� ��̸���Ʈ
			int[] loc = {input[i][0], input[i][1]};	//ó�� ��ġ
			map[loc[1]][loc[0]] = 1;	//ó�� ��ġ �������� ��������� ǥ��
			dir.add(input[i][2]);		//�ʱ� ������ �ֱ�
			int repetition = input[i][3];	//���� �巡��Ŀ������
			for(int j=0; j<repetition+1; j++) {	//�巡��Ŀ��� 0������ ���� 
				fill(dir, loc);	//Ŀ�� ��� ���ؼ� map�� ǥ���ϴ� �Լ�
				if(j!=0) { 	//dir�迭�� ��� ���� �� ��(0��Ŀ�� �ƴ�)
					ArrayList<Integer> tmp = new ArrayList();
					for(int k=0; k<dir.size(); k++) {	//���� �ִ� ������� ���� �ð�������� 90�� ����
						int changed_dir = dir.get(dir.size()-k-1) + 1;
						if (changed_dir > 3 ) changed_dir = 0;
						tmp.add(changed_dir);
					}
					dir.addAll(tmp);	//���� �迭�� ���� ���� �� �߰�
				}
				else {	//0�� Ŀ���� ��
					int changed_dir = dir.get(0) + 1;
					if (changed_dir > 3 ) changed_dir = 0;
					dir.set(0, changed_dir);
				}
			}
		}
		System.out.println(count());
	}
	
	public static void fill(ArrayList<Integer> dir, int[] loc) {
		for(int i=0; i<dir.size(); i++) {
			switch(dir.get(dir.size()-i-1)) {	//���⿡ ���� ���� ��ġ ����
			case 0:
				loc[0] += 1;
				break;
			case 1:
				loc[1] -= 1;
				break;
			case 2:
				loc[0] -= 1;
				break;
			case 3:
				loc[1] += 1;
				break;
			}
			map[loc[1]][loc[0]] = 1;
		}
	}
	
	public static int count() {		//4������ �� �巡��Ŀ���� ���簢�� ���� ���ϱ�
		int result=0;
		int[] axis_x = {0,0,1,1};
		int[] axis_y = {0,1,0,1};
		for(int i=0; i<100; i++) {		//100*100���
			for(int j=0; j<100; j++) {
				boolean flag = true;
				for(int k=0; k<4; k++) {
					if(map[i+axis_y[k]][j+axis_x[k]]==0) flag=false;	//0�ΰ� ������ false�� ǥ��
				}
				if(flag) result++;
			}
		}
		return result;
	}

}
