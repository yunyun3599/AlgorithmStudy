import java.util.*;
import java.io.*;

class Village implements Comparable<Village> {		//각 마을 별 총 인구수와 마을의 위치 저
	long loc;
	long population;
	Village(long loc, long population){
		this.loc = loc;
		this.population = population;
	}
	public int compareTo(Village other) {	//정렬 위해 구	
		return (int)(this.loc - other.loc);
	}
}

public class _2141_최윤재_우체국 {

	static int N;
	static ArrayList<Village> location = new ArrayList<>();
	static long total_population = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {	//입력받
			StringTokenizer st = new StringTokenizer(br.readLine());
			long X = Integer.parseInt(st.nextToken());
			long A = Integer.parseInt(st.nextToken());
			total_population += A;
			location.add(new Village(X, A));
		}
		
		Collections.sort(location);	//정
		
		long acc_population = 0;	//누적 인구
		for(int i=0; i<N; i++) {
			acc_population += location.get(i).population;
			if(acc_population >= (total_population + 1)/2) {	//총 인구수가 누적 인구수를 넘으면 해당 위치가 정답 
				System.out.println(location.get(i).loc);
				break;
			}
		}
		
	}
}
