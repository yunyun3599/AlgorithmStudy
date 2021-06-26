package tmp;
import java.util.*;
import java.io.*;

public class _20920_최윤재_영단어암기는어려워 {

	static int N;
	static int M;
	static HashMap<String, Integer> map = new HashMap<>();	//단어 이름을 key로, 나온 개수를 value로
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			String word = br.readLine();	//단어 입력받음
			if(word.length()<M) continue;	//너무 짧은 경우 그냥 넘기기
			if(!map.containsKey(word)) {	//처음 나오는 단어인 경우
				map.put(word, 1);	//해당 단어를 키로하고 값을 1로하는 페어를 put
			}
			else {		//이미 map 안에 존재하는 경우
				int value = map.get(word);	//해당 단어의 값 가져와서 그 값보다 1 키워서 넣기
				map.put(word, value+1);
			}
		}
		List<Map.Entry<String, Integer>> words = new ArrayList<>(map.entrySet());	//정렬을 위해 List로 바꿈
		Collections.sort(words, new Comparator<Map.Entry<String, Integer>>(){	//comparator 손봐서 조건에 맞도록 정렬
			public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
				int val2 = obj2.getValue();
				int val1 = obj1.getValue();
				if(val1 == val2) {		//나오는 빈도가 같은 경우
					String key1 = obj1.getKey();
					String key2 = obj2.getKey();
					if(key1.length() == key2.length()) return key1.compareTo(key2);	//길이도 같으면 사전순
					else return key2.length() - key1.length();	//길이가 다르면 길이가 긴 게 먼저
				}
				else return val2 - val1;	//값이 많이 나온 게 앞으로 가도록
			}
		});
		for(Map.Entry<String, Integer> word : words) {	//순서대로 출력
			bw.write(word.getKey());
			bw.write("\n");
		}
		bw.flush();
	}
}
