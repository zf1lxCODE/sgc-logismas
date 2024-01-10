/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logismasapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Víctor León
 */
public class JdbcDao {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/logismasdatabase";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "Fileton2015";
    private static final String SELECT_QUERY = "SELECT * FROM usuarios WHERE usuario = ? AND contraseña = ?";

    public boolean validate(String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            System.out.println(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return false;
    }

    public Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            return connection;
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return null;
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (ex instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + ex.getSQLState());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.err.println("Cause " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
