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
                                    break;
                                case 3:
                                    //todo:购买热搜
                                    break;
                                case 4:
                                    System.out.println("请输入你要添加的热搜事件的名字：");
                                    String name = getInput();
                                    HotItem item = new HotItem(name);
                                    hotSearchList.addHotSearch(item);
                                    System.out.println("添加成功");
                                    break;
                                case 5:
                                    // 1TODO: 2020/7/19 退出
                                    continue label1;
                                default:
                                    System.out.println("输入有误");
                            }
                        }
                        // 管理员
                    case 2:
                        System.out.println("请输入您的昵称：");
                        String adminName = getInput();
                        // TODO: 2020/7/20 校验
                        if (!adminName.equals("admin")) {
                            System.out.println("昵称错误。");
                        }
                        System.out.println("请输入您的密码：");
                        String password = getInput();
                        if (!password.equals("admin123")) {
                            System.out.println("密码错误。");
                        }

                        while (true) {
                            Menu.adminMenu(adminName);
                            int adminInput = Integer.parseInt(getInput());
                            switch (adminInput) {
                                case 1:
                                    // 1TODO: 2020/7/20 查看热搜排行榜
                                    hotSearchList.getHotSearchRank();
                                    break;
                                case 2:
                                    // 1TODO: 2020/7/20 添加热搜
                                    System.out.println("请输入你要添加的热搜事件的名字：");
                                    String name = getInput();
                                    HotItem item = new HotItem(name);
                                    hotSearchList.addHotSearch(item);
                                    System.out.println("添加成功");
                                    break;
                                case 3:
                                    // 1TODO: 2020/7/20 添加超级热搜
                                    System.out.println("请输入你要添加的超级热搜事件的名字：");
                                    String superHotSearchName = getInput();
                                    HotItem superHotSearchItem = new HotItem(superHotSearchName);
                                    superHotSearchItem.setSuperHotSearch(true);
                                    hotSearchList.addHotSearch(superHotSearchItem);
                                    break;
                                case 4:
                                    // 1TODO: 2020/7/20 退出 返回上一个菜单
                                    continue label1;
                                default:
                                    System.out.println("输入错误，请重新输入。");
                            }
                        }
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
