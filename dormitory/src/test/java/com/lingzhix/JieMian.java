package com.lingzhix;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class JieMian {

    private static ArrayList<Account> al = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("--------------ATM-------------------");
            System.out.println("请输入要进行的操作:");
            System.out.println("1.登录");
            System.out.println("2.注册");
            Scanner sc = new Scanner(System.in);
           // ArrayList<Account> al = new ArrayList<>();
            int number = sc.nextInt();
            switch (number) {
                //用户登录
                case 1:
                login(sc,al);
                break;
                //用户注册
                case 2:
                register1(sc,al);
            }
        }
    }

    private static void login(Scanner sc,ArrayList<Account> al) {
        if (al.size() > 0) {
            System.out.println("输入卡号：");
            String id = sc.next();
            while (true) {
                for (int i = 0; i < al.size(); i++) {
                    if (al.get(i).equals(id)) {
                        String password;
                        while (true) {
                            System.out.println("输入密码:");
                            password = sc.next();
                            if (password.equals(al.get(i).getPassword())) {
                                break;
                            }
                        }
                        String aaa;
                        while (true) {
                            System.out.println("输入用户名的第一个字:");
                            aaa = sc.next();
                            if (aaa.equals(al.get(i).getName().charAt(0))) {
                                break;
                            }
                        }
                        while (true) {
                            System.out.println("---------------ATM功能界面---------------------");
                            System.out.println("1.查询");
                            System.out.println("2.转账");
                            System.out.println("3.存钱");
                            System.out.println("4.取钱");
                            System.out.println("5.退出");
                            System.out.println("6.注销");
                            int number = sc.nextInt();
                            switch (number) {
                                case 1:
                                    //查询
                                    query(i,al);
                                    break;
                                case 2:
                                    //转账
                                    transform(i,al,sc);
                                    break;
                                case 3:
                                    //存钱
                                    add(i,al,sc);
                                    break;
                                case 4:
                                    //取钱
                                    realize(i,al,sc);
                                    break;
                                case 5:
                                    //退出
                                    return;
                                case 6:
                                    //注销
                                    al.remove(i);
                                    return;
                            }
                        }


                    }
                }
                System.out.println("输入的id有误!");
            }
        } else {
            System.out.println("没有账户，先注册！");
            return;
        }

    }

    private static void query(int i,ArrayList<Account> al) {
        System.out.println(al.get(i).getId());
        System.out.println(al.get(i).getName());
        System.out.println(al.get(i).getHadMoney());
        System.out.println(al.get(i).getOnceMoney());
    }

    private static void add(int i,ArrayList<Account> al,Scanner sc) {
        System.out.println("输入存钱金额:");
        double number = sc.nextDouble();
        al.get(i).setHadMoney(number);
        System.out.println("当前余额:");
        al.get(i).getHadMoney();
    }

    private static void transform(int i,ArrayList<Account> al,Scanner sc) {
        if (al.get(i).getHadMoney() <= 0) {
            System.out.println("没钱，无法转账。");
            return;
        }
        while (true) {
            System.out.println("输入提现金额:");
            double number = sc.nextDouble();
            if (number > al.get(i).getOnceMoney()) {
                System.out.println("超额重输");
            } else {
                while (true) {
                    System.out.println("输入对方账户卡号");
                    String data = sc.next();
                    for (int j = 0; j < al.size(); j++) {
                        if (data.equals(al.get(j).getId())) {
                            int t = 3;
                            while (t > 0) {
                                System.out.println("输入对方账户名第一个字");
                                String firstNmae = sc.next();
                                if (firstNmae.equals(al.get(j).getName().charAt(0))) {
                                    al.get(i).setHadMoney((-1) * number);
                                    al.get(j).setHadMoney(number);
                                    break;
                                } else {
                                    t--;
                                    System.out.println("还有"+t+"次机会");
                                }
                            }
                            return;
                        }
                    }
                    System.out.println("输入卡号有误！");
                }
            }
        }
    }

    private static void realize(int i,ArrayList<Account> al,Scanner sc) {
        System.out.println("输入取钱金额:");
        double number = (-1) * sc.nextDouble();
        al.get(i).setHadMoney(number);
        System.out.println("当前余额:");
        al.get(i).getHadMoney();
    }

    private static void register1(Scanner sc, ArrayList<Account> al) {
        System.out.println("-----------注册--------------");
        Account ac = new Account();
        System.out.println("输入用户名:");
        String name = sc.next();
        String password;
        String password1;
        while (true) {
            System.out.println("输入密码:");
            password = sc.next();
            System.out.println("确认密码:");
            password1 = sc.next();
            if (password1.equals(password)) {
              break;
            }
        }
        String id = getId(al);
        System.out.println("输入单次限额:");
        double onceMoney = sc.nextDouble();
        ac.setId(id);
        ac.setName(name);
        ac.setPassword(password);
        ac.setOnceMoney(onceMoney);
        al.add(ac);
        System.out.println(name+"注册成功，"+name+"的卡号为："+id);
    }

    private static String getId(ArrayList<Account> al) {
        Random r = new Random();
        String id = "";
        out:
        while (true) {
            for (int j = 0; j <= 8; j++) {
                id += r.nextInt(10);
            }
            for (int i = 0; i < al.size(); i++) {
                if (id.equals(al.get(i).getId())) {
                    break out;
                }
            }
            break;
        }
        return id;
    }

}
