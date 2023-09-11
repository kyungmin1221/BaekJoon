package BaekJoon.silver;

// DFS 와 BFS
// DFS
// BFS
// 그래프 탐색

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_1260 {
    static int N,E,S;
    static int[][] Graph;
    static boolean[] Visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        // 그래프와 방문 배열 초기화
        // 0번 인덱스를 비워놓는 이유는 주로 노드 번호가 1부터 시작할 경우, 배열의 인덱스와 노드 번호를 일치시키기 위해서
        Graph = new int[N+1][N+1];
        Visited = new boolean[N+1];

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 양방향 엣지를 표현
            Graph[u][v] = Graph[v][u] = 1;
        }
        Visited = new boolean[N+1];
        // 함수 호출
        DFS(Graph,Visited,S);
        System.out.println(sb);

        Visited = new boolean[N+1];
        BFS(Graph,Visited,S);
    }
    static void DFS(int[][] Graph, boolean[] Visited, int S) {
        // StringBuilder sb = new StringBuilder();
        Visited[S] = true;
        sb.append(S).append(" ");

        for(int i=1; i<Graph[S].length; i++) {
            if(Graph[S][i] == 0) {
                continue;
            }
            int next = i;
            if(!Visited[next]) {
                Visited[next] = true;
                DFS(Graph,Visited,next);
            }
        }
//        System.out.println("DFS: " + sb);
    }
    static void BFS(int[][] Graph, boolean[] Visited, int S) {
        // BFS는 큐(선입선출)로 구현할 수 있다.
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        // 시작점을 큐에 저장
        queue.add(S);
        // 시작점의 Visited 배열을 true로 저장
        Visited[S] = true;

        // 큐에 남은게 없을 때 까지
        while (!queue.isEmpty()) {
            // currentNum 에 큐에서 빼낸 수를 저장
            int currentNum = queue.poll();
            // 꺼낸 수 저장
            sb.append(currentNum).append(" ");
            // Graph[currentNum]의 길이(행)
            for(int i=1; i<Graph[currentNum].length; i++) {
                // 0이라면 , 즉 이어져 있지 않는 그래프라면 패스
                if(Graph[currentNum][i] == 0) {
                    continue;
                }
                // 그래프가 이어져있다면
                int next = i;
                // 아직 방문하지 않은 노드의 Visited 배열을 true로
                if(!Visited[next]) {
                    Visited[next] = true;
                    // 큐에 저장
                    queue.add(next);
                }
            }
        }
        // 최종 출력
        System.out.println(sb);
    }
}
