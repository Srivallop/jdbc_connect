import java.sql.*;

public class Example_DB_Conn {

    public static void main(String args[]) throws ClassNotFoundException {

        /*****  Make a connection to mySQL Database  ******/
        try {
            // Create Database Connection
            String URL = "jdbc:mysql://127.0.0.1:3306/university";
            String username = "root";
            String password = "";

            Connection  con = DriverManager.getConnection(URL,username,password);

            // Create SQL Statement
            Statement stmt= con.createStatement();

            // Insert new lecturer into university database

            //int iresult = stmt.executeUpdate("insert into instructor(ID,Rank,IName,IOffice,IPhone,DeptCode)values('7','Lecturer','Teerasak','Rama 9','0812345678','2')");
            //System.out.println("Inserted "+ iresult + " rows success" );

            // Update lecturer info in university database

            //int uresult = stmt.executeUpdate("update instructor set iPhone = '9999999999' where IName = 'Dave'");
            //System.out.println("Updated "+ uresult + " rows success" );

            // Delete lecturer info in university database

            //int dresult = stmt.executeUpdate("delete from instructor where ID = '7'");
            //System.out.println("Deleted "+ dresult + " rows success" );


            // Query instructor data from university database

            ResultSet  rs = stmt.executeQuery("Select * from instructor order by ID");
            while(rs.next()) {
                String id = rs.getString("ID");
                String rank = rs.getString("Rank");
                String iname = rs.getString("IName");
                String ioffice = rs.getString("IOffice");
                String iphone = rs.getString("IPhone");

                // Show query result
                System.out.println("Ident. "+id+", Name: "+iname+", Rank: "+rank+", Office: "+ioffice+", Phone: "+iphone);
            }

            // Close Connection
            rs.close();

        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Database Conn Error: " + e.getMessage());

        }
        catch(Exception e) {
            e.printStackTrace();
        }

        /*****  Make a connection to mySQL Database  ******/

    }
}

