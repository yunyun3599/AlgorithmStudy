package week19;

import java.io.*;
import java.util.*;

public class _11404_������_�÷��̵� {

	static int city;
	static int bus;
	static int map[][];
	static int MAX = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		city = Integer.parseInt(br.readLine());
		bus = Integer.parseInt(br.readLine());
		map = new int[city][city];
		for(int i=0; i<city; i++) Arrays.fill(map[i], MAX);
		for(int i=0; i<bus; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			map[start][end] = Math.min(map[start][end], weight); //�� ���� ���� ����
		}
		///////////////////////////////////�Է�
		floyd_warshall();				//�÷��̵�ͼ� ����
		for(int i=0; i<city; i++) {		//����
			for(int j=0; j<city; j++) {
				if(map[i][j]==MAX) bw.append(0+" ");
				else bw.append(map[i][j]+" ");
			}
			bw.append("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void floyd_warshall() {
		for(int i=0; i<city; i++) {		//������ ����
			for(int j=0; j<city; j++) {	//���۵���
				for(int k=0; k<city; k++) {	//��������
					if(map[j][i]!=MAX && map[i][k]!=MAX && j!=k)	//�� �� �ִ� ��쿡 ���Ͽ� Ȯ��
						map[j][k] = Math.min(map[j][k], map[j][i]+map[i][k]); //�� ���� �� ����
				}
			}
		}
	}

}
