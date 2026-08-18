package com.mycompany.biblioteca;

import java.time.LocalDate;

public class Loan {
    private String loanId;
    private Client client;
    private Book book;
    private LocalDate date;
    private String status; // "ACTIVE" or "RETURNED"

    public Loan(String loanId, Client client, Book book) {
        this.loanId = loanId;
        this.client = client;
        this.book = book;
        this.date = LocalDate.now();
        this.status = "ACTIVE";
    }

    public String getLoanId() { return loanId; }
    public Client getClient() { return client; }
    public Book getBook() { return book; }
    public LocalDate getDate() { return date; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "loanId=" + loanId
                + ", client=" + client.getName()
                + ", book=" + book.getTitle()
                + ", date=" + date
                + ", status=" + status;
    }
}