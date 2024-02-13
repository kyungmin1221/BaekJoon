package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Baek_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String,String> hashMap = new HashMap<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(bf.readLine());
            String mapkey = st.nextToken();
            String mapvalue = st.nextToken();
            hashMap.put(mapkey,mapvalue);
        }

        for(int i=0; i<m; i++) {
            String answer = bf.readLine();
            if(hashMap.containsKey(answer)) {
                System.out.println(hashMap.get(answer));
            }
        }

    }
}
