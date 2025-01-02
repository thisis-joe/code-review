package org.example;

import java.util.*;

//메인 기능
class QuoteLv9 {
    int id;
    String quote;
    String author;

    QuoteLv9(int id, String quote, String author) {
        this.id = id;
        this.quote = quote;
        this.author = author;
    }

    @Override
    public String toString() {
        return id + " / " + author + " / " + quote;
    }
}

public class Lv9 {
    private final Scanner scan = new Scanner(System.in);
    private final List<QuoteLv9> quotes = new ArrayList<>();
    private int nextId = 1;

    public void doLv9() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.printf("명령) ");
            String command = scan.nextLine().trim();

            switch (command.split("\\?")[0]) {
                case "등록":
                    registerQuote();
                    break;
                case "목록":
                    listQuotes();
                    break;
                case "종료":
                    System.out.println("프로그램을 종료합니다.");
                    return;
                case "삭제":
                    deleteQuote(command);
                    break;
                case "수정":
                    modifyQuote(command);
                    break;
                default:
                    System.out.println("유효하지 않은 명령어입니다.");
            }
        }
    }

    private void registerQuote() {
        System.out.printf("명언 : ");
        String quoteText = scan.nextLine().trim();
        System.out.printf("작가 : ");
        String author = scan.nextLine().trim();

        quotes.add(new QuoteLv9(nextId, quoteText, author));
        System.out.println(nextId++ + "번 명언이 등록되었습니다.");
    }

    private void listQuotes() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        if (quotes.isEmpty()) {
            System.out.println("등록된 명언이 없습니다.");
        } else {
            for (int i = quotes.size() - 1; i >= 0; i--) {
                System.out.println(quotes.get(i));
            }
        }
    }

    private void deleteQuote(String command) {
        try {
            int idToDelete = getIdFromCommand(command);
            boolean removed = quotes.removeIf(quote -> quote.id == idToDelete);

            if (removed) {
                System.out.println(idToDelete + "번 명언이 삭제되었습니다.");
            } else {
                System.out.println(idToDelete + "번 명언은 존재하지 않습니다.");
            }
        } catch (NumberFormatException e) {
            System.out.println("명령어 형식을 재확인 하십시오. 형식 : 삭제?id=숫자");
        }
    }

    private void modifyQuote(String command) {
        try {
            int idToModify = getIdFromCommand(command);
            QuoteLv9 targetQuote = findQuoteById(idToModify);

            if (targetQuote != null) {
                System.out.println("명언(기존) : " + targetQuote.quote);
                System.out.printf("명언 : ");
                targetQuote.quote = scan.nextLine().trim();

                System.out.println("작가(기존) : " + targetQuote.author);
                System.out.printf("작가 : ");
                targetQuote.author = scan.nextLine().trim();

                System.out.println(idToModify + "번 명언이 수정되었습니다.");
            } else {
                System.out.println(idToModify + "번 명언은 존재하지 않습니다.");
            }
        } catch (NumberFormatException e) {
            System.out.println("명령어 형식을 재확인 하십시오. 형식 : 수정?id=숫자");
        }
    }

    private int getIdFromCommand(String command) {
        return Integer.parseInt(command.split("=")[1].trim());
    }

    private QuoteLv9 findQuoteById(int id) {
        for (QuoteLv9 quote : quotes) {
            if (quote.id == id) {
                return quote;
            }
        }
        return null;
    }
}