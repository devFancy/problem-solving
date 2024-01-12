import java.util.*;
class Solution {
    static final int MAX = 200 + 10;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[computers.length];
        for(int i = 0; i < computers.length; i++) {
            if(visited[i] == false) {
                answer++;
                dfs(i, computers);
            }
        }
        return answer;
    }
    private void dfs(int node, int[][] computers) {
        visited[node] = true;
        for(int i = 0; i < computers.length; i++) {
            if(visited[i] == false && computers[node][i] == 1)
                dfs(i, computers);
        }
    }
}