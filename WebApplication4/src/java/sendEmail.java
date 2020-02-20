
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
@WebServlet("/sendEmail")
public class sendEmail extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException
    {
        try
     {
     Class.forName("oracle.jdbc.driver.OracleDriver");
     Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","anne","anne");
     
     Statement st = con.createStatement();
     
     ResultSet rs = st.executeQuery("select * from userentry");
     
     
     while(rs.next())
     {
         EmailSender es = new EmailSender();
         
         es.sendMail("anne.kedia7@gmail.com","Anne&Kedia07","anne.kedia7@gmail.com",rs.getString(3),"BYE","Gooooooooooood NIghttttttttttttt");
     }
     
     con.close();
             
     }
        catch(Exception e)
        {
            res.sendRedirect(e+"error.html");        
        }
        
    }
            
    
    
}
