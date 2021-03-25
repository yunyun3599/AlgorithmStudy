package week11;
import java.io.*;
import java.util.*;

public class _5052_최윤재_전화번호목록_3 {

	static String[] num_list;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcase = Integer.parseInt(br.readLine());
		
		Loop:
		for(int i=0; i<testcase; i++) {
			int num = Integer.parseInt(br.readLine());					//번호 몇개인지 입력
			num_list = new String[num];
			for(int j=0; j<num; j++) num_list[j] = br.readLine();		//번호들을 배열에 저장
			Arrays.sort(num_list);										//번호 정렬 (사전순)
			for(int j=0; j<num-1; j++) {							
				if (num_list[j+1].length() > num_list[j].length()) {	//뒷번호의 길이가 더 긴 경우에 한해서 수행
					if(num_list[j+1].substring(0,num_list[j].length()).equals(num_list[j])) {	//자신의 앞에 위치한 번호와 자신의 앞부분 번호를 비교
						result.append("NO\n");
						continue Loop;
					}
				}
			}
			result.append("YES\n");			
		}
		System.out.println(result);
	}

}
