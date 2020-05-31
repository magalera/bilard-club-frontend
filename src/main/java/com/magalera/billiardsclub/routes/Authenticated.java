package com.magalera.billiardsclub.routes;

import com.magalera.billiardsclub.domain.User;
import com.magalera.billiardsclub.domain.UserType;
import com.magalera.billiardsclub.routes.club.AddClubView;
import com.magalera.billiardsclub.session.Controller;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;

public class Authenticated extends VerticalLayout implements BeforeEnterObserver {

    public Authenticated() {
        if (!Controller.isUserLogged()) {
            getUI().ifPresent(ui -> ui.navigate(LoginOrRegisterView.class));
            return;
        }
        add(this.getClass().getName());

        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setWidthFull();

        MenuBar menuBar = new MenuBar();

        if (Controller.getUser().orElse(User.builder().build()).getType().equals(UserType.MANAGER)) {
            menuBar.addItem("Add club", this::addClub);
        }
        menuBar.addItem("Clubs");
        menuBar.addItem("My reservations");
        menuBar.addItem("Account");
        menuBar.addItem("Sign Out", this::singOut);

        add(menuBar);
    }

    private void addClub(ClickEvent<MenuItem> event) {
        getUI().ifPresent(ui -> ui.navigate(AddClubView.class));
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        if (!Controller.isUserLogged()) {
            event.forwardTo(LoginOrRegisterView.class);
        }
    }

    private void singOut(ClickEvent<MenuItem> event) {
        getUI().ifPresent(ui -> ui.getSession().close());
        getUI().ifPresent(ui -> ui.getPage().reload());
    }

}
