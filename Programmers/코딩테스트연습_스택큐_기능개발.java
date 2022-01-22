import java.util.ArrayList;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> deployArray = new ArrayList<>();
        for(int i=0; i<progresses.length; ) {
            int deploy = 1;
            int days = getDays(progresses[i], speeds[i]);
            while(++i<progresses.length && getDays(progresses[i], speeds[i]) <= days) deploy++;
            deployArray.add(deploy);
        }
        int[] answer = new int[deployArray.size()];
        for(int i=0; i<answer.length; i++) answer[i] = deployArray.get(i);
        return answer;
    }
    public int getDays(int progress, int speed) {
        return (99-progress)/speed + 1;
    }
}
