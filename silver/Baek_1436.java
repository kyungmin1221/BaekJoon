package BaekJoon.silver;


// 영화감독 숌//
// 브루트포스

import java.util.Scanner;

public class Baek_1436 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 3

        int target = 666;
        int count = 1;

        while( count != n ) {
            target ++;
            if(String.valueOf(target).contains("666")) {
                count++;
            }
        }
        System.out.println(target);
    }
}
