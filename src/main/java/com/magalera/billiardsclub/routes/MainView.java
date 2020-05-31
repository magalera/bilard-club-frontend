package com.magalera.billiardsclub.routes;

import com.magalera.billiardsclub.session.Controller;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(MainView.ROUTE_NAME)
public class MainView extends VerticalLayout {

    public static final String ROUTE_NAME = "main";

    public MainView() {
        if (!Controller.isUserLogged()) {
            getUI().ifPresent(ui -> ui.navigate(LoginOrRegisterView.class));
            return;
        }

        add(new Text(ROUTE_NAME));
    }

}
