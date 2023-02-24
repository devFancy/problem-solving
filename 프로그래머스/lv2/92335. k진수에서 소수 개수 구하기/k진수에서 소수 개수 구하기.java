import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String temp = "";
        
        //N진법 변환
        while(n != 0) {
            temp = n % k + temp;
            n /= k;
        }
        
        String [] arr = temp.split("0");
        
        for(String str : arr) {
            if(str.equals("")) {
                continue;
            }
            long num = Long.parseLong(str);
            if(isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    // 소수 확인 메서드
    public boolean isPrime(long decimal) {
        if(decimal < 2)
            return false;
        for(int i = 2; i <= Math.sqrt(decimal); i++) {
            if(decimal % i == 0) {
                return false;
            }
        }
        return true;
    }
    
}