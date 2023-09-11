package BaekJoon.silver;

// 미로탐색 //
// BFS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_2178 {
    // (0,1) : 오른쪽이동
    // (0,-1) : 왼쪽 이동
    // (-1,0) : 위쪽 이동
    // (1,1) : 아래쪽 이동
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int N,M;
    static int[][] A;
    static boolean[][] Visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        Visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(bf.readLine());
            String line = st.nextToken();
            for(int j=0; j<M; j++) {
                // 예를 들어 101010 이란 문자를 하나씩 잘라 A 배열에 넣는다.
                A[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }
        maze(0,0);
        // 최종적으로 A[N-1][M-1]에 저장되어 있는 수 가 출력
        System.out.println(A[N-1][M-1]);
    }

    // BFS 알고리즘 사용 //
    private static void maze(int start, int end) {
        Queue<int[]> queue = new LinkedList();
        // 처음 들어온 start 와 end 의 좌표를 일차원 배열로 받는다.
        // 큐에는 (0,0) 이 저장됨
        queue.offer(new int[] {start,end});
        Visited[start][end] = true;
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            // 상하좌우 탐색
            for(int k=0; k<4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x>=0 && y>=0 && x<N &&  y<M) {
                    if (A[x][y] != 0 && !Visited[x][y]) {
                        Visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}
