import java.util.*;

class Solution {
    public long solution(long n) {
        
        String [] list = String.valueOf(n).split("");
        Arrays.sort(list);
        
        StringBuilder sb = new StringBuilder();
        for(String alist : list) {
            sb.append(alist);
        }
        
        return Long.parseLong(sb.reverse().toString());
        
    }
}