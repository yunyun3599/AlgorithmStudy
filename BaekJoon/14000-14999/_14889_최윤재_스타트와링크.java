package week12;
import java.io.*;
import java.util.*;
public class _14889_최윤재_스타트와링크 {
	
	static int num;							// 사람 수
	static int[][] power;					// 능력치 배열
	static int[] assigned;					// 해당 사람을 start팀에 배정했으면 1, 아니면 0
	static int result = 100000;				// 결과값
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		power = new int[num][num];
		assigned = new int[num];
		
		for(int i=0; i<num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<num; j++) {
				power[i][j] = Integer.parseInt(st.nextToken());				
			}
		}///////////////////////////////////////////////////////////////// 입력
		assign(0,0);						//첫번째 사람에 대해서 부터 시작
		System.out.println(result);			//결과 출력
	}
	
	public static void assign(int player, int total) {
		if(total == num/2) {										//팀 인원이 다 찬 경우
			ArrayList<Integer> start = new ArrayList<Integer>();	//start팀에 속한 사람의 인덱스 저장
			ArrayList<Integer> link = new ArrayList<Integer>();		//링크팀에 속한 사람의 인덱스 저장
			int power_start = 0;									//스타트팀의 능력치 합
			int power_link = 0;										//링크팀의 능력치 합
			for(int i=0; i<num; i++) {								//해당하는 인덱스를 각 팀의 arraylist에 넣어줌
				if(assigned[i] == 1) start.add(i);
				else link.add(i);
			}
			for(int i=0; i<num/2-1; i++) {							//arraylist에서 인덱스 확인해서 능력치의 합들을 구함
				for(int j=i+1; j<num/2; j++) {
					power_start += power[start.get(i)][start.get(j)] + power[start.get(j)][start.get(i)];
					power_link += power[link.get(i)][link.get(j)] + power[link.get(j)][link.get(i)];
				}
			}
			result = Math.min(result, Math.abs(power_start - power_link));		//현재까지의 능력치 차이 중 가장 작은 값을 결과로 저장
			return;
		}
		for(int i = player; i<num; i++) {
			if(assigned[i] == 0) {
				assigned[i] = 1;			//해당 사람이 start팀에 속한 경우
				assign(i+1, total+1);		
				assigned[i] = 0;			//해당 사람이 start팀에 속하지 않은 경우
			}
		}
	}

}
