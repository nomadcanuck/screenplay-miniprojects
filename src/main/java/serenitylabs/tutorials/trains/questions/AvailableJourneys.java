package serenitylabs.tutorials.trains.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import serenitylabs.tutorials.trains.ui.JourneySummary;
import serenitylabs.tutorials.trains.ui.JourneyItinerary;

import java.util.List;


public class AvailableJourneys {

    public static Question<String> departureHeading() {
        return actor -> Text.of(JourneySummary.DEPARTURE_HEADER).viewedBy(actor).asString();
    }

    public static Question<String> destinationHeading() {
        return actor -> Text.of(JourneySummary.DESTINATION_HEADER).viewedBy(actor).asString();
    }

    public static Question<String> cheapestPriceHeading() {
        return actor -> Text.of(JourneySummary.CHEAPEST_PRICE_HEADER).viewedBy(actor).asString();
    }

    public static Question<String> ticketTypeHeading() {
        return actor -> Text.of(JourneySummary.TICKET_TYPE_HEADER).viewedBy(actor).asString();
    }

    public static Question<List<String>> typeOfTickets() {
        return actor -> Text.of(JourneyItinerary.JOURNEY_TICKET_TYPE).viewedBy(actor).asList();
    }

    public static Question<List<String>> durations() {
        return actor -> Text.of(JourneyItinerary.JOURNEY_DURATION).viewedBy(actor).asList();
    }

    public static Question<List<String>> origins() {
        return actor -> Text.of(JourneyItinerary.JOURNEY_DESTINATION).viewedBy(actor).asList();
    }

    public static Question<List<String>> destinations() {
        return actor -> Text.of(JourneyItinerary.JOURNEY_DESTINATION).viewedBy(actor).asList();
    }
}
