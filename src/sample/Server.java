package sample;

import java.sql.SQLException;

public class Server {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        InventorySystem inventorySystem = new InventorySystem();
       Fruit fruit1 = new Fruit(3,"apple",3,100,"applepie");
       inventorySystem.AddFruit(fruit1);
       inventorySystem.ShowTitle();
       inventorySystem.DeleteFruitByFid(3);
       inventorySystem.ShowTitle();
    }


}
