package controller;

import jdk.internal.util.xml.impl.Input;
import sample.Fruit;
import sample.InventorySystem;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    InventorySystem inventorySystem = new InventorySystem();
    Scanner scanner = new Scanner(System.in);
    public void ShowMainMenu() throws SQLException, ClassNotFoundException {

        boolean flag = true;
        while (flag){
            System.out.println("--------------------------------");
            System.out.println("1.查看水果信息");
            System.out.println("2.添加水果");
            System.out.println("3.查看水果");
            System.out.println("4.删除水果");
            System.out.println("5.exit");
            System.out.println("--------------------------------");
            int choose = scanner.nextInt();
        switch (choose) {
            case 1: {
                inventorySystem.ShowTitle();
                break;
            }
            case 2: {
                Fruit newFruit = CreateFruit();
                inventorySystem.AddFruit(newFruit);
                break;
            }
            case 3: {
                System.out.println("请输入你要查询的水果号");
                int id = scanner.nextInt();
                inventorySystem.SelectFruitByfid(id);
                break;
            }
            case 4: {
                System.out.println("请输入你需要删除的水果号");
                int id = scanner.nextInt();
                inventorySystem.DeleteFruitByFid(id);

                break;
            }
            case 5: {
                System.out.print("是否确认退出?Y/N");
                String  c = scanner.next();
                if(c.equalsIgnoreCase("y") ){
                flag = false;
                }
                break;
            }
            default:{
                System.out.print("?");
                break;
            }

        }

        }


    }
    public Fruit CreateFruit(){
        System.out.println("请输入水果序号");
        int id = scanner.nextInt();
        System.out.println("请输入水果名");
        String name = scanner.next();
        System.out.println("请输入价格");
        int price = scanner.nextInt();
        System.out.println("请输入库存");
        int count = scanner.nextInt();
        System.out.println("请输入备注");
        String remark = scanner.next();
        Fruit fruit = new Fruit(id,name,price,count,remark);
        return fruit;
    }
}
