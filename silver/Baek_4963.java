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

    static int w,h;
    static boolean[][] Visited;
    static int[][] A;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        while (w != 0 && h != 0) {                  // 입력의 마지막이 0 0 이면 종료
            w = Integer.parseInt(st.nextToken());   // 5
            h = Integer.parseInt(st.nextToken());   // 4
            A = new int[h][w];                      // 4 x 5 크기의 배열
            Visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < w; j++) {
                    A[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            land(0, 0);
            System.out.println(A[h - 1][w - 1]);
        }
    }

    public static void land(int start, int end) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start,end});
        Visited[start][end] = true;
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
        }

    }
}
