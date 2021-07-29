package tmp;
import java.io.*;
import java.util.*;

public class _2343_최윤재_기타레슨 {
	
	static int N;
	static int M;
	static int[] lesson;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());		//강의 개수
		M = Integer.parseInt(st.nextToken());		//블루레이 개수
		lesson = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			lesson[i] = Integer.parseInt(st.nextToken());
		}
		int low = 1;		//이분탐색
		int high = 1000000000;
		int mid = 0;
		while(low<high) {	//키값 찾을때까지
			mid = (low+high)/2;	//mid 값 업데이트
			if(check(mid)) {	//만약 가능한 경우라면 시간을 더 줄여봄
				high = mid;
			}
			else {				//불가능한 경우면 시간을 늘려봄
				low = mid+1;
			}
		}
		System.out.println(low);
	}
	public static boolean check(int size) {	//size가 블루레이의 크기
		int idx = 0;	//몇번째 강의까지 고려했는지 확인용
		int num = 0;	//현재까지 몇개의 블루레이가 필요한지 확인
		int tmp = 0;	//각 블루레이별 얼마나 시간을 채웠는지 저장용
		while(num<M && idx<N) {	//강의를 끝까지 다 넣었거나 최대 개수를 넘어선 경우는 반복문 그만
			if (tmp+lesson[idx] <= size) {	//가능한 크기 내에 이번 레슨이 들어갈 수 있는 경우
				tmp += lesson[idx];	//레슨 넣음
				idx++;	//인덱스 증가
			}
			else {	//현재 계산중인 블루레이에 못들어가는 경우
				num++;	//블루레이 개수 증가
				tmp = 0;	//블루레이 내에서 지금까지 찬 값 0으로 초기화
			}
		}
		
		if(idx==N) return true;	//만약 모든 비디오가 들어간 경우 true 반환
		return false;	//모든 비디오가 들어가지 못했으면  false 반환
	}
}
