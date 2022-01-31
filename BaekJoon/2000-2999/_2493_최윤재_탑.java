import java.io.*;
import java.util.*;
public class _2493_최윤재_탑 {

	static int N;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		Stack<int[]> stack = new Stack();	//0번 인덱스가 탑의 순서, 1번인덱스는 탑의 높이 
		for(int i=1; i<=N; i++) { 
			int top = Integer.parseInt(st.nextToken());	//탑의 높이 
			while(!stack.isEmpty()) {
				if(stack.peek()[1] >= top) {	//stack의 가장 위에 있는 탑이 지금 확인할 탑보다 높아서 수신 가능한 경우 
					sb.append(stack.peek()[0]+" ");	//해당 탑의 인덱스 출력 
					break;	//이번 탑에 대한 결과가 나왔으므로 반복 종료 
				}
				stack.pop();	//이번 탑의 높이보다 stack의 탑 높이가 작으면 해당 탑은 수신이 불가능한 상태이므로 pop해 버리
			}
			if(stack.isEmpty()) sb.append(0+" ");	//stack이 비어있으면 아무 탑도 수신을 못한 것이므로 0 출력 
			stack.push(new int[] {i, top});	//지금 탑을 기존 stack에 추가해 뒤 탑들 수신할 탑을 구할 때 이용 
		}
		
		System.out.println(sb);
	}

}
