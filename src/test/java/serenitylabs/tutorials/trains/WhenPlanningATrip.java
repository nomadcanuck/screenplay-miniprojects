package serenitylabs.tutorials.trains;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenitylabs.tutorials.trains.questions.AvailableJourneys;
import serenitylabs.tutorials.trains.tasks.ChosenTo;
import serenitylabs.tutorials.trains.tasks.ViewTheAvailableTickets;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;


@RunWith(SerenityRunner.class)
public class WhenPlanningATrip {

    @Managed(uniqueSession = true)
    WebDriver webDriver;

    Actor tracy;
    Actor bill;

    @Before
    public void setTheStage() {

        tracy = Actor.named("Tracy");
        tracy.can(BrowseTheWeb.with(webDriver));

        bill = Actor.named("Bill");
        bill.can(BrowseTheWeb.with(webDriver));
    }


    @Test
    @Title("Tracy books a one-way ticket from Ready to Oxford leaving now")
    public void booking_a_simple_trip() {
        givenThat(tracy).has(ChosenTo.bookATicket());

        when(tracy).attemptsTo(
                ViewTheAvailableTickets.from("Reading").to("Oxford")
        );

        then(tracy).should(

                seeThat("departure heading", AvailableJourneys.departureHeading(), equalToIgnoringCase("Reading")),
                seeThat("destination heading",AvailableJourneys.destinationHeading(), equalToIgnoringCase("Oxford")),
                seeThat("ticket type heading", AvailableJourneys.ticketTypeHeading(), is("Single")),
                seeThat("cheapest ticket price", AvailableJourneys.cheapestPriceHeading(), not(isEmptyString()))
        );
        and(tracy).should(
                seeThat("journey ticket types",AvailableJourneys.typeOfTickets(), everyItem(equalTo("Off-Peak Day Single"))),
                seeThat("journey durations", AvailableJourneys.durations(), everyItem(not(isEmptyOrNullString()))),
                seeThat("journey origins", AvailableJourneys.origins(), everyItem(equalTo("Reading"))),
                seeThat("journey destinations", AvailableJourneys.destinations(), everyItem(equalTo("Oxford")))
        );
    }
}
