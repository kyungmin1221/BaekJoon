package BaekJoon;

// 숫자카드 //

// 이분 탐색
// 해시
// 정렬

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baek_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] A = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        int[] B = new int[M];
        for(int i=0; i<M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x : A) {
            map.put(x,map.getOrDefault(x,0) +1 );
        }
        for(int x : B) {
            if(!map.containsKey(x)) {
                System.out.print("0" + " ");
            } else {
                System.out.print("1"+ " ");
            }
        }
    }
}
