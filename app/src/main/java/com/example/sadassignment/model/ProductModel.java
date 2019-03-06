package com.example.sadassignment.model;

public class ProductModel {
    private String name, description, price;
    int id;

    public int getId() {
        return id;
    }

    private ProductModel() {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public static class Builder {
        private String name, description, price;
        private int id;

        public Builder() {

        }

        public Builder writeInt(int id) {
            this.id = id;
            return this;
        }

        public Builder writeProductName(String name) {
            this.name = name;
            return this;
        }

        public Builder writeProductPrice(String price) {
            this.price = price;
            return this;
        }

        public Builder writeProductDescription(String description) {
            this.description = description;
            return this;
        }

        public ProductModel build() {
            ProductModel p = new ProductModel();
            p.name = this.name;
            p.price = this.price;
            p.description = this.description;
            return p;
        }
    }
}
