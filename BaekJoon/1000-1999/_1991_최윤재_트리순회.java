package week17;
import java.util.*;
import java.io.*;

public class _1991_최윤재_트리순회 {

	static int node;
	static char[][] tree = new char[26][2];		//각 알파벳의 왼쪽 자식노드가 [알파벳-'A'][0]에 오른쪽 자식노드가 [알파벳-'B'][1]에 저장
	static StringBuilder pre = new StringBuilder();		//전순위 결과
	static StringBuilder in = new StringBuilder();		//중순위 결과
	static StringBuilder post = new StringBuilder();	//후순위 결과
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		node = Integer.parseInt(br.readLine());
		for(int i=0; i<node; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			tree[root-'A'][0] = left;		//왼쪽 자식노드 저장
			tree[root-'A'][1] = right;		//오른쪽 자식노드 저장
		}
		preorder('A');		//A가 항상 루트이므로 A부터 시작해서 전순위, 중순위, 후순위 수행
		inorder('A');
		postorder('A');
		System.out.println(pre+"\n"+in+"\n"+post);	//결과 출력
	}
	
	public static void preorder(char root) {
		pre.append(root);			//루트부터 탐색
		if(tree[root-'A'][0] != '.') preorder(tree[root-'A'][0]);	//왼쪽 자식 노드가 있으면 재귀적으로 왼쪽 자식노드의 부분 탐색
		if(tree[root-'A'][1] != '.') preorder(tree[root-'A'][1]);	//오른쪽 자식노드가 있으면 오른쪽 자식노드의 부분 탐색
	}
	
	public static void inorder(char root) {
		if(tree[root-'A'][0] != '.') inorder(tree[root-'A'][0]);
		in.append(root);			//루트를 중간에 탐색
		if(tree[root-'A'][1] != '.') inorder(tree[root-'A'][1]);		
	}
	
	public static void postorder(char root) {
		if(tree[root-'A'][0] != '.') postorder(tree[root-'A'][0]);
		if(tree[root-'A'][1] != '.') postorder(tree[root-'A'][1]);
		post.append(root);			//루트를 마지막에 탐색
	}

}
