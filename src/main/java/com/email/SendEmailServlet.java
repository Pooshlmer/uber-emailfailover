package com.email;
/*
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
*/

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.EmailService;
import com.service.MailgunService;
import com.service.SendGridService;

public class SendEmailServlet extends HttpServlet {
  
  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {
        
    MailData mData = new MailData();
    mData.setToAddress(req.getParameter("to"));
    mData.setFromAddress(req.getParameter("from"));
    mData.setSubject(req.getParameter("subject"));
    mData.setBody(req.getParameter("body"));
    
    if (!mData.validate()) {
      resp.sendRedirect("failure.jsp");
      return;
    }
    
    LinkedList<EmailService> mailServices = initializeEmailServices();
    
    for (EmailService service : mailServices) {
      if (service.sendEmail(mData)) {
        resp.sendRedirect("success.jsp?service=" + service.getName());
        return;
      }
    }
    
    resp.sendRedirect("failure.jsp");
  }
  
  // Adds all the mail services used to a list
  private LinkedList<EmailService> initializeEmailServices() {
    LinkedList<EmailService> mailServices= new LinkedList<EmailService>();
    mailServices.add(new SendGridService());
    mailServices.add(new MailgunService());
    return mailServices;
  }
}