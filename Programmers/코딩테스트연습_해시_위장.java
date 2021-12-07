import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++) {
            String key = clothes[i][1];
            if(!map.containsKey(key)) {
                map.put(key, 1);
            }
            else {
                map.put(key, map.get(key) + 1);
            }
        }
        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext()) {
            String key = it.next();
            answer *= (map.get(key) + 1);
        }
        return answer -1;
    }
}
