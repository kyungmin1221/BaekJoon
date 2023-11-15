package BaekJoon.bronze;

// 공 //
// 시뮬레이션

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_1547 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(bf.readLine());
        int[] box = new int[5];

        box[1] = 1;

        for(int i=1; i<=M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int temp = box[x];
            box[x] = box[y];
            box[y] = temp;

        }
        for(int i=1; i<5; i++) {
            if(box[i] == 1) {
                System.out.println(i);
            }
        }

    }
}
