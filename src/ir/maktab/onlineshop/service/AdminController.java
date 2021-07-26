package ir.maktab.onlineshop.service;

import ir.maktab.onlineshop.domain.Admin;
import ir.maktab.onlineshop.domain.User;
import ir.maktab.onlineshop.repository.AdminRepository;
import ir.maktab.onlineshop.repository.UserRepository;
import ir.maktab.onlineshop.service.helper.Helper;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminController {
    static Scanner scanner = new Scanner(System.in);
    private static AdminRepository adminRepository = new AdminRepository();

    public static Admin login() {
        System.out.println("Please enter your Username: ");
        String username = scanner.nextLine();
        System.out.println("Please enter your Password: ");
        String password = scanner.nextLine();
        Admin admin = adminRepository.getByUserPass(username, password);
        if (admin == null)
            System.out.println("Incorrect Login credentials!");
        else
            return admin;
        return null;
    }

    public static void changeUserStatus() {
        UserRepository userRepository = new UserRepository();
        ArrayList<User> users = userRepository.getAll();
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }
        System.out.println("Please enter User ID");
        int id = scanner.nextInt();
        scanner.nextLine();
        User user = new UserRepository().getById(id);
        if (user.isStatus()) {
            boolean flag = Helper.check("Do you want to block this user?");
            if (flag)
                user.setStatus(false);
            else
                System.out.println("Nothing has changed.");
        } else {
            boolean flag = Helper.check("Do you want to active this user?");
            if (flag)
                user.setStatus(true);
            else
                System.out.println("Nothing has changed.");
        }
        new UserRepository().update(user);
    }

}
