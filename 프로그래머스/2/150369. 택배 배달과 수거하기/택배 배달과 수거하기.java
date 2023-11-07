class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int deliver = 0, pickup = 0;
        long answer = 0;
        
        for(int i = n-1; i >=0; i--) {
            if(deliveries[i] != 0 || pickups[i] != 0) {
                int cnt = 0;
                while(deliver < deliveries[i] || pickup < pickups[i]) {
                    // [i] 인덱스 위치를 몇 번 방문할지 카운트
                    cnt++;
                    deliver += cap;
                    pickup += cap;
                }
                deliver -= deliveries[i]; // 남은 트럭 자리 계산
                pickup -= pickups[i];
                answer += (i+1) * cnt * 2; // 맨 끝 인덱스부터 for문을 돌리면서 그 인덱스의 위치에 트럭이 몇번 오게 되는지 카운트 한 후에 거리를 계산해서 더해주는 방식
            }
        }
        
        return answer;
    }
}