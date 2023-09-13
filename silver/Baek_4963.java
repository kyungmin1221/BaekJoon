package BaekJoon.silver;

// 섬의 개수 //
// BFS
// DFS


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_4963 {
    // 상하좌우 , 대각선 까지 탐색
    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, 1, -1};

    static int N,M;
    static boolean[][] Visited;
    static int[][] A;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[M][N];
        Visited = new boolean[M][N];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < N; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        land(0,0);
    }

    public static int land(int start, int end) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start,end});
        Visited[start][end] = true;
        int answer = 0; // 섬의 개수를 저장할 변수
        while(!queue.isEmpty()) {
            int now[] = queue.poll();   // 처음은 (0,0)
            for(int k=0; k<8; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x>=0 && y>=0 && x<N && y<M) {
                    Visited[x][y] = true;
                    A[x][y] = A[now[0]][now[1]];
                    queue.add(new int[] {x,y});
                }
            }
            answer = answer + 1;
        }
        return answer;
    }
}
