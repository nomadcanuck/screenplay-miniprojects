package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.screenplay.targets.Target;

public class JourneySummary {

    public static final Target DEPARTURE_HEADER = Target.the("Departure header").locatedBy(".planner-header__origin");
    public static final Target DESTINATION_HEADER = Target.the("Destination header").locatedBy(".planner-header__destination");
    public static final Target CHEAPEST_PRICE_HEADER = Target.the("Cheapest price header").locatedBy(".planner-header__price");
    public static final Target TICKET_TYPE_HEADER = Target.the("Ticket type header").locatedBy(".planner-header__type");
}
