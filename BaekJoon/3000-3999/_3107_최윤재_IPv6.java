package tmp;
import java.util.*;

public class _3107_최윤재_IPv6 {
	
	static String input;
	static StringBuffer result = new StringBuffer();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine();
		String[] checkdoublecolon = input.split("::");	//::1인 경우는 결과가 " ","1"인데(length 2) 1::이면 결과가 "1"임 (length 1)
		if(checkdoublecolon.length==1) {	//::가 존재하지 않거나 ::가 가장 뒤에 있는 경우
			String[] checkcolon = checkdoublecolon[0].split(":");	//::기준으로 split한 것을 :로 또 split
			int allZero = 8-checkcolon.length;	//모두 0인 필드의 개수
			StringBuffer zerofield = new StringBuffer();	//모두 0인 경우 저장해놓을 sb
			StringBuffer notzerofield = new StringBuffer();	//0이 아닌 경우 저장해놓을 sb
			for(int i=0; i<checkcolon.length; i++) {	//0이 아닌 경우를 0으로 자릿수를 채운 string으로 변환
				String tmp = String.format("%4s", checkcolon[i]);
				tmp = tmp.replace(" ", "0");
				notzerofield.append(tmp+":");	//0이 아닌 필드에 append
			}
			if(input.substring(input.length()-2, input.length()).equals("::")) {		//0000연속 필드가 뒤에 있는 경우
				while(allZero-->0) {
					zerofield.append(":0000");	//0000필드 채우기
				}
			}
			notzerofield = notzerofield.deleteCharAt(notzerofield.length()-1);	//콜론 개수, 위치 조정 후 모두 0인 필드와 아닌 필드 append
			result.append(notzerofield);
			result.append(zerofield);
		}
		else {	//::가 존재하는 경우 -> 맨 앞에 ::이 있거나 중간에 ::이 나오는 경우
			String[] checkcolonfront = checkdoublecolon[0].split(":");	//::기준으로 앞의 문자열을 :로 split
			String[] checkcolonback = checkdoublecolon[1].split(":");	//::기준으로 뒤의 문자열을 :로 split
			StringBuffer notzerofieldfront = new StringBuffer();	//0이 아닌 필드 중 앞
			StringBuffer notzerofieldback = new StringBuffer();		//0이 아닌 필드중 뒤
			for(int i=0; i<checkcolonfront.length; i++) {	//앞 필드 자릿수 4개로 맞춤
				String tmp = String.format("%4s", checkcolonfront[i]);
				tmp = tmp.replace(" ", "0");
				notzerofieldfront.append(tmp+":");
			}
			for(int i=0; i<checkcolonback.length; i++) {	//뒷필드 자릿수 4개로 맞춤
				String tmp = String.format("%4s", checkcolonback[i]);
				tmp = tmp.replace(" ", "0");
				notzerofieldback.append(tmp+":");
			}
			int allZero = 8-checkcolonfront.length-checkcolonback.length;	//0000이 몇개 연속되어있나 구하기
			StringBuffer zerofield = new StringBuffer("");	//0000연속 필드 만들 sb
			if(input.substring(0,2).equals("::")) {	//0000 연속 필드가 앞에 있는경우
				allZero++;	//없는 필드가 하나 더 계산되어서 0000인 필드 개수 하나 더해줘야함 (::이 맨 앞인 경우 ::의 앞의 빈 문자열을 한개로 셈)
				while(allZero-->0) {	//0000필드 채우기
					zerofield.append("0000:");
				}
				notzerofieldback = notzerofieldback.deleteCharAt(notzerofieldback.length()-1);	//콜론 개수와 위치 맞춰서 append
				result.append(zerofield);
				result.append(notzerofieldback);
			}
			else {		//0000이 연속된 부분이 중간에 있을 때
				while(allZero-->0) {
					zerofield.append(":0000");
				}
				zerofield.append(":");
				notzerofieldfront = notzerofieldfront.deleteCharAt(notzerofieldfront.length()-1);	//zero필드 앞뒤로 숫자 필드 붙여주기
				notzerofieldback = notzerofieldback.deleteCharAt(notzerofieldback.length()-1);
				result.append(notzerofieldfront);
				result.append(zerofield);
				result.append(notzerofieldback);
			}
		}
		System.out.println(result);
	}

}
