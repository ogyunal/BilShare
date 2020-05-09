package com.bilshare.bilshare.backend.entity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Product extends AbstractEntity {
  private String name;

  @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
  private List<Item> products = new LinkedList<>();

  public Product() {
  }

  public Product(String name) {
    setName(name);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Item> getProducts() {
    return products;
  }
}