package com.codics.resources;

import java.io.*;
import java.util.*;

public class Container {
    public static final Map<Integer, Worker> workers = new HashMap<>();
    public static final List<Item> items = new ArrayList<>();
    public static final Set<Item> bagItems = new HashSet<>();
    public static final List<Item> soldItems = new ArrayList<>();
    public static final String PRODUCTS_PATHNAME = "resources/products";
    public static final String WORKERS_PATHNAME = "resources/workers";

    public static void loadWorkers() {

        File file = new File(WORKERS_PATHNAME);
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String delimeter = ",";
                String[] subString = line.split(delimeter);
                for (int i = 0; i < subString.length; i++) {
                    int workerId = Integer.parseInt(subString[0]);
                    Worker worker = new Worker(subString[1], subString[2]);
                    workers.put(workerId, worker);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static void uploadProducts() {

        try {
            File file = new File(PRODUCTS_PATHNAME);

            FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Item item : items) {
                bufferedWriter.write(item.getId() + ",");
                bufferedWriter.write(item.getName() + ",");
                bufferedWriter.write(item.getPrice() + " $\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadProducts() {

        File file = new File(PRODUCTS_PATHNAME);
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] subString = line.split(",", 3);
                int itemId = Integer.parseInt(subString[0]);
                String itemName = subString[1];
                double itemPrice = Double.parseDouble(subString[2].replace("$", ""));
                items.add(new Item(itemId, itemName, itemPrice));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

