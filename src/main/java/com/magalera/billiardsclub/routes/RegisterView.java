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
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(RegisterView.ROUTE_NAME)
public class RegisterView extends VerticalLayout implements BeforeEnterObserver {

    static final String ROUTE_NAME = "register";

    private final ComboBox<UserType> type = new ComboBox<>("Type");
    private final TextField firstName = new TextField("First name");
    private final TextField lastName = new TextField("Last name");
    private final TextField email = new TextField("Email");
    private final PasswordField password = new PasswordField("Password");
    private final Binder<User> binder = new Binder<>(User.class);

    @Autowired
    private UserService userService;

    public RegisterView() {
        add(new Text(ROUTE_NAME));

        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        type.setItems(UserType.values());
        Button submit = new Button("Submit",
                this::handleRegistration);

        binder.setBean(User.builder().build());
        binder.forField(type)
                .asRequired("Required").bind(User::getType, User::setType);
        binder.forField(firstName)
                .asRequired("Required").bind(User::getFirstName, User::setFirstName);
        binder.forField(lastName)
                .asRequired("Required").bind(User::getLastName, User::setLastName);
        binder.forField(email)
                .withValidator(new EmailValidator("Email is incorrect"))
                .bind(User::getEmail, User::setEmail);
        binder.forField(password)
                .asRequired("Required").bind(User::getPassword, User::setPassword);

        add(type, firstName, lastName, email, password, submit);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        if (Controller.isUserLogged()) {
            event.forwardTo(MainView.class);
        }
    }

    private void handleRegistration(ClickEvent<Button> event) {
        if (!binder.isValid()) {
            return;
        }
        User user = binder.getBean();

        try {
            user = userService.register(user);
            Controller.saveUser(user);
            Notification.show("Account has been created");
            getUI().ifPresent(ui -> ui.navigate(MainView.class));
        } catch (Exception e) {
            Notification.show("Error: " + e, 10000, Notification.Position.BOTTOM_START);
            e.printStackTrace();
        }
    }

}
