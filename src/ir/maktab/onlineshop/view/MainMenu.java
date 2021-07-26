package ir.maktab.onlineshop.view;

import ir.maktab.onlineshop.domain.User;
import ir.maktab.onlineshop.service.UserController;
import ir.maktab.onlineshop.service.helper.Helper;

import java.util.Scanner;

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
                        new UserMenu().run();
                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":
                    Helper.check(scanner, "Are you sure you want to exit?");
                    break;
                default:
                    System.out.println("Wrong!");
            }
        }
    }

}
