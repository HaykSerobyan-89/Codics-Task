package com.codics.subsections;

import com.codics.resources.Container;
import com.codics.resources.Item;
import com.codics.view.Menu;

import java.util.Scanner;

public class AccountingSubsection {
    private static final Scanner scanner = new Scanner(System.in);

    public static void showAccountingMenu() {

        System.out.println("1. Income\n" +
                "2. Stock\n" +
                "3. Go back <-");
        System.out.println("Select option");
        String option = scanner.nextLine();
        accountingSection(option);
    }

    public static void accountingSection(String option) {

        switch (option) {
            case "1":
                AccountingSubsection.income();
                break;
            case "2":
                AccountingSubsection.stock();
                break;
            case "3":
                Menu.showMenu();
                break;
            default:
                System.out.println("Please choose correct option");
                accountingSection(option);
                break;
        }
    }

    public static void income() {
        int result = 0;

        for (Item soldItems : Container.soldItems) {
            result += soldItems.getPrice();
        }
        System.out.println("Your income is : " + result + "$");
        showAccountingMenu();
    }

    public static void stock() {

        System.out.println(Container.items);
        showAccountingMenu();
    }
}
