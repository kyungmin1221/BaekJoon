package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baek_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String,Integer> hashMap = new HashMap<>();
        for(int i=0; i<n; i++) {
            String answer = bf.readLine();
            hashMap.put(answer,0);
        }
        System.out.println(hashMap);
        int count = 0;
        for(int i=0; i<m; i++) {
            String check = bf.readLine().toLowerCase();
            if(hashMap.containsKey(check)) {
                count ++;
            }
        }
        System.out.println(count);
    }
}

