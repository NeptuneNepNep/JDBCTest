package controller;

import sample.Fruit;
import sample.InventorySystem;

import java.sql.SQLException;

public class Server {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Menu m = new Menu();
        m.ShowMainMenu();
    }


}
