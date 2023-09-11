package BaekJoon;

// 친구 관계 파악하기 //
// DFS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_13023 {
    static int N,M;
    static boolean[] Visited;
    static ArrayList<Integer> A[];
    static boolean arrive;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());   //  5
        M = Integer.parseInt(st.nextToken());   //  4

        A = new ArrayList[N];
        for(int i=0; i<N; i++) {
            A[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            // 양방향 엣지
            A[u].add(v);
            A[v].add(u);
        }

        Visited = new boolean[N];
        arrive = false;
        for(int i =0; i<N; i++) {
            DFS(i,1);
            if(arrive) {
                break;
            }
        }
        if(arrive) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
    public static void DFS(int now,int depth) {
        if(depth == 5 || arrive) {
            arrive = true;
            return;
        }
        Visited[now] = true;
        for(int i : A[now]) {
            if(!Visited[i]) {
                DFS(i,depth + 1);
            }
        }
        // Visited[now] = false;를 설정하는 이유
        // 다른 경로에서 현재 노드(now)를 다시 방문할 수 있게 하기 위함
        // 예를 들어 , 0-1-2 에서 0-1-3 을 갈 수 있도록 함
        Visited[now] = false;
        // 코드가 실행되면 상위함수로 돌아가 코드 실행 ->  for(int i : A[now]) 실행
    }
}
