package domain;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private String name;

    private List<Employee> team = new ArrayList<>();

    private int progress;
    private int requiredWork;

    private ProjectStatus status;

    public Project(String name, int requiredWork) {

        this.name = name;
        this.requiredWork = requiredWork;
        this.status = ProjectStatus.NOT_STARTED;
    }

    public void addEmployee(Employee e) {
        team.add(e);
    }

    public void workOneTurn() {

        status = ProjectStatus.IN_PROGRESS;

        for (Employee e : team) {
            progress += e.work();
        }

        if (progress >= requiredWork) {
            progress = requiredWork;
            status = ProjectStatus.COMPLETED;
        }
    }

    public boolean isCompleted() {
        return progress >= requiredWork;
    }

    @Override
    public String toString() {

        return name +
                " | Progress: " + progress + "/" + requiredWork +
                " | Status: " + status;
    }
}