package com.inventory.dao;

import java.sql.*;
//import com.mysql.jdbc.Driver;

public class DatabaseDao {

    private Connection conn;

    public DatabaseDao() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://danthroposrds.czlsymlnerqj.us-east-2.rds.amazonaws.com:3306", "danthropos", "8tYXahmvN1oJ");
        } catch(SQLException sqle){
            System.out.println("sqle exception while establishing db connection");
            sqle.printStackTrace();
        } catch(ClassNotFoundException cnfe){
            System.out.println("cnfe exception while establishing db connection");
        }
    }

    public String getGroceries(){
        String out = "";
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from heb.Groceries");
            while (rs.next()) out += rs.getString(2) + " ";
        } catch(SQLException sqle){
            System.out.println("sqle exception while getting groceries");
        }

        return out;
    }

}
