package ir.maktab.onlineshop.service;

import ir.maktab.onlineshop.domain.CartItem;
import ir.maktab.onlineshop.domain.Product;
import ir.maktab.onlineshop.domain.User;
import ir.maktab.onlineshop.repository.ProductRepository;
import ir.maktab.onlineshop.repository.UserRepository;
import ir.maktab.onlineshop.service.helper.Helper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class CartController {
    static Scanner scanner = new Scanner(System.in);
    private static ArrayList<CartItem> cartItems = new ArrayList<>();

    private static int cartQuantity() {
        int cartQuantity = 0;
        for (int i = 0; i < cartItems.size(); i++) {
            cartQuantity += cartItems.get(i).getQuantity();
        }
        return cartQuantity;
    }

    public static BigDecimal cartTotalCost() {
        BigDecimal totalCost = new BigDecimal(0);
        for (int i = 0; i < cartItems.size(); i++) {
            totalCost = totalCost.add(cartItems.get(i).getProduct().getPrice().multiply(BigDecimal.valueOf(cartItems.get(i).getQuantity())));
        }
        return totalCost;
    }

    public static void viewCart() {
        if (cartQuantity() == 0)
            System.out.println("Your Cart is empty.");
        for (int i = 0; i < cartItems.size(); i++) {
            System.out.printf("id: %d. %s \n", i + 1, cartItems.get(i));
        }
    }

    public static void addToCart() {
        ProductController.viewAllProducts();
        System.out.println("Enter Product id that you want to purchase: ");
        int productId = scanner.nextInt();
        scanner.nextLine();
        Product product = new ProductRepository().getById(productId);
        System.out.println("Enter amount to purchase: ");
        int amount = scanner.nextInt();
        scanner.nextLine();
        if ((cartQuantity() + amount) > 5) {
            System.out.println("Each Cart can only have 5 items!");
        } else if (amount > product.getStock()) {
            System.out.println("There is only " + product.getStock() + " of this item in stock!");
        } else if (product.getStock() == 0) {
            System.out.println("Out of stock!");
        } else {
            cartItems.add(new CartItem(product, amount));
            System.out.println("Product Added to Cart successfully.");
        }
    }

    public static void removeFromCart() {
        viewCart();
        if (!cartItems.isEmpty()){
            System.out.println("Choose item id you want to remove");
            int itemId = scanner.nextInt();
            scanner.nextLine();
            cartItems.remove(itemId - 1);
        }
    }

    public static void checkout(User currentUser) {
        if (Helper.check("are sure you want to checkout?")) {
            if (cartTotalCost().compareTo(currentUser.getBalance()) == 1) {
                System.out.println("Your account balance is low, charge first");
            } else {
                for (int i = 0; i < cartItems.size(); i++) {
                    cartItems.get(i).getProduct().setStock(cartItems.get(i).getProduct().getStock() - cartItems.get(i).getQuantity());
                    new ProductRepository().update(cartItems.get(i).getProduct());
                }
                currentUser.setBalance(currentUser.getBalance().subtract(cartTotalCost()));
                new UserRepository().update(currentUser);
                cartItems.clear();
                System.out.println("Purchase successfully.");
            }
        }
    }


}
