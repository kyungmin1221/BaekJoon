package BaekJoon.bronze;

import java.util.Scanner;

public class Baek_27433 {

    static long factorial(int num) {

        if(num == 0) {
            return 1;
        } else {
            return num * factorial(num-1);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long answer = factorial(n);       // 5! -> 5*4*3*2*1 = 120
        System.out.println(answer);
    }
}
