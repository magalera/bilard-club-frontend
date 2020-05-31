package com.magalera.billiardsclub.routes;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route(LoginView.ROUTE_NAME)
public class LoginView extends VerticalLayout {

    public static final String ROUTE_NAME = "login";

    private final TextField email;
    private final PasswordField password;

    public LoginView() {
        add(new Text(ROUTE_NAME));
        email = new TextField("Email");
        password = new PasswordField("Password");

        Button submit = new Button("Submit",
                this::handleLogin);

        add(email, password, submit);
    }

    private void handleLogin(ClickEvent<Button> event) {
        getUI().ifPresent(ui -> ui.navigate(MainView.ROUTE_NAME));
    }

}
