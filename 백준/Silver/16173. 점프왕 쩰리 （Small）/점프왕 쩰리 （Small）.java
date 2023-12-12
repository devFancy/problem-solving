import java.util.*;
import java.io.*;

public class Main {
    static final int MAX = 3 + 110;
    static int[][] map;
    static int[] dirX = {0, 1};
    static int[] dirY = {1, 0};
    static int N;
    public static void dfs(int y, int x) {
        int value = map[y][x];
        map[y][x] = 0;
        if(y == N && x == N) return;

        for(int i = 0; i < 2; i++) {
            int newY = y + dirY[i] * value;
            int newX = x + dirX[i] * value;

            if(value != 0) {
                dfs(newY, newX);
            }
        }

    }
    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[MAX][MAX];

        // 1. map에 정보 반영하기 
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. dfs 호출
        dfs(1,1);

        // 3. 출력하기
        if(map[N][N] == 0) bw.write("HaruHaru");
        else bw.write("Hing");
        
        bw.close();
        br.close();
    }
}
