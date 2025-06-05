package bit.autonomi;

import jade.content.Concept;

public class Book implements Concept {
    private String title;
    private float price;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }
}