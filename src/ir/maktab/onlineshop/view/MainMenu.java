package ir.maktab.onlineshop.view;

import ir.maktab.onlineshop.domain.Admin;
import ir.maktab.onlineshop.domain.User;
import ir.maktab.onlineshop.service.AdminController;
import ir.maktab.onlineshop.service.UserController;
import ir.maktab.onlineshop.service.helper.Helper;

public class MainMenu extends Menu {
    public MainMenu() {
        super(new String[]{
                "Login",
                "Register",
                "Admin Login",
                "Exit"
        });
    }

    public void run() {
        while (true) {
            showMenu();
            String chosenItem = scanner.nextLine();
            switch (chosenItem) {
                case "1":
                    User currentUser = UserController.login();
                    if (currentUser != null)
                        new UserMenu().run(currentUser);
                    break;
                case "2":
                    UserController.register();
                    break;
                case "3":
                    Admin currentAdmin = AdminController.login();
                    if (currentAdmin != null)
                        new AdminMenu().run(currentAdmin);
                    break;
                case "4":
                    if (Helper.check("Are you sure you want to exit?"))
                        System.exit(0);
                default:
                    System.out.println("Wrong!");
                    break;
            }
        }
    }

}
