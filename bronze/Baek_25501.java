package BaekJoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_25501 {
    static int count = 0;
    static int recursion(String str,int l, int r) {
        count ++;
        char[] c = str.toCharArray();
        if(l>=r) {
            return 1;
        } else if (c[l] != c[r]) {
            return 0;
        } else {
            return recursion(str,l+1,r-1);
        }
    }

    static int isPalindrome(String str) {
        return recursion(str,0,str.length()-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for(int i =0; i<T; i++) {
            String str = bf.readLine();
            System.out.print(isPalindrome(str) + " " + count);
            System.out.println();
            count = 0;
        }

    }
}
