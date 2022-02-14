package com.harrylibrarybackend.harrylibrarybackend.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_purchase", nullable = false, updatable = false)
    private Long id;
    private Double purchaseTotal;
    @Column(nullable = false, updatable = false)
    private Date creationDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_purchase",
            joinColumns = @JoinColumn(name = "id_book"),
            inverseJoinColumns = @JoinColumn(name = "id_purchase"))
    private List<Book> books = new ArrayList<>();

    public Purchase() {
    }

    public Purchase(Double purchaseTotal, Date creationDate, List<Book> books) {
        this.purchaseTotal = purchaseTotal;
        this.creationDate = creationDate;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPurchaseTotal() {
        return purchaseTotal;
    }

    public void setPurchaseTotal(Double purchaseTotal) {
        this.purchaseTotal = purchaseTotal;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
