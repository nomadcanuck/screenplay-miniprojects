package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BuyTicketsForm {
    public static final Target FROM = Target.the("Departing from field ").located(By.id("depart-from"));
    public static final Target TO = Target.the("Going To field ").located(By.id("going-to"));
    public static final Target BUY_TICKETS = Target.the("Buy Tickets button").located(By.className("planner__submit"));
    public static final Target CLOSE_COOKIES = Target.the("Close the Cookie message").locatedBy("div.cookies button.button--white");
}
