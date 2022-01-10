package tmp;
import java.util.*;
public class _2448_최윤재_별찍기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		ArrayList<String> pattern = new ArrayList<>();	//패턴 저장
		pattern.add("  *  ");	//초기 패턴
		pattern.add(" * * ");
		pattern.add("*****");
		
		int total_iter = (int)(Math.log(N/3) / Math.log(2));	//반복 횟수는 log2(N/3)임
		
		for(int iter = 0; iter<total_iter; iter++) {	//반복 횟수만큼 반복
			draw(pattern);
		}
		for(String line : pattern) System.out.println(line);
	}
	
	public static void draw(List<String> pattern) {
		int patternLength = pattern.size();	//지금까지 만든 패턴
		
		for(int i=0; i<patternLength; i++) {	//패턴을 한 줄 단위로 밑에 쌓기
			StringBuilder sb = new StringBuilder();
			
			sb.append(pattern.get(i));	//중간에 공백을 두고 패턴을 두개를 이어붙임
			sb.append(" ");
			sb.append(pattern.get(i));
			
			pattern.add(sb.toString());	//패턴에 새로 만든 패턴 추가
			
			StringBuilder blank = new StringBuilder();	//기존에 있던 패턴 앞뒤로 빈칸 넣어줘야함
			for(int j=0; j<patternLength; j++) blank.append(" ");	//빈칸은 현재 패턴 길이만큼 새로 생김
			pattern.set(i, blank.toString() + pattern.get(i) + blank.toString());	//새로 만들어진 빈칸 포함 패턴으로 이전 패턴값 업데이트
		}
	}

}
