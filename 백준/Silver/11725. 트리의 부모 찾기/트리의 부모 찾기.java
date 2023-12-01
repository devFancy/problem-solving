import java.util.*;
import java.io.*;

class Main {
    static final int MAX = 100000 + 10;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int N;
    static int[] answer;

    public static void dfs(int idx) {
        visited[idx] = true;
        for(int i = 0; i < graph[idx].size(); i++) {
            int next = graph[idx].get(i);
            if(visited[next] == false) {
                answer[next] = idx;
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[MAX];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[MAX];
        answer = new int[MAX];

        // 1. 연결 정보 채우기
        int x, y;
        for(int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        // 2. dfs(재귀 함수) 호출하기
        dfs(1);

        // 3. 출력
        for(int i = 2; i <= N; i++) {
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }
        bw.close();
        br.close();
    }
}
