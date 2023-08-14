package org.example;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.ClassicConfiguration;


public class Main {
    public static void main(String[] args) {
        ClassicConfiguration classicConfiguration = new ClassicConfiguration();
        classicConfiguration.setUrl("jdbc:h2:./mydb;TRACE_LEVEL_SYSTEM_OUT=3");
        classicConfiguration.setUser("sa");
        classicConfiguration.setPassword("");
        classicConfiguration.setDataSource("jdbc:h2:./mydb;TRACE_LEVEL_SYSTEM_OUT=3","sa","");
        Flyway flyway = new Flyway(classicConfiguration);
        flyway.baseline();
        flyway.migrate();
        flyway.repair();

    }
}