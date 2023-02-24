class Solution {
    public int solution(int n) {
        
        boolean flag; // 소수이면 true, 아니면 false
        int answer = 0;
        
        //에라토스테네스의 법칙
        for(int i = 2; i <= n; i++) {
            flag = true;
            for(int j = 2; j <= Math.sqrt(i); j++) {
                if(i%j == 0) {
                    flag = false;
                    break;
                }
            }
            // flag = true, 소수값이므로 +1 추가
            if(flag == true) {
                answer++;
            }
        }
        
        return answer;
        
    }
}