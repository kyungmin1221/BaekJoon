package BaekJoon.gold;

// 신기한 소수 //
// DFS
// 재귀함수
// 백트랙킹

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class  Baek_2023{
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    static void DFS(int number, int jarisu) {
        if (jarisu == N) {
            if (isPrime(number)) {
                System.out.println(number);
            }
            return ;
        }
        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            if (isPrime(number * 10 + i)) {
                DFS(number * 10 + i, jarisu + 1);
            }
        }
    }

    static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {  // 더 효율적인 방법
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}


