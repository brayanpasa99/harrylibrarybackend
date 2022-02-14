package com.harrylibrarybackend.harrylibrarybackend.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_book", nullable = false, updatable = false)
    private Long id;
    private String title;
    @Column(nullable = false, updatable = false)
    private Double price;
    private Integer stock;
    private String imageUrl;

    @ManyToMany(mappedBy = "books")
    private List<Purchase> purchases = new ArrayList<>();

    public Book() {
    }

    public Book(String title, Double price, Integer stock, String imageUrl, List<Purchase> purchases) {
        this.title = title;
        this.price = price;
        this.stock = stock;
        this.imageUrl = imageUrl;
        this.purchases = purchases;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }
}
