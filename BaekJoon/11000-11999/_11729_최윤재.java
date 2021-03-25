package week10;
import java.io.*;
public class _11729_������ {

	static int num;			// ���� ����
	static int total;		//�� �����̴� Ƚ��
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		num = Integer.parseInt(br.readLine());
		
		bw.write((int) Math.pow(2, num)-1 + "\n");				//�ϳ��� Ÿ�� �ּ� �̵�Ƚ�� ���� (2^���ǰ��� -1)
		hanoi(num, 1, 2, 3);									//��� ȣ��. num���� 1���� 2�� �̿��� 3����
		//System.out.println(total);							//�̵��ø��� total++�ؼ� System.out.println(total)�� ����ϸ� ���� 12������ ����� �ȵ�
		bw.flush();												//��� ���
		bw.close();
	}
	public static void hanoi (int num, int from, int via, int to) throws IOException {
		if ( num==1 ) {											//���� �ϳ��� ��
			bw.write(from + " " + to + "\n");
			//total++;
			return;
		}
		hanoi(num-1, from, to, via);							//��� ȣ��
		bw.write(from + " " + to + "\n");
		//total++;
		hanoi(num-1, via, from, to);
	}
}
