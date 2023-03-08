import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

class Solution {
    
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        
        // 크기별로 몇 개 있는지 map에 저장함
        for (int tan : tangerine) {
            map.put(tan, map.getOrDefault(tan, 0)+1);
        }

        // 개수(value)가 많은 순으로 정렬
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());

        // 개수가 많은 순부터 사용
        for (Integer a : list) {
            if(k < 1) 
                return answer;
            k -= a;
            answer++;
        }

        return answer;
    }
}