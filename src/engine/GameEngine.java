package engine;

import domain.*;
import events.*;
import ui.ConsoleUI;

import java.util.Random;

public class GameEngine {

    private Company company;
    private ConsoleUI ui;

    private int turn = 1;
    private boolean running = true;

    private Random random = new Random();

    public GameEngine(Company company, ConsoleUI ui) {
        this.company = company;
        this.ui = ui;
    }

    public void run() {

        while (running) {

            ui.showTurn(turn);
            ui.showCompanyStatus(company);
            ui.showProjects(company);
            ui.showMenu();

            int choice = ui.readChoice();

            switch (choice) {

                case 1 -> workOneTurn();

                case 2 -> hireDeveloper();

                case 3 -> hireTester();

                case 4 -> hireDesigner();

                case 0 -> running = false;

                default -> System.out.println("Invalid option!");
            }

            checkWinLoseCondition();

            turn++;
        }

        System.out.println("Game ended.");
    }

    private void workOneTurn() {

        for (Project p : company.getProjects()) {
            p.workOneTurn();
        }

        company.paySalaries();

        triggerRandomEvent();
    }

    private void triggerRandomEvent() {

        int chance = random.nextInt(100);

        GameEvent event = null;

        if (chance < 25) {
            event = new MarketSlowdownEvent();
        }
        else if (chance < 40) {
            event = new BonusInvestmentEvent();
        }
        else if (chance < 55) {
            event = new ServerCrashEvent();
        }

        if (event != null) {
            event.apply(company);
        }
    }

    private void hireDeveloper() {

        Developer dev = new Developer(
                "New Developer",
                7,
                6500
        );

        company.hire(dev);

        if (!company.getProjects().isEmpty()) {
            company.getProjects().get(0).addEmployee(dev);
        }

        System.out.println("Developer hired!");
    }

    private void hireTester() {

        Tester tester = new Tester(
                "New Tester",
                5,
                5000
        );

        company.hire(tester);

        if (!company.getProjects().isEmpty()) {
            company.getProjects().get(0).addEmployee(tester);
        }

        System.out.println("Tester hired!");
    }

    private void hireDesigner() {

        Designer designer = new Designer(
                "New Designer",
                6,
                5500
        );

        company.hire(designer);

        if (!company.getProjects().isEmpty()) {
            company.getProjects().get(0).addEmployee(designer);
        }

        System.out.println("Designer hired!");
    }

    private void checkWinLoseCondition() {

        if (company.getCash() <= 0) {
            System.out.println("BANKRUPTCY! You lost the game.");
            running = false;
        }

        boolean allCompleted = true;

        for (Project p : company.getProjects()) {
            if (!p.isCompleted()) {
                allCompleted = false;
            }
        }

        if (allCompleted) {
            System.out.println("ALL PROJECTS COMPLETED! You win!");
            running = false;
        }
    }
}
