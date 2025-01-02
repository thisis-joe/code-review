package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuoteController {
    private final List<Quote> quotes = new ArrayList<>();
    private final Scanner scan;
    private int nextId = 1;

    public QuoteController(Scanner scan) {
        this.scan = scan;
    }

    // 1. 명언 등록
    public void registerQuote() {
        System.out.printf("명언 : ");
        String quoteText = scan.nextLine().trim();
        System.out.printf("작가 : ");
        String author = scan.nextLine().trim();

        quotes.add(new Quote(nextId, quoteText, author));
        System.out.println(nextId++ + "번 명언이 등록되었습니다.");
    }

    // 2. 명언 목록
    public void listQuotes() {
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

    // 3. 명언 삭제
    public void deleteQuote(String command) {
        try {
            int idToDelete = parseIdFromCommand(command);
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

    // 4. 명언 수정
    public void modifyQuote(String command) {
        try {
            int idToModify = parseIdFromCommand(command);
            Quote targetQuote = findQuoteById(idToModify);

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

    // 명령어에서 ID 추출
    private int parseIdFromCommand(String command) {
        return Integer.parseInt(command.split("=")[1].trim());
    }

    // ID로 명언 찾기
    private Quote findQuoteById(int id) {
        for (Quote quote : quotes) {
            if (quote.id == id) {
                return quote;
            }
        }
        return null;
    }
}