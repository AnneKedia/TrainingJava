/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.training.user.Modal;

import com.training.user.Bean.User;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author HP
 */
public class SignUpFormModal extends DatabaseObjectModal {
    
    public boolean insertUser(User user){
        boolean status=false;
        Connection con=createConnection();
        try{
        PreparedStatement pst = con.prepareStatement("Insert into userpas values(?,?)");
            pst.setString(1,user.getUserName());
            pst.setString(2,user.getPassword());
            pst.executeUpdate();
            con.close();  
            status=true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
}
