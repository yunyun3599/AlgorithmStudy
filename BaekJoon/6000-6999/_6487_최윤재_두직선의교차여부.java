package week12;
import java.io.*;
import java.util.*;
public class _6487_최윤재_두직선의교차여부 {

	static int testcase = 0;													//테스트 케이스 개수
	static StringBuilder result = new StringBuilder();							//결과 저장할 StringBuilder
	static float gradient1, gradient2, y_intercept1, y_intercept2;				//함수의 기울기, y절편
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testcase = Integer.parseInt(br.readLine());
		
		for(int i=0; i<testcase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int[] x = new int[4];
			int[] y = new int[4];
			for(int j=0; j<4; j++) {
				x[j] = Integer.parseInt(st.nextToken());
				y[j] = Integer.parseInt(st.nextToken());
			}
			//////////////////////////////////////////////////////////////////////입력
			boolean vertical1 = false, vertical2 = false;						//x축에 수직인 모양인 경우 vertical변수를 true로 바꿔줌
			//첫번째 함수
			if(y[0] == y[1]) {													//y값이 같을 때 (x축에 평행)
				gradient1 = 0;													//기울기 0
				y_intercept1 = y[0];											//y절편은 입력된 y값
			}
			else {						
				if(x[0] == x[1]) {												//x축에 수직인 경우
					vertical1=true;
				}
				else {															//x축에 수직도 평행도 아닌 경우
					gradient1 = (float)(y[1]-y[0]) / (x[1]-x[0]);				//기울기
					y_intercept1 = (float)y[0] - gradient1 * x[0];				//y절편
				}
			}
			//두번째 함수
			if(y[2] == y[3]) {													//x축에 평행한 경우
				gradient2 = 0;													//기울기 0
				y_intercept2 = y[2];											//y값이 y절편
			}
			else {				
				if(x[2] == x[3]) {												//x축에 수직인 경우
					vertical2 = true;
				}
				else {															//x축에 수직도 평행도 아닌 경우
					gradient2 = (float)(y[3]-y[2]) / (x[3]-x[2]);				//기울기
					y_intercept2 = (float)y[2] - gradient2 * x[2];				//y절편
				}
			}
			
			
			if (vertical1 && vertical2){										//두 함수가 모두 x축에 수직인 경우
				if (x[0] == x[2] ) {
					result.append("LINE\n");
				}
				else result.append("NONE\n");									//NONE
				continue;
			}
			else if (vertical1) {												//1번 함수만 x축에 수직인 경우
				float x_value = (float)x[0];	
				float y_value = gradient2 * x[0] + y_intercept2;				//해당 x값에 대한 y값 구함
				result.append(String.format("POINT %.2f %.2f\n", x_value, y_value));
				continue;
			}
				
			else if (vertical2) {												//2번함수만 x축에 수직인 경우
				float x_value = (float)x[2];
				float y_value = gradient1 * x[2] + y_intercept1;
				result.append(String.format("POINT %.2f %.2f\n", x_value, y_value));
				continue;
			}
																			
			if (gradient1 == gradient2) {										//두 함수의 기울기가 같은 경우
				if (y_intercept1 == y_intercept2) result.append("LINE\n");		//LINE
				else result.append("NONE\n");									//NONE
			}
			else {																//두 함수의 기울기가 다른 경우
				float x_point = (y_intercept2 - y_intercept1) / (gradient1 - gradient2);
				float y_point = gradient1 * x_point + y_intercept1;
				result.append(String.format("POINT %.2f %.2f\n", x_point, y_point));
			}
		}
		System.out.println(result);
	}
}
