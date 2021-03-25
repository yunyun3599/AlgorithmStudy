package week13;
import java.util.*;
import java.io.*;
public class _6588_������_������������ {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean[] prime = new boolean[1000001];					//prime[i] �� true�̸� i�� �Ҽ���� ��
		for(int i=0; i<1000001; i++) {							//�켱 ��� true�� �ʱ�ȭ
			prime[i] = true;
		}
		prime[0] = prime[1] = false;							//0�� 1�� �Ҽ� �ƴ�
		
		int base = 1;											//�����佺�׳׽��� ü �̿�
		while (base <= 500000) {								//base �� ������� Ȯ���ϹǷ� ������ �ݱ����� �ϸ� ��
			int mul = 2;										//base * mul ���ڸ� üũ
			for(int i=base+1; i<=1000000; i++) {				//���� base�� ����
				if (prime[i]) {									//�� base���� ū �� �� prime[base] = true�� ��찡 �� base��
					base = i;
					break;
				}
			}
			while(base * mul <= 1000000) {						//base*mul ���� false�� �ٲ�
				prime[base * mul] = false;
				mul++;
			}
		}
		
		while(true) {
			boolean flag = false;								//�� �Ҽ��� ������ ǥ�� �����ϸ� true �ƴϸ�  false
			int num = Integer.parseInt(br.readLine());
			if (num == 0) break;
			for(int i=3; i<=num/2; i++) {						//3���� ��ǥ���� �ݱ��� ������ ���� ���� �Ǵ� ��� ����
				if (prime[i] && prime[num-i]) {
					bw.write(num+" = "+i+" + "+(num-i)+"\n");
					flag = true;
					break;
				}
			}
			if(!flag) bw.write("Goldbach's conjecture is wrong.\n");
		}
		
		bw.flush();
		bw.close();
	}

}
