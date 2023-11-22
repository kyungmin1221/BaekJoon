package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// 단지 번호 붙이기 //
// bfs, dfs

public class Baek_2667 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int N;
    static int[][] map,copymap;
    static boolean[][] visited;

    static int hcount = 0;          // 각 단지의 수를 저장할 변수

    static void house(int x,int y) {        // 단지의 개수 출력
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x,y});
        map[x][y] = 0;
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny] != 0 && !visited[nx][ny]) {
                    map[nx][ny] = 0;
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx,ny});
                    house(nx,ny);
                }
            }
        }
    }


    static int housecount(int x,int y,int[][] copymap) {        // 각 단지내 집의 수 출력
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x,y});
        copymap[x][y] = 0;
        hcount ++;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<N && copymap[nx][ny] != 0) {
                    copymap[nx][ny] = 0;
                    queue.offer(new int[] {nx,ny});
                    housecount(nx,ny,copymap);
                }
            }
        }
        return hcount;      // 처음 1을 만나서 0으로 만들때까지의 1의 개수를 반환
    }



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arrayList = new ArrayList<>();
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];        //  원본 배열 , 단지수를 찾기 위한 배열
        copymap = new int[N][N];    // 원본 배열과 같은 배열 , 단지에 속하는 집의 수를 찾기 위한 배열
        visited = new boolean[N][N];
        int count = 0;      // 단지의 수를 저장할 변수

        // 1. 단지의 개수 찾기
        for(int i=0; i<N; i++) {
            String line = bf.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 1 ) {
                    count ++;
                    house(i,j);
                }
            }
        }
        System.out.println(count);      // 총 단지의 개수 출력


        // 2. 단지내 집의 개수 찾기
        for(int i=0; i<N; i++) {
            copymap[i] = map[i].clone();    // 원본배열을 깊은복사로 복사 - 원본배열에 영향 X
        }

        // 각 단지내 집의 수를 찾는다.
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(copymap[i][j] == 1) {        // 집(1)이면
                    arrayList.add(housecount(i,j,copymap));     // 반환된 집의 수를 리스트에 저장
                    hcount = 0;             // hcount 초기화
                }
            }
        }

        Collections.sort(arrayList);    // 오름차순 정렬
        for(int i=0; i<arrayList.size(); i++) {
            System.out.println(arrayList.get(i));   // 각 단지내 집의 수를 오름차순으로 정렬하여 출력
        }
    }
}
