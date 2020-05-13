package com.bilshare.ui;

import com.bilshare.ui.views.About.AboutView;
import com.bilshare.ui.views.AddAdvert.AddAdvertView;
import com.bilshare.ui.views.ContactUs.ContactUsView;
import com.bilshare.ui.views.MyProfileView.ProfileView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabVariant;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;
import com.bilshare.ui.views.dashboard.DashboardView;
import com.bilshare.ui.views.list.ListView;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinServlet;
import com.vaadin.flow.server.VaadinSession;
import com.bilshare.security.SecurityUtils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@PWA(
    name = "Vaadin CRM",
    shortName = "CRM",

    offlineResources = {
        "./styles/offline.css",
        "./images/offline.png"
    },
    enableInstallPrompt = false
)
@CssImport("./styles/shared-styles.css")
public class MainLayout extends AppLayout {

    private final Tabs menu;

    public MainLayout() {

        menu = createMenuTabs();
        addToNavbar(image, menu);

    }


    final String rsvldImage = VaadinService.getCurrent().resolveResource(
            "icons/bilShareLogoBaykus.png", VaadinSession.getCurrent().getBrowser());


    final Image baykus = new Image(rsvldImage, "");


    final String resolvedImage = VaadinService.getCurrent().resolveResource(
            "icons/bilShareLogoYazı.png", VaadinSession.getCurrent().getBrowser());


    final Image image = new Image(resolvedImage, "");



    private static Tabs createMenuTabs() {
        final Tabs tabs = new Tabs();
        tabs.setFlexGrowForEnclosedTabs(1);
        tabs.setOrientation(Tabs.Orientation.HORIZONTAL);
        tabs.add(getAvailableTabs());

        return tabs;
    }

    private static Tab[] getAvailableTabs() {
        final List<Tab> tabs = new ArrayList<>(4);

        tabs.add(createTab(VaadinIcon.BOOK, "Advert List",
                ListView.class));

        tabs.add(createTab(VaadinIcon.USER, "My Profile",
                ProfileView.class));

        tabs.add(createTab(VaadinIcon.PLUS_CIRCLE, "Add An Advert",
                AddAdvertView.class));

        tabs.add(createTab(VaadinIcon.EDIT, "Contact Us",
                ContactUsView.class));

        tabs.add(createTab(VaadinIcon.INFO_CIRCLE, "About",
                AboutView.class));



        /*if (SecurityUtils.isAccessGranted(UsersView.class)) {
            tabs.add(createTab(VaadinIcon.USER,TITLE_USERS, UsersView.class));
        }*/

        final String contextPath = VaadinServlet.getCurrent().getServletContext().getContextPath();
        final Tab logoutTab = createTab(createLogoutLink(contextPath));
        tabs.add(logoutTab);
        return tabs.toArray(new Tab[tabs.size()]);
    }

    private static Tab createTab(VaadinIcon icon, String title, Class<? extends Component> viewClass) {
        return createTab(populateLink(new RouterLink(null, viewClass), icon, title));
    }

    private static Tab createTab(Component content) {
        final Tab tab = new Tab();
        tab.addThemeVariants(TabVariant.LUMO_ICON_ON_TOP);
        tab.add(content);
        return tab;
    }

    private static Anchor createLogoutLink(String contextPath) {
        final Anchor a = populateLink(new Anchor(), VaadinIcon.ARROW_RIGHT, "Log Out");
        a.setHref(contextPath + "/logout");
        return a;
    }
    private static <T extends HasComponents> T populateLink(T a, VaadinIcon icon, String title) {
        a.add(icon.create());
        a.add(title);
        return a;
    }

}

