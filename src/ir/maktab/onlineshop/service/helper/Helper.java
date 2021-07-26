package ir.maktab.onlineshop.service.helper;

import java.util.Scanner;

public class Helper {

    public static boolean check(Scanner scanner, String question) {
        while (true) {
            System.out.println(question + " (y/n)");
            String chosenItem = scanner.nextLine();
            if (chosenItem == "y")
                return true;
            if (chosenItem == "n")
                return false;
        }
    }



}
