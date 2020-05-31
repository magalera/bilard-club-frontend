package com.magalera.billiardsclub.routes;

import com.vaadin.flow.router.Route;

@Route(MainView.ROUTE_NAME)
public class MainView extends Authenticated {

    public static final String ROUTE_NAME = "main";

    public MainView() {
        super();
    }

}
