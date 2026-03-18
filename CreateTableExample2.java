import java.sql.*;
import java.util.Scanner;

public class CreateTableExample2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // 1. Load Driver and connect
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/AJT",  
            "root",                              
            "YashPujara@18"                      
        );

        // 2. Create Statement
        Statement stmt = conn.createStatement();

        // 3. Create Table
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Emp (" +
                                "Id INT PRIMARY KEY, " +
                                "Name VARCHAR(50), " +
                                "City VARCHAR(50), " +
                                "Age INT)";
        stmt.executeUpdate(createTableSQL);
        System.out.println("Table 'Emp' is ready.");
    /*
        // 4. Prepare Insert
        String insertSQL = "INSERT INTO Emp (Id, Name, City, Age) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(insertSQL);
    
        for (int i = 1; i <= 3; i++) {
            System.out.println("\nEnter details for Employee " + i + ":");

            System.out.print("ID: ");
            int empId = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Name: ");
            String empName = sc.nextLine();

            System.out.print("City: ");
            String empCity = sc.nextLine();

            System.out.print("Age: ");
            int age = sc.nextInt();

            pstmt.setInt(1, empId);
            pstmt.setString(2, empName);
            pstmt.setString(3, empCity);
            pstmt.setInt(4, age);
            pstmt.executeUpdate();
            System.out.println("Employee " + i + " inserted successfully.");
        }*/

        // 5. Call Stored Procedure
        System.out.print("\nEnter an Employee ID to get City using Stored Procedure: ");
        int searchId = sc.nextInt();

        CallableStatement cstmt = conn.prepareCall("{call In_OutSP(?, ?, ?, ?)}");
        cstmt.setInt(1,sc.nextInt());
        cstmt.execute();

        String cityResult = cstmt.getString(3);
        System.out.println("City of Employee with ID " + cityResult);

        // 6. Close resources
        cstmt.close();
        //pstmt.close();
        stmt.close();
        conn.close();
        sc.close();
    }
}
