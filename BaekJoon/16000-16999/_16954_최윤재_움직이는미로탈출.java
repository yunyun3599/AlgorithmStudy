package tmp;
import java.io.*;
import java.util.*;

public class _16954_������_�����̴¹̷�Ż�� {

	static char map[][] = new char[8][8];	//ó�� �� ����
	static ArrayList<int[]> wall = new ArrayList<>();	//���� �� ��ġ(#)
	static Queue<int[]> loc = new LinkedList<>();	//���� ������ ��ġ ����� ���� ����
	static boolean[][] visited;	//�湮ó����
	static int dx[] = {-1,-1,-1,0,0,0,1,1,1};	//�����¿�밢������
	static int dy[] = {-1,0,1,-1,0,1,-1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<8; i++) {
			String str = br.readLine();
			for(int j=0; j<8; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '#') wall.add(new int[] {i,j});	//�� ��ġ�� wall�� �ִ� ��� wall arraylist�� ��ġ ����
			}
		}
		loc.add(new int[] {7,0});	//ù ��ġ
		while(!loc.isEmpty()) {		//������ ����� ���� ������ �ݺ��� ����
			int wall_num = wall.size();
			ArrayList<int[]> new_wall = new ArrayList<>();	//wall�� 1�� �� �̵��� ��ġ�� ����
			for(int i=0; i<wall_num; i++) {
				int[] cur = wall.get(i);
				int ny = cur[0]+1;	//��ĭ�� ������ ����
				int nx = cur[1];
				if(ny<8) new_wall.add(new int[] {ny,nx});
			}
			int iter = loc.size();	//���� ������ ���µ鿡 ���� for�� ����
			visited = new boolean[8][8];
			for(int i=0; i<iter; i++) {
				int[] cur = loc.poll();
				for(int k=0; k<9; k++) {	//�����¿�밢������ �� ����
					int ny = cur[0]+dy[k];
					int nx = cur[1]+dx[k];
					if(check(ny, nx)) {		//�̵��� �� �ִ� ĭ���� Ȯ��
						if(ny==0 && nx==7) {	////������ ������ ���
							System.out.println(1);
							System.exit(0);
						}
						boolean flag=false;
						for(int j=0; j<wall.size(); j++) {	//���� ���� �ִ� ĭ���� Ȯ��
							int[] blocked = wall.get(j);
							if(blocked[0] == ny && blocked[1] == nx) {
								flag = true;
								break;
							}
						}
						for(int j=0; j<new_wall.size(); j++) {	//1�� �� ���� ������ ĭ���� Ȯ��
							int[] blocked = new_wall.get(j);
							if(blocked[0] == ny && blocked[1] == nx) {
								flag = true;
								break;
							}
						}
						if(!flag) {	//���絵 ���� ���� 1�� �Ŀ��� ���� ���� ��쿡 ���ؼ��� ��ǥ ����
							loc.add(new int[] {ny,nx});
							visited[ny][nx] = true;	//�湮 ó��
						}
					}
				}
			}
			wall = new_wall;	//���� ���� ���� wall array�� ����Ű�� ��ü �ٲٱ�
		}
		System.out.println(0);
	}
	public static boolean check(int y, int x) {
		if(0<=y && 0<= x && y<8 && x<8 && !visited[y][x]) return true;
		return false;
	}
}
