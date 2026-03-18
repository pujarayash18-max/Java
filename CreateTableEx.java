import java.sql.*;
import java.util.Scanner;

public class CreateTableEx {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // 1. Load MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. Connect to the database
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/ajt",  
            "root",                              
            "YashPujara@18"                      
        );

        // 3. Create a Statement
        Statement stmt = conn.createStatement();

        // 4. Create table if it doesn't exist
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Emp (" +
                                "Id  int Primary Key, " +
                                "Name VARCHAR(50),"+
                                "City VARCHAR(50)," +
                                "Age INT)";
        stmt.executeUpdate(createTableSQL);
        System.out.println("Table 'Emp' is ready.");
        conn.close();
    }
}