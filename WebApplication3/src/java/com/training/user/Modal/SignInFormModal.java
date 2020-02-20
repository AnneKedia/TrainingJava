/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.training.user.Modal;
import com.training.user.Bean.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author HP
 */
public class SignInFormModal extends DatabaseObjectModal  {
    public boolean checkUser(User user) 
    {
        boolean result = false;
        Connection con;    
        try
        {
        con = createConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("Select * from userpas where username ='"+user.getUserName()+"' and password = '"+user.getPassword()+"'");
        if(rs.next())
        {
            result = true;
        } 
        con.close();
        
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
        
    }
}
