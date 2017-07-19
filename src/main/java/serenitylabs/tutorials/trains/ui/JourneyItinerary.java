package serenitylabs.tutorials.trains.ui;


import net.serenitybdd.screenplay.targets.Target;

public class JourneyItinerary {

    public static final Target JOURNEY_TICKET_TYPE = Target.the("journey ticket type")
            .locatedBy(".journey__summary-wrap button.journey__ticket-type-cta");

    public static final Target JOURNEY_DURATION = Target.the("journey duration")
            .locatedBy("span.journey__duration-text");

    public static final Target JOURNEY_ORIGIN = Target.the("journey origin")
            .locatedBy("span.journey__origin");

    public static final Target JOURNEY_DESTINATION = Target.the("journey destination")
            .locatedBy("span.journey__destination");

    public static final Target JOURNEY_PRICE = Target.the("journey destination")
            .locatedBy("span.journey__price");

}
