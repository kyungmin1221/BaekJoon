package BaekJoon;

import java.io.IOException;
import java.util.Scanner;


public class baek_1110 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int temp = N;
        int count = 0;

        while (true) {
            int left = temp/10;    // 2
            int right = temp % 10;    // 6
            temp =right *10 + (left+right)%10;
            count ++;
            if(N == temp ) {
                break;
            }
        }
        System.out.println(count);
    }
}
