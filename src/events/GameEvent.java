package events;

import domain.Company;

public interface GameEvent {

    void apply(Company company);
}