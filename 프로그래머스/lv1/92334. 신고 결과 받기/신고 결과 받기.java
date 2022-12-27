import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        ArrayList<User> users = new ArrayList<>();
        HashMap<String,Integer> suspendedList = new HashMap<>();
        HashMap<String,Integer> idIdx = new HashMap<String,Integer>();
        int idx = 0;
        
        //각 유저에 대한 고유 index를 setting후 users ArrayList에 User 객체 추가
        for(String name : id_list) {
            idIdx.put(name, idx++);
            users.add(new User(name));
        }
        
        //users의 idIdx.get(str[0])번째 index에 reportList에 피신고자 추가
        //users의 idIdx.get(str[1])번째 index에 reportedList에 신고자 추가
        for(String re : report){
            String[] str = re.split(" ");
            users.get(idIdx.get(str[0])).reportList.add(str[1]);
            users.get(idIdx.get(str[1])).reportedList.add(str[0]);
        }
        
        //reportedList의 크기가 주어진 k와 같거나 크면 suspendedList의 피신고자 put
        for(User user : users){
            if(user.reportedList.size() >= k)
                suspendedList.put(user.name,1);
        }
        
        //answer 배열 각 index에 해당하는 유저의 신고당한 횟수를 count up
        for(User user : users){
             for(String nameReport : user.reportList){
                 if(suspendedList.get(nameReport) != null){
                     answer[idIdx.get(user.name)]++;
                 }
             }
        }
        return answer;
    }
}

class User{
    String name;                        //해당 유저명
    HashSet<String> reportList;		//피신고자 리스트
    HashSet<String> reportedList;	//신고자 리스트
    public User(String name){
        this.name = name;
        reportList = new HashSet<>();
        reportedList = new HashSet<>();
    }
}