import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> complete = new HashMap<>();
        
        for(String player : completion) { 
            if(complete.containsKey(player)) complete.put(player, complete.get(player)+1);
            else complete.put(player, 1);
        }
        for(String player : participant){
            if(!complete.containsKey(player)) {
                answer = player;
                break;
            }
            if(complete.get(player)==1) complete.remove(player);
            else complete.put(player, complete.get(player)-1);
        }
        
        return answer;
    }
}
