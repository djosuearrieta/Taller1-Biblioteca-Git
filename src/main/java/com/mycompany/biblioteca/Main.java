package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Client> clients = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Loan> loans = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // El menú irá aquí (Fase 8)
    }

    static void createClient() {
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        clients.add(new Client(id, name, phone, email));
        System.out.println("Client created successfully.");
    }

    static void listClients() {
        if (clients.isEmpty()) {
            System.out.println("No clients registered.");
            return;
        }
        for (Client c : clients) {
            System.out.println(c);
        }
    }

    static Client searchClient(String id) {
        for (Client c : clients) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    static void updateClient() {
        System.out.print("Client ID to update: ");
        String id = sc.nextLine();
        Client c = searchClient(id);
        if (c == null) {
            System.out.println("Client not found.");
            return;
        }
        System.out.print("New name: ");
        c.setName(sc.nextLine());
        System.out.print("New phone: ");
        c.setPhone(sc.nextLine());
        System.out.print("New email: ");
        c.setEmail(sc.nextLine());
        System.out.println("Client updated.");
    }
    
        static void deleteClient() {
        System.out.print("Client ID to delete: ");
        String id = sc.nextLine();
        Client c = searchClient(id);
        if (c == null) {
            System.out.println("Client not found.");
            return;
        }
        clients.remove(c);
        System.out.println("Client deleted.");
    }
        
    static void createBook() {
        System.out.print("Code: ");
        String code = sc.nextLine();
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Publication year: ");
        String year = sc.nextLine();
        System.out.print("Author: ");
        String author = sc.nextLine();

        books.add(new Book(code, title, year, author));
        System.out.println("Book created successfully.");
    }
            
    static void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books registered.");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }
     
    static Book searchBook(String code) {
        for (Book b : books) {
            if (b.getCode().equals(code)) {
                return b;
            }
        }
        return null;
    }
    
        static void updateBook() {
        System.out.print("Book code to update: ");
        String code = sc.nextLine();
        Book b = searchBook(code);
        if (b == null) {
            System.out.println("Book not found.");
            return;
        }
        System.out.print("New title: ");
        b.setTitle(sc.nextLine());
        System.out.print("New author: ");
        b.setAuthor(sc.nextLine());
        System.out.print("New publication year: ");
        b.setPublicationYear(sc.nextLine());
        System.out.println("Book updated.");
    }
        
       static void deleteBook() {
        System.out.print("Book code to delete: ");
        String code = sc.nextLine();
        Book b = searchBook(code);
        if (b == null) {
            System.out.println("Book not found.");
            return;
        }
        books.remove(b);
        System.out.println("Book deleted.");
    }
    
       static void createLoan() {
        System.out.print("Client ID: ");
        String clientId = sc.nextLine();
        Client c = searchClient(clientId);
        if (c == null) {
            System.out.println("Client not found.");
            return;
        }

        System.out.print("Book code: ");
        String bookCode = sc.nextLine();
        Book b = searchBook(bookCode);
        if (b == null) {
            System.out.println("Book not found.");
            return;
        }
        if (!b.isAvailable()) {
            System.out.println("The book is not available.");
            return;
        }

        System.out.print("Loan ID: ");
        String loanId = sc.nextLine();

        Loan loan = new Loan(loanId, c, b);
        b.setAvailable(false);
        loans.add(loan);
        System.out.println("Loan registered successfully.");
    }
}