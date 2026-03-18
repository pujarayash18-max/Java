import java.sql.*;
import java.util.Scanner;

public class CreateTableExample1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

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

        

        // 5. Prepare INSERT statement
        String insertSQL = "INSERT INTO Employee (Emp_name, Street, City) VALUES (?, ?, ?)";// aya 
        PreparedStatement pstmt = conn.prepareStatement(insertSQL);

        // 6. Input and insert 5 different employee records
        for (int i = 1; i <= 4; i++) {
            System.out.println("\nEnter details for Employee " + i + ":");
            System.out.print("Name: ");
            String empName = sc.nextLine();
            System.out.print("Street: ");
            String street = sc.nextLine();
            System.out.print("City: ");
            String city = sc.nextLine();
            pstmt.setString(1, empName);
            pstmt.setString(2, street);
            pstmt.setString(3, city);
            pstmt.executeUpdate();
            System.out.println("Employee " + i + " inserted successfully.");
        }
        ResultSet rs=stmt.executeQuery("Select * from Employee");
        System.out.println("Emp_name \t Street \t City\n");
        while(rs.next())
        {
            System.out.println(rs.getString(1)+"\t "+rs.getString(2)+"\t \t "+rs.getString(3));
        }
        // 7. Close everything
        pstmt.close();
        stmt.close();
        conn.close();
        sc.close();
    }
}
