package com.codics.subsections;

import com.codics.resources.Item;
import com.codics.resources.Container;
import com.codics.view.Menu;

import java.io.*;
import java.util.Scanner;

public class AdminSubsection {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String PRODUCTS_PATHNAME = "resources/products";
    private static final String WORKERS_PATHNAME = "resources/workers";

    public static void showAdminMenu() {

        System.out.println("1. Add item\n" +
                "2. Edit item\n" +
                "3. Remove item\n" +
                "4. Add workers\n" +
                "5. Go back <-");
        System.out.println("Select option");
        String option = scanner.nextLine();
        adminSection(option);
    }

    public static void adminSection(String option) {

        switch (option) {
            case "1":
                AdminSubsection.addItem();
                break;
            case "2":
                AdminSubsection.editItem();
                break;
            case "3":
                AdminSubsection.removeItem();
                break;
            case "4":
                AdminSubsection.addWorkers();
                break;
            case "5":
                Menu.showMenu();
                break;
            default:
                System.out.println("Please choose correct option");
                adminSection(option);
                break;
        }
    }

    public static void workerWriter() {

        System.out.println("Write worker firstname");
        String firstName = scanner.nextLine();
        System.out.println("Write worker lasttname");
        String lastName = scanner.nextLine();

        try {
            File file = new File(WORKERS_PATHNAME);


            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String workerId = String.valueOf(bufferedReader.lines().count() + 1);
            bufferedWriter.write(workerId + ",");
            bufferedWriter.write(firstName + ",");
            bufferedWriter.write(lastName + "\n");

            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Container.loadWorkers();
    }

    public static void productWriter() {

        try {
            System.out.println("Write product name");
            String productName = scanner.nextLine();
            System.out.println("Write product price");
            double productPrice = Double.parseDouble(scanner.nextLine());

            File file = new File(PRODUCTS_PATHNAME);

            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String itemId = String.valueOf(bufferedReader.lines().count() + 1);
            bufferedWriter.write(itemId + ",");
            bufferedWriter.write(productName + ",");
            bufferedWriter.write(productPrice + " $\n");

            bufferedReader.close();
            bufferedWriter.close();
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }
        Container.loadProducts();
    }

    public static void addItem() {

        productWriter();
        showAdminMenu();
    }

    public static void editItem() {

        try {
            System.out.println(Container.items);
            System.out.println("Select item ID");
            String itemId = scanner.nextLine();
            Item editingItem = Container.items.get(Integer.parseInt(itemId) - 1);
            System.out.println("Write item new name");
            String editingName = scanner.nextLine();
            System.out.println("Write item new price");
            String editingPrice = scanner.nextLine();
            editingItem.setName(editingName);
            editingItem.setPrice(Double.parseDouble(editingPrice));

            Container.uploadProducts();
            System.out.println(Container.items.get(Integer.parseInt(itemId) - 1));
            showAdminMenu();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }

    public static void removeItem() {

        try {
            System.out.println(Container.items);
            System.out.println("Select item ID");
            String itemId = scanner.nextLine();
            Container.items.remove(Integer.parseInt(itemId) - 1);

            for (int i = 0; i < Container.items.size(); i++) {
                Container.items.get(i).setId(i + 1);
            }
            Container.uploadProducts();
            showAdminMenu();

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static void addWorkers() {
        workerWriter();
        showAdminMenu();
    }
}
