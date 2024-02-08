package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// n 번째로 큰숫자를 찾아야함
// 제일 큰 수를 일단 찾고 , 최대힙으로? 정렬을 하고 n 번쨰 수를 찾는다?
//


public class Baek_2075{
    static int n;
    static int[][] box;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        box = new int[n][n];

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> {
            int a = o1;
            int b = o2;

            if(a>b) {
                return -1;
            } else {
                return 1;
            }
        });

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for(int j=0; j<n; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                pq.add(box[i][j]);
            }
        }

        int count =0;
        System.out.println(pq);
        for(int i=0; i<n; i++) {
            count ++;
            if(count == n) {
                System.out.println(pq.poll());
                break;
            }
            pq.poll();

        }

    }
}
