package com.example.spring_ecommerce.entities;

public class Order {

    private int id;
    private int userId;
    private int paymentId;
    private int cardId;
    private String orderDate;
    private double grandTotal;
    private String carrier;

    public Order(int id, int userId, int paymentId, int cardId, String orderDate, double grandTotal, String carrier) {
        this.id = id;
        this.userId = userId;
        this.paymentId = paymentId;
        this.cardId = cardId;
        this.orderDate = orderDate;
        this.grandTotal = grandTotal;
        this.carrier = carrier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }
}
