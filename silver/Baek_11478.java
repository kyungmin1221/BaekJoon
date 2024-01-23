package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


// 서로 다른 부분 문자열 개수 //

public class Baek_11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        HashSet<String> set = new HashSet<>();

        for(int i=0; i<str.length(); i++) {
            int start = 0;
            int end = i+1;
            while(end <= str.length()) {
                set.add(str.substring(start,end));
                start++; end++;
            }
        }
        System.out.println(set.size());
    }
}
