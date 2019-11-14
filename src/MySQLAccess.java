import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MySQLAccess {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static final String DEFAULT_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DEFAULT_URL = "jdbc:mysql://localhost:3306?characterEncoding=latin1";
    private static final String DEFAULT_USERNAME = "root";
    private static final String DEFAULT_PASSWORD = "password";
    public Connection open() throws SQLException, ClassNotFoundException {
        Class.forName(DEFAULT_DRIVER);
        Connection conn = DriverManager.getConnection(DEFAULT_URL, DEFAULT_USERNAME, DEFAULT_PASSWORD);

        try {


            if (conn != null) {
                System.out.println("Connected to database succeeded");
            }
        } catch (Exception e) {
            System.out.print(e);
        }
        return conn;
    }
    public void readDataBase() throws Exception {


    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }
    public void setUserData(Connection conn, String email, String password) throws SQLException {
        Statement s=conn.createStatement();
        s.executeUpdate("INSERT INTO `users`(eMail, passWord) VALUE ('"+email+"','"+password+"')");
    }

    public void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String user = resultSet.getString("myuser");
            String password = resultSet.getString("password");
            System.out.println("User: " + user);
            System.out.println("password: " + password);

        }
    }
    public void userInsert (String name, String pass){

    }
    // You need to close the resultSet
    void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {

                statement.close();
            }

            if (connect != null) {
                System.out.println("Connection closed");
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}