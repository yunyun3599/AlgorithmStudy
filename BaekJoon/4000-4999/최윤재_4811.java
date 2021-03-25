package dynamic;

import java.util.*;
public class ������_4811 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		long result[][];
		
		while(true) {
			int num=sc.nextInt();
			if(num==0) break;
			
			result=new long[num+1][num+1];					//����¥�� ���� ���� �տ��� +1, ����¥�� ���� ���� �ڿ��� +1
			for(int i=0; i<num+1; i++) result[i][0]=1;	//30�ϰ� ��� �� �˾��� �Դ� ���
			
			
			for(int i=1; i<num+1; i++) {
				for(int j=1; j<=i; j++) {
					result[i][j]=result[i-1][j]+result[i][j-1];
				}
			}
			
			sb.append(result[num][num]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
