package BaekJoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 카드 정렬하기 //
// 그리디 & 우선순위 큐


public class Baek_1715 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> priority = new PriorityQueue<>();    // 오름차순으로 큐 정렬

        int N = Integer.parseInt(bf.readLine());
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int size = Integer.parseInt(st.nextToken());
            priority.add(size);
        }

        int card = 0;
        while(priority.size() > 1) {
            int numA = priority.poll();
            int numB = priority.poll();

            card += numA + numB;
            priority.add(numA + numB);
           // priority.add(card);
            System.out.println(priority);

        }
        System.out.println(card);
    }
}
