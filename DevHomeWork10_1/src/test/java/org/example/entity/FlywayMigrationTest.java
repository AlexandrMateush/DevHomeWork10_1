package org.example.entity;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FlywayMigrationTest {

    private Flyway flyway;

    @BeforeEach
    public void setUp() {
        FluentConfiguration config = new FluentConfiguration()
                .dataSource("jdbc:h2:mem:testdb", "sa", "")
                .locations("classpath:db/migration")
                .baselineOnMigrate(true);
        flyway = new Flyway(config);
    }

    @Test
    public void testMigration() {
        flyway.migrate();

        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
             Statement statement = connection.createStatement()) {


            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM client");
            assertTrue(resultSet.next());
            int rowCount = resultSet.getInt(1);
            assertEquals(3, rowCount);


            resultSet = statement.executeQuery("SELECT * FROM client");
            int rowCountInTable = 0;
            while (resultSet.next()) {
                rowCountInTable++;
                String name = resultSet.getString("name");
                assertTrue(name.startsWith("Client"));
            }
            assertEquals(3, rowCountInTable);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
