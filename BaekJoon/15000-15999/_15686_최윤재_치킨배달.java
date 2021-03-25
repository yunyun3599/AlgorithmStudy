package week13;
import java.util.*;
import java.io.*;

class Location{
	int y;
	int x;
	Location(int y, int x){
		this.x = x;
		this.y = y;
	}
}

public class _15686_������_ġŲ��� {

	static int N;				//���� ũ�� N*N
	static int M;				//�ִ� ġŲ�� ����
	static boolean[] open;
	static ArrayList<Location> house = new ArrayList<>();		//���� �ִ� ��ġ���� ����
	static ArrayList<Location> chicken = new ArrayList<>();		//ġŲ���� �ִ� ��ġ���� ����
	static int distance = 1000000;		//���� ���
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				int check = Integer.parseInt(st.nextToken());
				if(check == 1) house.add(new Location(i,j));		//���� ��ġ add
				if(check == 2) chicken.add(new Location(i,j));		//ġŲ���� ��ġ add
			}
		}
		open = new boolean[chicken.size()];						//open�迭�� �� ġŲ���� true�� ����
		
		makemap(0, 0);
		bw.write(distance+" ");
		bw.flush();
		bw.close();
	}
	
	public static void makemap(int loc, int num) {
		if (num == M) {												//�� ġŲ���� M���� ���� ��
			int tmp_total_distance = 0;								//�̹��� ���� ġŲ���� ���� �� �Ÿ�
			for(int i=0; i<house.size(); i++) {
				int tmp = 101;										//Ư�� ���� ġŲ������ �ּ� �Ÿ� ����
				for(int j=0; j<chicken.size(); j++) {
					if (open[j]) {
						int dist = Math.abs(house.get(i).y-chicken.get(j).y) + Math.abs(house.get(i).x-chicken.get(j).x);	//�̹��� ���� ġŲ���� ���ݱ����� �ּҰ� �� �� ������ ä��
						tmp = Math.min(tmp, dist);
					}
				}
				tmp_total_distance += tmp;							//���� �ּҰŸ��� �̹� ���̽��� �� �Ÿ��� ����
			}
			distance = Math.min(distance, tmp_total_distance);		//���� ������� ���Ͽ� �� ���� ���� ���������� ������Ʈ
			return;
		}
		for(int i=loc; i<chicken.size(); i++) {						//i��° ġŲ���� ���� ���� ���� ���� ��쿡 ���� Ž��
			open[i] = true;
			makemap(i+1, num+1);									//num�� �� ġŲ���� ����
			open[i] = false;
		}
	}
}


