import java.util.*;
 
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        HashSet<String> set=new HashSet<>(); // 사용 단어 저장
        
        char prev=words[0].charAt(words[0].length()-1);
        set.add(words[0]);
        // 2번째 단어부터 탐색
        for(int i = 1 ; i < words.length; i++){
            // 앞 단어의 마지막 문자로 시작하지 않거나 이미 말한 단어라면 종료
            if(prev != words[i].charAt(0) || set.contains(words[i])){
                answer[0]= i%n + 1; //  탈락자 번호
                answer[1]= i/n + 1; // 몇 번째 차례에서 탈락했는지에 대한 갯수
                break;
            }
            // 아니라면, 다음 체크를 위해 prev, set 설정
            prev=words[i].charAt(words[i].length()-1);
            set.add(words[i]);
        }
        return answer;
    }
}