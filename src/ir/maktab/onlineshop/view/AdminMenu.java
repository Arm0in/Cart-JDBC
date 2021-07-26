package ir.maktab.onlineshop.view;

import ir.maktab.onlineshop.domain.Admin;
import ir.maktab.onlineshop.service.AdminController;
import ir.maktab.onlineshop.service.helper.Helper;

public class AdminMenu extends Menu {
    public AdminMenu() {
        super(new String[]{
                "Change User Status",
                "Logout"
        });
    }

    public void run(Admin currentAdmin) {
        while (true) {
            showMenu();
            String chosenItem = scanner.nextLine();
            switch (chosenItem) {
                case "1":
                    AdminController.changeUserStatus();
                    break;
                case "2":
                    if (Helper.check("Are you sure you want to Logout?"))
                        new MainMenu().run();
                    break;
                default:
                    System.out.println("Wrong!");
            }
        }
    }
}
