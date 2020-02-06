package com.codics.subsections;

import com.codics.resources.Item;
import com.codics.resources.Container;
import com.codics.view.Menu;

import java.util.Scanner;

public class ShopSubsection {
    private static final Scanner scanner = new Scanner(System.in);

    public static void showShopMenu() {
        System.out.println("1. View items\n" +
                "2. Add to bag\n" +
                "3. My bag\n" +
                "4. Buy from my bag\n" +
                "5. Go back <-");
        String option = scanner.nextLine();
        shopSection(option);
    }

    public static void shopSection(String option) {

        switch (option) {
            case "1":
                ShopSubsection.viewItems();
                break;
            case "2":
                ShopSubsection.addItem();
                break;
            case "3":
                ShopSubsection.myBag();
                break;
            case "4":
                ShopSubsection.buyItem();
                break;
            case "5":
                Menu.showMenu();
                break;
            default:
                System.out.println("Please choose correct option");
                shopSection(option);
                break;
        }
    }

    public static void viewItems() {

        System.out.println(Container.items + "\n");
        showShopMenu();
    }

    public static void myBag() {

        System.out.println("My bag : " + Container.bagItems);
        showShopMenu();
    }

    public static void addItem() {

        System.out.println(Container.items + "\n" +
                "for add select item ID");

        try {
            int itemId = Integer.parseInt(scanner.nextLine());
            for (Item item : Container.items) {
                if (item.getId() != itemId) {
                    System.out.println("select correct item ID ");
                    addItem();
                } else {
                    Container.bagItems.add(Container.items.get(itemId - 1));
                    showShopMenu();
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            addItem();
        }
    }

    public static void buyItem() {

        if (Container.bagItems.isEmpty()) {
            System.out.println("My bag is empty, please add item in bag");
            showShopMenu();
        } else {
            System.out.println(Container.bagItems);
            System.out.println("Select item id");
            try {
                int buyId = Integer.parseInt(scanner.nextLine());
                for (Item item : Container.bagItems) {
                    if (item.getId() == buyId) {
                        System.out.println("item purchased successfully");
                        Container.soldItems.add(item);
                        Container.items.remove(buyId - 1);
                        Container.bagItems.remove(item);
                        Container.uploadProducts();
                        showShopMenu();
                    }
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                buyItem();
            }
        }
    }
}
