package tmp;
import java.io.*;
import java.util.*;
public class _14567_최윤재_선수과목 {

	static int N;
	static int M;
	static int lecture[];
	static int indegree[];
	static int semester = 1;
	static LinkedList<Integer>[] prerequisite;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lecture = new int[N+1];		//무슨 학기에 수강했는지 저장
		indegree = new int[N+1];	//들어오는 화살표 개수
		prerequisite = new LinkedList[N+1];	//해당 과목을 선수강과목으로 갖는 과목들 저장
		for(int i=1; i<N+1; i++) {
			prerequisite[i] = new LinkedList<Integer>();	//초기화
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			indegree[second]++;		//들어오는 화살표 개수 하나 늘리기
			prerequisite[first].add(second);	//선수강과목 관계 표시
		}////////////////////////////////////////////////////////입력
		Queue<Integer> queue = new LinkedList<>();	//큐
		for(int i=1; i<N+1; i++) {	//처음학기에 수강할 수 있는 과목들 queue에 넣기
			if(indegree[i]==0) {
				queue.add(i);
				lecture[i] = semester;	//현재 학기 lecture 배열에 저장
			}
		}
		while(!queue.isEmpty()) {	//queue가 빌때까지 반복
			semester++;	//학기 1 증가
			int qsize = queue.size();	//이전학기에 들은 만큼만 반복해야하므로 queue에 들은 과목 개수 구해놓기
			for(int i=0; i<qsize; i++) {	//queue에 들은 과목들에 대해 반복
				int before = queue.poll();
				for(int next : prerequisite[before]) {	//해당 과목을 선수과목으로 갖는 과목들
					indegree[next]--;	//들어오는 화살표 하나 줄이기
					if(indegree[next]==0) {	//이전에 들어야 하는 과목들을 다 들은 경우
						lecture[next] = semester;	//해당 과목의 lecture배열에 현재 학기 저장
						queue.add(next);	//queue에 해당 과목 넣기
					}
				}
			}
		}
		for(int i=1; i<N+1; i++) {
			bw.append(lecture[i]+" ");	//결과 출력
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
