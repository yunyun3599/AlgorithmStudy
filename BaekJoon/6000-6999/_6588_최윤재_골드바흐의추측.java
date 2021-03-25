package week13;
import java.util.*;
import java.io.*;
public class _6588_최윤재_골드바흐의추측 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean[] prime = new boolean[1000001];					//prime[i] 가 true이면 i가 소수라는 뜻
		for(int i=0; i<1000001; i++) {							//우선 모두 true로 초기화
			prime[i] = true;
		}
		prime[0] = prime[1] = false;							//0과 1은 소수 아님
		
		int base = 1;											//에라토스테네스의 체 이용
		while (base <= 500000) {								//base 의 배수들을 확인하므로 범위의 반까지만 하면 됨
			int mul = 2;										//base * mul 숫자를 체크
			for(int i=base+1; i<=1000000; i++) {				//다음 base를 구함
				if (prime[i]) {									//현 base보다 큰 값 중 prime[base] = true인 경우가 새 base됨
					base = i;
					break;
				}
			}
			while(base * mul <= 1000000) {						//base*mul 값을 false로 바꿈
				prime[base * mul] = false;
				mul++;
			}
		}
		
		while(true) {
			boolean flag = false;								//두 소수의 합으로 표현 가능하면 true 아니면  false
			int num = Integer.parseInt(br.readLine());
			if (num == 0) break;
			for(int i=3; i<=num/2; i++) {						//3부터 목표값의 반까지 범위를 토대로 합이 되는 경우 구함
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
