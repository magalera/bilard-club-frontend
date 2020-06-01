package com.magalera.billiardsclub.routes.club;

import com.magalera.billiardsclub.domain.BilliardsClub;
import com.magalera.billiardsclub.domain.City;
import com.magalera.billiardsclub.domain.Prices;
import com.magalera.billiardsclub.routes.Authenticated;
import com.magalera.billiardsclub.routes.MainView;
import com.magalera.billiardsclub.service.BilliardsClubService;
import com.magalera.billiardsclub.service.CityService;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.Setter;
import com.vaadin.flow.router.Route;


@Route(AddClubView.ROUTE_NAME)
public class AddClubView extends Authenticated {

    static final String ROUTE_NAME = "addClub";

    private final TextField name = new TextField("Name");
    private final ComboBox<City> city = new ComboBox<>("City");
    private final NumberField tablePrice = new NumberField("Table price");
    private final NumberField bilardSoccerPrice = new NumberField("Billiards soccer price");
    private final NumberField tournamentPrice = new NumberField("Tournament price");

    private final Binder<BilliardsClub> binder = new Binder<>(BilliardsClub.class);

    public AddClubView() {
        super();

        name.setWidthFull();
        city.setItems(CityService.getInstance().getAll());
        city.setWidthFull();
        tablePrice.setWidthFull();
        bilardSoccerPrice.setWidthFull();
        tournamentPrice.setWidthFull();

        Button add = new Button("Add",
                this::handleAdd);

        add(name, city, tablePrice, bilardSoccerPrice, tournamentPrice, add);

        binder.setBean(BilliardsClub.builder().prices(Prices.builder().build()).build());
        binder.forField(name)
                .asRequired("Required")
                .bind(BilliardsClub::getName, BilliardsClub::setName);
        binder.forField(city)
                .asRequired("Required")
                .bind(BilliardsClub::getCity, BilliardsClub::setCity);
        binder.forField(tablePrice)
                .asRequired("Required")
                .withValidator(value -> value > 0, "Table price must be grater than zero")
                .bind(
                        club -> club.getPrices().getTablePrice(),
                        (Setter<BilliardsClub, Double>) (club, value) -> club.getPrices().setTablePrice(value));
        binder.forField(bilardSoccerPrice)
                .asRequired("Required")
                .withValidator(value -> value > 0, "Billiards soccer price must be grater than zero")
                .bind(
                        club -> club.getPrices().getBilardSoccerPrice(),
                        (Setter<BilliardsClub, Double>) (club, value) -> club.getPrices().setBilardSoccerPrice(value));
        binder.forField(tournamentPrice)
                .asRequired("Required")
                .withValidator(value -> value > 0, "Tournament price must be grater than zero")
                .bind(
                        club -> club.getPrices().getTournamentPrice(),
                        (Setter<BilliardsClub, Double>) (club, value) -> club.getPrices().setTournamentPrice(value));
    }

    private void handleAdd(ClickEvent<Button> event) {
        if (!binder.isValid()) {
            return;
        }
        BilliardsClub club = binder.getBean();
        BilliardsClubService.getInstance().add(club);
        Notification.show("Billiards club has been created");
        getUI().ifPresent(ui -> ui.navigate(MainView.class));
    }

}
