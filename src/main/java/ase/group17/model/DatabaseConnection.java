package ase.group17.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Database Connection object.
 */
public class DatabaseConnection {

    /**
     * Username.
     */
    private static final String USERNAME = "root";

    /**
     * Password.
     */
    private static final String PASSWORD = "CZ3002StudentGroup17!";

    /**
     * Database Management System.
     */
    private static final String DBMS = "mysql";

    /**
     * Server Name.
     */
    private static final String SERVER_NAME = "localhost";

    /**
     * Port Number.
     */
    private static final String PORT_NUMBER = "3306";

    /**
     * Database.
     */
    private static final String DATABASE = "cz3002";

    /**
     * Login query.
     */
    private static final String LOGIN_QUERY = "SELECT username FROM users WHERE username = ? AND password = ?";

    /**
     * Connection string.
     */
    private static final String CONNECTION = "jdbc:" + DBMS + "://" + SERVER_NAME + ":" + PORT_NUMBER + "/" + DATABASE;

    /**
     * Connection object.
     */
    private final Connection connection;

    /**
     * Initialises Database Connection.
     *
     * @throws SQLException If there is problem establishing connection.
     */
    public DatabaseConnection() throws SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("user", USERNAME);
        connectionProps.put("password", PASSWORD);

        connection = DriverManager.getConnection(CONNECTION, connectionProps);
    }

    /**
     * Checks if login is valid.
     *
     * @param username Username of user.
     * @param password Password of user.
     * @return True if login is valid, false otherwise.
     * @throws SQLException If three is problem with database connection.
     */
    public boolean isLoginValid(String username, String password) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_QUERY);
        int parameterIndex = 0;
        preparedStatement.setString(++parameterIndex, username);
        preparedStatement.setString(++parameterIndex, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }
}
