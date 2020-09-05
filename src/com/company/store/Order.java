package com.company.store;

public class Order {

    private String name;
    private int quantity;
    private int cost;

    public Order(String name,int cost,int quantity) {
        setName(name);
        setQuantity( quantity);
        setCost( cost);
    }

    public void line() {
        System.out.print("-------------------------------------------------------------------\n");
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return " Заказ : " +
                " Название продукта : " + name +
                ", Количество : " + quantity +
                ", Стоимость : " + cost  ;
    }
}
