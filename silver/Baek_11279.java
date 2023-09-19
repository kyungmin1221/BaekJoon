package BaekJoon.silver;


// 최대 힙 //
// 우선순위 큐

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> {
            int a = o1;
            int b = o2;
            // a>b 에서 "-1" 을 반환한다면 a가 우선순위가 높다는 의미 (최소힙과 반대)
            // a b ...
            if(a>b) {
                return -1;
            }
            // a>b 에서 "1" 을 반환한다면 b가 우선순위가 높다는 의미 (최소힙과 반대)
            // b a ...
            else {
                return 1;
            }
        });
        for(int i=0; i<N; i++) {
            int input = Integer.parseInt(bf.readLine());
            if(input == 0) {
                if(pq.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(pq.poll());
                }
            }
            else {
                pq.add(input);
            }
        }
    }
}
