package BaekJoon;

// 카드2 //

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek_2164 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();    // 카드 개수 입력
        Queue<Integer> que = new LinkedList<Integer>();   // 큐 생성
        for(int i=1; i<= N; i++)
        {
            que.add(i);
        }
        while(que.size() > 1) {        // 카드가 마지막 한장이 남을 때 까지
            que.poll();               // 맨위 카드 버림
            que.add(que.poll());     // 맨위 카드 버린걸 뒤에 추가 (핵심)
         }
        System.out.println(que.poll());
    }
}
