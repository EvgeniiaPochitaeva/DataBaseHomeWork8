package app;

import app.database.Database;
import app.database.DatabaseMigrat;


public class App {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        new DatabaseMigrat().initDb(database);



    }

}
