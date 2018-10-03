/*
1) Import JDBC packages (make sure you have ojdbc*.jar in cp)
2) Load Oracle JDBC drivers
3) Connect to the database with some variables
4) Perform some SQL
*/

//Import JDBC packages
import java.sql.*;

public class Example {
    public static void main(String[] args) {
        //Declare Connection and Statement objects
        Connection myConnection = null;
        Statement myStatement = null;

        try {
            //Register the driver
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());

            //Configure Connection
            myConnection = DriverManager.getConnection(
                "jdbc:oracle:thin:@192.168.56.105:1521:xe", 
                "zoo", 
                "p4ssw0rd");

            //Create Statement
            myStatement = myConnection.createStatement();

            myStatement.execute("INSERT INTO ANIMALS (name, age, legs) VALUES ('Hippo', 23, 2)");

            //Create a ResultSet object for storing data from a SELECT
            ResultSet animals = myStatement.executeQuery("SELECT * FROM ANIMALS");

            while(animals.next()) {
                System.out.println(animals.getInt("id"));
                System.out.println(animals.getString("name"));
                System.out.println(animals.getInt("age"));
                System.out.println(animals.getInt("legs"));
                System.out.println();
            }

            myStatement.close();
            myConnection.close();
        } catch (SQLException ex) {
            ex.getMessage();
        } 
    }
}