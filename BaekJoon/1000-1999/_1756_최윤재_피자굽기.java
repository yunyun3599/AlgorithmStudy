package tmp;
import java.io.*;
import java.util.*;
public class _1756_최윤재_피자굽기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());	//오븐 깊이
		int N = Integer.parseInt(st.nextToken());	//피자 개수
		int maxwidth[] = new int[D];	//해당 높이의 오븐에 넣을 수 있는 피자 둘레의 max값
		int min = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<D; i++) {	//해당 높이 위치에 넣을 수 있는 max값 채우기
			min = Math.min(min, Integer.parseInt(st.nextToken()));
			maxwidth[i] = min;
		}
		int idx = D-1;	//가장 깊은 위치부터 피자 넣을 수 있나 확인
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {	//피자들 하나씩 확인
			int pizza = Integer.parseInt(st.nextToken());
			while(idx >= 0 && pizza > maxwidth[idx]) {	//해당 위치에 넣을 수 없으면 한 칸 위 확인
				idx--;
				if(idx < 0) break;	//인덱스 벗어나면 그만 확인하기
			}
			if(idx < 0) {	//피자를 다 넣지 못하는 경우
				System.out.println(0);
				System.exit(0);
			}
			idx--;	//피자를 넣은 경우 다음 피자는 그 위 칸을 확인
		}
		System.out.println(idx+2);	//다 넣은 경우에 반복문에서 한 번 뺏으니까 1 더하고, idx를 0부터 시작했으니까 1 또 더하기
	}

}
