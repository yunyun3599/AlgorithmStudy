package tmp;
import java.util.*;
import java.io.*;

class Loc{			//다리 위에 올라가있는 트럭을 Loc클래스를 이용해 표현
	int loc;		//다리 위 어디에 있는지
	int weight;		//해당 트럭의 weight
	Loc(int loc, int weight){
		this.loc = loc;
		this.weight = weight;
	}
}
public class _13335_최윤재_트럭 {

	static int num;			//트럭개수
	static int length;		//다리 길이
	static int weight;		//다리가 버틸 수 있는 무게
	static int[] truck;		//각 트럭의 무게
	static Queue<Loc> onBridge = new LinkedList<>();	//다리 위에 올라가 있는 트럭의 위치와 weight저장할 큐
	static int time;		//소요 시간
	static int idx;			//몇번째 트럭까지 처리됐는지 확인용
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		num = Integer.parseInt(st.nextToken());
		length = Integer.parseInt(st.nextToken());
		weight = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		truck = new int[num];
		for(int i=0; i<num; i++) {
			truck[i] = Integer.parseInt(st.nextToken());
		}/////////////////////////////////////////////////////////입력
		onBridge.add(new Loc(1, truck[idx++]));		//첫번째 트럭 올려놓기
		time++;										//1초 증가
		while(!onBridge.isEmpty()) {
			time++;						//시간 증가
			int weight_sum=0;			//현재 다리에 올라가있는 트럭 무게의 총합
			int onBridge_num=onBridge.size();	//현재 큐에 올라가있는 트럭에 대해서 한칸씩 전진
				while(onBridge_num-->0) {
					Loc tmp = onBridge.poll();
					if(tmp.loc+1<=length) {		//첫번째 트럭이 1초 후에도 다리 위에 있는 경우
						weight_sum += tmp.weight;	//중량 총합에 해당 중량 더하기
						onBridge.add(new Loc(tmp.loc+1, tmp.weight));	//새 위치를 반영하여 queue에 다시 넣기
					}
				}
				if(idx<num && truck[idx]<=weight-weight_sum) {	//새로운 트럭을 올릴 수 있는 경우
					onBridge.add(new Loc(1, truck[idx++]));
				}
		}
		System.out.println(time);	//시간 출력
	}

}
