package ir.maktab.onlineshop.service;

import ir.maktab.onlineshop.domain.User;
import ir.maktab.onlineshop.repository.UserRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserController {
    static Scanner scanner = new Scanner(System.in);
    private static UserRepository userRepository = new UserRepository();

    public static User login() {
        System.out.println("Please enter your Username: ");
        String username = scanner.nextLine();
        System.out.println("Please enter your Password: ");
        String password = scanner.nextLine();
        User user = userRepository.getByUserPass(username, password);
        if (user == null)
            System.out.println("Incorrect Login credentials!");
        else if (!user.isStatus())
            System.out.println("Your account is not active!");
        else
            return user;
        return null;
    }

    public static void register() {
        User user = new User();
        System.out.println("Please enter username: ");
        user.setUserName(scanner.nextLine());
        System.out.println("Please enter nationalcode: ");
        String nationalCode = scanner.nextLine();
        user.setNationalCode(nationalCode);
        user.setPassword(nationalCode);
        System.out.println("Please enter birthday yyyy-mm-dd: ");
        String str = scanner.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        user.setBirthday(LocalDate.parse(str, dtf));
        userRepository.save(user);
        System.out.println("Registered successfully.");
    }

    public static void chargeAccount(User currentUser) {
        User user = new UserRepository().getById(currentUser.getId());
        System.out.println("Enter amount you want to charge: ");
        String addAmount = scanner.nextLine();
        user.setBalance(user.getBalance().add(new BigDecimal(addAmount)));
        new UserRepository().update(user);
        System.out.println("Your account charged successfully");
    }


}
