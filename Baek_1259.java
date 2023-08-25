package BaekJoon;

// 펠린드롬수  :  앞에서 읽을때나 뒤에서 읽을 때나 같은 문자열을 말함 //
// 문자열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        String answer = "NO";
        str = str.replaceAll("[^A-Z]","");
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equals(tmp)) {
            answer = "YES";
        }
        System.out.println(answer);

    }
}
