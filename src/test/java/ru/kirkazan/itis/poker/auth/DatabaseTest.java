package ru.kirkazan.itis.poker.auth;

import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

/**
 * @author esadykov
 * @since 28.10.13 16:30
 */
public class DatabaseTest {

    @Test
    public void testConnection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://postgres.dev.kirkazan.ru:5432/itis2013autumn","dc","dc");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select 10");
            if (resultSet.next())
                Assert.assertEquals(10, resultSet.getInt(1));
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            Assert.fail(e.getMessage());
            e.printStackTrace();
        }
    }
}
