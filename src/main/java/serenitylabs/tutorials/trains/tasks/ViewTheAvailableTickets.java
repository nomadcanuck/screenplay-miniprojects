package serenitylabs.tutorials.trains.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import serenitylabs.tutorials.trains.ui.BuyTicketsForm;

public class ViewTheAvailableTickets implements Task {
    private final String departureStation;
    private final String destinationStation;

    public ViewTheAvailableTickets(String departureStation, String destinationStation) {
        this.departureStation = departureStation;
        this.destinationStation = destinationStation;
    }


    @Override
    @Step("{0} views the available tickets from #departureStation to #destinationStation")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(departureStation).into(BuyTicketsForm.FROM).thenHit(Keys.ARROW_DOWN, Keys.TAB),
                Enter.theValue(destinationStation).into(BuyTicketsForm.TO).thenHit(Keys.ARROW_DOWN, Keys.TAB),
                Click.on(BuyTicketsForm.CLOSE_COOKIES),
                Click.on(BuyTicketsForm.BUY_TICKETS)
        );
    }

    public static ViewTheAvailableTicketsBuilder from(String departureStation) {
        return new ViewTheAvailableTicketsBuilder(departureStation);
    }

    public static class ViewTheAvailableTicketsBuilder {
        private final String departureStation;

        public ViewTheAvailableTicketsBuilder(String departureStation) {

            this.departureStation = departureStation;
        }

        public Performable to(String destinationStation) {
            return Instrumented.instanceOf(ViewTheAvailableTickets.class).withProperties(departureStation, destinationStation);
        }
    }
}
