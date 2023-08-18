package BaekJoon;

// 절댓값 힙 //
// 우선순위 큐

/* 
x = 0 일때 ) 큐가 비어있을 떄는 0을 출력, 비어있지 않을 때는 절댓값이 최소인 값을 출력
단, 절댓값이 같다면 음수를 우선 출력

x ≠ 0 일 때 ) offer 또는 add 로 큐에 새로운 값을 출력하고, 우선순위 큐 정렬 기준으로 자동 정렬한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baek_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // MyComparator 클래스의 객체 생성
        MyComparator mc = new MyComparator();
        // 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>(mc);
        int N = Integer.parseInt(bf.readLine());
        int input;
        for(int i=0; i<N; i++) {
            input = Integer.parseInt(bf.readLine());
            // 입력한 문자가 0 이 아니라면 큐에 저장
            if(input != 0) {
                pq.add(input);
                // 문자가 0 이라면
            } else {
                // 큐가 비어있지 않다면
                if(!pq.isEmpty()) {
                    // MyComparator에서 구현한 우선순위 큐로 꺼낸 수 출력
                    System.out.println(pq.poll());
                }
                // 배열이 비어있는데 절댓값이 가장 작은 값을 출력하라고 하는 경우 0을 출력
                else {
                    System.out.println(0);
                }

            }
        }
    }
}
// Comparator의 compare 메소드는 다음의 반환 값을 기반으로 두 객체를 비교합니다
//  양수:     첫 번째 객체 (o1)이 두 번째 객체 (o2)보다 크다는 것을 나타냅니다.
//  음수:     첫 번째 객체 (o1)이 두 번째 객체 (o2)보다 작다는 것을 나타냅니다.
//  0  :    두 객체 (o1과 o2)가 같다는 것을 나타냅니다.
class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        int a = Math.abs(o1);
        int b = Math.abs(o2);
        // x = 0 일때
        // 절댓값이 작은 수를 출력
        if(a>b) {
            return 1;
        } else if (a<b) {
            return -1;
        }
        // 절댓값이 같다면 , 두 수중 음수를 출력해야 한다.
        else {
            // 두 수가 같다면 우선순위는 상관없다
            if(o1 == o2) {
                return 0;
                // o1 이 크다면 첫번째 수가 우선순위
            } else if (o1>o2) {
                return 1;
            }
            // o2가 크다면 두번째 수가 우선순위
            else {
                return -1;
            }
        }
    }
}
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Comparator;
//import java.util.PriorityQueue;
//public class Baek_11286 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(bf.readLine());
//        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)-> {
//           int a = Math.abs(o1);
//           int b = Math.abs(o2);
//           if(a == b) {
//               return o1 > o2 ? 1 : -1 ;
//           }
//           else {
//               return a - b;
//           }
//        });
//        for(int i=0; i<N; i++) {
//            int request = Integer.parseInt(bf.readLine());
//            if(request == 0 ) {
//                if(pq.isEmpty()) {
//                    System.out.println("0");
//                }
//                else {
//                    System.out.println(pq.poll());
//                }
//            }
//            else {
//                pq.add(request);
//            }
//        }
//    }
//}

