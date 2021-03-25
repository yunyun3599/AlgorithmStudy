package week14;
import java.util.*;
import java.io.*;
public class _11286_최윤재_절댓값힙 {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());							//총 개수
		Queue<Number> heap = new PriorityQueue<>();							//우선순위 큐 이용
		
		for(int i=0; i<num; i++) {											//입력
			int tmp = Integer.parseInt(br.readLine());
			if(tmp == 0) {
				if (heap.isEmpty()) bw.write("0\n");						//힙이 비었을 때
				else {
					Number number = heap.poll();							//가장 절댓값이 작은 수 poll
					int value = 0;
					if (number.isPositive == 1) value = number.value;		//isPositive가 1인 경우, 즉 양수인 경우는 그냥 그 값
					else value = -number.value;								//음수인 경우는 -를 붙인 값
					bw.write(value+"\n");									//결과 출력
				}
			}
			else {
				int isPositive = 0;											//새로운 숫자를 heap에 넣는 경우
				if (tmp > 0) isPositive = 1;								//새로 들어운 숫자가 양수인 경우 isPositive를 1로 설정
				else isPositive = -1;										//음수인 경우 isPositive를 -1로 설정
				heap.add(new Number(Math.abs(tmp), isPositive));			//결과 heap에 저장
			}
		}
		bw.flush();
		bw.close();
	}

}

class Number implements Comparable<Number>{				//heap에 넣을 객체. 숫자의 절대값과 음수/양수를 표시하는 값을 변수로 가짐
	int value;
	int isPositive;
	Number(int value, int isPositive){
		this.value = value;
		this.isPositive = isPositive;
	}
	public int compareTo(Number another) {				//heap내에서 정렬은 value가 작은값부터. value가 같으면 is Positive를 이용해 음수부터
		if (this.value == another.value) {
			return this.isPositive - another.isPositive;
		}
		return this.value - another.value;
	}
}
