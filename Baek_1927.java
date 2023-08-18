package BaekJoon;

// 최소 힙 //
// 우선순위 큐


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
            int a = o1;
            int b = o2;
            //  a > b일 경우, 1을 반환합니다. 즉, a가 b보다 크면 a가 큐에서 b보다 뒤에 위치해야 합니다.
            // 123 2 1 .. 순서
            if(a>b) {
                return -1;
            }
            else {
                return 1;
            }
    });
        for(int i=0; i<N; i++) {
          int input = Integer.parseInt(bf.readLine());
          if(input == 0) {
              if(pq.isEmpty()) {
                  System.out.println("0");
              }
              else {
                  System.out.println(pq.poll());
              }
          }
          else {
              pq.add(input);
          }
        }
    }
}
