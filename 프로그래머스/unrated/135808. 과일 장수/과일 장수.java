import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        int appleAllCount = score.length;
        int makeBoxCount = appleAllCount / m;
        int remainder = appleAllCount % m;
        
        Arrays.sort(score); // 오름차순 정렬
        
        for(int i = remainder; i < appleAllCount; i = i+m) {
            int oneBoxPrice = score[i] * m;
            answer += oneBoxPrice;
        }
        return answer;
    }
    
}