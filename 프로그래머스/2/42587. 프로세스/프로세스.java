import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Pair> queue = new LinkedList<>();
    

        for(int i = 0; i < priorities.length; i++) {
            queue.add(new Pair(i, priorities[i]));
        }

        while(!queue.isEmpty()) {
            int currnet = queue.peek().value;

            boolean flag = false;

            for(Pair pair : queue) {
                if(pair.value > currnet) { // 현재 값보다 나머지 값이 우선순위가 더 높다면
                    flag = true;
                    break;
                }
            }
            if(flag) {
                Pair temp = queue.poll();
                queue.add(temp);
            } else {
                // 현재 값이 나머지 값보다 우선순위가 더 높다면 answer++
                answer++;
                Pair pair = queue.poll();

                if(pair.index == location) { // 현재 찾고자 하는 위치이면 출력
                    return answer;
                }
            }
        }

        return answer;
    }
    class Pair {
        int index;
        int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}