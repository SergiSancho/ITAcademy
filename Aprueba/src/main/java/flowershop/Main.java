package flowershop;

//import flowershop.application.Flowershop;

import flowershop.application.Menu;
import flowershop.configdb.mysql.CreateDatabaseMysql;
import flowershop.dao.DaoManager;
import flowershop.dao.FlowerDao;
import flowershop.entities.Flower;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String database = "mysql";
        if (database.equalsIgnoreCase("mysql")){
            CreateDatabaseMysql.initializeDatabase();
            DaoManager.setManager(database);
            Menu<Integer> menu = new Menu<>(DaoManager.getManager());
            menu.startMenu();
        }
    }
}