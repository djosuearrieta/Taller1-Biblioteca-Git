package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Client> clients = new ArrayList<>();
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
}