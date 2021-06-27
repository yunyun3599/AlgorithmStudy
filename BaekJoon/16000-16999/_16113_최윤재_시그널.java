package tmp;
import java.util.*;

public class _16113_최윤재_시그널 {

	static String[] numbers = {	//각 숫자별로 String으로 나타냈을 때 어떤 모양인지
			"####.##.##.####",
			"",
			"###..#####..###",
			"###..####..####",
			"#.##.####..#..#",
			"####..###..####",
			"####..####.####",
			"###..#..#..#..#",
			"####.#####.####",
			"####.####..####"
			};
	static char[][] signal;	//입력받는 문자열 넣을 곳
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		sc.nextLine();
		String input = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		
		signal = new char[5][len/5];
		for(int i=0; i<5; i++) {
			signal[i] = input.substring(i*(len/5), (i+1)*(len/5)).toCharArray();	//행별로 받음
		}
		///////////////////////////////입력
		for(int i=0; i<len/5; i++) {	//1열부터 차례대로 무슨 숫자인지 확인
			if(signal[0][i]=='.') continue;
			if((i+2)<len/5 && signal[0][i]=='#'&&signal[0][i+2]=='#') {	//첫행첫열과 첫행3열의 값이 둘 다 #인 경우, i+2<len/5안하면 런타임에러 
				if(signal[0][i+1]=='#') {	//가운데까지 #인 경우 -> ###이 첫행인 경우(2,3,5,6,7,8,9,0이 해당)
					String tmp="";
					for(int j=0; j<5; j++) {	//tmp에 각 행별 값을 append해서 하나의 string값으로 만듦
						tmp += signal[j][i];
						tmp += signal[j][i+1];
						tmp += signal[j][i+2];
					}
					for(int j=0; j<10; j++)	//numbers 배열에 미리 저장해놓은 string값과 비교
						if(tmp.equals(numbers[j])) {
							sb.append(j);
							break;
						}
					i += 3;	//인덱스 증가시키기
				}
				else {
					if(signal[4][i]=='#') {	//가장 앞에 1이 오고 한 열만 비우고 다음 숫자가 또 온 경우
						sb.append(1);
						i += 1;
					}
					else {	//4인경우
						sb.append(4);
						i += 3;
					}
				}
			}
			else {		//1인경우
				sb.append(1);
				i += 1;
			}
		}
		System.out.println(sb);	//결과 출력
	}
}
