package week9;
import java.io.*;
import java.util.*;
public class _1927_최윤재 {
	
	static ArrayList<Integer> heap = new ArrayList();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());									//입력 개수
		
		for(int i=0; i<N; i++) {													//입력 받기
			int tmp = Integer.parseInt(br.readLine());								//tmp가 이번에 입력된 숫자
			if(tmp==0) {												//0이 입력된 경우
				if (heap.isEmpty()) System.out.println(0);				//heap이 비어있으면 0을 출력
				else {													//heap이 비어있지 않은 경우
					System.out.println(heap.get(0));					//min heap이므로 루트 값 출력
					if (heap.size()!=1) {								//루트 이외에도 힙에 다른 값이 있는 경우
						heap.set(0, heap.remove(heap.size()-1));		//출력한 루트값 지우고 맨 뒷 값을 루트자리에 옮김 
						down(0);										//downheap 수행
					}
					else heap.remove(0);								//heap에 루트 하나만 있던 경우는 그냥 루트 값 지우고 끝
				}
			}
			else {								//tmp에 들어온 값이 0이 아닐 때
				heap.add(tmp);					//heap에 해당 값을 add 시켜줌
				sort(heap.size()-1); 			//upheap 수행
			}
		}
	}
	
	public static void sort(int idx) {			//upheap 수행하는 함수
		int idx_parents=(idx-1)/2;				//parent 인덱스
		int parents=heap.get(idx_parents);		//parent 값
		int child=heap.get(idx);				//자식 노드 값
		if(parents>child) {						//parent의 값이 더 커서 switch가 일어나는 경우
			heap.set(idx_parents, child);		
			heap.set(idx, parents);
			sort(idx_parents);					//재귀 호출로 바뀐 값을 또다시 upheap
		}
		return;
	}
	
	public static void down(int idx) {			//downheap 수행하는 함수
		int min=0;								//두 자식 노드 중 더 작은 값 저장할 변수 
		int c_idx=-1;							//두 자식 노드 중 더 작은 값의 인덱스 저장할 변수
		if(2*idx+1>heap.size()-1) return;		//현재 노드가 말단 노드인 경우는 그냥 return
		else if(2*idx+1==heap.size()-1) {		//왼쪽 자식 노드만 존재할 경우
			if (heap.get(idx)>heap.get(heap.size()-1)){		//왼쪽 자식 노드가 parent보다 큰 경우
				int tmp = heap.get(idx);					//둘의 값 바꿔줌
				heap.set(idx, heap.get(heap.size()-1));
				heap.set(2*idx+1, tmp);
			}
			return;
		}
		if (heap.get(2*idx+1)>heap.get(2*idx+2)) {	//오른쪽 자식 노드와 왼쪽 자식 노드의 값 비교
			min = heap.get(2*idx+2);
			c_idx=2*idx+2;
		}
		else {
			min=heap.get(2*idx+1);
			c_idx=2*idx+1;
		}
		if(heap.get(idx)>min) {						//더 작은 자식 노드의 값보다 부모 노드의 값이 크다면 switch
			heap.set(c_idx, heap.get(idx));
			heap.set(idx, min);
			down(c_idx);
		}
		return;
	}
}
