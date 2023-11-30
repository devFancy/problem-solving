import java.util.*;
import java.io.*;

class Main {
    static final int MAX = 100 + 10;
    static boolean[][] graph;
    static boolean visited[];
    static int N, M, start, end, answer;
    
    public static void dfs(int idx, int count) {
        // count는 처음 입력받았던 start와 현재 실행하고 있는 idx가 몇 촌사이인지 알려주는 값이다.
        visited[idx] = true;
        if(idx == end) {
            answer = count;
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(visited[i] == false && graph[idx][i]) {
                dfs(i, count + 1);
            }
        }
    }

    public static void main(String args[]) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());

        // 1. graph에 연결 정보 채우기
        graph = new boolean[MAX][MAX];
        visited = new boolean[MAX];
        answer = -1;


        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }

        // 2. dfs(재귀 함수)호출 하기
        dfs(start, 0);
        // 0이라는 값은 현재 DFS가 실행되는 시점에 촌수가 몇촌인지 담아주는 의미이다.


        // 3. 출력하기
        bw.write(String.valueOf(answer));

        bw.close();
        br.close();
    }
}