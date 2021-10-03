import java.util.*;
import java.io.*;
public class _1041_최윤재_주사위 {
	
	static int N;
	static int dice[] = new int[6];		//ABCDEF값 저
	static int min1 = Integer.MAX_VALUE;	//1면만 보이는 경우의 최솟값 
	static int min2 = Integer.MAX_VALUE;	//2면만 보이는 경우의 최솟값 
	static int min3 = Integer.MAX_VALUE;	//3면만 보이는 경우의 최솟값 
	static int min5 = Integer.MAX_VALUE;	//5면만 보이는 경우의 최솟값 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for(int i=0; i<6; i++) {
			dice[i] = Integer.parseInt(st.nextToken());	//입력 
			min1 = Math.min(min1, dice[i]);	//가장 작은 값을 가진 면 기억해둠 
			max = Math.max(max, dice[i]);	//가장 큰 값을 가진 면 기억해둠 
			sum += dice[i];	//dice값들의 합 
		}
		min2 = Math.min(min2, dice[0]+dice[1]);	//2면이 보이는 경우들에 대해 최솟값 구하기 
		min2 = Math.min(min2, dice[0]+dice[2]);
		min2 = Math.min(min2, dice[0]+dice[3]);
		min2 = Math.min(min2, dice[0]+dice[4]);
		min2 = Math.min(min2, dice[1]+dice[2]);
		min2 = Math.min(min2, dice[1]+dice[3]);
		min2 = Math.min(min2, dice[1]+dice[5]);
		min2 = Math.min(min2, dice[2]+dice[4]);
		min2 = Math.min(min2, dice[2]+dice[5]);
		min2 = Math.min(min2, dice[3]+dice[4]);
		min2 = Math.min(min2, dice[3]+dice[5]);
		min2 = Math.min(min2, dice[4]+dice[5]);
		min3 = Math.min(min3, dice[0]+dice[1]+dice[2]);	//3면이 보이는 경우들에 대해 최솟값 구하기 
		min3 = Math.min(min3, dice[0]+dice[1]+dice[3]);
		min3 = Math.min(min3, dice[0]+dice[2]+dice[4]);
		min3 = Math.min(min3, dice[0]+dice[3]+dice[4]);
		min3 = Math.min(min3, dice[1]+dice[2]+dice[5]);
		min3 = Math.min(min3, dice[1]+dice[3]+dice[5]);
		min3 = Math.min(min3, dice[2]+dice[4]+dice[5]);
		min3 = Math.min(min3, dice[3]+dice[4]+dice[5]);
		min5 = sum - max;	//5면이 보이는 경우의 최솟값 
		calc();	//결과 계산 
	}
	public static void calc() {
		if(N==1) {	//N이 1이면 5면 보이는 경우 1번 
			System.out.println(min5);
			return;
		}
		if(N==2) {	//N이 2인 경우 
			System.out.println(min3 * 4 + min2 * 4);
			return;
		}
		//N이 3인 경우 
		long val3 = (long)min3*4;	//3면이 보이는 경우들의 합 
		long val2 = (long)min2*(N-2)*8 + min2*4;	//2면이 보이는 경우들의 합 
		long val1 = (long)min1*(N-2)*(N-2)*5 + min1*(N-2)*4;//1면이 보이는 경우들의 합 
		System.out.println(val1+val2+val3);
		return;
	}
}