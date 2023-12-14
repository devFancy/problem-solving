// 프로그래머스 - 네트워크
class Solution {
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[computers.length];

        // 노드 방문 초기화
        for(boolean visit : visited) {
            visit = false;
        }

        for(int i = 0; i < computers.length; i++) {
            if(visited[i] == false) {
                answer ++;
                dfs(i, computers);
            }
        }

        return answer;
    }

    /*
     * node: 현재 노드
     * visited: 방문여부
     * computer: 컴퓨터간의 연결 정보를 나타내는 2차원 배열
     */
    public void dfs(int node, int[][] computers) {
        visited[node] = true;

        for(int i = 0; i < computers.length; i++) {
            if(visited[i] == false && computers[node][i] == 1) {
                dfs(i, computers);
            }
        }
    }
}
