package BaekJoon.gold;

// 연구소 //
// 구현
// broute force
// bfs

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 함
// 0 : 빈칸,  1: 벽, 2: 바이러스
public class Baek_14502 {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int n,m,count=0;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        simulation(0);
        System.out.println(count);
    }

    static void simulation(int n) {


    }
}
