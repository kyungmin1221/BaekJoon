package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


// 덱

public class Baek_2346 {

        public static void main (String[]args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(bf.readLine());
            Deque<Integer> deque = new ArrayDeque<>();
            int[] balloon = new int[n+1];

            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int i =1; i<=n; i++) {
                balloon[i] = Integer.parseInt(st.nextToken());
                deque.offerLast(i);       // 1 2 3 4 5
            }

            StringBuilder sb = new StringBuilder();

            while(!deque.isEmpty()) {
                int index = deque.removeFirst();        // 1 -> 4 ->...-> 2
                sb.append(index).append(" ");

                if (deque.isEmpty()) {
                    break;
                }

                int steps = balloon[index];     // step = 3 -> steps = -3 ... steps = 2

                if(steps > 0) {
                    for(int i=0; i<steps-1; i++) {
                        deque.offerLast(deque.removeFirst());
                    }
                } else {
                    for(int i=0; i<Math.abs(steps); i++) {
                        deque.offerFirst(deque.removeLast());
                    }
                }

            }   // end while

            System.out.println(sb);


    }
}


