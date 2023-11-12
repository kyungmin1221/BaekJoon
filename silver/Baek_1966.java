package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 프린터 큐 //
// 시뮬레이션 , 큐
public class Baek_1966 {
    static int T,N,M;	// 테스트 케이스,문서의 개수,중요


    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(bf.readLine());

        for(int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            Queue<int[]> queue = new LinkedList<>();
            int count = 0;
            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                queue.offer(new int[]{i, num});
            }

            while(true) {
                int[] cur = queue.poll();
                boolean check = true;

                for(int[] primary : queue) {
                    // poll() 한 원소의 중요도[1]와 현재 큐의 첫번째 원소의 중요도[1] 을 비교
                    if(primary[1]>cur[1]) {     // 현재 큐의 첫번째 중요도가 더 크다면 방금 poll() 한 원소를 뒤로 보내야됌
                        check = false;
                        break;
                    }
                }
                // poll() 한 원소의 중요도가 제일 높다면
                if(check) {
                    count++; // 인쇄 시작
                    // 꺼낸 원소의 인덱스 번호가 원하는 인덱스와 같다면
                    if(cur[0] == M) {
                        break;
                    }
                } else {
                    queue.offer(cur);
                }

            }
            System.out.println(count);
        }
    }
}

