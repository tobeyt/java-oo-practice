package com.twu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {
            Menu.mainMenu();
            int c = Integer.parseInt(getInput());
            try {
                switch (c) {
                    // 用户
                    case 1:
                        System.out.println("1");
                        break;
                    // 管理员
                    case 2:
                        System.out.println("2");
                        break;
                    // 退出
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("输入有误");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static Scanner sc = null;

    public static String getInput() {
        sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
