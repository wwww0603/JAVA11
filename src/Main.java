import domain.*;
import engine.GameEngine;
import ui.ConsoleUI;

public class Main {

    public static void main(String[] args) {

        Company company = new Company("TechCorp", 50000);

        Developer dev = new Developer("Anna", 8, 7000);
        Tester tester = new Tester("Piotr", 6, 6000);
        Designer designer = new Designer("Eva", 7, 5000);

        company.hire(dev);
        company.hire(tester);
        company.hire(designer);

        Project project = new Project("Mobile App", 120);

        project.addEmployee(dev);
        project.addEmployee(tester);
        project.addEmployee(designer);

        company.addProject(project);

        ConsoleUI ui = new ConsoleUI();

        GameEngine engine = new GameEngine(company, ui);

        engine.run();
    }
}