package pl.dawidgorecki.jdbc;

import pl.dawidgorecki.utils.ConfigurationLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    public Connection getConnection() throws SQLException {
        Properties config = ConfigurationLoader.loadProperties();
        return DriverManager.getConnection(
                config.getProperty("db.url"),
                config.getProperty("db.username"),
                config.getProperty("db.password")
        );
    }
}
