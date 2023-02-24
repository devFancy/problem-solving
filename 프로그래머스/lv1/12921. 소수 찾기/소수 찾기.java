class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[n + 1];

        for (int i = 2; i <= (int) Math.sqrt(n); ++i) {
            if (arr[i] == 1) continue;
            for (int j = i + i; j <= n; j += i) {
                arr[j] = 1;
            }
        }
        
        for (int i = 2; i < arr.length; ++i) {
            if (arr[i] != 1) ++answer;
        }

        return answer;
    }
}