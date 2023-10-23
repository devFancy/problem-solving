import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> sub_container = new Stack<>(); // 보조 컨테이너 벨트
        int container_box = 1; // 현재 메인 컨테이너에 있는 박스
        for(int o : order) {
            while(container_box <= order.length) {
                if(container_box == o) break;
                else if (!sub_container.isEmpty() && sub_container.peek() == o) break;
                else {
                    sub_container.push(container_box);
                    container_box++;
                }
            } 

            if(container_box == o) {
                container_box++;
                answer++;
            } else if(!sub_container.isEmpty() && sub_container.peek() == o) {
                sub_container.pop(); 
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }
}