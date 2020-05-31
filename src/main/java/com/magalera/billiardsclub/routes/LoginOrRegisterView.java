package com.magalera.billiardsclub.routes;

import com.magalera.billiardsclub.session.Controller;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;

@Route(LoginOrRegisterView.ROUTE_NAME)
public class LoginOrRegisterView extends VerticalLayout implements BeforeEnterObserver {

    public static final String ROUTE_NAME = "";

    public LoginOrRegisterView() {
        setSizeFull();
        add(new Button("Login", event -> getUI().ifPresent(ui -> ui.navigate(LoginView.class))));
        add(new Button("Register", event -> getUI().ifPresent(ui -> ui.navigate(RegisterView.class))));
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        if (Controller.isUserLogged()) {
            event.forwardTo(MainView.class);
        }
    }

}
