package configdb.mongo;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoConnection {

    // URL de conexión a MongoDB (por ejemplo, localhost con el puerto predeterminado 27017)
    private static final String CONNECTION_STRING = "mongodb://localhost:27017";
    private static final String DATABASE_NAME = "blackrose";

    // Instancia única de MongoClient (Singleton)
    private static MongoClient mongoClient;

    // Método para obtener la conexión a la base de datos
    public static MongoDatabase getDatabase() {
        if (mongoClient == null) {
            synchronized (MongoConnection.class) {
                if (mongoClient == null) {
                    mongoClient = MongoClients.create(CONNECTION_STRING);
                }
            }
        }
        return mongoClient.getDatabase(DATABASE_NAME);
    }

    // Método para cerrar la conexión (opcional)
    public static void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}

