class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long ans = x;
        
        for(int i = 0; i< n; i++) {
            answer[i] = ans;
            ans += x;
        }
        for(int i = 0; i < n; i++) {
            System.out.print(answer[i]);   
        }
        return answer;
    }
}