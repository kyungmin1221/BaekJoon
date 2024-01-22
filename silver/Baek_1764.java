package BaekJoon.silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        HashSet<String> set = new HashSet<>();
        ArrayList<String> arr = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());   // 듣도 x
        int M = Integer.parseInt(st.nextToken());   // 보도 x


        for(int i=0; i<N; i++) {
           set.add(bf.readLine());
        }

        for(int i=0; i<M; i++) {
            String str = bf.readLine();
            if(set.contains(str)) {
                arr.add(str);
            }
        }
        Collections.sort(arr);      // 사전 순 정렬

        System.out.println(arr.size());     // 크기 출력
        for(String s : arr) {
            System.out.println(s);
        }
    }
}
