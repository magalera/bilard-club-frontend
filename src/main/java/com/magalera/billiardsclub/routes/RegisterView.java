package com.magalera.billiardsclub.routes;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(RegisterView.ROUTE_NAME)
public class RegisterView extends VerticalLayout {

    public static final String ROUTE_NAME = "register";

    public RegisterView() {
        add(new Text(ROUTE_NAME));
    }

}
