package org.example;

import java.util.*;



public class QuoteApp {
    private final Scanner scan = new Scanner(System.in);
    QuoteController quoteController = new QuoteController(scan);
    private final List<Quote> quotes = new ArrayList<>();
    private int nextId = 1;

    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.printf("명령) ");
            String command = scan.nextLine().trim();

            switch (command.split("\\?")[0]) {
                case "등록":
                    quoteController.registerQuote();
                    break;
                case "목록":
                    quoteController.listQuotes();
                    break;
                case "종료":
                    System.out.println("프로그램을 종료합니다.");
                    return;
                case "삭제":
                    quoteController.deleteQuote(command);
                    break;
                case "수정":
                    quoteController.modifyQuote(command);
                    break;
                default:
                    System.out.println("유효하지 않은 명령어입니다.");
            }
        }
    }
}
