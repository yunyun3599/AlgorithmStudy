package tmp;
import java.io.*;
import java.util.*;
public class _14500_������_��Ʈ�ι̳� {

	static int height;
	static int width;
	static ArrayList<int[][]> maps = new ArrayList<>();		//map������ �������� ���� �� 4����, ���Ϲ��� �� �������� ���� �� 4����
	static ArrayList<int[][]> shapes = new ArrayList<>();	//�ش� ������� �����̱� ���� ��ǥ �� ���� ��
	static int result = 0;	//���
	
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		 height = Integer.parseInt(st.nextToken());
		 width = Integer.parseInt(st.nextToken());
		 
		 shapes.add(new int[][] {{0,0,1,1},{0,1,0,1}});	//������� Ž���ϱ� ���� ��ǥ�̵� ��
		 shapes.add(new int[][] {{0,0,0,0},{0,1,2,3}});	//�Ѹ��
		 shapes.add(new int[][] {{0,0,0,1},{0,1,2,1}});	//�̸��
		 shapes.add(new int[][] {{0,1,1,2},{0,0,1,1}}); //�����
		 shapes.add(new int[][] {{0,0,0,1},{0,1,2,0}}); //�����
		 
		 int[][] firstmap = new int[height][width];	//ó�� ������ �Ǵ� map�Է¹ޱ�
		 for(int i=0; i<height; i++) {
			 st = new StringTokenizer(br.readLine()," ");
			 for(int j=0; j<width; j++) {
				 firstmap[i][j] = Integer.parseInt(st.nextToken());
			 }
		 }
		 maps.add(firstmap);	//���� map��� ArrayList�� ����
		 for(int i=0; i<3; i++) {	//�������� 3�� ������ �� �� ArrayList�� ����
			int[][] tmp = rotate(i);
			maps.add(tmp);
		 }
		 maps.add(upsidedown());	//���Ʒ� ������ map ��� ArrayList�� ����
		 for(int i=4; i<7; i++) {	//���Ʒ� ������ map�������� �������� 3�� ����
			 int[][] tmp = rotate(i);
			 maps.add(tmp);
		 }
		 
		 for(int[][] shape : shapes) {	//�� ��翡 ���� ���ư� map������� Ž��
			 for(int[][] map : maps) {
				 for(int i=0; i<map.length; i++) {
					 for(int j=0; j<map[0].length; j++) {
						 int tmp = 0;
						 for(int k=0; k<4; k++) {
							 int y = i+shape[0][k];
							 int x = j+shape[1][k];
							 if(check(y,x,map)) {	//�������� ������ Ž��
								 tmp+=map[y][x];
							 }
						 }
						 result = Math.max(tmp, result);	//�̹��� Ž���� ���� ���� ���� max�� ������Ʈ
					 }
				 }
				 if(shapes.indexOf(shape)==0) break;	//������̸� �ѹ��� �ϸ� ��
				 else if(shapes.indexOf(shape)==1 && maps.indexOf(map)==1) break;	//�Ѹ���̸� ���� ����̶� �������� �� �� ���� ���� �ϸ� ��
				 else if(shapes.indexOf(shape)==2 && maps.indexOf(map)==3) break;	//�̸���̸� ��������̶� �������� ���� �� 3���� ���ؼ� �ϸ� ��
				 else if(shapes.indexOf(shape)==3 && maps.indexOf(map)==5) break;	//������ ���� ����̸� �������, �������� �ѹ� ���� ���, ���Ϲ����Ѹ��, ������ ��翡 ���� �������� �ѹ� ���� ���
			 }						//������� 8���� �� �ؾ���
		 }
		 System.out.println(result);
    }
	public static int[][] rotate(int idx){	//�������� ���ư� map��� ��ȯ
		int[][] standard = maps.get(idx);
		int[][] new_map = new int[standard[0].length][standard.length];
		for(int i=0; i<standard.length; i++) {
			for(int j=0; j<standard[0].length; j++) {
				new_map[standard[0].length-j-1][i] = standard[i][j];
			}
		}
		return new_map;
	}
	public static int[][] upsidedown(){	//���Ʒ� ������ map��� ��ȯ
		int[][] standard = maps.get(0);
		int[][] new_map = new int[height][width];
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				new_map[i][j] = standard[height-i-1][j];
			}
		}
		return new_map;
	}
	
	public static boolean check(int y, int x, int[][] map) {	//���� üũ
		if(0<=y &&  0<=x && y<(map.length) && x<(map[0].length)) return true;
		return false;
	}
}
	