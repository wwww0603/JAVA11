package ui;

import domain.Company;
import domain.Project;

import java.util.Scanner;

public class ConsoleUI {

    private Scanner scanner = new Scanner(System.in);

    public void showTurn(int turn) {
        System.out.println("\n========================");
        System.out.println("TURN " + turn);
        System.out.println("========================");
    }

    public void showCompanyStatus(Company company) {
        System.out.println(company);
    }

    public void showProjects(Company company) {

        System.out.println("\nProjects:");

        for (Project p : company.getProjects()) {
            System.out.println(p);
        }
    }

    public void showMenu() {

        System.out.println("\nMENU:");
        System.out.println("1. Work One Turn");
        System.out.println("2. Hire Developer");
        System.out.println("3. Hire Tester");
        System.out.println("4. Hire Designer");
        System.out.println("0. Exit");

        System.out.print("Choose: ");
    }

    public int readChoice() {

        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a number!");
            scanner.next();
        }

        return scanner.nextInt();
    }
}