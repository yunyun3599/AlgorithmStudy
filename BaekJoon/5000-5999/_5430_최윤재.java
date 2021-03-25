package week8;
import java.util.*;
import java.io.*;
public class _5430_최윤재 {

	static StringBuilder result = new StringBuilder();
	static LinkedList<String> arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));			//입력받기
		
		int testcase=Integer.parseInt(bf.readLine());						//총 테스트케이스 개수
		
		for(int i=0; i<testcase; i++, result.append("\n")) {				//테스트케이스 하나 당 한 바퀴
			String function = bf.readLine();								//function에 함수 문자열 저장
			int num = Integer.parseInt(bf.readLine());						//배열 내 숫자 개수
			String tmp = bf.readLine();										//숫자 입력받음
			tmp=tmp.replace("[", "");										//앞뒤 괄호[] 없앰 
			tmp=tmp.replace("]", "");	
			arr = new LinkedList<String>();									//원소 저장할 LinkedList	(array 쓰면 D 들어왔을 때 delete한 후 길이 처리가 힘들어서 LinkedList 씀)
			String[] input = tmp.split(",");								//,를 기준으로 입력을 split함
			for(int j=0; j<input.length; j++) arr.add(input[j]);			//split 결과가 들은 배열 값을 LinkedList로 옮김
			
			int Dcount=0;													//D의 개수를 세봄
			for(int j=0; j<function.length(); j++) 
				if (function.charAt(j)=='D') Dcount++;
			
			if (Dcount > arr.size() || Dcount>tmp.length()) {				//D의 개수가 숫자 개수보다 많으면 error를 출력함. 숫자 없을 때도 arr.size()가 1이 나와서 tmp.length도 조건에 or로 줌
				result.append("error");
				continue;
			}
			
			result.append("[");												//error 아닐 때 출력을 위해 [를 먼저 append
			int idx = 0;													//현재 앞에부터 출력하는지 뒤집어서 출력하는지 알기 위해 idx 씀
			for(int j=0;j<function.length();j++) {
				if (function.charAt(j)=='R' && idx==0) idx=arr.size()-1;	//R이 들어왔는데 idx가 0이면 뒤부터 출력해야하므로 idx 값을 바꿈
				else if(function.charAt(j)=='R' && idx !=0) idx=0;			//R이 들어왔는데 idx가 0아니면 앞부터 출력해야하므로 idx를 0으로 바꿈
				else {														//D가 들어온 경우는 현재 idx가 가리키고 있는 값을 지움
					arr.remove(idx);
					if(idx!=0) idx--;
				}
			}
			if(idx==0) {													//앞부터 출력해야 하는 경우
				while(!arr.isEmpty()) {
					result.append(arr.removeFirst());
					result.append(",");
				}
			}
			else {															//뒤부터 출력해야 하는 경우
				while(!arr.isEmpty()) {
					result.append(arr.removeLast());
					result.append(",");
				}
			}
			if(result.charAt(result.length()-1)==',') result.deleteCharAt(result.length()-1);		//마지막 콤마 삭제. []를 출력하는 경우는 그냥 마지막 character지우믄 [가 지워지므로 마지막 character가 ,인지 확인
			result.append("]");												//] append
		}
		System.out.println(result);											//최종 결과 출력
	}
}

//AC