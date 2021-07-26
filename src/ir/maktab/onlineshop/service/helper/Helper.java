package ir.maktab.onlineshop.service.helper;

import java.util.Scanner;

public class Helper {

    public static boolean check(String question) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(question + " (y/n)");
            char chosenItem = scanner.nextLine().charAt(0);
            if (chosenItem == 'y')
                return true;
            if (chosenItem == 'n')
                return false;
        }
    }



}
