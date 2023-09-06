package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_1260_2 {
    static int N,E,S;
    static boolean[] Visited;
    static ArrayList<Integer>A[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 양방향 엣지 그래프 표현
            A[u].add(v);
            A[v].add(u);
        }
        // 오름차순 정렬
        // 가장 작은 수 부터 방문할 수 있음
        for(int i=1; i<=N; i++) {
            Collections.sort(A[i]);
        }

        Visited = new boolean[N+1];
        DFS(S);
        System.out.println();
        Visited = new boolean[N+1];
        BFS(S);
        System.out.println();


    }
    public static void DFS(int node) {
        System.out.print(node +" ");
        Visited[node] = true;
        for(int i : A[node]) {
            if(!Visited[i]) {
                DFS(i);
            }
        }
    }
    public static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        Visited[node] = true;
        queue.add(node);
        while(!queue.isEmpty()) {
            int k = queue.poll();
            System.out.print(k + " ");
            for(int i : A[k]) {
                if(!Visited[i]) {
                    Visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
