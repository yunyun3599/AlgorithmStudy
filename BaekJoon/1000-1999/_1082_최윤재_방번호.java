import java.io.*;
import java.util.*;
public class _1082_최윤재_방번호 {
	
	static int N, M;		//숫자 개수, 가지고 있는 	
	static int[] cost;	//각 숫자별 cost
	static int[] num;	//각 숫자별로 몇개 샀는
	static int mincost = Integer.MAX_VALUE;	//가장 적은 금액 숫자의 금액  
	static int mincostnumber  = -1;	//가장 적은 금액 숫
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N];
		num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			if(cost[i]<=mincost) {
				mincost = cost[i];
				mincostnumber = i;
			}
		}
		
		M = Integer.parseInt(br.readLine());
		/////////////////////////////////////////입력 
		int res = M;	//남은 돈 
		while(res >= mincost) {	//남은 돈이 최소값보다 크면 반
			res -= mincost;		//숫자 사고 남은 돈 
			num[mincostnumber]++;	//가장 적은 가격의 숫자 최대한 확보 
		}

		if(mincostnumber==0 && num[mincostnumber]!=1) {	//가장작은 숫자가 0인데 1개만 사지는 않은 경우 
			boolean getanother = false;	//다른 숫자 샀는 지 
			while(!getanother && num[mincostnumber] != 1) {		//다른 숫자 못샀으면 
				num[mincostnumber]--;	//가장 적은 금액의 숫자 하나 더 덜 삼
				res += mincost;	//덜 산만큼 금액 나머지 액수에 더함  
				for(int i=N-1; i>mincostnumber; i--) {	//큰 숫자부터 확인하며 남은 돈으로 살 수 있나 확인 
					if(cost[i] <= res) {	//남은 돈으로 살 수 있는 경우 
						num[i] = 1;	//해당 숫자 샀으니까 개수 하나 늘림 
						res -= cost[i];	//해당 숫자만큼 잔돈에서 cost 깎음 
						getanother = true;	//반복 그만 
						break;
					}
				}
			}
		}
		boolean changed = true;	//바꾼 바가 있는지 여부 
		while(changed) {
			if(num[mincostnumber]==0) break;	//바꿀 수 없도록 가장 적은 금액의 숫자 사지 않은 경우 
			changed = false;	//안바꿨다고 가정 
			res += mincost;	//moncost만큼 잔돈에 더함 
			for(int i=N-1; i>mincostnumber; i--) {
				if(cost[i] <= res) {		//살 수 있는 경우 
					num[mincostnumber]--;	//mincost의 num 줄이기 
					num[i]++;	//새로 한 거 하나 개수 늘리기 
					changed = true;	//바꿨으니까 또 반복 
					res -= cost[i];	//산만큼 잔액에서 빼기 
					break;
				}
			}
		}
		StringBuffer sb = new StringBuffer();	//결과 출력 
		for(int i=N-1; i>=0; i--) {
			for(int j=0; j<num[i]; j++) {
				sb.append(i);
			}
		}
		System.out.println(sb);
	}

}
