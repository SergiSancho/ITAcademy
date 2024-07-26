package flowershop;

//import flowershop.application.Flowershop;

import flowershop.application.Menu;
import flowershop.configdb.mysql.CreateDatabaseMysql;
import flowershop.dao.DaoManager;

public class Main {

    public static void main(String[] args) {
        String database = "mysql";
        if (database.equalsIgnoreCase("mysql")){
            CreateDatabaseMysql.initializeDatabase();
            DaoManager.setManager(database);
            Menu menu = new Menu (DaoManager.getManager());
            menu.startMenu();
        }
    }
}