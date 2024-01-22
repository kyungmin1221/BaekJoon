package BaekJoon.silver;



// 단어 정렬 //
// 문자열 & 정렬
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class baek_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String[] str = new String[N];
        for(int i=0; i<N; i++) {
            str[i] = bf.readLine();
        }

        // 1. 길이가 짧은거
        // 2. 길이가 같다면 사전 순
        // + 중복이면 하나만 출력
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) {    // 길이가 같다면
                    return o1.compareTo(o2);        // 사전 순
                }
                else {
                    return o1.length() - o2.length();   // 양수 -> o2 , o1.. 순서
                }
            }
        }
        );
        ArrayList<String> arr = new ArrayList<>();
        arr.add(str[0]);

        for(int i=1; i<N; i++) {
            if(!str[i].equals(str[i-1])) {
                arr.add(str[i]);
            }
        }

        for(int i=0; i<arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
}
