package org.example;

import java.util.Scanner;

public class Lv2 {
    public void doLv2(){
        Scanner scan = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");
        while(true) {
            System.out.printf("명령) ");
            String order = scan.nextLine().trim(); //next() 와 nextLine() 혼용 X - 혼용 시 Scanner 버퍼문제 가능성
            String quote = "";
            String name = "";
            if (order.equals("등록")) {
                System.out.printf("명언 : ");
                quote = scan.nextLine().trim();

                System.out.printf("작가 : ");
                name = scan.nextLine().trim();

            }
            else if (order.equals("종료")) {
                return;
            }
        }
    }
}
