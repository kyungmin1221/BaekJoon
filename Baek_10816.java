package BaekJoon;

// 숫자 카드 2 //
// 정렬
// 해시 맵

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baek_10816 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            int A = Integer.parseInt(st.nextToken());
            map.put(A,map.getOrDefault(A,0) + 1);
        }
        int M = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<M; i++) {
            int B = Integer.parseInt(st.nextToken());
            bw.write(map.getOrDefault(B,0)+ " ");
        }
        bw.flush();
        bw.close();
    }
}

