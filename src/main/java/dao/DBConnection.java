package dao;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author chen
 */
public class DBConnection {

    private static Properties properties = new Properties();
    private static DataSource dataSource;

    static {
        try {
            FileInputStream in = new FileInputStream("src/main/resources/dbcp.properties");
            properties.load(in);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        try {
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private DBConnection() {
    }

    public static Connection getConnection() throws SQLException {

        Connection connection = null;
        try {
            connection=dataSource.getConnection();
        } catch (SQLException e) {
            throw e;
        }
        return connection;
    }

}
