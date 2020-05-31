package com.magalera.billiardsclub.routes;

import com.magalera.billiardsclub.domain.User;
import com.magalera.billiardsclub.service.UserService;
import com.magalera.billiardsclub.session.Controller;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;

import java.util.Optional;

@Route(LoginView.ROUTE_NAME)
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

    public static final String ROUTE_NAME = "login";

    private final TextField email = new TextField("Email");
    private final PasswordField password = new PasswordField("Password");

    public LoginView() {
        add(new Text(ROUTE_NAME));

        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        Button submit = new Button("Submit",
                this::handleLogin);

        add(email, password, submit);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        if (Controller.isUserLogged()) {
            event.forwardTo(MainView.class);
        }
    }

    private void handleLogin(ClickEvent<Button> event) {
        Optional<User> user = UserService.getInstance().login(email.getValue(), password.getValue());
        if (user.isPresent()) {
            Controller.saveUser(user.get());
            getUI().ifPresent(ui -> ui.navigate(MainView.class));
        } else {
            Notification.show("Invalid email or password");
        }
    }

}
