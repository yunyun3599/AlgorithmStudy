package week13;
import java.io.*;
import java.util.*;
public class _10816_������_����ī��2 {

	static int[] Sanggeun = new int[20000001];			// 0 �ε����� -10000000, 10000000�ε����� 0, 20000000�ε����� 10000000
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		for(int i=0; i<num; i++) {
			Sanggeun[10000000 - sc.nextInt()]++;		//�ش� �ε��� ��++
		}
		
		num = sc.nextInt();
		for(int i=0; i<num; i++) 
			result.append(Sanggeun[10000000 - sc.nextInt()]+" ");	//�ش� ī�� ���� ���� ���
		System.out.println(result);
	}

}
