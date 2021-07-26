package ir.maktab.onlineshop.domain;

import java.math.BigDecimal;

public class Product {
    private int id;
    private String name;
    private String brand;
    private String description;
    private BigDecimal price;
    private Category category;

    public Product(int id, String name, String brand, String description, BigDecimal price, Category category) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product[" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category=" + category.getTitle() +
                ']';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
