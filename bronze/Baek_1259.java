package BaekJoon.bronze;

// 펠린드롬수  :  앞에서 읽을때나 뒤에서 읽을 때나 같은 문자열을 말함 //
// 문자열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String str = bf.readLine();
            boolean test = true;
            if(str.equals("0")) {
                break;
            }
            for(int i=0; i<str.length(); i++) {
                if(str.charAt(i) != str.charAt(str.length()-1-i)) {
                    test = false;
                }
            }
            if(test) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }   // "0" 이 오면 종료
    }
}
