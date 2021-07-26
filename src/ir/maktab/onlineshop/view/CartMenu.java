package ir.maktab.onlineshop.view;

import ir.maktab.onlineshop.domain.User;
import ir.maktab.onlineshop.service.CartController;
import ir.maktab.onlineshop.service.ProductController;
import ir.maktab.onlineshop.service.helper.Helper;

public class CartMenu extends Menu{
    public CartMenu() {
        super(new String[]{
                "Add to Cart",
                "Remove from Cart",
                "View Cart",
                "Cart Sum",
                "Checkout"
        });
    }

    public void run(User currentUser) {
        while (true) {
            showMenu();
            String chosenItem = scanner.nextLine();
            switch (chosenItem) {
                case "1":
                    CartController.addToCart();
                    break;
                case "2":
                    CartController.removeFromCart();
                    break;
                case "3":
                    CartController.viewCart();
                    break;
                case "4":
                    System.out.println("Total Sum = " + CartController.cartTotalCost());
                    break;
                case "5":
                    CartController.checkout(currentUser);
                    break;
                default:
                    System.out.println("Wrong!");
            }
        }
    }
}
