
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
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
@WebServlet("/userEntry")
public class UserEntry extends HttpServlet {
 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException
 {
     String username = req.getParameter("username");
     //res.getWriter().write(username);
     String password = req.getParameter("password");
    // res.getWriter().write(password);
     String email = req.getParameter("useremail");
    //res.getWriter().write(email);
     boolean result = false;
     try
     {
     Class.forName("oracle.jdbc.driver.OracleDriver");
     Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","anne","anne");
    // res.getWriter().write("Connection entered");
     PreparedStatement st = con.prepareStatement("Insert into userentry values(?,?,?)");
     st.setString(1, username);
     st.setString(2, password);
     st.setString(3, email);
     
        st.executeUpdate();
          con.close();
         // res.getWriter().write("Data set");
   
  
    res.sendRedirect("success.html");
   
     }
     catch(Exception e)
     {
         res.sendRedirect("error.html");
     }
     
 }
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse res){
        try  {
        RequestDispatcher rd=req.getRequestDispatcher("userEntry.html");
        rd.forward(req, res);
        }
        catch  (Exception e) {
            e.printStackTrace();
        }
    }
    
}
