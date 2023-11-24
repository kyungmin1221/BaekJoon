package BaekJoon.silver;

// 안전영역 //
// 그래프탐

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_2486 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int safelevel = 0;
    static int maxcount = Integer.MIN_VALUE;

    static void safe(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x,y} );
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<N) {
                    if(!visited[nx][ny] && map[nx][ny] >= safelevel) {
                        visited[nx][ny] = true;
                        safe(nx,ny);
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
               map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int k = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int max = map[i][j];
                k = Math.max(k, max);       // map 에서 최대 값을 구함
            }
        }

        for(int t=1; t<=k; t++) {
            int answer = 0;
            safelevel = t;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    visited[i][j] = false;
                }
            }

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(!visited[i][j] && map[i][j] >= safelevel) {
                        answer ++;
                        safe(i,j);
                    }
                }
            }
            maxcount = Math.max(maxcount,answer);
        }
        System.out.println(maxcount);
    }
}

