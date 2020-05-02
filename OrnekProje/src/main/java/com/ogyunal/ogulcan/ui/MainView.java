package com.ogyunal.ogulcan.ui;

import static com.ogyunal.ogulcan.ui.utils.BakeryConst.TITLE_DASHBOARD;
import static com.ogyunal.ogulcan.ui.utils.BakeryConst.TITLE_LOGOUT;
import static com.ogyunal.ogulcan.ui.utils.BakeryConst.TITLE_PRODUCTS;
import static com.ogyunal.ogulcan.ui.utils.BakeryConst.TITLE_STOREFRONT;
import static com.ogyunal.ogulcan.ui.utils.BakeryConst.TITLE_USERS;
import static com.ogyunal.ogulcan.ui.utils.BakeryConst.VIEWPORT;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabVariant;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.server.VaadinServlet;
import com.ogyunal.ogulcan.app.security.SecurityUtils;
import com.ogyunal.ogulcan.ui.components.OfflineBanner;
import com.ogyunal.ogulcan.ui.views.HasConfirmation;
import com.ogyunal.ogulcan.ui.views.admin.products.ProductsView;
import com.ogyunal.ogulcan.ui.views.admin.users.UsersView;
import com.ogyunal.ogulcan.ui.views.dashboard.DashboardView;
import com.ogyunal.ogulcan.ui.views.storefront.StorefrontView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Viewport(VIEWPORT)
@PWA(name = "Bakery App Starter", shortName = "My Starter Project",
		startPath = "login",
		backgroundColor = "#227aef", themeColor = "#227aef",
		offlinePath = "offline-page.html",
		offlineResources = {"images/offline-login-banner.jpg"})
public class MainView extends AppLayout {

	private final ConfirmDialog confirmDialog = new ConfirmDialog();
	private final Tabs menu;

	public MainView() {
		confirmDialog.setCancelable(true);
		confirmDialog.setConfirmButtonTheme("raised tertiary error");
		confirmDialog.setCancelButtonTheme("raised tertiary");

		this.setDrawerOpened(false);
		Span appName = new Span("My Starter Project");
		appName.addClassName("hide-on-mobile");

		menu = createMenuTabs();

		this.addToNavbar(appName);
		this.addToNavbar(true, menu);
		this.getElement().appendChild(confirmDialog.getElement());

		getElement().addEventListener("search-focus", e -> {
			getElement().getClassList().add("hide-navbar");
		});

		getElement().addEventListener("search-blur", e -> {
			getElement().getClassList().remove("hide-navbar");
		});
	}

	@Override
	protected void afterNavigation() {
		super.afterNavigation();
		confirmDialog.setOpened(false);
		if (getContent() instanceof HasConfirmation) {
			((HasConfirmation) getContent()).setConfirmDialog(confirmDialog);
		}

		String target = RouteConfiguration.forSessionScope().getUrl(this.getContent().getClass());
		Optional<Component> tabToSelect = menu.getChildren().filter(tab -> {
			Component child = tab.getChildren().findFirst().get();
			return child instanceof RouterLink && ((RouterLink) child).getHref().equals(target);
		}).findFirst();
		tabToSelect.ifPresent(tab -> menu.setSelectedTab((Tab)tab));
	}

	private static Tabs createMenuTabs() {
		final Tabs tabs = new Tabs();
		tabs.setOrientation(Tabs.Orientation.HORIZONTAL);
		tabs.add(getAvailableTabs());
		return tabs;
	}

	private static Tab[] getAvailableTabs() {
		final List<Tab> tabs = new ArrayList<>(4);
		tabs.add(createTab(VaadinIcon.EDIT, TITLE_STOREFRONT,
						StorefrontView.class));
		tabs.add(createTab(VaadinIcon.CLOCK,TITLE_DASHBOARD, DashboardView.class));
		if (SecurityUtils.isAccessGranted(UsersView.class)) {
			tabs.add(createTab(VaadinIcon.USER,TITLE_USERS, UsersView.class));
		}
		if (SecurityUtils.isAccessGranted(ProductsView.class)) {
			tabs.add(createTab(VaadinIcon.CALENDAR, TITLE_PRODUCTS, ProductsView.class));
		}
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
		final Anchor a = populateLink(new Anchor(), VaadinIcon.ARROW_RIGHT, TITLE_LOGOUT);
		a.setHref(contextPath + "/logout");
		return a;
	}

	private static <T extends HasComponents> T populateLink(T a, VaadinIcon icon, String title) {
		a.add(icon.create());
		a.add(title);
		return a;
	}
}
