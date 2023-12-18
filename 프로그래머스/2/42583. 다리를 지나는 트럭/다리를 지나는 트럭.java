// 다리를 지나는 트럭(23.12.18) - 1차 복습
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int sum = 0; // 현재 다리를 지나는 트럭 무게의 합
        int time = 0; // 모든 트럭이 다리를 건너는 최소 시간의 합(걸린 시간)

        Queue<Integer> bridgeQueue = new LinkedList<>(); // 다리를 지나기 전 트럭
        for(int truck : truck_weights) {
        
            while(true) {
                // 1. 큐가 비어있는 경우 트럭 추가
                if(bridgeQueue.isEmpty()) {
                    bridgeQueue.offer(truck);
                    sum += truck;
                    time++; // 다리에 오를 때만 시간 추가 
                    break;
                }
                // 다리에 건너는 트럭 무게의 합 == 견딜 수 있는 최대무게(weight)
                else if(bridgeQueue.size() == bridge_length) {
                    sum -= bridgeQueue.poll();
                }

                // 2. 큐가 비어있지 않은 경우
                else {
                    // 2-2. (다음 트럭까지 포함하여) 다리에 건너는 트럭 무게의 합 > 견딜 수 있는 최대 무게
                    if(sum + truck > weight) {
                        bridgeQueue.offer(0);
                        time++;
                    }
                    // 2-3. (다음 트럭까지 포함하여) 다리에 건너는 트럭 무게의 합 < 견딜 수 있는 최대 무게
                    else {
                        bridgeQueue.offer(truck);
                        sum += truck;
                        time++;
                        break;
                    }

                }
            }
        }
        // 걸린 시간 + 마지막 트럭의 통과 시간
        return time + bridge_length;
    }
}