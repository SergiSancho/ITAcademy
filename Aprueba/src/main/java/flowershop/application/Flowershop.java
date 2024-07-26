/*package flowershop.application;

import flowershop.configdb.mysql.CreateDatabaseMysql;
import flowershop.dao.DaoManager;
import flowershop.configdb.*;
//TODO: import Menu

public class Flowershop<ID> {
    private String database;
    static Flowershop instance;
    private DaoManager manager;

    private Flowershop() {
        database = "mysql";
    }

    private static void setInstance() {
        if (instance == null) {
            instance = new Flowershop();
        }
    }

    public static void start() {
         Flowershop.setInstance();
         instance.setDaoManager();
         //CreateDatabase.create(instance.database);
        CreateDatabaseMysql.initializeDatabase;
        Menu<ID> menu = new Menu<ID>();
        menu.startMenu(manager);
    }

    private void setDaoManager() {
         DaoManager.setManager(database);
         this.manager = DaoManager.getManager();
    }
}

// Habíamos comentado la posibilidad de dejar creado un método estilo public void setDatabase(String db),
// pero no se me ocurre cómo compaginarlo con lo de asignar la database en el constructor.
// Así que por ahora no lo he creado.*/










/*package flowershop.application;


import flowershop.configdb.mysql.CreateDatabaseMysql;
import flowershop.dao.DaoManager;

public class Flowershop<ID> {

    private String database;
    private DaoManager daoManager;

    // Constructor para inicializar el tipo de base de datos
    public Flowershop(String database) {
        this.database = database;
    }

    public void start() {

        // Inicializa la base de datos. Cambia esto según el tipo de base de datos.
        if ("mysql".equalsIgnoreCase(database)) {
            CreateDatabaseMysql.initializeDatabase();
        }
        // Aquí puedes agregar la inicialización para otras bases de datos si es necesario

        // Crear el menú y pasar el DaoManager
        setDaoManager();
        Menu<ID> menu = new Menu<ID> (daoManager);
        menu.startMenu();
    }

    private void setDaoManager() {
        DaoManager.setManager(database);
        this.daoManager = DaoManager.getManager();
    }
}

*/