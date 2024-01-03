import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        List<String> result = new ArrayList<>();
        boolean[] visited = new boolean[tickets.length];
        
        dfs(0, "ICN", "ICN", tickets, visited, result);
        
        Collections.sort(result);
        
        return result.get(0).split(" ");
    }
    private void dfs(int level, String departure, String path, String[][] tickets, boolean[] visited, List<String> answer) {
        if(level == tickets.length) {
            answer.add(path);
            return;
        }
        for(int i = 0; i < tickets.length; i++) {
            if(visited[i]) 
                continue;
            if(tickets[i][0].equals(departure)) {
                visited[i] = true;
                dfs(level + 1, tickets[i][1], path + " " + tickets[i][1], tickets, visited, answer);
                visited[i] = false;
            }
            
        }
    }
}