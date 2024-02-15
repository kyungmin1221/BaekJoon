package BaekJoon.silver;


// 바이러스 //
// DFS
// 재귀 호출

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek_2606 {
    static int n;
    static ArrayList<Integer>[] arrayList;
    static int number;
    static boolean[] visited;
    static int count = 0;

    static int computer(int start) {
        visited[start] = true;
        for(int x : arrayList[start]) {
            if(!visited[x]) {
                count ++;
                visited[x] = true;
                computer(x);

            }

        }
        return count;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        number = Integer.parseInt(bf.readLine());
        arrayList = new ArrayList[n+1];
        visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            arrayList[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<number; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arrayList[u].add(v);
            arrayList[v].add(u);
        }
        computer(1);

        System.out.println(count);

        }
    }
    
    

