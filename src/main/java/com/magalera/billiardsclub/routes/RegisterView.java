package com.magalera.billiardsclub.routes;

import com.magalera.billiardsclub.domain.User;
import com.magalera.billiardsclub.domain.UserType;
import com.magalera.billiardsclub.service.UserService;
import com.magalera.billiardsclub.session.Controller;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;

@Route(RegisterView.ROUTE_NAME)
public class RegisterView extends VerticalLayout implements BeforeEnterObserver {

    public static final String ROUTE_NAME = "register";

    private final ComboBox<UserType> type = new ComboBox<>("Type");
    private final TextField firstName = new TextField("First name");
    private final TextField lastName = new TextField("Last name");
    private final TextField email = new TextField("Email");
    private final PasswordField password = new PasswordField("Password");

    public RegisterView() {
        add(new Text(ROUTE_NAME));

        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        type.setItems(UserType.values());
        Button submit = new Button("Submit",
                this::handleRegistration);

        add(type, firstName, lastName, email, password, submit);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        if (Controller.isUserLogged()) {
            event.forwardTo(MainView.class);
        }
    }

    private void handleRegistration(ClickEvent<Button> event) {
        User user = User.builder()
                .type(type.getValue())
                .firstName(firstName.getValue())
                .lastName(lastName.getValue())
                .email(email.getValue())
                .password(password.getValue())
                .build();
        user = UserService.getInstance().register(user);
        Controller.saveUser(user);
        Notification.show("Account has been created");
        getUI().ifPresent(ui -> ui.navigate(MainView.class));
    }

}
