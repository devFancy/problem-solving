import java.util.*;
import java.io.*;

class Main {
    static final int MAX = 1000 + 10;
    static boolean[][] graph;
    static boolean[] visited;
    static ArrayList<Integer> queue; // bfs를 위해 만든 것
    static int N, M, V;

    public static void dfs(int idx) {
        visited[idx] = true;
        System.out.print(idx + " "); // 몇 번째 노드를 방문했다.
        
        for(int i = 1; i <= N; i++) {
            if(visited[i] == false && graph[idx][i] == true) {
                dfs(i);
            }
        }
        
    }
    /*
     * queue를 만들고, visited를 새로 초기화해준다.
     * 가장 첫 번째 시작 정점이라는 값(1)을 추가해주고, 그 값(1)을 방문했다라고 표기해준다. (처음 V 값이 1이므로)
     * !queue.isEmpty() 때까지, 가장 앞에 있는 값을 꺼내오고, 출력해 준 다음에 그 값을 기준으로 방문할 수 있는 값들을 방문한다.
     * 
     */
    public static void bfs() {
        queue = new ArrayList<>();
        visited = new boolean[MAX];

        queue.add(V);
        visited[V] = true;

        while (!queue.isEmpty()) {
            int idx = queue.remove(0); // 가장 앞에 있는 녀석을 꺼내서 걔를 인덱스에 담겠다.
            System.out.print(idx + " ");

            for(int i = 1; i <= N; i++) {
                if(visited[i] == false && graph[idx][i] == true) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
            
        }
    }
    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new boolean[MAX][MAX];
        visited = new boolean[MAX];

        // 1. graph에 연결 정보 채우기
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }

        // 2. dfs(재귀 함수) 호출 + 출력하기
        dfs(V);
        System.out.println();

        // 3. bfs(너비 우선 탐색) 호출 + 출력하기
        bfs();

        bw.close();
        br.close();
    }
}
