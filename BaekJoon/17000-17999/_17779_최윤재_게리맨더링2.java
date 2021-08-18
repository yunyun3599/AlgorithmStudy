package tmp;
import java.util.*;
import java.io.*;

public class _17779_최윤재_게리맨더링2 {

	static int N;
	static int map[][];
	static int min = Integer.MAX_VALUE;
	static int total;		//모든 인구수 합
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				total += map[i][j];
			}
		}
		/////////////////////////////////////////////////입력
		for(int x=0; x<N; x++) {		//(x,y)가 시작 기준점
			for(int y=0; y<N; y++) {
				for(int d1 = 1; d1<N; d1++) {	//d1과 d2 가능한 경우를 모두 해봄
					for(int d2=1; d2<N; d2++) {
						if(x+d1+d2<N && y-d1>=0 && y+d2<N) divide(x,y,d1,d2);	//조건 만족시 선거구 분할
					}
				}
			}
		}
		System.out.println(min);
	}
	public static void divide(int x, int y, int d1, int d2) {	//선거구 분할하는 함수
        int[] population = new int[5];	//각 구역별 인구수 합


        for (int i = 0; i < x + d1; i++) {	//1선거구
        	int end = y;	//x좌표 끝나는 부분 계산
        	if(i>=x) end = y-(i-x+1);
            for (int j = 0; j <= end; j++) {
                population[0] += map[i][j];
            }
        }

        for (int i = 0; i <= x + d2; i++) {	//2선거구
        	int start = y+1;
        	if(i>x) start = start+(i-x);	//x좌표 시작하는 부분 계산
            for (int j = start; j <N ; j++) {
                population[1] += map[i][j];
            }
        }

        int k=0;
        for (int i = x + d1; i < N; i++) {	//3선거구
        	int end = y-d1+d2;
        	if(i < x+d1+d2) end = y-d1+k++;	//x좌표 끝나는 부분 계산
            for (int j = 0; j < end; j++) {
                population[2] += map[i][j];
            }
        }

        k=0;
        for (int i = x + d2 + 1; i < N; i++) {	//4선거구
        	int start = y-d1+d2;
        	if(i<=x+d1+d2) start = y+d2+k--;	//x좌표 시작하는 부분 계산
            for (int j = start; j<N; j++) {
                population[3] += map[i][j];
            }
        }
        population[4] = total-population[0]-population[1]-population[2]-population[3];	//총 인구수에서 각 선거구 인구수 빼면 5선거구 인구수
        Arrays.sort(population);	//인구수대로 정렬
        min = Math.min(min, population[4] - population[0]);	//차의 최솟값 업데이트
    }

}
