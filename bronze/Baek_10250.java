package BaekJoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_10250 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());
        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            // 402 호 기준
            int H =   Integer.parseInt(st.nextToken());     // 세로 6
            int W =   Integer.parseInt(st.nextToken());     // 가로 12
            int N =   Integer.parseInt(st.nextToken());     // 들어오는 순서 11

            int room = N / H ;
            if(N % H == 0) {
                System.out.println((H * 100) + (room));
            } else {
                System.out.println((N % H) * 100 + (room + 1));
            }
        }
    }
}
