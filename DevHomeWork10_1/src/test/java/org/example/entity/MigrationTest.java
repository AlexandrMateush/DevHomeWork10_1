package org.example.entity;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.ClassicConfiguration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MigrationTest {

    private static Flyway flyway;

    @BeforeAll
    public static void setup() {
        ClassicConfiguration classicConfiguration = new ClassicConfiguration();
        classicConfiguration.setUrl("jdbc:h2:./mydb;TRACE_LEVEL_SYSTEM_OUT=3");
        classicConfiguration.setUser("sa");
        classicConfiguration.setPassword("");
        flyway = new Flyway(classicConfiguration);
    }

    @Test
    public void testMigrations() {
        flyway.clean();
        flyway.baseline();
        flyway.migrate();

        assertTrue(true);
    }

    @AfterAll
    public static void cleanup() {
        flyway.clean();
    }
}