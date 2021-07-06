package tmp;
import java.util.*;
import java.io.*;

class Frame implements Comparable<Frame> {		//Arraylist에 넣을 객체
	int no;	//학생번호
	int rec;	//추천수
	int time;	//들어간 시점 (작을수록 옛날)
	Frame(int no, int rec, int time){
		this.no = no;
		this.rec = rec;
		this.time = time;
	}
	public int compareTo(Frame another) {	//정렬방법. (rec가 적은게 앞으로, rec같으면 일찍인 게 앞으로)
		if(this.rec == another.rec) {
			return this.time - another.time;
		}
		return this.rec - another.rec;
	}
}

public class _1713_최윤재_후보추천하기 {

	static int frame;	//사진틀 수
	static int num;	//추천 개수
	static int time;	//시간 1씩 증가
	static ArrayList<Frame> cand = new ArrayList<>();	//사진 틀 올라간 학생 정보
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		frame = Integer.parseInt(br.readLine());
		num = Integer.parseInt(br.readLine());
		StringTokenizer input = new StringTokenizer(br.readLine());
		//////////////////////////////////////////////입력
		for(int i=0; i<num; i++) {	//각 추천에 대해 수행
			int student = Integer.parseInt(input.nextToken());
			boolean flag = true;
			for(Frame candidate : cand) {	//이미 사진틀에 올라간 사람인 경우
				if(candidate.no == student) {
					candidate.rec++;
					flag = false;
					break;
				}
			}
			if(flag) {	//사진틀에 올라가 있지 않은 사람인 경우
				if(cand.size() < frame) cand.add(new Frame(student, 1, time++));	//사진틀에 자리 남아있을 때
				else {	//사진틀에서 누구 내려야 할 때
					Collections.sort(cand);	//내릴 사람 구하기 위한 정렬
					cand.remove(0);	//정렬 결과 가장 앞에 있는 학생 내림
					cand.add(new Frame(student, 1, time++));	//새 학생 올리고 시간 증가시킴
				}
			}
		}
		Collections.sort(cand, new Comparator<Frame>() {	//출력을 위해 학생 숫자를 오름차순으로 정렬
			public int compare(Frame candidate1, Frame candidate2) {
				return candidate1.no - candidate2.no;
			}
		});
		for(Frame candidate : cand) {	//정렬된 결과를 차례대로 출력
			bw.write(candidate.no+" ");
		}
		bw.flush();
		bw.close();
	}

}
