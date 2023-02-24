import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();
        
        // [1] HashMap 알파벳으로 초기화
        for(int i = 'A'; i <= 'Z'; i++) {
            hm.put((char)i + "", i+1 - 'A');
        }
        
        for(int i = 0; i < msg.length(); i++) {
            int idx = i + 1;
            
            // [2] msg 길이만큼 반복
            while(idx <= msg.length()) {
                // [3] idx가 문자열 끝까지 도달하면 해당 인덱스를 결과 배열에 추가
                // 초기 반복문을 빠져나오기 위해 i를 idx로 초기화
                if(idx == msg.length()) {
                    arr.add(hm.get(msg.substring(i)));
                    i = idx;
                    break;
                }
                
                // [4] 다음 키 미리 계산(다음 키를 확인하기 위해 초기 반복문의 i보다 한칸 큰 idx 선언)
                String nextKey = msg.substring(i, idx + 1);
                // [5] 다음 키가 있을 경우 문자를 하나 추가하기 위해 idx 증가
                if(hm.containsKey(nextKey)) 
                    idx++;
                // [6] 다음 키가 없을 경우
                else {
                    // [6-1] 결과 배열에 현재 키의 인덱스를 추가
                    arr.add(hm.get(msg.substring(i, idx)));
                    // [6-2] 현재 해쉬에 없는 다음 키를 해쉬에 추가
                    hm.put(nextKey, hm.size() + 1);
                    // [6-3] 문자의 idx-1 까지 처리했음으로 i를 idx-1로 초기화(밖에 반복문 시작시 i++ 되므로 idx-1로 초기화)
                    i = idx - 1;
                    break;
                }
            }
        }
        // [7] ArrayList를 int []로 변환
        int[] answer = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
        }
        return answer;
    }
}