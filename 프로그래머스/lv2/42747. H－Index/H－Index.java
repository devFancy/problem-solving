import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int h = 0;
        int max = 0;
        
        //1.
        Arrays.sort(citations);
        
        //2.
        for(int i = 0; i < citations.length; i++) {
        
            //2-1
            int smaller = Math.min(citations[i], citations.length-i);
            
            //2-2
            if(smaller >= answer) {
                answer = Math.max(answer, smaller);
            }
            else {
                break;
            }
        }
        
        //3.
        return answer;
    }
}