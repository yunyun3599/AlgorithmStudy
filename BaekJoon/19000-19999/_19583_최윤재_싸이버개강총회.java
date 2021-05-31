package tmp;
import java.util.*;
import java.io.*;
public class _19583_최윤재_싸이버개강총회 {

	static String start;	//시작시간
	static String end;		//끝나는 시간
	static String streaming_end;	//스트리밍 끝나는 시간
	static HashSet<String> people = new HashSet<>();	//참여한 학생들 넣어두는 해쉬셋
	static int result;	//출석 인정된 인원수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		start = st.nextToken();	
		end = st.nextToken();
		streaming_end = st.nextToken();
		//////////////////////////////////////////////////입력
		String input = "";
		while((input = br.readLine()) != null ) {	//입력이 있는 동안 반복
			st = new StringTokenizer(input, " ");
			String time = st.nextToken();	//채팅시간
			String id = st.nextToken();		//채팅 아이디
			if(time.compareTo(start) <= 0) people.add(id);	//시작 인정 시간 이내면 해쉬맵에 넣음
			else if(time.compareTo(end)>=0 && time.compareTo(streaming_end)<=0) {	//시작시간이 인정된 회원에 한해 끝시간도 인정되는지 확인
				if(people.contains(id)) {
					result++;
					people.remove(id);
				}
			}
		}
		System.out.println(result);
	}

}
