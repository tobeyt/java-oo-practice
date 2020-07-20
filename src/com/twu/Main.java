package com.twu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HotSearch hotSearchList = new HotSearch();

        label1:
        while (true) {
            Menu.mainMenu();
            int c = Integer.parseInt(getInput());
            try {
                switch (c) {
                    // 用户
                    case 1:
                        System.out.println("请输入您的昵称");
                        String userName = getInput();
                        User user = new User(userName);
                        label2:
                        while (true) {
                            Menu.userMenu(userName);
                            int userInput = Integer.parseInt(getInput());
                            switch (userInput) {
                                case 1:
                                    hotSearchList.getHotSearchRank();
                                    break;
                                case 2:
                                    System.out.println("请输入你要投的热搜名称：");
                                    String hotSearchName = getInput();
                                    System.out.printf("请输入你要投票的热搜票数：  （你目前还有：%d票）\n", user.getVotes());
                                    int hotSearchCount = Integer.parseInt(getInput());
                                    if (!user.voteToHotSearch(hotSearchCount)) {
                                        System.out.println("投票失败");
                                    } else {
                                        hotSearchList.votedToHotSearch(hotSearchName, hotSearchCount);
                                        System.out.println("投票成功");
                                    }
                                    continue label2;
                                case 3:
                                    //todo:购买热搜
                                    break;
                                case 4:
                                    System.out.println("请输入你要添加的热搜事件的名字：");
                                    String name = getInput();
                                    HotItem item = new HotItem(name);
                                    hotSearchList.addHotSearch(item);
                                    System.out.println("添加成功");
                                    Menu.userMenu(userName);
                                    break;
                                case 5:
                                    // TODO: 2020/7/19 退出
                                    continue label1;
                                default:
                                    System.out.println("输入有误");
                            }
                        }
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
