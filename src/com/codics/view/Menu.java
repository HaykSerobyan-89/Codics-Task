package com.codics.view;

import com.codics.subsections.AccountingSubsection;
import com.codics.subsections.AdminSubsection;
import com.codics.subsections.ShopSubsection;

import java.util.Scanner;

public class Menu {

    public static String scanLine() {

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void showMenu() {

        System.out.println("Menu\n" +
                "1. Administrator\n" +
                "2. Shop \n" +
                "3. Accounting\n" +
                "4. Exit\n" +
                "Select option");
        optionChoose();
    }


    public static void shopSubsection() {

        switch (scanLine()) {
            case "1":
                ShopSubsection.viewItems();
                break;
            case "2":
                ShopSubsection.myBag();
                break;
            case "3":
                showMenu();
                break;
            default:
                System.out.println("Please choose correct option");
                shopSubsection();
                break;
        }
    }

    public static void accountingSubsection() {

        switch (scanLine()) {
            case "1":
                AccountingSubsection.income();
                break;
            case "2":
                AccountingSubsection.stock();
                break;
            case "3":
                showMenu();
                break;
            default:
                System.out.println("Please choose correct subsection");
                accountingSubsection();
                break;
        }
    }

    public static void optionChoose() {

        switch (scanLine()) {
            case "1":
                System.out.println("Administrator section:");
                AdminSubsection.showAdminMenu();
                break;
            case "2":
                System.out.println("Shop section:");
                ShopSubsection.showShopMenu();
                break;
            case "3":
                System.out.println("Accounting section:");
                AccountingSubsection.showAccountingMenu();
                break;
            case "4":
                break;
            default:
                System.out.println("Please choose correct option");
                showMenu();
                optionChoose();
                break;
        }
    }
}
