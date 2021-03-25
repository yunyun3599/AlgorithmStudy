package week17;
import java.util.*;
import java.io.*;

public class _1991_������_Ʈ����ȸ {

	static int node;
	static char[][] tree = new char[26][2];		//�� ���ĺ��� ���� �ڽĳ�尡 [���ĺ�-'A'][0]�� ������ �ڽĳ�尡 [���ĺ�-'B'][1]�� ����
	static StringBuilder pre = new StringBuilder();		//������ ���
	static StringBuilder in = new StringBuilder();		//�߼��� ���
	static StringBuilder post = new StringBuilder();	//�ļ��� ���
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		node = Integer.parseInt(br.readLine());
		for(int i=0; i<node; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			tree[root-'A'][0] = left;		//���� �ڽĳ�� ����
			tree[root-'A'][1] = right;		//������ �ڽĳ�� ����
		}
		preorder('A');		//A�� �׻� ��Ʈ�̹Ƿ� A���� �����ؼ� ������, �߼���, �ļ��� ����
		inorder('A');
		postorder('A');
		System.out.println(pre+"\n"+in+"\n"+post);	//��� ���
	}
	
	public static void preorder(char root) {
		pre.append(root);			//��Ʈ���� Ž��
		if(tree[root-'A'][0] != '.') preorder(tree[root-'A'][0]);	//���� �ڽ� ��尡 ������ ��������� ���� �ڽĳ���� �κ� Ž��
		if(tree[root-'A'][1] != '.') preorder(tree[root-'A'][1]);	//������ �ڽĳ�尡 ������ ������ �ڽĳ���� �κ� Ž��
	}
	
	public static void inorder(char root) {
		if(tree[root-'A'][0] != '.') inorder(tree[root-'A'][0]);
		in.append(root);			//��Ʈ�� �߰��� Ž��
		if(tree[root-'A'][1] != '.') inorder(tree[root-'A'][1]);		
	}
	
	public static void postorder(char root) {
		if(tree[root-'A'][0] != '.') postorder(tree[root-'A'][0]);
		if(tree[root-'A'][1] != '.') postorder(tree[root-'A'][1]);
		post.append(root);			//��Ʈ�� �������� Ž��
	}

}
