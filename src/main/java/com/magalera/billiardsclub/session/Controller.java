package com.magalera.billiardsclub.session;

import com.magalera.billiardsclub.domain.User;
import com.vaadin.flow.server.VaadinSession;

public class Controller {

    private static final String USER_SESSION_KEY = "user";

    public static boolean isUserLogged() {
        return VaadinSession.getCurrent().getAttribute(Controller.USER_SESSION_KEY) != null;
    }

    public static void saveUser(User user) {
        VaadinSession.getCurrent().setAttribute(USER_SESSION_KEY, user);
    }
}
