import java.io.*;
import java.util.*;
public class _1105_최윤재_팔 {

	static char[] L;
	static char[] R;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = st.nextToken().toCharArray();
		R = st.nextToken().toCharArray();
		
		if(L.length != R.length) System.out.println(0);	//L과 R의 자릿수가 맞지 않으면 결과는 0
		else System.out.println(count());	//8 몇개인지 구하기 
	}
	
	public static int count() {
		int result = 0;
		for(int idx=0; idx<L.length; idx++) {
			if(L[idx] == R[idx]) {
				if(L[idx] == '8') result++;
			}
			else return result;
		}
		return result;
	}
}
