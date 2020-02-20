package com.training.user.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.training.user.Bean.User;
import com.training.user.Modal.SignInFormModal;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
/**
 *
 * @author HP
 */
@WebServlet("/signInForm")
public class SignInFormServletController extends HttpServlet
{
   @Override
   protected void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException
   {
    String userName = req.getParameter("userName");
    String password =  req.getParameter("password");
    User user = new User(userName,password);
    SignInFormModal form = new SignInFormModal();
    boolean result = form.checkUser(user);
    if(result)
    {
        res.getWriter().write("<h1> Hi " + user.getUserName() + "</h1>");
    }
    else
    {
        res.getWriter().write("Log In Failed");
    }
   }
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException
   {
       RequestDispatcher rs = req.getRequestDispatcher("signin.html");
       rs.forward(req,res);               
   }
    
}
