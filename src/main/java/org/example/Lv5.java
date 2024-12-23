package org.example;

import java.util.*;

class QuoteLv5{
    int id; // Lv4의 actCnt처럼 몇번 째로 등록이 아닌, 명언별로 번호를 달아주기위해 추가
    String quote;
    String author;

    //생성자 -> 생성자를 사용하지 않으면 객체 생성 후 별도로 필드를 초기화해야 하므로 번거로움
    QuoteLv5(int id, String quote, String name){
        this.id=id;
        this.quote=quote;
        this.author=author;
    }

    //List나 다른 컬렉션에서 객체를 출력하려고 할 때, 각 객체의 toString() 메서드가 자동으로 호출되므로 toString()을 오버라이딩
    //오버라이딩 하지 않으면 클래스명@주소값 이 반환됨.
    @Override
    public String toString(){
        return id+" / "+author+" / "+quote;
    }
}

public class Lv5 {
    Scanner scan = new Scanner(System.in);
    List<QuoteLv5> QL5 = new ArrayList<>();

    public void doLv5(){
        int id = 1;
        System.out.println("== 명언 앱 ==");

        while(true){
            System.out.printf("명령) ");
            String order=scan.nextLine().trim();
            if(order.equals("등록")){
                System.out.printf("명언 : ");
                String quote = scan.nextLine().trim();
                System.out.printf("작가 : ");
                String author = scan.nextLine().trim();

                QL5.add(new QuoteLv5(id,quote,author));
                System.out.println(id++ +"번 명언이 등록되었습니다.");
            }
            else if(order.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                if(QL5.isEmpty()) {
                    System.out.println("등록된 명언이 없습니다.");
                }
                else{
                    for(int i=QL5.size()-1;i>=0;i--){
                        System.out.println(QL5.get(i));
                    }
                }
            }
            else if(order.equals("종료")){
                return;
            }
            else{
                System.out.println("유효하지 않은 명령어입니다.");
            }
        }

    }

}
