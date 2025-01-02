package org.example;

class Quote {
    int id;
    String quote;
    String author;

    Quote(int id, String quote, String author) {
        this.id = id;
        this.quote = quote;
        this.author = author;
    }

    @Override
    public String toString() {
        return id + " / " + author + " / " + quote;
    }
}