package tmp;
import java.io.*;
import java.util.*;
public class _3967_������_������Ÿ {
	
	static char[][] final_map = new char[5][9];	//���� ����� ��
	static int[][] map = new int[5][9];		//int ������ �����س��� map (���� �� map)
	static boolean[] used = new boolean[12];	//1-12�� �̹� ���� ���̸� true
	static String result = "";	//���� ��� String�� ����
	static ArrayList<int[]> empty_loc = new ArrayList<>();	//ä�����ϴ� ���� ��ġ
	static int[][] loc = {{0,4},{1,1},{1,3},{1,5},{1,7},{2,2},{2,6},{3,1},{3,3},{3,5},{3,7},{4,4}};	//���ڰ� �����ϴ� ���� ��ġ
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<5; i++) {
			String tmp = br.readLine();
			for(int j=0; j<9; j++) {
				char tmp_char = tmp.charAt(j);
				int tmp_num = tmp_char - 'A' + 1;
				if(0 < tmp_num && tmp_num < 13) {	//���ĺ��� �������� 1-12�� ����
					map[i][j] = tmp_num;
					used[tmp_num-1] = true;
				}
				else if(tmp_char=='.') map[i][j] = -1;	//ä���� ���� ���� -1
				else {		//���� ���� ���� ���� ���� 0
					map[i][j] = 0;
					empty_loc.add(new int[] {i,j});
				}
				final_map[i][j] = tmp_char;
			}
		}
		fill(0);	//ä��� ����
		int idx = 0;
		for(int[] yx : loc ) {
			final_map[yx[0]][yx[1]] = result.charAt(idx++);	//����� �޾ƿ� String�� ���� finalmap�� ����
		}
		for(int i=0; i<5; i++) {	//��� ���
			for(int j=0; j<9; j++) {
				System.out.print(final_map[i][j]);
			}System.out.println();
		}
	}
	public static void fill(int idx) {	//�� ä���
		if(idx == empty_loc.size()) {	//��� ���� ä���� ���
			if(calc()) {	//��� ���� 26���� Ȯ��
				for(int i=0; i<12; i++) {	//�´ٸ� char���� ���� result�� string�� �ֱ�
					result += Character.toString((char)((map[loc[i][0]][loc[i][1]]-1)+'A'));
				}
			}
			return;
		}
		int[] yx = empty_loc.get(idx);	//�̹��� Ž���� ���� x,y��ǥ
		int y = yx[0]; int x = yx[1];
		for(int i=1; i<13; i++) {
			if(used[i-1]) continue;	//�̹� ���� ���̸� continue
			map[y][x] = i;	//���� �Ⱦ��� �� �ֱ�
			used[i-1] = true;//��ٰ� ǥ��
			fill(idx+1);
			used[i-1] = false;
			if(!result.equals(""))return;	//�̹� result�� ���� ���� ���̻� �� �ʿ� �����ϱ� return (�̰� �Ƚ�ٰ� �ð��ʰ���)
		}
	}
	
	public static boolean calc() {	//��� line�� ���� 26���� Ȯ��
		int line1=0, line2=0, line3=0, line4=0, line5=0, line6=0;
		line1 = map[0][4]+map[1][3]+map[2][2]+map[3][1];
		line2 = map[0][4]+map[1][5]+map[2][6]+map[3][7];
		line3 = map[1][1]+map[1][3]+map[1][5]+map[1][7];
		line4 = map[1][1]+map[2][2]+map[3][3]+map[4][4];
		line5 = map[1][7]+map[2][6]+map[3][5]+map[4][4];
		line6 = map[3][1]+map[3][3]+map[3][5]+map[3][7];
		if(line1==26 && line2==26 && line3==26 && line4==26 && line5==26 && line6==26) return true;
		return false;
	}

}
