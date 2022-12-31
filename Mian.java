package BaekJoon;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int bugger1 = sc.nextInt();
        int bugger2 = sc.nextInt();
        int bugger3 = sc.nextInt();
        int coca = sc.nextInt();
        int cyder = sc.nextInt();


        // coca is small
        if(bugger1<bugger2 && bugger3<bugger1) {   // bugger3 is small
            if(coca<cyder) {
                System.out.println(bugger3 + coca - 50);
            }
        } else if (bugger2<bugger3 && bugger1 < bugger2) { // bugger1 is small
            if(coca<cyder) {
                System.out.println(bugger1 + coca - 50);
            }
        }
        else {
            if(coca<cyder) {
                System.out.println();
            }

        }

    }
}