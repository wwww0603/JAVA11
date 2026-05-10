package domain;

public class Designer extends Employee {

    public Designer(String name, int skill, double salary) {
        super(name, skill, salary);
    }

    @Override
    public int work() {
        return skill + 3;
    }
}