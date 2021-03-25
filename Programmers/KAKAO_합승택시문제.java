import java.util.*;
class Node implements Comparable<Node>{
    int num;
    int weight;
    Node(int num, int weight){
        this.num = num;
        this.weight = weight;
    }
    public int compareTo(Node node){
        return this.weight <= node.weight ? -1 : 1;
    }
}
class Solution {
    int[] from_start;
    int[] from_a;
    int[] from_b;
    ArrayList<Node>[] fare;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        fare = new ArrayList[n];
        for(int i=0; i<n; i++){
            fare[i] = new ArrayList();
        }
        for(int i=0; i<fares.length; i++){
            int node1 = fares[i][0]-1;
            int node2 = fares[i][1]-1;
            int weight = fares[i][2];
            fare[node1].add(new Node(node2, weight));
            fare[node2].add(new Node(node1, weight));
        }
        from_start = calc_weight(n, s-1);
        from_a = calc_weight(n, a-1);
        from_b = calc_weight(n, b-1);
        int result = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int tmp_result = from_start[i] + from_a[i] + from_b[i];
            if(tmp_result != 0) result = Math.min(tmp_result, result);
        }
        int answer = result;
        return answer;
    }
    
    public int[] calc_weight(int n, int start){
        int[] arr = new int[n];
        PriorityQueue<Node> pq = new PriorityQueue();
        pq.add(new Node(start, 0));
        while(!pq.isEmpty()){
            Node tmp = pq.poll();
            if(arr[tmp.num] == 0) arr[tmp.num] = tmp.weight;
            else continue;
            for(Node next : fare[tmp.num]){
                if(arr[next.num] == 0 && next.num != start)
                    pq.add(new Node(next.num, next.weight+tmp.weight));
            }
        }
        return arr;
    }
}