package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_1966 {
    static int T,N,M;	// 테스트 케이스,문서의 개수,중요
    static int priary;

    static void solution(int N, int M, int priary) {


    }

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        T = Integer.parseInt(bf.readLine());
        int testcase = 1;
      //   while(testcase<=T) {
             StringTokenizer st = new StringTokenizer(bf.readLine());
             N = Integer.parseInt(st.nextToken());
             M = Integer.parseInt(st.nextToken());

             st = new StringTokenizer(bf.readLine());
             for (int i = 0; i < N; i++) {
                 queue.offer(Integer.parseInt(st.nextToken()));
             }

             solution(N, M, priary);
         }

}
