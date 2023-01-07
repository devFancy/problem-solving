import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        while(n > 0) {
            int div = 0;
            div = n % 10;
            answer += div;
            n = n / 10;
        }
        return answer;
    }
}