package ir.maktab.onlineshop.service;

import ir.maktab.onlineshop.domain.Product;
import ir.maktab.onlineshop.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductController {
    static Scanner scanner = new Scanner(System.in);
    private static ProductRepository productRepository = new ProductRepository();

    public static void viewAllProducts() {
        ArrayList<Product> products = productRepository.getAll();
        System.out.println(products.size());
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i));
        }
    }



}
