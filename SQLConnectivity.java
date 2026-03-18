import java.sql.*;

public class SQLConnectivity {
    public static void main(String[] args) throws Exception {

        // 1. Load MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. Connect to the database
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/DBMS",  
            "root",                              
            "YashPujara@18"                      
        );

        // 3. Create a Statement
        Statement stmt = conn.createStatement();

        // 4. Create table if it doesn't exist
        String createTableSQL = "Select * from Work";
        ResultSet rs=stmt.executeQuery(createTableSQL);
        System.out.println("Name: \t Company Name \t Salary\n");
        while(rs.next())
        {
            System.out.println(rs.getString(1)+"\t "+rs.getString(2)+"\t \t "+rs.getInt(3));
        }
        //closing the connection
        conn.close();
    }
}