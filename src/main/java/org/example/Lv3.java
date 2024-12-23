package org.example;

import java.util.Scanner;

public class Lv3 {
    public void doLv3(){
        String order="";
        String quote="";
        String name="";
        int count = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");


        while(true){
            System.out.printf("명령: ");
            order = scan.nextLine().trim();
            if(order.equals("등록")){
                System.out.printf("명언: ");
                quote=scan.nextLine().trim();
                System.out.printf("작가: ");
                name=scan.nextLine().trim();

                count++;

                System.out.println(count + "번 명언이 등록되었습니다.");
                return;
            }
            else if(order.equals("종료")){
                return;
            }

        }


    }
}
