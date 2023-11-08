class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length];
        
        // 노드 방문 초기화
        for (boolean visit : visited) {
        visit = false;
        }
        
        for(int i = 0; i < computers.length; i++) {
            if(visited[i] == false) { // 해당 노드를 방문하지 않았을 경우
            
                dfs(i, visited, computers);
                answer++; // 새로운 네트워크 찾았으므로 +1 증가
            }
        }
        
        return answer;
    }
    // node: 현재 노드, visited: 방문여부, computers: 컴퓨터간의 연결 정보를 나타내는 2차원 배열
    public void dfs(int node, boolean[] visited, int[][] computers) {
        visited[node] = true;
        
        for(int i = 0; i < computers.length; i++) {
            // 아직 방문하지 않는 노드 && 현재 노드와 연결된 경우
            if(visited[i] == false & computers[node][i] == 1) {
                dfs(i, visited, computers);
            }
        }
    }
}