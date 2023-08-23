package BaekJoon;

// 연결 요소의 개수 구하기 //
// DFS : 깊이 우선 탐색
// 재귀함수이용

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_11724 {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static void dfs(int node) {
        // 노드를 방문했었다면 그냥 리턴해준다.
        if(visited[node]) {
            return;
        }
        // 해당 노드를 true 로 바꾸어주고
        visited[node] = true;
        // 해당 노드의 원소들을 확인
        for(int i : A[node]) {
            // 연결 노드 중 방문하지 않았던 노드들만 탐색한다.
            if(visited[i] == false) {
                // 방문하지 않았던 원소의 재귀함수를 호출한다.
                dfs(i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());   // 노드 개수
        int E = Integer.parseInt(st.nextToken());   // 에지 개수
        A = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i =1; i<N+1; i++) {
            A[i] = new ArrayList<>();
        }
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            // 양방향 에지이므로 양쪽에 에지를 더하기
            A[u].add(v);
            A[v].add(u);
        }
        // 연결 요소의 개수를 출력할 변수
        int count = 0;
        for(int i=1; i<N+1; i++) {
            // 방문하지 않은 노드가 없을 때까지 반복하기
            if(!visited[i]) {
                // 연결요소의 개수를 증가
                // 문제에서는 1에서 한번 증가하고, 3에서 한번 더 증가하여 count = 2 가 된다.
                count ++;
                // 재귀함수 호출
                dfs(i);
            }
        }
        // 연결 요소의 개수 출력
        // 1-2-5  , 3-4-6 으로 연결되어 있다.
        // 문제에서는 1에서 한번 증가하고, 3에서 한번 더 증가하여 count = 2 가 된다.
        System.out.println(count);
    }
}
