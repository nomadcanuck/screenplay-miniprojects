package serenitylabs.tutorials.trains.ui;

public enum MainMenu {
    BuyTickets("https://buytickets.southwesttrains.co.uk/journey");

    private final String url;

    public String getUrl() {
        return url;
    }

    MainMenu(String url) {
        this.url = url;
    }
}
