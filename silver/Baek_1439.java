package BaekJoon.silver;

import java.io.*;

// 뒤집기 //
// 그리디 & 문자열


// 조건 //
// 연속된 "하나 이상" 의 숫자를 잡고 모두 뒤집는 것 -> 최소행동의 수를 찾는다


public class Baek_1439 {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();

        int zero = 0;
        int one = 0;

        if (str.charAt(0) == '0') {
            zero++;
        }
        else {
            one++;
        }

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) != str.charAt(i)) {
                if (str.charAt(i) == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
        }
        System.out.println(Math.min(zero, one));
    }
}
