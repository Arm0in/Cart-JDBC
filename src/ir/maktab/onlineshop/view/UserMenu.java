package ir.maktab.onlineshop.view;

import ir.maktab.onlineshop.domain.User;
import ir.maktab.onlineshop.service.ProductController;
import ir.maktab.onlineshop.service.UserController;
import ir.maktab.onlineshop.service.helper.Helper;

public class UserMenu extends Menu {
    public UserMenu() {
        super(new String[]{
                "View All Products",
                "Charge account",
                "Shop",
                "Logout"
        });
    }

    public void run(User currentUser) {
        while (true) {
            showMenu();
            String chosenItem = scanner.nextLine();
            switch (chosenItem) {
                case "1":
                    ProductController.viewAllProducts();
                    break;
                case "2":
                    UserController.chargeAccount(currentUser);
                    break;
                case "3":
                    new CartMenu().run(currentUser);
                    break;
                case "4":
                    if (Helper.check("Are you sure you want to Logout?"))
                        new MainMenu().run();
                    break;
                default:
                    System.out.println("Wrong!");
            }
        }
    }
}
