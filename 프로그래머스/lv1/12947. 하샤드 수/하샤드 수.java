import java.util.*;

class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int sum = 0;
        int number = x;
        
        while(number > 0) {
            int div = number % 10;
            sum += div;
            number /= 10;
        }
        if(x % sum == 0) {
            answer = true;
        } else {
            answer = false;
        }
        
        return answer;
    }
}