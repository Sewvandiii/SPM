/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thili
 */
public class dbConnect {

    private Connection con;
    private static dbConnect dbc;

    private dbConnect() throws ClassNotFoundException {
        //DB Driver
        String db_host = "jdbc:mysql://localhost:3306/logindb";
        String db_username = "root";
        String db_password = "";
        con = null;

        try {
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection(db_host, db_username, db_password);

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }



public static dbConnect getDatabaseConnection() throws ClassNotFoundException{
        
        if(dbc == null ){
            dbc = new dbConnect();
        }
        return dbc;
    }
    
    public Connection getConnection(){
        return con;
    }
    
}
