import java.util.*;

class Solution {
    public String solution(String str) {
        String answer = "";
        // 1. 공백을 기준으로 문자열을 잘라서 String 배열에 저장
        String [] strArr = str.split(" ");
        // 2. 잘린 String 배열을 순서대로 처리
        for(int i = 0; i < strArr.length; i++) {
            String now = strArr[i];
            
            // 문자열의 길이가 0이면 " " 추가
            if(strArr[i].length() == 0) {
                answer += " ";
            }
            // 문자열의 길이가 있다면
            else {
                // 첫번째 문자는 소문자 -> 대문자로 변환
                answer += now.substring(0, 1).toUpperCase();
                // 나머지 문자는 대문자 -> 소문자로 변환
                answer += now.substring(1, now.length()).toLowerCase();
                // 단어 사이에 공백을 위해 마지막에 `" "`을 추가
                answer += " ";
            }
        }
        // 3. 입력 받은 문자열의 맨 마지막이 `" "`이라면, 해당 부분을 제거하고 반환
        if(str.substring(str.length()-1, str.length()).equals(" ")) {
            return answer;
        }
        
        return answer.substring(0, answer.length()-1);
    }
}