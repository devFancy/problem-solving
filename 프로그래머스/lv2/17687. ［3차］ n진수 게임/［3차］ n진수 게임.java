class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder convert = new StringBuilder();
        StringBuilder answer = new StringBuilder();


        // convert의 길이가 미리 구할 숫자 갯수 * 게임 참가 인원만큼 될 때 까지 n진수로 변환
        for(int i = 0; convert.length() <= t * m; i++){
            convert.append(Integer.toString(i, n));
        }

        // 튜브의 순서에 해당하는 글자들만 추출
        // 문자열은 0부터 이므로 p-1부터
        // 튜브가 말할 것만 알면되기 때문에 +m 씩 증가
        for(int i = p - 1; i < m * t; i = i + m) {
            answer.append(convert.charAt(i));
        }
        return answer.toString().toUpperCase();
    }
}