package tmp;
import java.io.*;
import java.util.*;

class Seat implements Comparable<Seat>{			//priority queue�� ���� ��ü. ��ǥ�� �ֺ��� �����ϴ� ģ�� ��, �� �ڸ��� ��ҷ� ����
	int y;				//�켱���� ť ������ �����ϴ� ������ �����ϴ� ģ�� �� -> �� �ڸ� -> y��ǥ -> x��ǥ ��
	int x;
	int likes;
	int empty;
	Seat(int y, int x, int likes, int empty){
		this.y = y;
		this.x = x;
		this.likes = likes;
		this.empty = empty;
	}
	public int compareTo(Seat another) {
		if(this.likes == another.likes) {
			if(this.empty == another.empty) {
				if(this.y == another.y) return this.x-another.x;
				else return this.y-another.y;
			}
			else return another.empty - this.empty;
		}
		else return another.likes-this.likes;
	}
}

public class _21608_������_����ʵ��б� {
	
	static int N;
	static int[][] map;
	static int[][] like;
	static int[] axis_x = {0,0,-1,1};
	static int[] axis_y = {-1,1,0,0};
	static PriorityQueue<Seat> pq;
	static int result;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		like = new int[N*N][5];
		for(int i=0; i<N*N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<5; j++) {
				like[i][j] = Integer.parseInt(st.nextToken());		//�����ϴ� ģ�� ���� �迭
			}
		}////////////////////////////////////////////////////////////�Է�
		for(int i=0; i<N*N; i++) {
			pq = new PriorityQueue<>();		//�� �л��� ���� �켱���� ť
			assign(i);						//�л� ������� �ڸ� ��ġ
			Seat seat = pq.poll();			//���� �켱���� ���� �ڸ� poll
			map[seat.y][seat.x] = like[i][0];	//�ش� �ڸ��� �ش� �л� ����
		}
		for(int i=0; i<N; i++) {			//�ֺ��� ���� �����ϴ� ģ�� �� ��� ���� �ű��
			for(int j=0; j<N; j++) {
				int likes = 0;
				int tmp[] = new int[4];		//�̹��� ���� ����� �л��� �����ϴ� ģ������ tmp�迭�� ����
				for(int k=0; k<N*N; k++) {	//tmp �迭 ä��� ����
					if(map[i][j]==like[k][0]) {
						for(int k1=0; k1<4; k1++) tmp[k1] = like[k][k1+1];
					}
				}
				for(int k=0; k<4; k++) {	//�����¿츦 Ȯ���ؼ� �����ϴ� ģ�� ���� likes�� ����
					int y = i+axis_y[k];
					int x = j+axis_x[k];
					if(check(y,x)) {
						if(map[y][x]==tmp[0] || map[y][x]==tmp[1] || map[y][x]==tmp[2] || map[y][x]==tmp[3]) likes++;
					}
				}
				if(likes==1) result+=1;			//�����ϴ� ģ�� ����� ���� ���
				else if(likes==2) result+=10;
				else if(likes==3) result+=100;
				else if(likes==4) result+=1000;
			}
		}
		System.out.println(result);
	}
	public static void assign(int student) {		//�ڸ� ���� �Լ�
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==0) {				//���� ����ִ� �ڸ��� ���� ����
					int likes=0, empty=0;		//likes�� �����ϴ� ģ�� ��, empty�� �� �ڸ�
					for(int k=0; k<4; k++) {
						int y = i+axis_y[k];	//�����¿� ����
						int x = j+axis_x[k];
						if(check(y, x)) {		//map ���� üũ
							if(map[y][x]==0) empty++;	//���ڸ��� ��� empty����
							else if(map[y][x]==like[student][1] || map[y][x]==like[student][2] || map[y][x]==like[student][3] || map[y][x]==like[student][4]) likes++;	//�����ϴ� ģ���� ��� likes����
						}
					}
					pq.add(new Seat(i,j,likes,empty));	//priority queue�� ����
				}
			}
		}
	}
	public static boolean check(int y, int x) {			//���� üũ
		if(0<=y && 0<= x && y<N && x<N) return true;
		return false;
	}

}
