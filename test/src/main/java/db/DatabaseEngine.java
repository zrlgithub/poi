package db;
import security.PasswordHasher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * @author timus
 *
 */
public class DatabaseEngine {

private static final String JDBC_URL = "jdbc:sqlite:src/main/resources/poi.db";
   private static final String DB_USER = "root";
   private static final String DB_PASSWORD = "root";
   private static Connection connection;
   
  // initialize connection to database
   static {
       try {
           connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }

   public static Connection getConnection() {
       return connection;
   }
   //////////////////////
   public static boolean executeUpdate(String sql, Object... params) {
       try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
           setParameters(preparedStatement, params);
           int rowsAffected = preparedStatement.executeUpdate();
           return rowsAffected > 0;
       } catch (SQLException e) {
           e.printStackTrace();
           return false;
       }
   }
   public static ResultSet executeQuery(String sql) {
       try {
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
           setParameters(preparedStatement);
           return preparedStatement.executeQuery();
       } catch (SQLException e) {
           e.printStackTrace();
           return null;
       }
   }
   ////////////////////////////////////////
   private static void setParameters(PreparedStatement preparedStatement, Object... params) throws SQLException {
       for (int i = 0; i < params.length; i++) {
           preparedStatement.setObject(i + 1, params[i]);
       }
   }
   public static boolean registerUser(String username, String password) {
	   if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
           return false; // Username or password is null or empty
       }
	   if (usernameExists(username)) {
           return false; // Username is already taken
       }
       String hashedPassword = PasswordHasher.hashPassword(password);
       String insertQuery = "INSERT INTO users (name, password, score) VALUES (?, ?, 0)";
       return executeUpdate(insertQuery, username, hashedPassword);
   }

   public static boolean checkPassword(String username, String inputPassword) {
       String query = "SELECT password FROM users WHERE name = ?";
       try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
           preparedStatement.setString(1, username);
           try (ResultSet resultSet = preparedStatement.executeQuery()) {
               if (resultSet.next()) {
                   String hashedPassword = resultSet.getString("password");
                   return PasswordHasher.verifyPassword(inputPassword, hashedPassword);
               }
               return false;
           }
       } catch (SQLException e) {
           e.printStackTrace();
           return false;
       }
   }
    private static boolean usernameExists(String username) {
    String query = "SELECT COUNT(*) AS count FROM users WHERE name = ?";
       try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
           preparedStatement.setString(1, username);
           try (ResultSet resultSet = preparedStatement.executeQuery()) {
               if (resultSet.next()) {
                   int count = resultSet.getInt("count");
                   return count > 0;
               }
               return false;
           }
       } catch (SQLException e) {
           e.printStackTrace();
           return false;
       }
   }
   
}
