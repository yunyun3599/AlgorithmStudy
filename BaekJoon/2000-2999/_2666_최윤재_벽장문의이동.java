package tmp;
import java.io.*;
import java.util.*;
public class _2666_최윤재_벽장문의이동 {

	static int num;
	static int open1;
	static int open2;
	static int sequence_num;
	static int sequence[];
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		open1 = Integer.parseInt(st.nextToken());
		open2 = Integer.parseInt(st.nextToken());
		sequence_num = Integer.parseInt(br.readLine());	//입력받을 순서 개수
		sequence = new int[sequence_num];	//벽장 열어볼 순서대로 저장
		for(int i=0; i<sequence_num; i++) {
			sequence[i] = Integer.parseInt(br.readLine());
		}////////////////////////////////////입력
		calc(0, 0);	//sequence배열의 인덱스, move횟수를 파라미터로 이용
		System.out.println(result);
	}
	static void calc(int idx, int move) {
		if(idx==sequence_num) {	//주어진 모든 벽장을 다 확인해 본 경우
			result = Math.min(result, move);	//결과 업데이트
			return;
		}
		int dist1 = Math.abs(open1-sequence[idx]);	//1번문과 현재 타겟의 거리
		int dist2 = Math.abs(open2-sequence[idx]);	//2번문과 현재 타겟의 거리
		int originopen1 = open1;	//원래 어떤 벽장문이 열려있었는지 기억 위해 저장해둠
		int originopen2 = open2;
		open1 = sequence[idx];	//첫번째 열린 자리를 이용
		calc(idx+1, move+dist1);	//sequence상 다음 것 확인
		open1 = originopen1;	//첫번째 열린 거 원래 벽장으로 바꿈
		open2 = sequence[idx];	//두번째 열린자리를 이용
		calc(idx+1, move+dist2);	//sequence상 다음 것 확인
		open2 = originopen2;	//두번째 열린 거 원래 벽장으로 바꿈
	}

}
