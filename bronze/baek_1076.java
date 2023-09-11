package BaekJoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

// 저항 //

public class baek_1076 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,String> map = new HashMap<String,String>() {{
                put("black","0");
                put("brown","1");
                put("red","2");
                put("orange","3");
                put("yellow","4");
                put("green","5");
                put("blue","6");
                put("violet","7");
                put("grey","8");
                put("white","9");
            } };
        String color1 = br.readLine();
        String color2 = br.readLine();
        String color3 = br.readLine();
        long ans = Long.parseLong(map.get(color1) + map.get(color2));
        ans *= Math.pow(10 , (double)Integer.parseInt(map.get(color3)));

        System.out.println(ans);
    }
}
