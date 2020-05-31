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
import com.vaadin.flow.router.Route;


@Route(AddClubView.ROUTE_NAME)
public class AddClubView extends Authenticated {

    public static final String ROUTE_NAME = "addClub";

    private final TextField name = new TextField("Name");
    private final ComboBox<City> city = new ComboBox<>("City");
    private final NumberField tablePrice = new NumberField("Table price", 20d, null);
    private final NumberField bilardSoccerPrice = new NumberField("Billiards soccer price", 25d, null);
    private final NumberField tournamentPrice = new NumberField("Tournament price", 1000d, null);

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
    }

    private void handleAdd(ClickEvent<Button> event) {
        BilliardsClub club = BilliardsClub.builder()
                .name(name.getValue())
                .city(city.getValue())
                .prices(Prices.builder()
                        .tablePrice(tablePrice.getValue())
                        .bilardSoccerPrice(bilardSoccerPrice.getValue())
                        .tournamentPrice(tournamentPrice.getValue())
                        .build())
                .build();

        BilliardsClubService.getInstance().add(club);
        Notification.show("Billiards club has been created");
        getUI().ifPresent(ui -> ui.navigate(MainView.class));
    }

}
