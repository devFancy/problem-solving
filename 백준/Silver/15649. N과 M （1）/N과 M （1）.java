import java.util.Scanner;

public class Main {
    public static int []  arr;
    public static boolean [] visit;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();   // 1부터 N 까지의 자연수중에서
        int M = in.nextInt();   // 중복없이 M개를 고른 수열

        arr = new int[M];
        visit = new boolean[N];
        dfs(N, M, 0);
    }
    public static void dfs(int N, int M, int depth) {
        if(depth == M) {
            for(int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < N; i++) {
            if(visit[i] == false) {

                visit[i] = true;    // 해당 노드를 방문상태로 변경
                arr[depth] = i+1;
                dfs(N, M, depth + 1);

                visit[i] = false;
            }
        }
        return;
    }
}