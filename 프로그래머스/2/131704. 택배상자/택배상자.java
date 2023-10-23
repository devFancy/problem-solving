import java.util.*;

/**
* main_con : 메인 컨테이너
* sub_con : 서브 컨테이너
* 주문 갯수만큼 for 문 돌리면서
* 1) 메인 컨테이너 오는 순서대로 while문을 돌리면서
* 1-1) 메인 컨테이너의 현재 위치에 있는 값과 일치하면 break;
* 1-2) 서브 컨테이너가 비어있지 않고, 서브 컨테이너의 현재 위치에 있는 값과 일치하면 break;
* 1-3) 메인, 서브에 있는 값과 일치하지 않으면 1 증가시켜 1-1로 되돌아간다.
* 2) 서브 컨테이너(Stack)에 다 저장되었으면 탐색 시작한다.
* 2-1) 메인 컨테이너의 현재 위치에 있는 값과 일치하면 정답 갯수 +1 증가
* 2-2) 서브 컨테이너가 비어있지 않고, 서브 컨테이너의 현재 위치에 있는 값과 일치하면 서브 컨테이너 pop()하고 정답 갯수 + 1 증가
* 2-3) 메인, 서브에 있는 값과 일치하지 않으면 종료
*/

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int main_con = 1;
        Stack<Integer> sub_con = new Stack<>();
        for(int o : order) {
            while(main_con <= order.length) { // 1
                if(main_con == o) break; // 1-1
                else if(!sub_con.isEmpty() && sub_con.peek() == o) // 1-2
                    break;
                else { // 1-3
                    sub_con.push(main_con);
                    main_con++;
                }
            }
            if(main_con == o) { // 2-1
                answer++;
                main_con++;
            } else if(!sub_con.isEmpty() && sub_con.peek() == o) // 2-2
            {
                sub_con.pop();
                answer++;
            } else // 2-3
            {
                break;
            }
        }
        return answer;
    }
}