package BaekJoon.silver;


// 바이러스 //


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Baek_2606 {

    static int n,m;
    static ArrayList<Integer>[] graph;
    static int count;
    static boolean[] visitesd;

    static int virus(int startnode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startnode);
        visitesd[startnode] = true;

        while (!queue.isEmpty()) {
            int vir = queue.poll();
            for(int x : graph[vir]) {
                if(!visitesd[x]) {
                    queue.offer(x);
                    visitesd[x] = true;
                    count ++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        m = Integer.parseInt(bf.readLine());

        visitesd = new boolean[n+1];
        graph = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[v].add(e);
            graph[e].add(v);
        }
        virus(1);
        System.out.println(count);

    }
}
    
    

