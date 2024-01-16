package BaekJoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1011 {
    static int T;
    static int x,y;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T =Integer.parseInt(bf.readLine());
        for(int i=1; i<=T; i++) {

            StringTokenizer st = new StringTokenizer(bf.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            int distance = y-x;
            int max = (int)Math.sqrt(distance);

            if(max == Math.sqrt(distance)) {
                System.out.println(max*2 - 1);
            } else if (distance <= (max * max) + max) {
                System.out.println(2 * max);
            } else {
                System.out.println(( 2 * max) + 1);
            }

        }

    }
}
