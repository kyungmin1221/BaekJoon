package BaekJoon.silver;



// 수 들의 합 5 //

import java.util.Scanner;

public class baek_2018 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int start = 1;
        int end = 1;
        int sum = 1;
        int count = 1;

        while(end != N) {
            if(sum == N) {
                count ++;
                end ++;
                sum += end;
            } else if (sum > N) {
                // start++;   sum 을 먼저 증가시킬시 sum 값이 안맞게된다..!
                sum -= start;
                start++;
            }else {
                end++;
                sum += end;
            }
        }
        scanner.close();
        System.out.println(count);
    }
}
