package BaekJoon;

// 암기왕 //

// 해시

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Baek_2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 테스트 케이스
        int T = Integer.parseInt(bf.readLine());

        // T(테스트케이스) 만큼 루프 반복
        for(int t = 0; t<T; t++) {
            int N = Integer.parseInt(bf.readLine());
            int[] A = new int[N];
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(bf.readLine());
            int[] B = new int[M];
            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int x : A) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
            for (int x : B) {
                if (!map.containsKey(x)) {
                    sb.append("0");
                } else {
                    sb.append("1");
                }
                sb.append("\n");
            }
        }   // T(테스트케이스) 만큼 루프 반복


        System.out.println(sb);
    }
}