class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        int num = 0;

        // m명이 t번 말하는 경우까지 구함
        while(sb.length() < m * t) {
            sb.append(Integer.toString(num++, n));
        }

        // 문자열은 0부터 이므로 p-1부터
        // 튜브가 말할 것만 알면되기 때문에 +m 씩 증가
        for(int i = p - 1; i < m * t; i = i + m) {
            answer.append(sb.charAt(i));
        }
        return answer.toString().toUpperCase();
    }
}