package tmp;
import java.util.*;
import java.io.*;
public class _6064_최윤재_카잉달력 {

	static int testcase;
	static StringBuilder sb = new StringBuilder("");
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testcase = Integer.parseInt(br.readLine());
		while(testcase-->0) {
			HashSet<Integer> set = new HashSet<>();	//x로 가능한 일자들 넣을  hashset
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int bigger = M > N ? M : N;	//더 큰 수
			int smaller = M < N ? M : N;	//더 작은 수
			int GCD = getGCD(bigger, smaller);	//최대공약수 구함
			int LCM = M*N/GCD;	//최소공배수 구함(끝나는 날)
			
			boolean impossible = true;
			while(x<=LCM) {	//최소공배수보다 작고 x값이 나올 수 있는 모든 날들을 Hashset에 넣음
				set.add(x);
				x += M;
			}
			while(y<=LCM) {	//최소공배수보다 작고 y값이 나올 수 있는 날들에 대해 탐색
				if(set.contains(y)) {	//x날도 가능하다고 set 안에 넣은 경우
					impossible = false;
					sb.append(y+"\n");
					break;
				}
				y += N;
			}
			if(impossible) sb.append(-1+"\n");	//불가능한경우
		}
		System.out.println(sb);
	}
	public static int getGCD(int bigger, int smaller) {	//최대공약수 구하는 방법 (유클리드 호제법)
		if(bigger%smaller==0) return smaller;
		int remainder = bigger%smaller;
		int result = getGCD(smaller, remainder);
		return result;
	}
}
