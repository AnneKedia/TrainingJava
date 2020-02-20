/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.training.user.Modal;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author HP
 */
public class DatabaseObjectModal {
    protected Connection createConnection () {
    Connection con=null;
                 try{   
                Class.forName("oracle.jdbc.driver.OracleDriver");
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","anne","anne");
                
                 }
                 catch(Exception e)  {
                     e.printStackTrace();
                 }
                 return con;
    }
}

