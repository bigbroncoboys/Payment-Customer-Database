//open connection, obtain tables?, add elements, update tables, close connection

import java.sql.*;
public class main<first> {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static final String DEFAULT_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DEFAULT_URL = "jdbc:mysql://localhost:3306?characterEncoding=latin1";
    private static final String DEFAULT_USERNAME = "root";
    private static final String DEFAULT_PASSWORD = "password";
    public static void main(String[] args) throws Exception {
//        MySQLAccess sql = new MySQLAccess();
//        //sql.readDataBase();
//        sql.open();
//        //sql.writeResultSet(users);
//        sql.close();

        Class.forName(DEFAULT_DRIVER);
        Connection conn = DriverManager.getConnection(DEFAULT_URL, DEFAULT_USERNAME, DEFAULT_PASSWORD);

        try {
            if (conn != null) {
                System.out.println("Connected to database succeeded");
            }
        } catch (Exception e) {
            System.out.print(e);
        }


        }
    }
