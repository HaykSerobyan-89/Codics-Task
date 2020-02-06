package com.codics;

import com.codics.resources.Container;
import com.codics.view.Menu;

public class ShopApp {

    public static void main(String[] args) {

        Container.loadWorkers();
        Container.loadProducts();
        Menu.showMenu();
    }
}
