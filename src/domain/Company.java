package domain;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private String name;
    private double cash;

    private List<Employee> employees = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();

    public Company(String name, double cash) {
        this.name = name;
        this.cash = cash;
    }

    public void hire(Employee e) {
        employees.add(e);
    }

    public void addProject(Project p) {
        projects.add(p);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public double getCash() {
        return cash;
    }

    public void addCash(double amount) {
        cash += amount;
    }

    public void reduceCash(double amount) {
        cash -= amount;
    }

    public void paySalaries() {

        double total = 0;

        for (Employee e : employees) {
            total += e.getSalary();
        }

        cash -= total;

        System.out.println("Salaries paid: " + total);
    }

    @Override
    public String toString() {

        return "Company: " + name +
                " | Cash: " + cash +
                " | Employees: " + employees.size();
    }
}