package ir.maktab.onlineshop;

import ir.maktab.onlineshop.view.MainMenu;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MainMenu mainMenu = new MainMenu();
        mainMenu.run();
    }
}
