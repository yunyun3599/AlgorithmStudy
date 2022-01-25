import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++) {
            pq.add(scoville[i]);
        }
        while(pq.peek() < K && pq.size() > 1) {
            int small1 = pq.poll();
            int small2 = pq.poll();
            pq.add(small1 + small2*2);
            answer++;
        }
        if(pq.peek() < K) return -1;
        else return answer;
    }
}
