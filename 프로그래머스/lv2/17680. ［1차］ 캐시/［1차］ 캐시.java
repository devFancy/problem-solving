import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        List<String> cacheList = new ArrayList<>();
        
        if(cacheSize == 0) {
            return cities.length * 5;
        }
        
        for(int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase(); // 소문자로 변환
            //cache hit
            if(cacheList.contains(cities[i])) {
                cacheList.remove(cities[i]);
                cacheList.add(cities[i]);
                answer += 1;
            }
            //cache miss
            else {
                answer += 5;
                if(cacheList.size() == cacheSize) {
                    cacheList.remove(0);
                    cacheList.add(cities[i]);
                }
                else {
                    cacheList.add(cities[i]);
                }
            }
        }
        
        return answer;
    }
}