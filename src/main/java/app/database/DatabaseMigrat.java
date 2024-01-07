package app.database;

import app.prefs.Prefs;
import org.flywaydb.core.Flyway;

public class DatabaseMigrat {

   public void initDb(Database database) {
       String connectionUrl = new Prefs().getString(Prefs.DB_JDBC_CONNECTION_URL);
       Flyway flyway = Flyway
               .configure()
               .dataSource(connectionUrl, null, null)
               .load();
       flyway.migrate();


   }

}
