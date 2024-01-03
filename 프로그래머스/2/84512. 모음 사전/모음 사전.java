import java.util.*;
class Solution {
    static String[] words = {"A", "E", "I", "O", "U"};
    static int MAX_LANGTH = 5;
    
    public int solution(String word) {
        int answer = 0;
        List<String> elements = new ArrayList<>();
        
        for(int i = 0; i < words.length; i++) {
            dfs(elements, String.valueOf(words[i]));
        }
        
        for(int i = 0; i < elements.size(); i++) {
            if(elements.get(i).equals(word)) {
                answer = i + 1;
                break;
            }
        }
        
        return answer;
    }
    public void dfs(List<String> elements, String str) {
        // 'A'에 대한 최대 길이 AAAAA(5)
        if(str.length() > MAX_LANGTH) 
            return;
        
        if(!elements.contains(str)) 
            elements.add(str);
        
        for(int i = 0; i < words.length; i++) {
            dfs(elements, str + words[i]);
        }
    }
}