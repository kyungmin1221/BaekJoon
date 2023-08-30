package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFS_STUDY {

    static int N,E;  // N은 노드의 수, E는 엣지(간선)의 수
    static int[][] Graph;  // 그래프를 표현할 2D 배열
    static boolean[] Visited;  // 각 노드의 방문 여부를 저장할 배열

    // 재귀함수로 구현한 DFS
    static void dfs(int node) {
        Visited[node] = true;  // 현재 노드를 방문했다고 표시
        System.out.println(node +  " ");  // 현재 노드 출력

        // 인접 노드를 순회
        for(int next=0; next<N; ++next ) {
            // 아직 방문하지 않은 노드이며, 간선이 존재한다면
            if(!Visited[next] && Graph[node][next] != 0 ) {
                dfs(next);  // 해당 노드로 DFS 진행
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // N과 E를 입력 받음
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // 그래프와 방문 배열 초기화
        Graph = new int[N+1][N+1];
        Visited = new boolean[N+1];

        // 간선 정보를 입력 받음
        for(int i=0; i<E; ++i) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 양방향 간선으로 그래프를 설정
            Graph[u][v] = Graph[v][u] = 1;
        }

        // 노드 0부터 DFS 시작
        dfs(0);
    }
}

