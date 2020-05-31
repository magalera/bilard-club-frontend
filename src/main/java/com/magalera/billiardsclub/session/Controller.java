package com.magalera.billiardsclub.session;

import com.magalera.billiardsclub.domain.User;
import com.vaadin.flow.server.VaadinSession;

import java.util.Optional;

public class Controller {

    private static final String USER_SESSION_KEY = "user";

    public static boolean isUserLogged() {
        return VaadinSession.getCurrent().getAttribute(Controller.USER_SESSION_KEY) != null;
    }

    public static void saveUser(User user) {
        VaadinSession.getCurrent().setAttribute(USER_SESSION_KEY, user);
    }

    public static Optional<User> getUser() {
        return Optional.of((User) VaadinSession.getCurrent().getAttribute(USER_SESSION_KEY));
    }
}
