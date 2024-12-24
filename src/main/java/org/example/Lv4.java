package org.example;

import java.util.*;

class QuoteLv4{ // 관리를 위해 명언-작가 저장하는 클래스 따로 작성
    String quote;
    String author;
    int quoteCnt = 0;
    QuoteLv4(String quote, String author){
        this.quote = quote;
        this.author = author;
    }
}
public class Lv4 {

    public void doLv4(){
        int actCnt = 0;
        Scanner scan=new Scanner(System.in);
        List<QuoteLv4> QL4= new ArrayList<>();

        while(true){
            System.out.printf("명령) ");
            String order=scan.nextLine().trim();
            if(order.equals("등록")){
                System.out.printf("명언 : ");
                String quote = scan.nextLine().trim();
                System.out.printf("작가 : ");
                String author = scan.nextLine().trim();

                QL4.add(new QuoteLv4(quote,author));
                actCnt++;

                System.out.println(actCnt+"번 명령이 등록되었습니다.");
            }
            else if(order.equals("종료")){
                return;
            }

        }

    }
}
