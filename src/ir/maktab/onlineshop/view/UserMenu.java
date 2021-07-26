package ir.maktab.onlineshop.view;

import ir.maktab.onlineshop.service.helper.Helper;

public class UserMenu extends Menu {
    public UserMenu() {
        super(new String[]{
                "View All Products",
                "Add to Cart",
                "View Cart",
                "Logout"
        });
    }

    public void run() {
        while (true) {
            showMenu();
            String chosenItem = scanner.nextLine();
            switch (chosenItem) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":
                    if (Helper.check(scanner, "Are you sure you want to Logout?"))
                        new MainMenu().run();
                    break;
                default:
                    System.out.println("Wrong!");
            }
        }
    }
}
