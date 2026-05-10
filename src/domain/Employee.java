package domain;

public abstract class Employee {

    protected String name;
    protected int skill;
    protected double salary;

    public Employee(String name, int skill, double salary) {
        this.name = name;
        this.skill = skill;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSkill() {
        return skill;
    }

    public double getSalary() {
        return salary;
    }

    public abstract int work();

    @Override
    public String toString() {
        return name + " Skill:" + skill + " Salary:" + salary;
    }
}