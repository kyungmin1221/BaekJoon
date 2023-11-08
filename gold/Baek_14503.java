package BaekJoon.gold;

// 로봇 청소기 //
// 시뮬레이션
// 구현

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_14503 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    // 방의 크기
    static int n,m;

    // 청소기의 좌표 & 바라보는 방향
    static int r,c,d;
    static int[][] map;
    static int count = 1;
      static void simulation(int r, int c, int direction) {
        // 청소x : 0 , 벽 : 1, 청소O : 2

        // 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
        // 로봇 청소기가 있는 칸은 항상 빈 칸
            map[r][c] = 2;

        // direction = 0:북, 1:동, 2:서, 3:남

        // 동서남북 탐색
        for(int i=0; i<4; i++) {
            // 빈시계 방향 90도 회전
            // 주변 4칸중 빈칸이 있는 지 확인하기 위함
            direction = (direction+3) % 4;

            // 주변 4칸을 확인할 좌표 nx,ny
            int nx = r + dx[direction];
            int ny = c + dy[direction];
            // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸(0)이 있는 경우
            if(nx>=0 && ny>=0 && nx<n && ny<m) {
                if(map[nx][ny] == 0) {
                    count ++;
                    simulation(nx,ny,direction);
                    return;
                }
            }
        }
        // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
        d = (direction+2) % 4;
        int bx = r + dx[d];
        int by = c + dy[d];

        // 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진
        if(bx>=0 && by>=0 && bx<n && by<m && map[bx][by] != 1) {
                simulation(bx,by,direction);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        simulation(r,c,d);
        System.out.println(count);
    }
}
