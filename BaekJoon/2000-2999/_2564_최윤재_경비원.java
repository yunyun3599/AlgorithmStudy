package week15;
import java.util.*;

class Loc{					//�� ������ ��ġ
	int dir;
	int x;
	int y;
	Loc(int dir, int x, int y){
		this.dir = dir;
		this.x = x;
		this.y = y;
	}
}

public class _2564_������_���� {

	static int width;
	static int height;
	static int store;
	static Loc[] map;
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		width = sc.nextInt();
		height = sc.nextInt();
		store = sc.nextInt();
		map = new Loc[store];
		
		for(int i=0; i<store; i++) {
			int dir = sc.nextInt();
			int offset = sc.nextInt();
			map[i] = setLocation(dir, offset);
		}
		///////////////////////////////////////////////���� �Է�
		int dir = sc.nextInt();
		int offset = sc.nextInt();
		Loc dong = setLocation(dir, offset);
		//////////////////////////////////////////////������ ��ġ �Է�
		int exception = 0;							//���ֺ��� �ִ� ���� Ư���� ����̹Ƿ� ���ֺ��� ������ exception������ ����
		if (dong.dir == 1) exception = 2;
		else if(dong.dir == 2) exception=1;
		else if (dong.dir == 3) exception = 4;
		else exception = 3;

		for(int i=0; i<store; i++) {
			Loc tmp = map[i];
			if (tmp.dir == exception) {				//������ ���
				int max = height + width;
				int point_x = width - dong.x;
				int point_y = height - dong.y;
				int diff = Math.abs(point_x - tmp.x) + Math.abs(point_y - tmp.y);	//�ִ� �Ÿ� �������� ������ ��ŭ ���ִ� ����
				result += (max - diff);
			}
			else
				result += Math.abs(dong.x - tmp.x) + Math.abs(dong.y - tmp.y);		//����� ���
		}
		System.out.println(result);
		 
	}
	
	public static Loc setLocation(int dir, int offset) {							//��ǥ ��ȯ
		Loc loc;
		switch(dir) {
		case 1:							//�� [0][x]
			loc = new Loc(dir, offset, 0);
			break;
		case 2:							//�� [height][x]
			loc = new Loc(dir, offset, height);
			break;
		case 3:							//�� [x][0]
			loc = new Loc(dir, 0, offset);
			break;	
		default:							//�� [width][x]
			loc = new Loc(dir, width, offset);
			break;
		}
		return loc;
	}
}
