import java.io.*;
import java.util.*;

class NodeInfo{			//루트 노드를 찾기 위한 parentNode 저
	int parentNode;
	ArrayList<Integer> child;
	NodeInfo(int parentNode, ArrayList<Integer> child){
		this.parentNode = parentNode;
		this.child = child;
	}
}
public class _6416_최윤재_트리인가 {

	static int testcase = 0;	//테스트케이스 번호 
	static boolean testend = false;	//테스트케이스 입력이 끝났는지 여부 
	static StringBuilder result = new StringBuilder();	//최종 정답 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(!testend) {
			testcase++;
			StringBuffer input = new StringBuffer();
			while(true) {	//빈 문자열이 들어오면 테스트케이스 하나 종료, -1 -1이 들어오면 전체 종료 
				String line = br.readLine();
				if(line.equals("")) break;
				if(line.equals("-1 -1")) {
					testend = true;
					break;
				}
				input.append(line);	//input에 모든 입력을 한 줄로 받음
				input.append(" ");
			}
			
			if(input.length()==0 && testend) break;	//테스트케이스 끝나는 경우 (마지막에 빈 줄 들어오고 -1 -1하는 경우와 바로 -1 -1하는 경우 둘 다 고려해야함)
			
			StringTokenizer st = new StringTokenizer(input.toString());
			HashMap<Integer, NodeInfo> tree = new HashMap();	//트리 정보 저장. 해당 노드 번호가 키, value로는 부모 노드값과 자식 노드 리스트 가짐 
			HashSet<Integer> notvisited = new HashSet<>();	//트리 유효성 검사할 때 순환되는 경우나 아예 방문 안하는 경우를 찾기 위해 방문 여부 처리 
			while(st.hasMoreTokens()) {
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				if(u==0) break;
				notvisited.add(u);	//방문 여부 체크용 
				notvisited.add(v);
				if(tree.containsKey(u)) {	//부모노드와 자식 노드들에 대해 각각 이미 map에 있는 경우와 없는 경우를 따로 고려해 적절하게 put
					tree.get(u).child.add(v);	//자식 노드 하나 추가 
					if(tree.containsKey(v)) {	//부모노드 값 업데이트 
						tree.get(v).parentNode = u;
					}
					else {
						tree.put(v, new NodeInfo(u, new ArrayList<>()));	//새로 추가하는 경우 
					}
				}
				else {	//u에 대해 새로 추가하는 경우 
					ArrayList<Integer> tmp = new ArrayList<>();
					tmp.add(v);
					tree.put(u, new NodeInfo(-1, tmp));
					if(tree.containsKey(v)) {
						tree.get(v).parentNode = u;
					}
					else {
						tree.put(v, new NodeInfo(u, new ArrayList<>()));
					}
				}
			}
			int root = -1;	//루트 노드 찾기 
			Iterator<Integer> keys = tree.keySet().iterator();
			while(keys.hasNext()) {	//parentNode 값으로 -1을 찾는 노드 찾으면 됨 
				int key = keys.next();
				if(tree.get(key).parentNode==-1) {
					root = key;
					break;
				}
			}
			boolean isTree = checktree(root, tree, notvisited);	//트리인지 여부 확인 
			if(root == -1) isTree = true;	//빈 트리인 경우 핸들링 
			if(!notvisited.isEmpty()) isTree = false;	//방문하지 않은 노드가 있는 경우 tree 아님 
			if(isTree) result.append("Case "+testcase+" is a tree.\n");
			else result.append("Case "+testcase+" is not a tree.\n");
		}
		System.out.println(result);
	}
	static boolean checktree(int node, HashMap<Integer, NodeInfo> tree, HashSet notvisited) {
		if(!notvisited.contains(node)) return false;	//방문 이미 한 노드면 순환하므로 False
		notvisited.remove(node);	//방문처리 
		boolean result = true;
		for(int child : tree.get(node).child) {
			result = result & checktree(child, tree, notvisited);	//자식 노드들에 대해 false인 경우가 하나라도 있으면 false 리턴 
			if(!result) break;
		}
		return result;
	}
}
