import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int iter=0; iter<commands.length; iter++){
            int i = commands[iter][0]-1;
            int j = commands[iter][1];
            int k = commands[iter][2]-1;
            ArrayList<Integer> arr = new ArrayList<>();
            for(int idx = i; idx<j; idx++){
                arr.add(array[idx]);
            }
            Collections.sort(arr);
            answer[iter] = arr.get(k);
            
        }
        return answer;
    }
}
