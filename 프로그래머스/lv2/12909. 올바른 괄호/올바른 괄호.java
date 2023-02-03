import java.util.*;

class Solution {
    boolean solution(String s) {
        // [1] 정답을 저장할 변수로 answer와 stack을 선언
        boolean answer = true;
        Stack <Character> stack = new Stack<>();

        // 반복문을 이용하여 문자열을 앞에서부터 비교
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // [2] 문자를 비교할 때 `(` 일 경우 스택에 push 
            if(c == '(') {
                stack.push(c);
            }
            
            // [3] `)`일 경우
            if( c == ')') {
                // stack의 크기가 0이면 false 반환
                if(stack.size() == 0) {
                    answer = false;
                }
                // stack의 크기가 0이 아니라면  `(`가 있다는 의미이므로 스택에 pop
                else {
                    stack.pop();
                }
            }
        }
        // [4] 문자열을 끝까지 확인한 이후에 스택의 크기가 0이면 true 반환
        if(stack.size() != 0) {
            answer = false;
        }
        
        return answer;
    }
}