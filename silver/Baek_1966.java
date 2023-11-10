package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_1966 {
    static int T,N,M;	// 테스트 케이스,문서의 개수,중요
    static String priary;

    static void solution(int N, int M, String priary) {
        Queue<Character> queue = new LinkedList<>();
        char[] num = priary.toCharArray();
        int copy = 0;

        for(int i=0; i<N; i++) {
            queue.offer(num[i]);
        }
        while(!queue.isEmpty()) {
            char a = queue.poll();
            char b = queue.poll();
            // 현재 문서보다 중요도가 높은 문서가 있다면 큐에 뒤에 재배치 , 아니면 인쇄
            if(a<b) {
                queue.offer(a);
            } else
        }

    }

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

         T = Integer.parseInt(bf.readLine());
         int testcase = 1;
        // while(testcase<=T) { }
        StringTokenizer st  = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());

        st  = new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++) {
            priary = st.nextToken();
        }

        solution(N,M,priary);

    }
}
