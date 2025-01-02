package org.example;

import java.util.*;

class QuoteLv8{
    int id; // Lv4의 actCnt처럼 몇번 째로 등록이 아닌, 명언별로 번호를 달아주기위해 추가
    String quote;
    String author;

    //생성자 -> 생성자를 사용하지 않으면 객체 생성 후 별도로 필드를 초기화해야 하므로 번거로움
    QuoteLv8(int id, String quote, String author){
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

public class Lv8 {
    Scanner scan = new Scanner(System.in);
    List<QuoteLv8> QLstLv8 = new ArrayList<>();

    public void doLv8(){
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

                QLstLv8.add(new QuoteLv8(id,quote,author));
                System.out.println(id++ +"번 명언이 등록되었습니다.");
            }
            else if(order.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                if(QLstLv8.isEmpty()) {
                    System.out.println("등록된 명언이 없습니다.");
                }
                else{
                    for(int i=QLstLv8.size()-1;i>=0;i--){
                        System.out.println(QLstLv8.get(i));
                    }
                }
            }
            else if(order.equals("종료")){
                return;
            }
            else if(order.startsWith("삭제?id=")){ //startsWith 메서드를 사용.
                try{
                    int deleteId = Integer.parseInt(order.split("=")[1]); //이부분 동작에 대해 예외처리 함.
                    boolean isRemoved = QLstLv8.removeIf(QLstEle -> QLstEle.id == deleteId);

                    if (isRemoved) {
                        System.out.println(deleteId + "번 명언이 삭제되었습니다.");
                    } else {
                        System.out.println(deleteId + "번 명언은 존재하지 않습니다.");
                    }
                }
                catch(Exception e){
                    System.out.println("명령어 형식을 재확인 하십시오. 형식 : 삭제?id=숫자 ");
                }
            }
            else if(order.startsWith("수정?id=")){ //startsWith 메서드를 사용.
                try{
                    int modifyId = Integer.parseInt(order.split("=")[1]); //이부분 동작에 대해 예외처리 함.
                    boolean isExist = false; //존재여부 확인용

                    for(int i=0 ; i<QLstLv8.size();i++){
                        if(QLstLv8.get(i).id==modifyId){
                            isExist=true;

                            System.out.println("명언(기존) : "+QLstLv8.get(i).quote);
                            System.out.printf("명언 : ");
                            QLstLv8.get(i).quote = scan.nextLine().trim(); //명언 클래스 리스트 객체 갱신

                            System.out.println("작가(기존) : "+QLstLv8.get(i).author);
                            System.out.printf("작가 : ");
                            QLstLv8.get(i).author = scan.nextLine().trim(); //명언 클래스 리스트 객체 갱신

                        }
                    }

                    if (isExist) {
                        System.out.println(modifyId + "번 명언이 수정되었습니다.");
                    } else {
                        System.out.println(modifyId + "번 명언은 존재하지 않습니다.");
                    }

                }
                catch(Exception e){
                    System.out.println("명령어 형식을 재확인 하십시오. 형식 : 수정?id=숫자 ");
                }
            }
            else{
                System.out.println("유효하지 않은 명령어입니다.");
            }
        }

    }


}
