package events;

import domain.Company;

public class MarketSlowdownEvent implements GameEvent {

    @Override
    public void apply(Company company) {

        System.out.println("EVENT: Market slowdown! Lost 5000.");

        company.reduceCash(5000);
    }
}