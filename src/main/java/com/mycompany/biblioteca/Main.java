package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Client> clients = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Loan> loans = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

        public static void main(String[] args) {
        int option;
        do {
            System.out.println("\n===== LIBRARY SYSTEM =====");
            System.out.println("1. Create client");
            System.out.println("2. List clients");
            System.out.println("3. Search client");
            System.out.println("4. Update client");
            System.out.println("5. Delete client");
            System.out.println("6. Create book");
            System.out.println("7. List books");
            System.out.println("8. Search book");
            System.out.println("9. Update book");
            System.out.println("10. Delete book");
            System.out.println("11. Register loan");
            System.out.println("12. Register return");
            System.out.println("13. List active loans");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1 -> createClient();
                case 2 -> listClients();
                case 3 -> {
                    System.out.print("ID to search: ");
                    Client c = searchClient(sc.nextLine());
                    System.out.println(c != null ? c : "Not found.");
                }
                case 4 -> updateClient();
                case 5 -> deleteClient();
                case 6 -> createBook();
                case 7 -> listBooks();
                case 8 -> {
                    System.out.print("Code to search: ");
                    Book b = searchBook(sc.nextLine());
                    System.out.println(b != null ? b : "Not found.");
                }
                case 9 -> updateBook();
                case 10 -> deleteBook();
                case 11 -> createLoan();
                case 12 -> returnLoan();
                case 13 -> listActiveLoans();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option.");
            }
        } while (option != 0);
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
       
       static void returnLoan() {
        System.out.print("Loan ID to return: ");
        String loanId = sc.nextLine();

        for (Loan l : loans) {
            if (l.getLoanId().equals(loanId) && l.getStatus().equals("ACTIVE")) {
                l.setStatus("RETURNED");
                l.getBook().setAvailable(true);
                System.out.println("Return registered successfully.");
                return;
            }
        }
        System.out.println("Active loan not found.");
    }
       
       static void listActiveLoans() {
        boolean found = false;
        for (Loan l : loans) {
            if (l.getStatus().equals("ACTIVE")) {
                System.out.println(l);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No active loans.");
        }
    }
}