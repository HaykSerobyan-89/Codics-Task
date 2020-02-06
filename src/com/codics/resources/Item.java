package com.codics.resources;

public class Item {
    private int itemId;
    private String name;
    private double price;

    public Item(int itemId, String name, double price) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return itemId;
    }

    public void setId(int id) {
        this.itemId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + itemId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
