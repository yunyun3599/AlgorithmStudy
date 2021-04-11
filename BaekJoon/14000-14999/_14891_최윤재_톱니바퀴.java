package tmp;
import java.io.*;
import java.util.*;
public class _14891_������_��Ϲ��� {

	static LinkedList<Integer>[] wheel = new LinkedList[4];	//������ �ε��� 2, ���� �ε��� 6, �ð���� ȸ���ÿ� ������ poll�ؼ� ������, �ݽð�����϶��� pollFirst�ؼ� ���� �ڷ�
	static boolean handled[] = new boolean[4];	//�̹� ���� ��Ϲ������� Ȯ��

	public static void main(String[] args) throws IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<4; i++) {
			wheel[i] = new LinkedList<>();
			String tmp = br.readLine();
			for(int j=0; j<8; j++) wheel[i].add(tmp.charAt(j)-'0');	//N���� 0, S���� 1
		}	//�Է�
		
		int num = Integer.parseInt(br.readLine());	//������ Ƚ��
		
		while(num-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int wheel_num = Integer.parseInt(st.nextToken())-1;	//���� ��Ϲ��� idx
			int dir = Integer.parseInt(st.nextToken());		//�ð������ 1, �ð�ݴ������ -1
			rotate(wheel_num, dir);
		}
		int result=0;
		for(int i=0; i<4; i++) {
			if(wheel[i].get(0)==0) continue;	//N�̸� result�� ������ ����
			result += Math.pow(wheel[i].get(0)*2, i);	//S�� 2�� i���Ѹ�ŭ ���ϱ�
		}
		System.out.println(result);
	}
	
	public static void rotate(int idx, int dir) {	//������
		handled[idx] = true;	//�̹� ��Ϲ����� �������� üũ
		int next_idx = idx-1;	//�´���ִ� ��Ϲ�����
		if(0<=next_idx && !handled[next_idx]) {	//�̹� ��Ϲ����� ���ʿ� �ִ� ��Ϲ���
			if(wheel[idx].get(6) != wheel[next_idx].get(2)) rotate(next_idx, dir*(-1)); 	//����ִ� ���� �ٸ��� ��������� ����
		}
		next_idx = idx+1;	//�̹� ��Ϲ����� �����ʿ� �ִ� ��Ϲ���
		if(next_idx<=3 && !handled[next_idx]) {
			if(wheel[idx].get(2) != wheel[next_idx].get(6)) rotate(next_idx, dir*(-1)); 
		}
		if(dir==1) {	//�ð�����ϰ��
			int move = wheel[idx].pollLast();
			wheel[idx].addFirst(move);
		}
		else {	//�ݽð�����ϰ��
			int move = wheel[idx].pollFirst();
			wheel[idx].add(move);
		}
		handled[idx] = false;	//�湮 ó�� Ǯ���ֱ�
	}

}
