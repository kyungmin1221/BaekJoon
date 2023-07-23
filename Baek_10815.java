package BaekJoon;

import java.util.*;
import java.util.Scanner;

/*
HashSet : set 인터페이스에서 지원하는 구현 클래스
성질 )
1. 중복된 값을 허용하지 않는다 .
2. list 등과는 다르게 저장한 순서가 보장되지 않는다.
3. null을 값으로 허용한다. 
 */


public class Baek_10815 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<N; i++) {
            int A = scanner.nextInt();
            set.add(A);
        }
        int M = scanner.nextInt();
        for(int i=0; i<M; i++) {
            int B= scanner.nextInt();
            if(set.contains(B)) {
                System.out.print(1);
            }
            else {
                System.out.print(0);
            }
            System.out.print(" ");
        }
    }
}

