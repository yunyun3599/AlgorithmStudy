package tmp;
import java.util.*;
import java.io.*;
public class _2841_최윤재_외계인의기타연주 {

	static int N;
	static int P;
	static Stack<Integer>[] stack = new Stack[6];	//각 줄에 대해 stack 이용
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	//음 개수
		P = Integer.parseInt(st.nextToken());	//프랫 개수
		
		for(int i=0; i<6; i++) {
			stack[i] = new Stack<Integer>();	//스택 생성
		}
		
		for(int i=0; i<N; i++) {	//들어오는 음 개수만큼 반복
			st = new StringTokenizer(br.readLine());
			int note = Integer.parseInt(st.nextToken())-1;	//줄이 뭔지
			int fret = Integer.parseInt(st.nextToken());	//무슨 프랫인지
			if(stack[note].isEmpty()) {	//해당 줄에 아무것도 안누르고 있을 때
				stack[note].push(fret);	//그냥 누르면 됨
				cnt++;	//눌렀으니까 카운트 증가
			}
			else {
				while(!stack[note].isEmpty() && stack[note].peek()>fret) {	//지금 들어온 프랫보다 높은 프랫들 다 pop
					stack[note].pop();
					cnt++;	//cnt 증가
				}
				if(stack[note].isEmpty() || stack[note].peek()!=fret) {	//stack이 비어있거나 top값이 자기 자신이 아님 -> 해당 프랫 누르기 위해 움직여야함
					cnt++;	//cnt 증가
					stack[note].push(fret);	//프랫 눌렀음을 표시
				}
			}
		}
		System.out.println(cnt);
	}

}
