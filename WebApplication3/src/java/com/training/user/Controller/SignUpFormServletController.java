/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.training.user.Controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.training.user.Bean.User;
import com.training.user.Modal.SignUpFormModal;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author HP
 */
@WebServlet("/signUp")
public class SignUpFormServletController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res){
        String userName=req.getParameter("userName");
        String password=req.getParameter("password");
        User user=new User(userName,password);
        SignUpFormModal signUp=new SignUpFormModal();
        boolean isSignUpDone=signUp.insertUser(user);
        try{
        if(isSignUpDone)  {
            res.getWriter().write("Sign Up Successfull");
        } else {
            res.getWriter().write("Sign Up Unsuccessful");
        }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse res){
        try  {
        RequestDispatcher rd=req.getRequestDispatcher("signUpForm.html");
        rd.forward(req, res);
        }
        catch  (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
