package water;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class Conn{
    Connection con;
    Statement sta;
    public static String url = "jdbc:mysql://localhost:3306/water";
    public static String uname = "root";
    public static String password = "root";
    Conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,uname,password);
            sta = con.createStatement();
            System.out.println("Connection Successfully");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Not connected");
        }
    }

    public static void main(String[] args) {
        new Conn();
    }
}
