package tmp;
import java.util.*;
import java.io.*;

public class _2212_최윤재_센서 {

	static int N;
	static int K;
	static int[] sensor;	//센서 위치
	static int[] dist;	//각 센서간 거리
	static int result;	//최종 결과
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		sensor = new int[N];
		dist = new int[N-1];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) sensor[i] = Integer.parseInt(st.nextToken());	//입력
		Arrays.sort(sensor);	//센서 위치 순서대로 정렬
		for(int i=0; i<N-1; i++) 	//센서가 거리 차 구함
			dist[i] = sensor[i+1] - sensor[i];
		Arrays.sort(dist);	//센서간 거리 차이 정렬
		for(int i=0; i<N-K; i++) {	//센서 개수보다 기지국 개수가 적으면 적은 만큼의 빈 거리는 포함해야함
			result += dist[i];	//거리가 짧은 순으로 결과에 더하기
		}
		System.out.println(result);
	}
}
