import java.util.*;

class Solution {
    public String solution(String s) {
        int max, min, n;
        String [] str = s.split(" ");
        
        max = min = Integer.parseInt(str[0]);
        
        for(int i = 0; i < str.length; i++) {
            n = Integer.parseInt(str[i]);
            if(max < n) max = n;
            if(min > n) min = n;
        }
        
        return min + " " + max;
    }
}

