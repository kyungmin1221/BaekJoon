package BaekJoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baek_1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int A = Integer.parseInt(st.nextToken()); //bf.readLine() st.nextToken()
        int B = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();

        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<A; i++) {
            set.add(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<B; i++) {
            String str = st.nextToken();
            if(set.contains(str)) {
                set.remove(str);
            } else {
                set.add(str);
            }
        }
        System.out.println(set.size());
    }
}
