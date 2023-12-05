import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 50 + 10;
    static boolean[][] map;
    static boolean[][] visited;
    static int M, N;
    static int[] dirY = {-1, -1, 0, 1, 1, 1, 0, -1}; // 상하좌우, 대각선 포함 - 8개 방향
    static int[] dirX = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void dfs(int y, int x) {
        visited[y][x] = true;
        for(int i = 0; i < 8; i++) {
            int newY = y + dirY[i];
            int newX = x + dirX[i];
            if(map[newY][newX] && visited[newY][newX] == false) {
                dfs(newY, newX);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            if(N == 0 && M == 0) break;
            
            map = new boolean[MAX][MAX];
            visited = new boolean[MAX][MAX];

            for(int i = 1; i <= N; i++) {
                int x;
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j <= M; j++) {
                    x = Integer.parseInt(st.nextToken());
                    map[i][j] = (x == 1 ? true : false); // 방법1
                    // map[i][j] = Integer.parseInt(st.nextToken()) == 1; // 방법2
                }
            }

            // 2. dfs 수행
            int answer = 0;
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= M; j++) {
                    if(map[i][j] && visited[i][j] == false) {
                        dfs(i, j);
                        answer++;
                    }
                }
            }

            // 3. 출력
            bw.write(String.valueOf(answer));
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
