package com.magalera.billiardsclub.routes;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(MainView.ROUTE_NAME)
public class MainView extends VerticalLayout {

    public static final String ROUTE_NAME = "main";

    public MainView() {
        add(new Text(ROUTE_NAME));
    }

}
