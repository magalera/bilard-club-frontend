package com.magalera.billiardsclub.routes;

import com.magalera.billiardsclub.session.Controller;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class LoginOrRegisterView extends VerticalLayout {

    public LoginOrRegisterView() {
        if (Controller.isUserLogged()) {
            getUI().ifPresent(ui -> ui.navigate("main"));
            return;
        }

        add(new Button("Login", event -> getUI().ifPresent(ui -> ui.navigate(LoginView.ROUTE_NAME))));
        add(new Button("Register", event -> getUI().ifPresent(ui -> ui.navigate(RegisterView.ROUTE_NAME))));
    }
}
