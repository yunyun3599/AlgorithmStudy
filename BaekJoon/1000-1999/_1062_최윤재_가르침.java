import java.io.*;
import java.util.*;
public class _1062_최윤재_가르침 {

	static boolean alph[] = new boolean[26];
	static int N;
	static int K;
	static String[] words;
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		words = new String[N];
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			words[i] = input.substring(4, input.length()-4);
		}
		
		if(K < 5) {
			System.out.println(result);
			System.exit(0);
		}
		
		alph['a'-'a'] = true;
		alph['n'-'a'] = true;
		alph['t'-'a'] = true;
		alph['i'-'a'] = true;
		alph['c'-'a'] = true;		
		select(0, 5);
		System.out.println(result);
	}
	
	public static void select(int idx, int num) {
		if(num == K) {
			int cantread = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<words[i].length(); j++) {
					if(!alph[words[i].charAt(j)-'a']) {
						cantread++;
						break;
					}
				}
			}
			result = Math.max(result, words.length - cantread);
			return;
		}
		for(int i=idx; i<26; i++) {
			if(alph[i]) continue;
			alph[i] = true;
			select(i+1, num+1);
			alph[i] = false;
		}
	}

}
