package events;

import domain.Company;

public class BonusInvestmentEvent implements GameEvent {

    @Override
    public void apply(Company company) {

        System.out.println("EVENT: Investor bonus! Gained 10000.");

        company.addCash(10000);
    }
}