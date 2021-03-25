package week9;
import java.util.*;
public class _1992_������ {
	static StringBuilder result = new StringBuilder();		//��� ����
	static int[][] map;										//�Է� ����
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len=sc.nextInt();
		sc.nextLine();
		map=new int[len][len];
		for(int i=0; i<len; i++) {
			String tmp = sc.nextLine();
			for(int j=0; j<len; j++) {
				map[i][j]=tmp.charAt(j)-'0';
			}
		}
//////////////////////////////////////////////////////////�Է� ó��
		
		section(len, 0, 0);								//0,0���� Ȯ���ϴ� �Լ� ȣ��
		System.out.println(result);						//��� ���
	}
	
	public static void section(int wid, int x, int y) {	//�� �������� Ȯ�� �� ������� ���� �Լ�
		if(wid==1) {									//������ �� ĭ�� ��
			result.append(map[y][x]);					//�ش� ĭ�� ���� append
			return;
		}
		if(check(wid,x,y)) {							//�־��� ĭ ���� ���ڰ� �� �������� Ȯ��
			result.append(map[y][x]);					//�����ϴٸ� �ش� ĭ�� ���ڸ� append
			return;
		}
		result.append("(");								//�� ĭ�� �ƴϰ� ���������� ���� �� �켱 (�� ������
		section(wid/2, x, y);							//�� ĭ�� 4ĭ���� �ɰ� �� ĭ���� ��� ȣ��
		section(wid/2, x+wid/2, y);
		section(wid/2, x, y+wid/2);
		section(wid/2, x+wid/2, y+wid/2);
		result.append(")");								//���� �ش� ���鿡 )�� append
	}
	public static boolean check(int wid, int x, int y) {	//�־��� ĭ ���� ���ڵ��� ��� �������� Ȯ���ϴ� �Լ�
		int num=map[y][x];
		for(int i=y; i<y+wid; i++) {					//��ĭ�� Ȯ��
			for(int j=x; j<x+wid; j++) {
				if(num!=map[i][j]) return false;
			}
		}
		return true;									//�� ���� ���� true ����
	}

}
