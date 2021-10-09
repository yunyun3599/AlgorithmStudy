import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for(int i=0; i<phone_book.length-1; i++){
            String s1 = phone_book[i];
            String s2 = phone_book[i+1];
            if(s1.length() > s2.length()) continue;
            if(s1.equals(s2.substring(0,s1.length()))) return false;
        }
        return true;
    }
}
