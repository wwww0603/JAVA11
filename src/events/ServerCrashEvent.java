package events;

import domain.Company;

public class ServerCrashEvent implements GameEvent {

    @Override
    public void apply(Company company) {

        System.out.println("EVENT: Server crash! Lost 3000.");

        company.reduceCash(3000);
    }
}