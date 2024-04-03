package org.HMB.dataBaseService;

import org.HMB.property.PropertyReader;
import org.flywaydb.core.Flyway;

public class DatabaseInitPostgres {
    public void initDBPostgres() {
        String url = PropertyReader.getConnectionUrlForPostgres();
        String user = PropertyReader.getUserForPostgres();
        String pass = PropertyReader.getPasswordForPostgres();

        Flyway flyway = Flyway.configure()
                .dataSource(url, user, pass)
                .load();

        flyway.migrate();
    }
}
