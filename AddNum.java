package BaekJoon;

import java.util.Scanner;

public class AddNum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String sNum = scan.next();
        char[] cNum = sNum.toCharArray();

        int sum = 0;
        for(int i=0; i<cNum.length; i++) {
            sum += cNum[i] - '0';
            System.out.println(sum);
        }
       // System.out.println(sum);

    }
}
